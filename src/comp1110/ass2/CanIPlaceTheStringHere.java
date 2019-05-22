package comp1110.ass2;

import java.util.HashMap;

import static comp1110.ass2.AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours;
import static comp1110.ass2.RailroadInk.areConnectedNeighbours;


public class CanIPlaceTheStringHere {
    /**
     * Author: Yusen Wei
     * to tell if I can place that boardsting there given a board of HashMap
     * @param boardString
     * @param tilesMap
     * @return true if I can place
     */
    public static boolean canIplacetheStringHere(String boardString, HashMap<String, String> tilesMap){
        String checkLeft = "";
        String checkUp = "";
        String checkRight = "";
        String checkDown = "";
        char row = boardString.charAt(2);
        int column = boardString.charAt(3);
        checkLeft += row;
        checkLeft += (char)(column - 1);
        checkUp += (char)((int)row - 1);
        checkUp += (char)column;
        checkRight += row;
        checkRight += (char)(column + 1);
        checkDown += (char)((int)row + 1);
        checkDown += (char)column;
        boolean b = false;
        //they should legally connect all the near tiles and have at lest one connected neighbour
        if (tilesMap.containsKey(checkLeft)){
            if (!areLegallyConnectedNeighbours(tilesMap.get(checkLeft), boardString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkLeft), boardString))
                b = true;
        }
        if (tilesMap.containsKey(checkUp)){
            if (!areLegallyConnectedNeighbours(tilesMap.get(checkUp), boardString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkUp), boardString))
                b = true;

        }
        if (tilesMap.containsKey(checkRight)){
            if (!areLegallyConnectedNeighbours(tilesMap.get(checkRight), boardString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkRight), boardString))
                b = true;
        }
        if (tilesMap.containsKey(checkDown)){
            if (!areLegallyConnectedNeighbours(tilesMap.get(checkDown), boardString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkDown), boardString))
                b = true;
        }
        return b;
    }
}
