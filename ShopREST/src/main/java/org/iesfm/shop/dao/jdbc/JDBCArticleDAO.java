package org.iesfm.shop.dao.jdbc;

import org.iesfm.shop.Article;
import org.iesfm.shop.dao.ArticleDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.*;

public class JDBCArticleDAO implements ArticleDAO {
    private final static String INSERT_ARTICLE = "INSERT INTO Article" +
            "(name, " +
            "price,  " +
            "tags " +
            ") " +
            "VALUES(" +
            "   :name," +
            "   :price," +
            "   :tags" +
            ")";

    private final static String SELECT_ARTICLE = "SELECT * FROM Article";
    private final static String SELECT_TAG_BY_ARTICLE_ID = "SELECT * FROM Tag WHERE article_id = :article_id";
    private final static String SELECT_ARTICLE_BY_ID = "SELECT * FROM Article WHERE id = :id";
    private final static String SELECT_TAG = "SELECT * FROM Tag";

    private Article article;

    private NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Article> list() {
        return null;
//        Map<String, Object> params = new HashMap<>();
//        return jdbc.query(SELECT_ARTICLE,
//                params,
//                (rs, rowNum) -> new Article(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getDouble("price"),
//                        getTag()
//                ));
    }

    @Override
    public List<Article> list(String tag) {
        return null;
    }

    @Override
    public Article get(int id) {
        return null;
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
//        try{
//            return jdbc.queryForObject(SELECT_ARTICLE_BY_ID,
//                    params,
//                    (rs, rowNum) -> new Article(
//                            rs.getInt(id),
//                            rs.getString("name"),
//                            rs.getDouble("price"),
//                            getTag()
//                    ));
//        } catch ( EmptyResultDataAccessException e){
//            return null;
//        }

    }

    @Override
    public boolean insert(Article article) {

        Map<String, Object> params = new HashMap<>();
        params.put("name", article.getName());
        params.put("price", article.getPrice());
        params.put("tags", article.getTags());
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

//    public Set<String> getTag(){
//        Map<String, Object> params = new HashMap<>();
//        return jdbc.query(SELECT_TAG,
//                params,
//                (rs, rowNum) -> new Set<String>(
//                        rs.getInt("article_id"),
//                        rs.getString("name")
//                ));
//    }

    public Set<String> getArticleByTag (int articleId){
        return null;
//        Map<String, Object> params = new HashMap<>();
//        params.put("article_id", articleId);
//        return jdbc.queryForObject(SELECT_TAG_BY_ARTICLE_ID,
//                params,
//                (rs, rowNum) -> new Set<String>(
//                        rs.getInt("id"),
//                        rs.getString("name")
//                ) {
//                });
    }
}
