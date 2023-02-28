package com.duckrace;

import java.util.List;

import static com.duckrace.Reward.*; // ok to use * for static imports

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer5 = new DuckRacer(5, "Chris");

        System.out.println(racer5);
        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);
        racer5.win(PRIZES);

        System.out.println(racer5);

//        // hey, I can cheat- I can just call getRewards(), get that List back and add()
//        List<Reward> rewards = racer5.getRewards();
//        rewards.add(PRIZES);
//        rewards.add(PRIZES);

        System.out.println(racer5);
    }
}