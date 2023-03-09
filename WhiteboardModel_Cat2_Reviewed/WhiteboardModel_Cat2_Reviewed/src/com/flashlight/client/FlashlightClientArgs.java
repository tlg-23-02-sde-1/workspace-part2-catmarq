package com.flashlight.client;

import com.flashlight.Flashlight;

import java.util.Arrays;

/*
 * JR: incomplete and flawed.
 *
 * A check is done for less than 2 arguments, but the usage banner indicates three are needed:
 *  <brand> <lumen> <health>
 *
 * Nothing is done with the input arguments, and no Flashlight object is created,
 * which was the main objective of this client.
 *
 * If the user runs the application with your example arguments, there is simply no output.
 */
class FlashlightClientArgs {
    public static void main(String[] args) {
        if (args.length < 2) {
            String usage = "Usage: java FlashlightClientArgs <brand> <lumen> <health>";
            String example = "Example: java FlashlightClientArgs XHP90 160000 100";
            String note1 = "Health must be between" + Flashlight.MIN_HEALTH + " and " + Flashlight.MAX_HEALTH;
            System.out.println(usage + "\n" + example + "\n" + note1  );

        }
    }

}
