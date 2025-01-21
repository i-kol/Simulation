import WorldMap.WorldMap;
import WorldMap.WorldRenderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Simulation {
    public void startSimulation() {
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        worldMap.fillWorldMapWithEntities();
        for (int i = 0; i < 10; i++) {
            renderer.render(worldMap);

            worldMap.moveCreature(worldMap);
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }


        }
    }
}
