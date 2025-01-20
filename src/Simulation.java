import WorldMap.WorldMap;
import WorldMap.WorldRenderer;



public class Simulation {
    public void startSimulation(){
        WorldMap worldMap = new WorldMap();
        WorldRenderer renderer = new WorldRenderer();
        worldMap.fillWorldMapWithEntities();
        for (int i = 0; i < 10; i++) {
            renderer.render(worldMap);
            worldMap.moveCreature(worldMap);
//            try {
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
//        renderer.render(worldMap);
//        System.out.println("_________________________________");
//        worldMap.moveCreature(worldMap);
//        System.out.println("_________________________________");
//        renderer.render(worldMap);
    }
}
