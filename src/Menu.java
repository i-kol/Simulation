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

    protected static void simulationControl() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press: 1 - start/restart simulation, 2 - pause, 3 - continue, 4 - stop and exit");
        int option = scanner.nextInt();

        if (option == 1) {
            Simulation.flag = false;
        }

        scanner.close();

//        switch (option) {
//            case 1: simulation.start();
//                break;
//            case 2: simulation.sleep(5000);
//                break;
//            case 3: simulation.notify();
//                break;
//            case 4: simulation.join();
//            Simulation.flag = false;
//                break;
//            default:
//                System.out.println("Unknown command!\nPress: 1 - start/restart simulation, 2 - pause, 3 - continue, 4 - stop and exit");
//                break;
//        }
    }
}
