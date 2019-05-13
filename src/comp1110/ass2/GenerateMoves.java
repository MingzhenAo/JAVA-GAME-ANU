package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;

public class GenerateMoves {
    //generate moves valid for task 6
    public static ArrayList<String> generateValidMoves(String boardString, String diceRoll){
        ArrayList<String> resultList = new ArrayList<>();
        String[] head = new String[4];
        head[0] = diceRoll.substring(0,2);
        head[1] = diceRoll.substring(2,4);
        head[2] = diceRoll.substring(4,6);
        head[3] = diceRoll.substring(6,8);
        if (head[0].equals(head[1]))
            head[1] = "";
        if (head[0].equals(head[2]))
            head[2] = "";
        if (head[1].equals(head[2]))
            head[2] = "";
        String[] boardStringArray = RailroadInk.getPlacementStringArray(boardString);
        HashMap<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i ++) {
            tilesMap.put(boardStringArray[i].substring(2,4), boardStringArray[i]);
        }
        String check;
        //basic ABs movements from diceRoll
        for (int j = 0; j < head.length; j ++) {
            if (head[j].equals(""))
                continue;
            for (char row = 'A'; row <= 'G'; row ++) {
                for (int column = 0; column <= 6; column ++) {
                    check = "";
                    check += row;
                    check += column;
                    if (tilesMap.containsKey(check))
                        continue;
                    for (int orientation = 0; orientation <= 7; orientation ++) {
                        String finalString = boardString;
                        String placementString = head[j] + row + column + orientation;
                        finalString += placementString;
                        if (RailroadInk.isValidPlacementSequence(finalString))
                            resultList.add(placementString);
                    }
                }
            }
        }
        //advanced movements from S tiles
        HashMap<String, String> specialTilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i ++) {
            if (boardStringArray[i].substring(0,1).equals("S")) {
                specialTilesMap.put(boardStringArray[i].substring(0,2), boardStringArray[i]);
            }
        }
        if (specialTilesMap.size() < 3){
            for (int order = 0; order <= 5; order ++){
                if (specialTilesMap.containsKey("S" + order))
                    continue;
                for (char row = 'A'; row <= 'G'; row ++) {
                    for (int column = 0; column <= 6; column++) {
                        check = "";
                        check += row;
                        check += column;
                        if (tilesMap.containsKey(check))
                            continue;
                        for (int orientation = 0; orientation <= 7; orientation++) {
                            String finalString = boardString;
                            String placementString = "S" + order + row + column + orientation;
                            finalString += placementString;
                            if (RailroadInk.isValidPlacementSequence(finalString))
                                resultList.add(placementString);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    //generate strict moves
    public static ArrayList<String> generateStrictMoves(String boardString, String diceRoll){
        ArrayList<String> resultList = new ArrayList<>();
        String[] head = new String[4];
        head[0] = diceRoll.substring(0,2);
        head[1] = diceRoll.substring(2,4);
        head[2] = diceRoll.substring(4,6);
        head[3] = diceRoll.substring(6,8);
        if (head[0].equals(head[1]))
            head[1] = "";
        if (head[0].equals(head[2]))
            head[2] = "";
        if (head[1].equals(head[2]))
            head[2] = "";
        String[] boardStringArray = RailroadInk.getPlacementStringArray(boardString);
        HashMap<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i ++) {
            tilesMap.put(boardStringArray[i].substring(2,4), boardStringArray[i]);
        }
        String check;
        //basic movements from diceRoll
        for (int j = 0; j < head.length; j ++) {
            if (head[j].equals(""))
                continue;
            for (char row = 'A'; row <= 'G'; row ++) {
                for (int column = 0; column <= 6; column ++) {
                    check = "";
                    check += row;
                    check += column;
                    if (tilesMap.containsKey(check))
                        continue;
                    for (int orientation = 0; orientation <= 7; orientation ++) {
                        if (CanIPlaceTheStringHere.canIplacetheStringHere(head[j] + row + column + orientation, tilesMap))
                            resultList.add(head[j] + row + column + orientation);
                    }
                }
            }
        }
        //advanced movements from S tiles
        HashMap<String, String> specialTilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i ++) {
            if (boardStringArray[i].substring(0,1).equals("S")) {
                specialTilesMap.put(boardStringArray[i].substring(0,2), boardStringArray[i]);
            }
        }
        if (specialTilesMap.size() < 3){
            for (int order = 0; order <= 5; order ++){
                if (specialTilesMap.containsKey("S" + order))
                    continue;
                for (char row = 'A'; row <= 'G'; row ++) {
                    for (int column = 0; column <= 6; column++) {
                        check = "";
                        check += row;
                        check += column;
                        if (tilesMap.containsKey(check))
                            continue;
                        for (int orientation = 0; orientation <= 7; orientation++) {
                            if (CanIPlaceTheStringHere.canIplacetheStringHere("S" + order + row + column + orientation, tilesMap))
                                resultList.add("S" + order + row + column + orientation);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(generateStrictMoves("","A0A0A0B0"));
    }

}
