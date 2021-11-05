package cz.skoleni.helloworld;

import org.hsqldb.jdbc.JDBCDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

        System.out.println("*********************");

        // 1. zpusob
//        for (Item item : items) {
//            System.out.println(item);
//        }

        // 2. zpusob
//        items.forEach(new ItemPrintConsumer());

        // 3. zpusob
//        items.forEach(new Consumer<Item>() {
//            @Override
//            public void accept(Item item) {
//                System.out.println(item);
//            }
//        });

        // 4. zpusob: Lambda (od Java 8), funguje pro tzv. funkcionalni interfacy
        // Co je fun. interface? Interface, ktery obsahuje PRAVE JEDNU ABSTRAKTNI METODU!!!
//        items.forEach((Item item) -> {
//            System.out.println(item);
//        });

//        items.forEach((item) -> {
//            System.out.println(item);
//        });

//        items.forEach(item -> {
//            System.out.println(item);
//        });

        // Nejjednodussi lambda:
        items.forEach(item -> System.out.println(item));

        // 5. Method reference:
        items.forEach(System.out::println);

    }

}

// 2. zpusob
//class ItemPrintConsumer implements Consumer<Item> {
//
//    @Override
//    public void accept(Item item) {
//        System.out.println(item);
//    }
//}