import worldMap.WorldMap;
import worldMap.WorldRenderer;

public class Simulation {
    public void startSimulation() {
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        worldMap.fillWorldMapWithEntities();

        for (int i = 0; i < 10; i++) {
            try {

                renderer.render(worldMap);
                worldMap.moveCreature(worldMap);
                Thread.sleep(50);

//                System.out.println("\033[H\033[2J");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
