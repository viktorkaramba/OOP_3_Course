package stones;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceTest extends StoneTest{

    @Test
    public void getValue() {
        assertEquals(stone1.getPrice().getValue(),price1.getValue());
    }

    @Test
    public void setValue() {
        Price price = new Price();
        float value = 2000;
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