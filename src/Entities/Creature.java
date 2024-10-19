package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;

import java.util.HashSet;
import java.util.Set;

import static WorldMap.WorldRenderer.GROUND;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    abstract void makeMove(WorldMap worldMap, Coordinates coordinates);

    public boolean isSquareAvailableForMove(Coordinates coordinates, WorldMap worldMap) {
        return (worldMap.getEntity(coordinates).toString()).equals(GROUND);
    }
}
