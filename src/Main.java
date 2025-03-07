
public class Main {
    public static void main(String[] args){
        Menu.enterWorldMapSize();
        Simulation simulation = new Simulation();

        Thread simulationThread = new Thread(() ->
        {
            try {
                simulation.startSimulation();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread menuThread = new Thread(() ->
        {
            try {
                Menu.simulationControl();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        simulationThread.start();
        menuThread.start();
    }
}