package entities;

import worldMap.Coordinates;

import static worldMap.WorldMap.getEntity;
import static worldMap.WorldMap.removeEntity;

public class Predator extends Creature {
    int attackStrength;
    public final static int PREDATOR_MAX_HEALTH = 40;
    public final static int PREDATOR_SPEED = 3; //2
    public final static int PREDATOR_ATTACK_STRENGTH = 10;

    public Predator(int speed, int health, int attackStrength, int actionPoint) {
        super(speed, health, actionPoint);
        this.attackStrength = attackStrength;
    }

    @Override
    void attackTheTarget(Coordinates coordinates) {
        Herbivore target = (Herbivore) getEntity(coordinates);

        if (health > (PREDATOR_MAX_HEALTH - PREDATOR_ATTACK_STRENGTH)) {
            health = PREDATOR_MAX_HEALTH;
        } else {
            health += PREDATOR_ATTACK_STRENGTH;
        }

        target.health = target.health - PREDATOR_ATTACK_STRENGTH;

        if (target.health > 0) {
            System.out.println(getClass().getSimpleName() + " attacked the Herbivore at: [" + coordinates.getRowCount() + "," + coordinates.getColumnCount() + "]");
            System.out.println("Herbivore health is: " + target.health + " points");
        } else {
            System.out.println(getClass().getSimpleName() + " ate the Herbivore at: [" + coordinates.getRowCount() + "," + coordinates.getColumnCount() + "]");
            removeEntity(coordinates);
        }
    }
}