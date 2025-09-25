package com.example.worldMap;

import java.util.Scanner;

public class WorldSizeValidator {
    protected final static int MIN_SIZE = 5;
    protected final static int MAX_SIZE = 100;
    protected final static String TITLE = String.format("Enter a number from %s to %s %n", MIN_SIZE, MAX_SIZE);
    protected final static String ERROR = "Invalid value! Please try again";
    protected final Scanner scanner = new Scanner(System.in);

    private void showTitle() {
        System.out.println(TITLE);
    }

    private void showError() {
        System.out.println(ERROR);
    }

    public int input() {
        while (true) {
            showTitle();
            String input = scanner.nextLine();

            if (isTypeValid(input)) {
                int result = parseInput(input);

                if (isAllowed(result)) {
                    return result;
                }
            }
            showError();
        }
    }

    private boolean isTypeValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int parseInput(String input) {
        return Integer.parseInt(input);
    }

    private boolean isAllowed(int result) {
        return result >= MIN_SIZE && result <= MAX_SIZE;
    }
}
