package cz.skoleni.helloworld;

import org.hsqldb.jdbc.JDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainJdbc {

    public static void main(String[] args) throws SQLException {
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost/eshop");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        Connection connection = dataSource.getConnection();

        String sql = "select * from item";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Item> items = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item();
            item.setName(resultSet.getString("name"));
            item.setPrice(resultSet.getDouble("price"));
            items.add(item);
        }
        statement.close();

        for (Item item : items) {
            System.out.println(item);
        }
    }

}
