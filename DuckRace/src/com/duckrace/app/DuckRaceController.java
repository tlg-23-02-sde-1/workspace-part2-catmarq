package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;
import static com.duckrace.Reward.*;

import java.util.Locale;
import java.util.Scanner;

//application controller- directs the overall flow of the application,
//and coordinates all user prompting. taking those inputs and passing
//them into the system
public class DuckRaceController {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);


    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter the following [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {     // now you can proceed
                validInput = true;

//                reward = ("D".equals(input)) ? Reward.DEBIT_CARD : Reward.PRIZES;  (This is cleaner than below)

                if ("D".equals(input)) {
                    reward = DEBIT_CARD;
                } else {
                    reward = PRIZES;
                }
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter id of the winner [1-14]: ");  // TODO: Don't hardcode the 14
            String input = scanner.nextLine().trim();  // blocks for input
            if (input.matches("\\d{1,2}")) {    // any digit, one or two times
                id = Integer.parseInt(input);         // now you can safely parseInt()
                if (id >= 1 && id <= 14) {
                    validInput = true;
                }
            }
        }
        return id;
    }
    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("Welcome to the Duck Race!!");
        System.out.println();
    }
}
