package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

public class TelevisionClient {
    public static void main(String[] args) {
//        Television tv1 = new Television();
//        Television tv2 = new Television("RCA", 10);
//        System.out.println(tv1);
//        System.out.println(tv2);
//
//        tv2.changeChannel(7);
//        System.out.println(tv2);
//        System.out.println();

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        System.out.println("tvA == tvB: "   + (tvA == tvB));        // always false
        System.out.println("tvA.equals(tvB): "  + tvA.equals(tvB)); // true now

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        // Let's create a set<Televisions> and see what happens
        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);   // should be rejected as a duplicate

        // the size of the set should be 1
        System.out.println("The size of the Set is: " + tvs.size());

    }
}