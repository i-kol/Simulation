package com.example.actions;

import com.example.entities.*;
import com.example.worldMap.Coordinates;
import com.example.worldMap.WorldMap;

import java.util.HashMap;
import java.util.Map;

public class TurnActions {

    private static int moveCounter = 1;

    public static boolean isCellAvailableForMove(Coordinates coordinates) {
        return WorldMap.isCellOnWorldMap(coordinates) && (WorldMap.isCellEmpty(coordinates));
    }

    public static int getMoveCounter() {
        return moveCounter;
    }

    public static void moveCreature() {
        HashMap<Coordinates, Entity> updatedWorldMap = new HashMap<>(WorldMap.entities);
        System.out.println("Move number " + getMoveCounter() + "\n");

        for (Map.Entry<Coordinates, Entity> entry : updatedWorldMap.entrySet()) {
            Entity entity = entry.getValue();

            if (entity instanceof Creature) {
                Coordinates coordinates = entry.getKey();
                ((Creature) entity).makeMove(coordinates);
                EntitiesRespawn.addEndedEntities(Grass.class);
                EntitiesRespawn.addEndedEntities(Herbivore.class);
            }
        }
        moveCounter++;
    }
}