package WorldMap;

import Entities.Grass;

import java.util.*;

public class Pathfinder {

    public Coordinates findPath(WorldMap worldMap, Coordinates coordinates){
        LinkedList<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Coordinates target = null;
        List<Coordinates> neighboringCells;

        queue.add(coordinates);



        while (!queue.isEmpty()){
            queue.getFirst();
            if(worldMap.getEntity(coordinates) instanceof Grass){
                target = coordinates;

            } else {
                visited.add(coordinates);
                neighboringCells = getAdjacentCell(coordinates, worldMap);
                queue.poll(); //проверить, что удалит именно первый элемент из очереди

                for(Coordinates neighbour : neighboringCells ){
                    queue.add(neighbour);
                }
            }
        }

        return target;
    }

    private List<Coordinates> getAdjacentCell(Coordinates coordinates, WorldMap worldMap){
        ArrayList<Coordinates> listOfAdjacentCell = new ArrayList<>();

        Coordinates newRowCountMinus = new Coordinates(coordinates.getRowCount() - 1, coordinates.getColumnCount());
        Coordinates newRowCountPlus = new Coordinates(coordinates.getRowCount() + 1, coordinates.getColumnCount());
        Coordinates newColumnCountMinus = new Coordinates(coordinates.getRowCount(), coordinates.getColumnCount() - 1);
        Coordinates newColumnCountPlus = new Coordinates(coordinates.getRowCount(), coordinates.getColumnCount() + 1);

        if(worldMap.isCellAvailableOnWorldMap(newRowCountMinus)) {listOfAdjacentCell.add(newRowCountPlus);}
        if(worldMap.isCellAvailableOnWorldMap(newRowCountPlus)) {listOfAdjacentCell.add(newRowCountMinus);}
        if(worldMap.isCellAvailableOnWorldMap(newColumnCountMinus)) {listOfAdjacentCell.add(newColumnCountMinus);}
        if(worldMap.isCellAvailableOnWorldMap(newColumnCountPlus)) {listOfAdjacentCell.add(newColumnCountPlus);}

        return listOfAdjacentCell;
    }

}
