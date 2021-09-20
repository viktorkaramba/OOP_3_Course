package stones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest extends StoneTest{

    @Test
    void getValue() {
        assertEquals(stone1.getWeight().getValue(), weight1.getValue());
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