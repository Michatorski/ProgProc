package org.iesfm.shop.controller;

import org.iesfm.shop.Article;
import org.iesfm.shop.dao.ArticleDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
public class ArticleController {
    private ArticleDAO articleDAO;

    public ArticleController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles")
    public List<Article> list(){
        return articleDAO.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles?tag=libros")
    public List <Article> list(@RequestParam(name = "tag") String tag){
        List<Article> articles= articleDAO.list(tag);
        if (articles == null){
            throw  new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, article not found");
        } else {
            return  articles;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles/{id}")
    public Article get(@PathVariable("id") int id){
        Article article = articleDAO.get(id);
        if (article == null){
            throw  new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, article not found");
        } else {
            return  article;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/articles")
    public void createArticle(@RequestBody Article newArticle){
        boolean isCreated = articleDAO.insert(newArticle);
        if (newArticle.equals(articleDAO)){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "ERROR 409, ya existe el arictulo"
            );
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/articles/{id}")
    public void  delete(@PathVariable("id") int id){
        boolean isDeleted = articleDAO.delete(id);
        if (!isDeleted){
            throw  new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, article not found"
            );
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/article/{id}")
    public void update(@RequestBody Article article){
        if (!articleDAO.update(article)){
            throw  new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, article not found"
            );
        }
    }
}
