package stones;

import database.DBConnection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class NecklaceTest {

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
    void getStones() {
        Necklace necklace1 = new Necklace(stones);
        assertEquals(necklace1.getStones(), stones);
        for (int i = 0; i<necklace1.getStones().size(); i++){
            assertEquals(necklace1.getStones().get(i).getWeight().getValue(),stones.get(i).getWeight().getValue());
            assertEquals(necklace1.getStones().get(i).getPrice().getValue(),stones.get(i).getPrice().getValue());
            assertEquals(necklace1.getStones().get(i).getName(),stones.get(i).getName());
            assertEquals(necklace1.getStones().get(i).getImage(),stones.get(i).getImage());
        }
    }

    @Test
    void setStones() {
        Necklace necklace = new Necklace();
        necklace.setStones(stones);
        assertEquals(necklace.getStones(), stones);
        for (int i = 0; i<necklace.getStones().size(); i++){
            assertEquals(necklace.getStones().get(i).getWeight().getValue(),stones.get(i).getWeight().getValue());
            assertEquals(necklace.getStones().get(i).getPrice().getValue(),stones.get(i).getPrice().getValue());
            assertEquals(necklace.getStones().get(i).getName(),stones.get(i).getName());
            assertEquals(necklace.getStones().get(i).getImage(),stones.get(i).getImage());
        }
    }

    @Test
    void addStone() {
        Necklace necklace = new Necklace();
        for (int i = 0; i<necklace.getStones().size(); i++){
           necklace.addStone(stones.get(i));
        }
        for (int i = 0; i<necklace.getStones().size(); i++){
            assertEquals(necklace.getStones(),stones);
        }
    }

    @Test
    void generalWeight() {
        Necklace necklace1 = new Necklace(stones);
        assertEquals(necklace1.generalWeight().getValue(), 226);
    }

    @Test
    void generalPrice() {
        Necklace necklace1 = new Necklace(stones);
        assertEquals(necklace1.generalPrice().getValue(),1195415);
    }

    @Test
    void sortByPrice() {
        Necklace necklace = new Necklace(stones);
        necklace.sortByPrice();
        double price =necklace.getStones().get(0).getPrice().getValue();
        for (int i = 0; i<necklace.getStones().size(); i++){
            assertTrue(price <= necklace.getStones().get(i).getPrice().getValue());
            price = necklace.getStones().get(i).getPrice().getValue();
        }
    }

    @Test
    void searchByRange() {
        Necklace necklace = new Necklace(stones);
        Vector<Stone> rangeStones = new Vector<Stone>(necklace.searchByRange(0.2,0.6));
        for(int i = 0; i<necklace.searchByRange(0.2,0.6).size(); i++) {
            assertEquals(necklace.searchByRange(0.2, 0.6),rangeStones);
        }
    }
}