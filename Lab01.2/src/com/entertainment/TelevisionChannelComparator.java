package com.entertainment;

import java.util.Comparator;

public class TelevisionChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television T1, Television T2) {
        return Integer.compare(T1.getCurrentChannel(), T2.getCurrentChannel());
    }
}
