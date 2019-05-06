package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.RailroadInk.areConnectedNeighbours;
import static comp1110.ass2.RailroadInk.getPlacementStringArray;
import static comp1110.ass2.TileRotate.getRotatedTile;

public class getbasicscore {

    public static int centraltilesScore(String boardString) {
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

    public static HashMap<String, String> line(ArrayList<String> a, HashMap<String, String> c) {
        HashMap<String, String> e = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (c.get(a.get(i)) != null) {
                for (int k = 0; k < a.size(); k++) {
                    if (areConnectedNeighbours(a.get(i), a.get(k))) {
                        String m = a.get(k);
                        a.set(k, handle(a.get(i), a.get(k)));
                        if (!c.containsKey(a.get(k))) {
                            a.add(a.get(k));
                            c.put(a.get(k), a.get(k).substring(2, 4));
                            e.put(a.get(k), a.get(k).substring(2, 4));
                        }
                        if (m.substring(0, 2).equals("B2")) {
                            a.set(k, m);
                        }

                    }
                }
            }
        }

        return e;
    }


    /**
     * @param boardString
     * @return
     */
    public static ArrayList<HashMap<String, String>> exitsMapped(String boardString) {
        String[] boardStringArray = getPlacementStringArray(boardString);
        ArrayList<String> m = new ArrayList<>();
        for (int i = 0; i < boardStringArray.length; i++) {
            m.add(boardStringArray[i]);
        }
        HashMap<String, String> a = new HashMap<>();
        ArrayList<HashMap<String, String>> b = new ArrayList<>();
        for (int h = 0; h < m.size(); h++) {
            if (a.get(m.get(h)) == null && !m.get(h).substring(0, 2).equals("B2")) {
                a.put(m.get(h), m.get(h).substring(2, 4));
                HashMap<String, String> n = line(m, a);
                if (n.size() != 0) {
                    n.put(m.get(h), m.get(h).substring(2, 4));
                    b.add(n);
                }
            }
        }
        return b;
    }

    public static int exitsScore(String boardString) {
        int score = 0;
        ArrayList<Integer> f = new ArrayList<>();
        for (int i = 0; i < exitsMapped(boardString).size(); i++) {
            HashMap<String, String> a = exitsMapped(boardString).get(i);
            int count = 0;
            for (String key : a.keySet()) {
                if (a.get(key).equals("A1") && getRotatedTile(key)[1] != 5)
                    count++;
                if (a.get(key).equals("A3") && getRotatedTile(key)[1] != 5)
                    count++;
                if (a.get(key).equals("A5") && getRotatedTile(key)[1] != 5)
                    count++;
                if (a.get(key).equals("B0") && getRotatedTile(key)[0] != 5)
                    count++;
                if (a.get(key).equals("B6") && getRotatedTile(key)[2] != 5)
                    count++;
                if (a.get(key).equals("D0") && getRotatedTile(key)[0] != 5)
                    count++;
                if (a.get(key).equals("D6") && getRotatedTile(key)[2] != 5)
                    count++;
                if (a.get(key).equals("F0") && getRotatedTile(key)[0] != 5)
                    count++;
                if (a.get(key).equals("F6") && getRotatedTile(key)[2] != 5)
                    count++;
                if (a.get(key).equals("G1") && getRotatedTile(key)[3] != 5)
                    count++;
                if (a.get(key).equals("G3") && getRotatedTile(key)[3] != 5)
                    count++;
                if (a.get(key).equals("G5") && getRotatedTile(key)[3] != 5)
                    count++;
            }
            f.add(count);
        }

        for (int j = 0; j < f.size(); j++) {
            switch (f.get(j)) {
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


    public static int getEndScore(String boardString) {
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
