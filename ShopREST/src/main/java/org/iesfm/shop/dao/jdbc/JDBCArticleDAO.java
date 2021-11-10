package org.iesfm.shop.dao.jdbc;

import org.iesfm.shop.Article;
import org.iesfm.shop.dao.ArticleDAO;

import java.util.List;

public class JDBCArticleDAO implements ArticleDAO {

    @Override
    public List<Article> list() {
        return null;
    }

    @Override
    public List<Article> list(String tag) {
        return null;
    }

    @Override
    public Article get(int id) {
        return null;
    }

    @Override
    public boolean insert(Article article) {
        return false;
    }

    @Override
    public boolean update(Article article) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
