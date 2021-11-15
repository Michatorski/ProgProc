package org.iesfm.shop.controller;

import org.iesfm.shop.Article;
import org.iesfm.shop.dao.ArticleDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    private ArticleDAO articleDAO;

    public ArticleController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/shop")
    public List<Article> list(){
        return articleDAO.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/shop/{tag}")
    public List <Article> list(@PathVariable("tag") String tag){
        return articleDAO.list(tag);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/shop/{id}")
    public Article get(@PathVariable("id") int id){
        return articleDAO.get(id);
    }
}
