import worldMap.WorldRenderer;

import static actions.InitActions.fillWorldMapWithEntities;
import static actions.TurnActions.moveCreature;

public class Simulation {
    protected static boolean flag = true;

    static WorldRenderer renderer = new WorldRenderer();

    public void startSimulation() throws InterruptedException {
        fillWorldMapWithEntities();
        renderer.render();

        while (flag){
            moveCreature();
            renderer.render();
            System.out.println("\033[H\033[2J");
            Thread.sleep(1000);
        }
    }

    public static void stopSimulation() {
        flag = false;
    }

    public static void pauseSimulation() throws InterruptedException {
Thread.currentThread().wait();
    }

    public static void nextTurn() throws InterruptedException {
        pauseSimulation();
        moveCreature();
        renderer.render();
        System.out.println("\033[H\033[2J");
    }
}
