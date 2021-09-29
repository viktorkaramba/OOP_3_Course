package stones;

import database.DBConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
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
    public void getValue() {
       assertEquals(stones.get(0).getPrice().getValue(), 900);
    }

    @Test
    public void setValue() {
        Price price = new Price();
        double value = 2000;
        price.setValue(value);
        assertEquals(price.getValue(),value);
    }

    @Test
    public void sum() {
        Price price = new Price(2000);
        price.sum(1000);
        assertEquals(price.getValue(),3000);
    }
}