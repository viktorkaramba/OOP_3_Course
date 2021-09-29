package stones;

import database.DBConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {
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
    void compare() {
        PriceComparator myPriceComparator = new PriceComparator();
        assertEquals(myPriceComparator.compare(stones.get(6),stones.get(8)),0);
        assertEquals(myPriceComparator.compare(stones.get(1),stones.get(2)),-1);
        assertEquals(myPriceComparator.compare(stones.get(10),stones.get(11)),1);
    }
}