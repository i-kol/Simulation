package com.example;

import com.example.worldMap.WorldMap;
import com.example.worldMap.WorldSizeValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private final static String PAUSE = "1";
    private final static String CONTINUE = "2";
    private final static String ONE_MOVE = "3";
    private final static String STOP = "4";

    public static void showControlMenu() {
        System.out.println("Press:");
        System.out.printf("%s and \"Enter\" - to pause the simulation %n", PAUSE);
        System.out.printf("%s and \"Enter\" - to continue the simulation %n", CONTINUE);
        System.out.printf("%s and \"Enter\" - to make 1 move %n", ONE_MOVE);
        System.out.printf("%s and \"Enter\" - to stop the simulation and exit %n", STOP);
    }

    protected static void enterWorldMapSize() {
        WorldSizeValidator validator = new WorldSizeValidator();

        System.out.println("\nEnter world map size.\nNumber of rows: ");
        int rowNumber = validator.input();
        System.out.println("Enter number of columns: ");
        int columnNumber = validator.input();

        WorldMap.width = rowNumber;
        WorldMap.height = columnNumber;
    }

    protected static void controlSimulation() throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();

            switch (input) {
                case "1":
                    System.out.println("You have paused the simulation");
                    Simulation.pauseSimulation();
                    break;
                case "2":
                    System.out.println("You continued the simulation");
                    Simulation.continueSimulation();
                    break;
                case "3":
                    Simulation.nextTurn();
                    break;
                case "4":
                    System.out.println("You stop the simulation");
                    Simulation.stopSimulation();
                    return;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }
}
