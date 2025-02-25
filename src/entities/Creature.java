package entities;

import worldMap.Coordinates;

import java.util.List;

import static worldMap.Pathfinder.findPath;
import static worldMap.Pathfinder.getNeighborCells;
import static worldMap.WorldMap.*;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(Coordinates coordinates) {
        List<Coordinates> path = findPath(coordinates);

        if (!path.isEmpty()) {


            removeEntity(coordinates);
            if (path.size() > speed) {
                setEntity(path.get(speed), this);
            } else {
                setEntity(path.get(path.size() - 1), this);
            }
            System.out.println(getClass().getSimpleName() + " moved to the coordinate: [" + coordinates.getRowCount() + "," + coordinates.getColumnCount() + "]");
        } else {
            System.out.println(getClass().getSimpleName() + " cannot move because it cannot see the way");
        }
    }

    public <T> void senseTheTarget(Coordinates coordinates, Class<T> targetClass) {
        List<Coordinates> neighborCells = getNeighborCells(coordinates);

        for (Coordinates cell : neighborCells) {
            Object entity = getEntity(cell);
            if (targetClass.isInstance(entity)) {
                //T target = targetClass.cast(entity);
                attackTheTarget(cell);
            }
        }
    }

    abstract void attackTheTarget(Coordinates coordinates);
}