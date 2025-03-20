package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.example.worldMap.WorldMap.mapHeight;
import static com.example.worldMap.WorldMap.mapWidth;

public class Menu {
    protected static void enterWorldMapSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter world map size.\nNumber of rows: ");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter number of columns: ");
        int columnNumber = scanner.nextInt();

        mapWidth = rowNumber;
        mapHeight = columnNumber;
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

    public static void showControlMenu() {
        System.out.println("""
                
                Press:
                "1" and "Enter" - to pause the simulation
                "2" and "Enter" - to continue the simulation
                "3" and "Enter" - to make 1 move
                "4" and "Enter" - to stop the simulation and exit
                """);
    }
}
