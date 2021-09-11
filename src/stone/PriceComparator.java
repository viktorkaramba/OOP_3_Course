package stone;

import java.util.Comparator;

public class PriceComparator implements Comparator<Stone> {

    public int compare(Stone stone1, Stone stone2) {
        if (stone1.GetPrice().GetValue() == stone2.GetPrice().GetValue()) {
            return 0;
        }
        if (stone1.GetPrice().GetValue() > stone2.GetPrice().GetValue()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
