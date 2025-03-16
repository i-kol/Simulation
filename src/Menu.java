import java.io.IOException;
import java.util.Scanner;

import static worldMap.WorldMap.mapHeight;
import static worldMap.WorldMap.mapWidth;

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
        int key = System.in.read();

        if (key == '1') {
            System.out.println("You stop the simulation");
            Simulation.stopSimulation();
        }

        if (key == '2') {
            System.out.println("You have paused the simulation");
            Simulation.pauseSimulation();
        }

        if (key == '3') {
            System.out.println("Move number " + 5 + " is done");
            Simulation.nextTurn();
        }
    }
}
