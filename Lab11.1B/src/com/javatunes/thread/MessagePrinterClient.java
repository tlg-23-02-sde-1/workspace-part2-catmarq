/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // TODO: create two instances of your thread subclass and start them up
        MessagePrinter printer1 = new MessagePrinter("I am Running");
        Thread thd1 = new Thread(printer1, "P1");
        thd1.start();

        MessagePrinter printer2 = new MessagePrinter("Me too");
        Thread thd2 = new Thread(printer2, "P2");
        thd2.start();
    }
}