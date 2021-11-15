package org.iesfm.shop.dao.configuration;

import org.iesfm.shop.dao.ArticleDAO;
import org.iesfm.shop.dao.inmemory.InMemoryArticleDAO;
import org.iesfm.shop.dao.jdbc.JDBCArticleDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DAOConfiguration {

    @Bean
    public ArticleDAO articleDAO (){
        return new InMemoryArticleDAO();
    }

    @Bean
    public JDBCArticleDAO jdbcArticleDAO (){
        return new JDBCArticleDAO();
    }

    @Bean
    public NamedParameterJdbcTemplate jdbc ( DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(
            @Value("${database.driver}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.user}") String user,
            @Value("${database.password}") String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
