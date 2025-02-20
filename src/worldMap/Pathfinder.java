package worldMap;

import entities.*;

import java.util.*;

public class Pathfinder {

    public static List<Coordinates> findPath(WorldMap worldMap, Coordinates startCell) {

        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Coordinates target = null;

        queue.add(startCell);
        visited.add(startCell);
        parentMap.put(startCell, null);

        while (!queue.isEmpty()) {
            Coordinates currentCell = queue.poll();

            if (worldMap.getEntity(currentCell) instanceof Grass) {
                target = currentCell;
                break;
            }

            for (Coordinates neighbor : getAdjacentCells(worldMap, currentCell)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor, currentCell); // Запоминаем родителя
                }
            }
        }

        List<Coordinates> shortestPath = new ArrayList<>();

        for (Coordinates cell = target; cell != null; cell = parentMap.get(cell)) {
            shortestPath.add(cell);
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }

    public static List<Coordinates> getNeighborCells(WorldMap worldMap, Coordinates coordinates) {
        ArrayList<Coordinates> listOfNeighboringCells = new ArrayList<>();

        for (int row = -1; row <= 1; row++) {
            for (int column = -1; column <= 1; column++) {
                Coordinates cell = new Coordinates(coordinates.getRowCount() + row, coordinates.getColumnCount() + column);

                if (worldMap.isCellOnWorldMap(cell)) {
                    if (row == 0 && column == 0) {
                        continue;
                    }
                    listOfNeighboringCells.add(cell);
                }
            }
        }

        return listOfNeighboringCells;
    }

    public static List<Coordinates> getAdjacentCells(WorldMap worldMap, Coordinates coordinates) {
        ArrayList<Coordinates> listOfAdjacentCells = new ArrayList<>();
        List<Coordinates> listOfNeighboringCells = getNeighborCells(worldMap, coordinates);

        for (Coordinates cell : listOfNeighboringCells) {
            if (worldMap.isCellAvailableForMove(cell)) {
                listOfAdjacentCells.add(cell);
            }
        }

        return listOfAdjacentCells;
    }
}