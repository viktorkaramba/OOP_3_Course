package comparators;

import gun.Gun;

import java.util.Comparator;

public class TTCComparator implements Comparator<Gun.TTC> {
    @Override
    public int compare(Gun.TTC o1, Gun.TTC o2) {
        if (o1.getSightingRange().compareTo(o2.getSightingRange()) == 0) {
            return 0;
        }
        if (o1.getSightingRange().compareTo(o2.getSightingRange()) == 1) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
