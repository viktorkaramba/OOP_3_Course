package stones;

import java.util.Comparator;

public class PriceComparator implements Comparator<Stone> {

    public int compare(Stone stone1, Stone stone2) {
        if (stone1.getPrice().getValue() == stone2.getPrice().getValue()) {
            return 0;
        }
        if (stone1.getPrice().getValue() > stone2.getPrice().getValue()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
