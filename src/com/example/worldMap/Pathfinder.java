package com.example.worldMap;

import com.example.actions.TurnActions;
import com.example.entities.*;

import java.util.*;

public class Pathfinder {

    public static List<Coordinates> findPath(Coordinates startCell) {

        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Coordinates target = null;

        queue.add(startCell);
        visited.add(startCell);
        parentMap.put(startCell, null);

        while (!queue.isEmpty()) {
            Coordinates currentCell = queue.poll();

            for (Coordinates neighborForTargetSearch : getNeighborCells(currentCell)) {
                if ((WorldMap.getEntity(neighborForTargetSearch) instanceof Grass && WorldMap.getEntity(startCell) instanceof Herbivore) ||
                        (WorldMap.getEntity(neighborForTargetSearch) instanceof Herbivore && WorldMap.getEntity(startCell) instanceof Predator)) {
                    target = neighborForTargetSearch;
                    parentMap.put(target, currentCell);
                    break;
                }
            }

            if (target != null) {
                break;
            }

            for (Coordinates neighborForPathSearch : getAdjacentCells(currentCell)) {
                if (!visited.contains(neighborForPathSearch)) {
                    visited.add(neighborForPathSearch);
                    queue.add(neighborForPathSearch);
                    parentMap.put(neighborForPathSearch, currentCell); // Запоминаем родителя
                }
            }
        }

        List<Coordinates> path = new ArrayList<>();

        for (Coordinates cell = target; cell != null; cell = parentMap.get(cell)) {
            path.add(cell);
        }

        Collections.reverse(path);

        return path;
    }

    public static List<Coordinates> getNeighborCells(Coordinates coordinates) {
        ArrayList<Coordinates> listOfNeighboringCells = new ArrayList<>();

        for (int row = -1; row <= 1; row++) {
            for (int column = -1; column <= 1; column++) {
                Coordinates cell = new Coordinates(coordinates.getRow() + row, coordinates.getColumn() + column);

                if (WorldMap.isCellOnWorldMap(cell)) {
                    if (row == 0 && column == 0) {
                        continue;
                    }
                    listOfNeighboringCells.add(cell);
                }
            }
        }

        return listOfNeighboringCells;
    }

    public static List<Coordinates> getAdjacentCells(Coordinates coordinates) {
        ArrayList<Coordinates> listOfAdjacentCells = new ArrayList<>();
        List<Coordinates> listOfNeighboringCells = getNeighborCells(coordinates);

        for (Coordinates cell : listOfNeighboringCells) {
            if (TurnActions.isCellAvailableForMove(cell)) {
                listOfAdjacentCells.add(cell);
            }
        }

        return listOfAdjacentCells;
    }
}