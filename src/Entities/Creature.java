package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;

import static WorldMap.WorldMap.MAP_HEIGHT;
import static WorldMap.WorldMap.MAP_WIDTH;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    abstract void makeMove(WorldMap worldMap, Coordinates coordinates);

    public boolean isSquareAvailableForMove(Coordinates coordinates, WorldMap worldMap) {
        return worldMap.getEntity(coordinates) == null && coordinates.getRowCount() < MAP_WIDTH
                && coordinates.getRowCount() >= 0 && coordinates.getColumnCount() <
                MAP_HEIGHT && coordinates.getColumnCount() >= 0;
    }
}