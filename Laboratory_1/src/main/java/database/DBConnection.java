package database;


import stones.Necklace;
import stones.Price;
import stones.Stone;
import stones.Weight;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DBConnection extends JFrame{
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

    public Necklace readInfo(){
        Connection connect = DBConnection.connect();
        Statement statement = null;
        Necklace necklace = new Necklace();
        try {
            String sql = "SELECT * FROM Rocks";
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Image image;
            byte[] imageBytes;
            while (resultSet.next()){
                String name = resultSet.getString("Name");
                Price price = new Price(resultSet.getDouble("Price"));
                Weight weight = new Weight(resultSet.getInt("Weight"));
                imageBytes = resultSet.getBytes(4);
                image = getToolkit().createImage(imageBytes);
                ImageIcon icon = new ImageIcon(image);
                Stone stone = new Stone(price,weight,image,name);
                if(stone.GetPrice().GetValue()>=10000) {
                    necklace.addStone(stone);
                }
                System.out.println("Name " + name+ " Price " + price.GetValue()+ " Weight " + weight.GetValue());
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return necklace;
    }

}
