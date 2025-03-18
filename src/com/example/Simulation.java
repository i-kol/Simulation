package com.example;

import com.example.worldMap.WorldRenderer;

import static com.example.actions.InitActions.fillWorldMapWithEntities;
import static com.example.actions.TurnActions.moveCreature;

public class Simulation {
    protected static boolean isRunning = true;
    protected static boolean isPaused = false;

    static WorldRenderer renderer = new WorldRenderer();

    public void startSimulation() throws InterruptedException {
        fillWorldMapWithEntities();
        renderer.render();

        while (isRunning) {
            if (!isPaused) {
                moveCreature();
                renderer.render();
                System.out.println("\033[H\033[2J");
                Thread.sleep(1000);
            }
        }
    }

    public static void pauseSimulation() throws InterruptedException {
        isPaused = true;
    }

    public static void continueSimulation() throws InterruptedException {
        isPaused = false;
    }

    public static void nextTurn() throws InterruptedException {
        pauseSimulation();
        moveCreature();
        renderer.render();
        System.out.println("\033[H\033[2J");
    }


    public static void stopSimulation() {
        isRunning = false;
    }
}
