package stones;

import java.awt.*;

/**
 * Used to separate stones by their quality
 * If value of quality less, that stone is semiprecious
 * @author Svynar Viktor
 */
public class SemiPreciousStone extends Stone {
    public SemiPreciousStone(){super();}
    public SemiPreciousStone(Price price, Weight weight) {
        super(price, weight);
    }
    public SemiPreciousStone(Price price, Weight weight, Image image, String name, double transparency) {
        super(price, weight, image,name, transparency);
    }
    public SemiPreciousStone(Price price, Weight weight,  double transparency) {
        super(price, weight, transparency);
    }
}
