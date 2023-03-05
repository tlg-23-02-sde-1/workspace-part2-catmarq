package com.flashlight.client;

import com.flashlight.Flashlight;

import java.util.Arrays;

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
