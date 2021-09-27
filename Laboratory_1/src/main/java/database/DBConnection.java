package database;


import stones.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

/**
 * Using to connect database with app
 * @author Svynar Viktor
 */
public class DBConnection extends JFrame{

    /** Static function that connects to the database*/
    public static Connection connect(){
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Laboratory_1/src/main/resources/Stones.db");
            System.out.println("Yes!!");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
        return connect;
    }

    /** Used to retrieve data from the database*/
    public Vector<Stone> readInfo(){
        Connection connect = DBConnection.connect();
        Statement statement = null;
        Vector<Stone> stones = new Vector<Stone>();
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
                double transparency = resultSet.getDouble("Transparency");
                imageBytes = resultSet.getBytes(5);
                image = getToolkit().createImage(imageBytes);
                ImageIcon icon = new ImageIcon(image);
                if(getQualityFactor(price,weight,transparency) > 300){
                    PreciousStone preciousStone = new PreciousStone(price, weight, image, name, transparency);
                    stones.add(preciousStone);
                }
                else {
                    SemiPreciousStone semiPreciousStone = new SemiPreciousStone(price, weight, image, name, transparency);
                    stones.add(semiPreciousStone);
                }
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return stones;
    }

    /** Used to count quality of a stone*/
    public double getQualityFactor(Price price, Weight weight, double transparency){
        double oneCarat = price.getValue()/weight.getValue();
        double weight_ = weight.getValue();
        while(weight_>1){
            oneCarat*=1.5;
            weight_--;
        }
        oneCarat*=transparency;
        return oneCarat;
    }

}
