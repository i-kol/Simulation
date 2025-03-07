import worldMap.WorldRenderer;

import static actions.InitActions.fillWorldMapWithEntities;
import static actions.TurnActions.moveCreature;

public class Simulation {
    protected static boolean flag = true;

    public void startSimulation() throws InterruptedException {
        WorldRenderer renderer = new WorldRenderer();
        fillWorldMapWithEntities();
        renderer.render();

        while (flag){
            moveCreature();
            renderer.render();
            System.out.println("\033[H\033[2J");
            Thread.sleep(1000);
        }
    }
}
