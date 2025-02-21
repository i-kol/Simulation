import worldMap.WorldMap;
import worldMap.WorldRenderer;

public class Simulation {
    public void startSimulation() {
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        worldMap.fillWorldMapWithEntities();
        renderer.render(worldMap);

        for (int i = 0; i < 8; i++) {
            worldMap.moveCreature(worldMap);
            renderer.render(worldMap);
        }
    }
}

// System.out.println("\033[H\033[2J");