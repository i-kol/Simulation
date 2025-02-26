package entities;

import worldMap.Coordinates;

import static worldMap.WorldMap.getEntity;
import static worldMap.WorldMap.removeEntity;

public class Predator extends Creature {
    int attackStrength;
    public final static int PREDATOR_MAX_HEALTH = 40;
    public final static int PREDATOR_SPEED = 2;
    public final static int PREDATOR_ATTACK_STRENGTH = 10;

    public Predator(int speed, int health, int attackStrength) {
        super(speed, health);
        this.attackStrength = attackStrength;
    }

    @Override
    void attackTheTarget(Coordinates coordinates) {
        removeEntity(coordinates);
//        health.getEntity(coordinates);
        if (health > (PREDATOR_MAX_HEALTH - PREDATOR_ATTACK_STRENGTH)) {
            health = PREDATOR_MAX_HEALTH;
        }
        health += PREDATOR_ATTACK_STRENGTH;
    }

    @Override
    public void makeMove(Coordinates coordinates) {
        makeStep(coordinates);
        senseTheTarget(coordinates, Herbivore.class);
    }
}