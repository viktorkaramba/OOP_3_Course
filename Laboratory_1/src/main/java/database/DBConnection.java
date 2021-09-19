package database;


import stones.Price;
import stones.Stone;
import stones.Weight;

import java.sql.*;

public class DBConnection {
    public static Connection connect(){
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Rocks.db");
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
                Price price = new Price(resultSet.getDouble("Price"));
                Weight weight = new Weight(resultSet.getInt("Weight"));
                Stone stone = new Stone(price,weight,name);
                System.out.println("Name " + name+ " Price " + price.GetValue()+ " Weight " + weight.GetValue());
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

}
