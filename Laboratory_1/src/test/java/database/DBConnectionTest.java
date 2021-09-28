package database;

import org.junit.jupiter.api.Test;
import stones.Necklace;
import stones.Stone;
import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {

    @Test
    void connect() {

    }

    @Test
    void readInfo() {
        DBConnection a = new DBConnection();
        Necklace necklace = new Necklace(a.readInfo());
        for(Stone s: necklace.getStones()) {
            assertTrue(s instanceof Stone);
        }
        assertTrue(necklace.getStones().size() == 20);
    }
}