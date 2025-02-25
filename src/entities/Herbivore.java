package entities;

import worldMap.Coordinates;

import static entities.Grass.GRASS_HEALTH_RECOVER;
import static worldMap.WorldMap.removeEntity;

public class Herbivore extends Creature {
    public final static int HERBIVORE_MAX_HEALTH = 20;
    public final static int HERBIVORE_SPEED = 1;

    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    void attackTheTarget(Coordinates coordinates) {
        removeEntity(coordinates);
        if (health > (HERBIVORE_MAX_HEALTH - GRASS_HEALTH_RECOVER)) {
            health = HERBIVORE_MAX_HEALTH;
        }
        health += GRASS_HEALTH_RECOVER;
    }
}