package com.example.entities;

import com.example.worldMap.Coordinates;

import static com.example.entities.Grass.GRASS_HEALTH_RECOVER;
import static com.example.worldMap.WorldMap.removeEntity;

public class Herbivore extends Creature {
    public final static int HERBIVORE_MAX_HEALTH = 25;
    public final static int HERBIVORE_SPEED = 2;

    public Herbivore(int speed, int health, int actionPoint) {
        super(speed, health, actionPoint);
    }

    @Override
    void attackTheTarget(Coordinates coordinates) {
        removeEntity(coordinates);
        if (health > (HERBIVORE_MAX_HEALTH - GRASS_HEALTH_RECOVER)) {
            health = HERBIVORE_MAX_HEALTH;
        } else {
            health += GRASS_HEALTH_RECOVER;
        }
        System.out.println(getClass().getSimpleName() + " ate the Grass at: [" + coordinates.getRowCount() + "," + coordinates.getColumnCount() + "]");
        System.out.println("Herbivore health is: " + health + " points");
    }
}