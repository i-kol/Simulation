package com.example.actions;

import com.example.entities.*;
import com.example.worldMap.Coordinates;
import com.example.worldMap.WorldMap;

import java.util.HashMap;
import java.util.Map;

import static com.example.actions.EntitiesRespawn.addEndedEntities;
import static com.example.worldMap.WorldMap.*;

public class TurnActions {

    public static boolean isCellAvailableForMove(Coordinates coordinates) {
        return isCellOnWorldMap(coordinates) && (isCellEmpty(coordinates));
    }

    public static void moveCreature() {
        HashMap<Coordinates, Entity> updatedWorldMap = new HashMap<>(WorldMap.worldMap);

        for (Map.Entry<Coordinates, Entity> entry : updatedWorldMap.entrySet()) {
            Entity entity = entry.getValue();

            if (entity instanceof Creature) {
                Coordinates coordinates = entry.getKey();
                ((Creature) entity).makeMove(coordinates);
                addEndedEntities(Grass.class);
                addEndedEntities(Herbivore.class);
            }
        }
    }
}
