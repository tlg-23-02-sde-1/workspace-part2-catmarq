/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

import static java.lang.Thread.interrupted;

public class MessagePrinter implements Runnable{
    private final String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print(message);
                    Thread.sleep(1000);
                }
                System.out.println("task complete");
                break;
            } catch (InterruptedException e) {
                System.out.println("I was sleeping when interrupted");
                break;
            }
        }
        System.out.println("perform cleanup");
    }
}