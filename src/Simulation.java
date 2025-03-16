import worldMap.WorldRenderer;

import static actions.InitActions.fillWorldMapWithEntities;
import static actions.TurnActions.moveCreature;

public class Simulation {
    protected static boolean flag = true;
    WorldRenderer renderer = new WorldRenderer();

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

    public void pauseSimulation() {

    }
}
