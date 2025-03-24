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
                Thread.sleep(1000);
            } else {
                Thread.sleep(100);
            }
        }
    }

    public static void pauseSimulation() {
        isPaused = true;
    }

    public static void continueSimulation() {
        isPaused = false;
    }

    public static void nextTurn() {
        pauseSimulation();
        moveCreature();
        renderer.render();
    }

    public static void stopSimulation() {
        isRunning = false;
    }
}
