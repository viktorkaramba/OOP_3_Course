package stones;

import database.DBConnection;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;



class StoneTest {

    public static Vector<Stone> stones = new Vector<>();


    @BeforeAll
    public static void connectDB(){
        DBConnection db = new DBConnection();
        stones.addAll(db.readInfo());
    }

    @AfterAll
    public static  void closeDB(){
        stones.clear();
    }

    @Test
    void getWeight() {
        assertEquals(stones.get(1).getWeight().getValue(),3);
    }

    @Test
    void getPrice() {
        assertEquals(stones.get(1).getPrice().getValue(),4600);
    }

    @Test
    void setWeight() {
        Stone stone = new PreciousStone();
        stone.setWeight(stones.get(3).getWeight());
        assertEquals(stone.getWeight().getValue(),2);
    }

    @Test
    void setPrice() {
        Stone stone = new PreciousStone();
        stone.setPrice(stones.get(3).getPrice());
        assertEquals(stone.getPrice().getValue(),4000);
    }

    @Test
    void getImage() {
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        Image image = chainAdditional.getImage();
        Stone stone = new PreciousStone();
        stone.setImage(image);
        assertEquals(stone.getImage(),image);
    }

    @Test
    void setImage() {
        ImageIcon chainAdditional = new ImageIcon("src/main/resources/chain.png");
        Image image = chainAdditional.getImage();
        Stone stone = new PreciousStone();
        stone.setImage(image);
        assertEquals(stone.getImage(),image);
    }

    @Test
    void getName() {
        Stone stone = new PreciousStone();
        assertEquals(stone.getName(),"Unknown");
    }

    @Test
    void setName() {
        Stone stone = new PreciousStone();
        stone.setName("Ruby");
        assertEquals(stone.getName(),"Ruby");
    }

    @Test
    void getTransparency() {
        assertEquals(stones.get(3).getTransparency(),0.5);
        assertEquals(stones.get(8).getTransparency(),0.8);
    }

    @Test
    void setTransparency() {
        Stone stone = new PreciousStone();
        stone.setTransparency(0.3);
        assertEquals(stone.getTransparency(),0.3);
    }
}