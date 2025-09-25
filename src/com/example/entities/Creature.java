package com.example.entities;

import com.example.worldMap.Coordinates;
import com.example.worldMap.Pathfinder;
import com.example.worldMap.WorldMap;

import java.util.List;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;
    protected int actionPoint;

    public Creature(int speed, int health, int actionPoint) {
        this.speed = speed;
        this.health = health;
        this.actionPoint = actionPoint;
    }

    abstract void attackTheTarget(Coordinates coordinates);

    public <T> void senseTheTarget(Coordinates coordinates, Class<T> targetClass) {
        List<Coordinates> neighborCells = Pathfinder.getNeighborCells(coordinates);

        for (Coordinates cell : neighborCells) {
            Entity entity = WorldMap.getEntity(cell);

            if (targetClass.isInstance(entity) && actionPoint > 0) {
                attackTheTarget(cell);
                actionPoint--;
            }
        }
    }

    public void makeStep(Coordinates coordinates) {
        List<Coordinates> path = Pathfinder.findPath(coordinates);

        if (!path.isEmpty() && actionPoint > 0) {
            WorldMap.removeEntity(coordinates);

            if (path.size() - 1 > speed) {
                WorldMap.setEntity(path.get(speed), this);
            } else {
                WorldMap.setEntity(path.get(path.size() - 2), this);
            }

            actionPoint--;
            System.out.println(getClass().getSimpleName() + " moved to the coordinate: [" + coordinates.getRow() + "," + coordinates.getColumn() + "]");

        } else {
            System.out.println(getClass().getSimpleName() + " cannot move because it cannot see the way");
        }
    }

    public void makeMove(Coordinates coordinates) {
        actionPoint++;

        if (this instanceof Herbivore) {
            senseTheTarget(coordinates, Grass.class);
        } else if (this instanceof Predator) {
            senseTheTarget(coordinates, Herbivore.class);
        } else {
            System.out.println("Unknown type of creature");
        }

        if (actionPoint > 0) {
            makeStep(coordinates);
        }
    }
}