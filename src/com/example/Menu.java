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
//            System.out.println("Введите команду (1 - пауза, 2 - продолжить, 3 - следующий ход, 4 - остановить):");
            String input = reader.readLine();  // считываем строку

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
                    System.out.println("Move number " + " is done");
                    Simulation.nextTurn();
                    break;
                case "4":
                    System.out.println("You stop the simulation");
                    Simulation.stopSimulation();
                    return; // выход из метода, если нужно завершить
                default:
                    System.out.println("Неверная команда");
            }
        }
    }

//    protected static void controlSimulation() throws IOException, InterruptedException {
//        int key = System.in.read();
//
//        if (key == '1') {
//            System.out.println("You have paused the simulation");
//            Simulation.pauseSimulation();
//        }
//
//        if (key == '2') {
//            System.out.println("You continued the simulation");
//            Simulation.continueSimulation();
//        }
//
//        if (key == '3') {
//            System.out.println("Move number " + 5 + " is done");
//            Simulation.nextTurn();
//        }
//
//        if (key == '4') {
//            System.out.println("You stop the simulation");
//            Simulation.stopSimulation();
//        }
//    }

    public static void showControlMenu() {
        System.out.println("""
                
                Press:
                "1" - to pause the simulation
                "2" - to continue the simulation
                "3" - to make 1 move
                "4" - to stop the simulation and exit
                """);
    }
}
