import WorldMap.WorldMap;
import WorldMap.WorldRenderer;



public class Simulation {
    public void startSimulation(){
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        worldMap.fillWorldMapWithEntities(worldMap.chooseNumberOfCreaturesByMapSize());
        renderer.render(worldMap);
        System.out.println("_________________________________");
        worldMap.moveCreature(worldMap);
        renderer.render(worldMap);
    }
}
