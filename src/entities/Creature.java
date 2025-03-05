package entities;

import worldMap.Coordinates;

import java.util.List;

import static worldMap.Pathfinder.*;
import static worldMap.WorldMap.*;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;
    protected int actionPoint;

    public Creature(int speed, int health, int actionPoint) {
        this.speed = speed;
        this.health = health;
        this.actionPoint = actionPoint;
    }

    public void makeStep(Coordinates coordinates) {
        List<Coordinates> path = findPath(coordinates);

        if (!path.isEmpty() && actionPoint > 0) {
            removeEntity(coordinates);

            if (path.size() - 1 > speed) {
                setEntity(path.get(speed), this);
            } else {
                setEntity(path.get(path.size() - 2), this);
            }

            actionPoint--;
            System.out.println(getClass().getSimpleName() + " moved to the coordinate: [" + coordinates.getRowCount() + "," + coordinates.getColumnCount() + "]");

        } else {
            System.out.println(getClass().getSimpleName() + " cannot move because it cannot see the way");
        }
    }

    public <T> void senseTheTarget(Coordinates coordinates, Class<T> targetClass) {
        List<Coordinates> neighborCells = getNeighborCells(coordinates);

        for (Coordinates cell : neighborCells) {
            Object entity = getEntity(cell);

            if (targetClass.isInstance(entity) && actionPoint > 0) {
                attackTheTarget(cell);
                actionPoint--;
            }
        }
    }

    abstract void attackTheTarget(Coordinates coordinates);

    public abstract void makeMove(Coordinates coordinates);
}