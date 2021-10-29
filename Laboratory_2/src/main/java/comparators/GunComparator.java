package comparators;

import gun.Gun;

import java.util.Comparator;

public class GunComparator implements Comparator<Gun> {

    @Override
    public int compare(Gun o1, Gun o2) {
        TTCComparator ttcComparator = new TTCComparator();
        if (ttcComparator.compare(o1.getTTC(), o2.getTTC()) == 0) {
            return 0;
        }
        if (ttcComparator.compare(o1.getTTC(), o2.getTTC()) == 1) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
