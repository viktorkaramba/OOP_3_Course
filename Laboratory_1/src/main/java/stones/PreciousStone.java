package stones;

import stones.Price;
import stones.Stone;
import stones.Weight;

import java.awt.*;


public class PreciousStone extends Stone {

    public PreciousStone(Price price, Weight weight) {
        super(price, weight);
    }
    public PreciousStone(Price price, Weight weight, Image image, String name, double transparency) {
        super(price, weight, image,name, transparency);
    }

}
