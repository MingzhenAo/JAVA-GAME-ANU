package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.RailroadInk.areConnectedNeighbours;
import static comp1110.ass2.RailroadInk.getPlacementStringArray;
import static comp1110.ass2.TileRotate.getRotatedTile;

public class BasicScore {
    /**
     * Author:Mingzhen Ao
     * To pick up the central tiles and calculate the scores
     *
     * @param boardString
     * @return the centralTiles Score
     */
    public static int getCentralTilesScore(String boardString) {
        int score = 0;
        String[] placementStringArray = getPlacementStringArray(boardString);
        //central tiles
        for (int i = 0; i < placementStringArray.length; i++) {
            if (placementStringArray[i].charAt(2) >= 'C' && placementStringArray[i].charAt(2) <= 'E') {
                if (placementStringArray[i].charAt(3) >= '2' && placementStringArray[i].charAt(3) <= '4') {
                    score++;
                }
            }
        }
        return score;
    }

    /**
     * Author:Mingzhen Ao
     * To fix the problem of B2 ,According to different connection way ,we can assume B2 is A4 or A1(be careful the direction).
     *
     * @param s1 Original 5 characters
     * @param s2 the 5 characters which will be added
     * @return the changed String s2
     */

    public static String handle(String s1, String s2) {
        if (!s2.substring(0, 2).equals("B2")) {
            return s2;
        } else {
            if (s1.charAt(2) == s2.charAt(2) && s1.charAt(3) - s2.charAt(3) == 1) {
                if (getRotatedTile(s2)[2] == 0) {
                    return "A4" + s2.substring(2, 5);
                } else {
                    return "A1" + s2.substring(2, 4) + "1";
                }
            }
            if (s1.charAt(2) == s2.charAt(2) && s2.charAt(3) - s1.charAt(3) == 1)// same row,j right, i left
            {

                if (getRotatedTile(s2)[0] == 0) {
                    return "A4" + s2.substring(2, 5);
                } else {
                    return "A1" + s2.substring(2, 4) + "1";
                }
            }
            if (s1.charAt(3) == s2.charAt(3) && s1.charAt(2) - s2.charAt(2) == 1)//same column,i below, j top
            {
                if (getRotatedTile(s2)[3] == 0) {
                    return "A4" + s2.substring(2, 5);
                } else {
                    return "A1" + s2.substring(2, 4) + "0";
                }
            }
            if (s1.charAt(3) == s2.charAt(3) && s2.charAt(2) - s1.charAt(2) == 1)//same column,j below, i top
            {

                if (getRotatedTile(s2)[1] == 0) {
                    return "A4" + s2.substring(2, 5);
                } else {
                    return "A1" + s2.substring(2, 4) + "0";
                }
            }
        }
        return s2;
    }

    /**
     * Author:Mingzhen  Ao
     *
     * @param list the all tiles ArrayList
     * @param map  just contain 1 String which don't exit in ArrayList
     * @return All the tiles in the same line with C's string;
     */

    public static HashMap<String, String> line(ArrayList<String> list, HashMap<String, String> map) {

        HashMap<String, String> resultMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            if (map.get(list.get(i)) != null) {

                for (int k = 0; k < list.size(); k++) {

                    if (areConnectedNeighbours(list.get(i), list.get(k))) {

                        String s = list.get(k);

                        list.set(k, handle(list.get(i), list.get(k)));
                        if (!map.containsKey(list.get(k))) {
                            list.add(list.get(k));
                            map.put(list.get(k), list.get(k).substring(2, 4));
                            resultMap.put(list.get(k), list.get(k).substring(2, 4));
                        }
                        if (s.substring(0, 2).equals("B2")) {
                            list.set(k, s);
                        }

                    }
                }
            }
        }

