package WorldMap;

import java.util.*;

public class Pathfinder {

//    public static Coordinates findPath(WorldMap worldMap, Coordinates coordinates){
//        Queue<Coordinates> queue = new LinkedList<>();
//        Set<Coordinates> visited = new HashSet<>();
//        Coordinates target = null;
//        List<Coordinates> neighboringCells;
//
//        queue.add(coordinates);
//
//        while (!queue.isEmpty()){
//            queue.peek();
//            if(worldMap.getEntity(coordinates) instanceof Grass){
//                target = coordinates;
//
//            } else {
//                visited.add(coordinates);
//                neighboringCells = getAdjacentCell(worldMap, coordinates);
//                queue.poll(); //проверить, что удалит именно первый элемент из очереди
//
//                for(Coordinates neighbour : neighboringCells ){
//                    queue.add(neighbour);
//                }
//            }
//        }
//        return target;
//    }

    public static List<Coordinates> getAdjacentCell(WorldMap worldMap, Coordinates coordinates){
        ArrayList<Coordinates> listOfAdjacentCell = new ArrayList<>();

        Coordinates rowCountMinus = new Coordinates(coordinates.getRowCount() - 1, coordinates.getColumnCount());
        Coordinates rowCountPlus = new Coordinates(coordinates.getRowCount() + 1, coordinates.getColumnCount());
        Coordinates columnCountMinus = new Coordinates(coordinates.getRowCount(), coordinates.getColumnCount() - 1);
        Coordinates columnCountPlus = new Coordinates(coordinates.getRowCount(), coordinates.getColumnCount() + 1);

        if(worldMap.isCellAvailableForMove(rowCountMinus)) {listOfAdjacentCell.add(rowCountMinus);}
        if(worldMap.isCellAvailableForMove(rowCountPlus)) {listOfAdjacentCell.add(rowCountPlus);}
        if(worldMap.isCellAvailableForMove(columnCountMinus)) {listOfAdjacentCell.add(columnCountMinus);}
        if(worldMap.isCellAvailableForMove(columnCountPlus)) {listOfAdjacentCell.add(columnCountPlus);}

        return listOfAdjacentCell;
    }

}
