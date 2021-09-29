package stones;

import java.awt.*;

/**
 * Used to separate stones by their quality
 * If value of quality bigger, that stone is precious
 * @author Svynar Viktor
 */
public class PreciousStone extends Stone {
    public PreciousStone(){super();}
    public PreciousStone(Price price, Weight weight) {
        super(price, weight);
    }
    public PreciousStone(Price price, Weight weight, Image image, String name, double transparency) {
        super(price, weight, image,name, transparency);
    }
    public PreciousStone(Price price, Weight weight,  double transparency) {
        super(price, weight, transparency);
    }
}
