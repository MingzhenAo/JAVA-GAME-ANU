package comp1110.ass2;

import java.util.*;

import static comp1110.ass2.RailroadInk.*;
import static comp1110.ass2.TileRotate.getRotatedTile;

/**
 * This class provides a method representing the GameBoard with LinkedHashMap
 * and some other method operating the linkedHashMap
 */


public class Board {

    /**
     * This method use likedHashMap to provide a game board that all grids are empty.
     * If a grid is empty, after the grid position(e.g. A0, B0) it shows [0]. For example, String "A0[0]" means that the grid A0 has not been placed a tile.
     * If a grid has been placed a tiLe, after the grid, there exist an array with 4 elements. For example, String "B1[5,0,1,5]" means that in the grid B1, there is a tile which is empty in its left, with a highway in the top, with a railway in the right, and empty in the bottom.
     *
     * @return
     */

    public static LinkedHashMap<String, int[]> getBoard() {

        LinkedHashMap<String, int[]> board = new LinkedHashMap<>();
        int[] temp = {0};

        String[] first = {"A", "B", "C", "D", "E", "F", "G"};
        String[] second = {"0", "1", "2", "3", "4", "5", "6"};

        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < first.length; j++) {

                String s = first[i] + second[j];
                board.put(s, temp);

            }

        }
        return board;
    }


    /**
     * 根据boardingString 返回当前放置贴图情况下的游戏板 According to the boardString passed, return a board represented by linkedHashMap reflecting the present condition.
     *
     * @param boardString
     * @return a placementBoard represented by linkedHashMap
     */
    public static LinkedHashMap<String, int[]> getPlacementBoard(String boardString) {

        String[] placementStringArray = getPlacementStringArray(boardString);

        LinkedHashMap<String, int[]> placementBoard = Board.getBoard();


        //Get all tile has been placed, and put them into relevant grids
        for (int i = 0; i < placementStringArray.length; i++) {

            placementBoard.put(placementStringArray[i].substring(2, 4), getRotatedTile(placementStringArray[i]));

        }

        return placementBoard;
    }


    /**
     * Get all grids whether it is empty or not
     *
     * @param boardString
     * @return
     */
    public static ArrayList<String> getAllGridsCondition(String boardString) {

        HashMap<String, int[]> placementBoard = getPlacementBoard(boardString);

        Set<Map.Entry<String, int[]>> set = placementBoard.entrySet();


        ArrayList<String> combo = new ArrayList<>();


        for (Map.Entry<String, int[]> entry : set) {

            String key = entry.getKey();
            int[] value = entry.getValue();

            combo.add(key + Arrays.toString(value));
        }

        return combo;
    }


    /**
     * Get all grids that has been placed a tile
     *
     * @param boardString
     * @return
     */
    public static ArrayList<String> getPlacementGrids(String boardString) {

        ArrayList<String> condition = getAllGridsCondition(boardString);


        //Remove all empty grids
        for (int i = condition.size() - 1; i >= 0; i--) {

            if (condition.get(i).length() == 5) {
                condition.remove(i);
            }
        }

        return condition;
    }


    /**
     * Return all empty grids
     *
     * @param boardString
     * @return
     */
    public static String[] getEmptyGrids(String boardString) {

        //Get all grids whether it is empty or not
        ArrayList<String> combo = getAllGridsCondition(boardString);

        //Remove those grids that has been placed a tile
        for (int i = combo.size() - 1; i >= 0; i--) {

            if (combo.get(i).length() != 5) {
                combo.remove(i);
            }
        }


        String[] array = new String[combo.size()];

        for (int i = 0; i < combo.size(); i++) {

            array[i] = combo.get(i).substring(0, 2);

        }

        return array;
    }


    /**
     * According to the boardingString passed, return the first placementString that can be connected.
     *
     * @param boardString
     * @param list        a list containing all placementString that theoretically a dice can generate
     * @return
     */
    public static String getValidPlacementString(String boardString, ArrayList<String> list) {


        String result = "";

        //Get a String array that containing all placementString
        String[] placementStringArray = getPlacementStringArray(boardString);

        //Get a String ArrayList
        List<String> placementList = new ArrayList<>();

        //Take all elements in the placementStringArray to the list
        for (String str : placementStringArray) {
            placementList.add(str);
        }


        //find all valid String
        for (int i = 0; i < list.size(); i++) {

            boolean flag;

            for (int j = 0; j < placementList.size(); j++) {

                flag = areConnectedNeighbours(list.get(i), placementList.get(j));

                if (flag) {

                    //Determine whether a new boardString is valid, after added a new placementString
                    boolean b = isValidPlacementSequence(boardString + list.get(i));

                    if (b) {
                        result = list.get(i);
                        return result;
                    }

                }

            }

        }

        return result;
    }


}
