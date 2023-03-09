/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

import static java.lang.Thread.interrupted;

public class MessagePrinter extends Thread{
    private final String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    /**
     * TODO: implement run() as follows:
     * It should loop 10 times, printing the 'message' field to stdout,
     * then pausing for some interval (in millis) that you choose.
     * <p>
     * Use a try/catch to call Thread.sleep(interval) for the pause.
     * The sleep() method throws InterruptedException, which you need to catch.
     * You can either leave the catch block empty, or print the exception to stdout.
     */
    public void run() {
        while (!interrupted()) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print(message);
                    Thread.sleep(3000);
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