import WorldMap.WorldMap;
import WorldMap.WorldRenderer;



public class Simulation {
    public void startSimulation(){
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        worldMap.fillWorldMapWithEntities();
        renderer.render(worldMap);
        System.out.println("_________________________________");
        worldMap.moveCreature(worldMap);
        System.out.println("_________________________________");
        renderer.render(worldMap);
    }
}
