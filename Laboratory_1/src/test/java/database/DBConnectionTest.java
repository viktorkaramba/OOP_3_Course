package database;

import org.junit.jupiter.api.Test;
import stones.Necklace;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {

    @Test
    void connect() {

    }

    @Test
    void readInfo() {
        DBConnection a = new DBConnection();
        a.readInfo();
        Necklace necklace = new Necklace(a.readInfo());
        for(int i =0; i<necklace.getStones().size(); i++){
            assertTrue(necklace.getStones().get(i).getPrice().getValue()>= 10000);
        }
    }
}