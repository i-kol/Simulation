package actions;

import entities.*;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.HashMap;
import java.util.Map;

import static worldMap.WorldMap.*;
import static worldMap.WorldMap.getEntity;

public class TurnActions {

    public static boolean isCellAvailableForMove(Coordinates coordinates) {
        return isCellOnWorldMap(coordinates) && (isCellEmpty(coordinates) || getEntity(coordinates) instanceof Grass || getEntity(coordinates) instanceof Herbivore);
    }

    public static void moveCreature(WorldMap worldMap) {
        HashMap<Coordinates, Entity> updatedWorldMap = new HashMap<>(WorldMap.worldMap);
        for (Map.Entry<Coordinates, Entity> entry : updatedWorldMap.entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Creature) {
                //мы перебрали всю копию карты, ищем там все сущности entity, и если очередная сущность Creature,
                //то получаем ее координаты и делаем ход makeMove
                Coordinates coordinates = entry.getKey();
                ((Creature) entity).makeMove(coordinates);
            }
        }
    }
}
