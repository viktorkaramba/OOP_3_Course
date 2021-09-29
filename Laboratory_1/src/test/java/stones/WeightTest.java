package stones;

import database.DBConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {
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
    void getValue() {
        assertEquals(stones.get(1).getWeight().getValue(), 3);
    }

    @Test
    void setValue() {
        Weight weight = new Weight();
        int value = 5;
        weight.setValue(value);
        assertEquals(weight.getValue(),value);
    }

    @Test
    void sum() {
        Weight weight = new Weight(5);
        weight.sum(5);
        assertEquals(weight.getValue(),10);
    }
}