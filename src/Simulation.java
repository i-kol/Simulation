import worldMap.WorldMap;
import worldMap.WorldRenderer;

import static actions.InitActions.fillWorldMapWithEntities;
import static actions.TurnActions.moveCreature;

public class Simulation {
    public void startSimulation() {
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        fillWorldMapWithEntities();
        renderer.render();

        for (int i = 0; i < 10; i++) {
            moveCreature(worldMap);
            renderer.render();
        }
    }
}

// System.out.println("\033[H\033[2J");