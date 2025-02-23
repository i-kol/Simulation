package entities;

import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.List;

import static worldMap.Pathfinder.findPath;
import static worldMap.WorldMap.setEntity;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(WorldMap worldMap, Coordinates coordinates) {

        List<Coordinates> path = findPath(worldMap, coordinates);

        if (!path.isEmpty()) {
            worldMap.removeEntity(coordinates, this);
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
}