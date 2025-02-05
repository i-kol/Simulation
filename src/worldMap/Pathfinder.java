package worldMap;

import entities.*;
import java.util.*;

public class Pathfinder {

    public static Coordinates findPath(WorldMap worldMap, Coordinates currentCell){
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Coordinates target = null;
        List<Coordinates> targets = new ArrayList<>();
        List<Coordinates> neighboringCells;

        queue.add(currentCell);

        while (!queue.isEmpty()) {
            neighboringCells = getAdjacentCell(worldMap, currentCell);

            for (Coordinates cell: neighboringCells) {
                Entity entity = worldMap.getEntity(cell);

                if (entity instanceof Grass) {  //надо заменить целевой класс травы на универсальный класс для обоих типов существ
                    targets.add(cell);
                }

                visited.add(cell);
                queue.add(cell);
            }
        }

        // проверка, есть ли новая currentCell в списке visited


        // выбор из списка targets целевой клетки target, находящейся ближе всего к currentCell (до которой меньше всего ходов)

        return target;


//        while (!queue.isEmpty()){
//            queue.peek();
//            if(worldMap.getEntity(currentCoordinates) instanceof Grass){
//                target = currentCoordinates;
//
//            } else {
//                visited.add(currentCoordinates);
//                neighboringCells = getAdjacentCell(worldMap, currentCoordinates);
//                queue.poll(); //проверить, что удалит именно первый элемент из очереди
//
//                for(Coordinates neighbour : neighboringCells ){
//                    queue.add(neighbour);
//                }
//            }
//        }

    }

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
