package stones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest extends StoneTest{

    @Test
    void compare() {
        PriceComparator myPriceComparator = new PriceComparator();
        assertEquals(myPriceComparator.compare(stone1,stone2),1);
    }
}