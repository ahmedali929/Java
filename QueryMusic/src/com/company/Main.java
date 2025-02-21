package com.company;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Properties props = new Properties();
        try{
            props.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an Album Name: ");
        String artistId = scanner.nextLine();
        int artistid = Integer.parseInt(artistId);
        String query = "SELECT * FROM music.artists WHERE artist_id = %d".formatted(artistid);

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(props.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(props.getProperty("port")));
        dataSource.setDatabaseName(props.getProperty("databaseName"));


        try (var connection  = dataSource.getConnection(props.getProperty("user"),System.getenv("MYSQL_PASS"));
             Statement statement = connection.createStatement();
             ) {
                ResultSet resultSet = statement.executeQuery(query);

                var meta = resultSet.getMetaData();

                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
                }

                while(resultSet.next()) {
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        System.out.printf("%-15s", resultSet.getString(i));
                    }
                    System.out.println();
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
