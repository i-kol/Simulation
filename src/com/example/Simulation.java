package com.example;

import com.example.actions.InitActions;
import com.example.actions.TurnActions;
import com.example.worldMap.WorldRenderer;

public class Simulation {
    protected static boolean isRunning = true;
    protected static boolean isPaused = false;

    static WorldRenderer renderer = new WorldRenderer();

    public void startSimulation() throws InterruptedException {
        InitActions.fillWorldMapWithEntities();
        renderer.render();

        while (isRunning) {
            if (!isPaused) {
                TurnActions.moveCreature();
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
        TurnActions.moveCreature();
        renderer.render();
    }

    public static void stopSimulation() {
        isRunning = false;
    }
}
