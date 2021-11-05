package cz.skoleni.helloworld;

import org.hsqldb.jdbc.JDBCDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainJdbcTemplate {

    public static void main(String[] args) throws SQLException {
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost/eshop");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> names = jdbcTemplate.queryForList("select name from item", String.class);
        for (String name : names) {
            System.out.println(name);
        }

        List<Item> items = jdbcTemplate.query("select * from item", (rs, rowNum) -> {
            Item item = new Item();
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            return item;
        });

        for (Item item : items) {
            System.out.println(item);
        }

    }

}
