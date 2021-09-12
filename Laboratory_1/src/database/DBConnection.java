package database;

import java.sql.*;

public class DBConnection {
    public static Connection connect(){
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Rocks.db");
            System.out.println("Yes!!");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
        return connect;
    }

    public static void readInfo(){
        Connection connect = DBConnection.connect();
        Statement statement = null;
        try {
            String sql = "SELECT * FROM Rocks";
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("Name");
                int price = resultSet.getInt("Price");
                int weight = resultSet.getInt("Weight");
                System.out.println("Name " + name+ " Price " + price+ " Weight " + weight);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