        return resultMap;
    }


    /**
     * Author:Mingzhen Ao
     * To get all the lines in the Map, each line store in each HashMap,Arraylist contains all Hashmaps
     *
     * @param boardString
     * @return All the lines in the Map
     */
    public static ArrayList<HashMap<String, String>> exitsMapped(String boardString) {
        String[] boardStringArray = getPlacementStringArray(boardString);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < boardStringArray.length; i++) {
            list.add(boardStringArray[i]);
        }
        HashMap<String, String> map = new HashMap<>();
        ArrayList<HashMap<String, String>> mapList = new ArrayList<>();

        for (int h = 0; h < list.size(); h++) {
            if (map.get(list.get(h)) == null && !list.get(h).substring(0, 2).equals("B2")) {
                map.put(list.get(h), list.get(h).substring(2, 4));
                HashMap<String, String> lineMap = line(list, map);
                if (lineMap.size() != 0) {
                    lineMap.put(list.get(h), list.get(h).substring(2, 4));
                    mapList.add(lineMap);
                }
            }
        }
        return mapList;
    }

    /**
     * Author:Mingzhen Ao
     * Calculate the exits Scores
     *
     * @param boardString
     * @return The exits Scores
     */
    public static int getExitsScore(String boardString) {
        int score = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < exitsMapped(boardString).size(); i++) {
            HashMap<String, String> map = exitsMapped(boardString).get(i);
            int count = 0;
            for (String key : map.keySet()) {
                if (map.get(key).equals("A1") && getRotatedTile(key)[1] != 5)
                    count++;
                if (map.get(key).equals("A3") && getRotatedTile(key)[1] != 5)
                    count++;
                if (map.get(key).equals("A5") && getRotatedTile(key)[1] != 5)
                    count++;
                if (map.get(key).equals("B0") && getRotatedTile(key)[0] != 5)
                    count++;
                if (map.get(key).equals("B6") && getRotatedTile(key)[2] != 5)
                    count++;
                if (map.get(key).equals("D0") && getRotatedTile(key)[0] != 5)
                    count++;
                if (map.get(key).equals("D6") && getRotatedTile(key)[2] != 5)
                    count++;
                if (map.get(key).equals("F0") && getRotatedTile(key)[0] != 5)
                    count++;
                if (map.get(key).equals("F6") && getRotatedTile(key)[2] != 5)
                    count++;
                if (map.get(key).equals("G1") && getRotatedTile(key)[3] != 5)
                    count++;
                if (map.get(key).equals("G3") && getRotatedTile(key)[3] != 5)
                    count++;
                if (map.get(key).equals("G5") && getRotatedTile(key)[3] != 5)
                    count++;
            }
            list.add(count);
        }

        for (int j = 0; j < list.size(); j++) {
            switch (list.get(j)) {
                case 2:
                    score += 4;
                    break;
                case 3:
                    score += 8;
                    break;
                case 4:
                    score += 12;
                    break;
                case 5:
                    score += 16;
                    break;
                case 6:
                    score += 20;
                    break;
                case 7:
                    score += 24;
                    break;
                case 8:
                    score += 28;
                    break;
                case 9:
                    score += 32;
                    break;
                case 10:
                    score += 36;
                    break;
                case 11:
                    score += 40;
                    break;
                case 12:
                    score += 45;
                    break;
            }
        }
        return score;
    }

    /**
     * Author:Mingzhen Ao
     * use reversed thinking calculate dead Score
     *
     * @param boardString
     * @return dead score
     */
    public static int getEndsScore(String boardString) {
        String[] placementStringArray = getPlacementStringArray(boardString);
        int score = 0;
        for (int i = 0; i < placementStringArray.length; i++) {
            score -= 4; //assume every time it's got 4 dead ends
            //get rid of the end that's blank or empty with the number 5
            if (TileEnum.valueOf(placementStringArray[i].substring(0, 2)).left == 5)
                score++;
            if (TileEnum.valueOf(placementStringArray[i].substring(0, 2)).top == 5)
                score++;
            if (TileEnum.valueOf(placementStringArray[i].substring(0, 2)).right == 5)
                score++;
            if (TileEnum.valueOf(placementStringArray[i].substring(0, 2)).bottom == 5)
                score++;
            //if the tile was connected to the exit then plus 1
            switch (placementStringArray[i].substring(2, 3)) {
                case "A":
                    if (getRotatedTile(placementStringArray[i])[1] != 5)
                        score++;
                    break;
                case "G":
                    if (getRotatedTile(placementStringArray[i])[3] != 5)
                        score++;
                    break;
            }
            switch (placementStringArray[i].substring(3, 4)) {
                case "0":
                    if (getRotatedTile(placementStringArray[i])[0] != 5)
                        score++;
                    break;
                case "6":
                    if (getRotatedTile(placementStringArray[i])[2] != 5)
                        score++;
                    break;
            }
            //any connected neighbors then plus 1
            for (int j = 0; j < placementStringArray.length; j++) {
                if (areConnectedNeighbours(placementStringArray[i], placementStringArray[j]))
                    score++;
            }
        }
        return score;
    }
}
