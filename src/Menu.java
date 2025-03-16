import java.io.IOException;
import java.util.Scanner;

import static worldMap.WorldMap.mapHeight;
import static worldMap.WorldMap.mapWidth;

public class Menu {
    protected static void enterWorldMapSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter world map size. Number of rows: ");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter number of columns: ");
        int columnNumber = scanner.nextInt();

        mapWidth = rowNumber;
        mapHeight = columnNumber;
    }

    protected static void abortSimulation(Thread thread) throws IOException, InterruptedException {
        int key = System.in.read();
        if (key == '1') {
            System.out.println("You stop the simulation");
            thread.wait();
            //Simulation.flag = false;
        }
    }
}
