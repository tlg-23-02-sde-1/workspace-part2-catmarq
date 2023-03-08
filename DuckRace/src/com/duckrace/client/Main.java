package com.duckrace.client;

import com.duckrace.app.DuckRaceController;

/*
 * Application main class
 * instanciate and say go
 */
class Main {

    public static void main(String[] args) {
        DuckRaceController app = new DuckRaceController();
        app.execute();
    }

}
