import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.BasicScore.exitsMapped;
import static comp1110.ass2.RailroadInk.areConnectedNeighbours;
import static comp1110.ass2.RailroadInk.getPlacementStringArray;
import static comp1110.ass2.TileRotate.getRotatedTile;

public class GetadvancedScore {
    public static String handlelong(String s1, String s2) {
        if (s1.charAt(2) == s2.charAt(2) && s1.charAt(3) - s2.charAt(3) == 1) {
            if (getRotatedTile(s2)[2] == 0) {
                return s2;
            } else
                return "";
        }
        if (s1.charAt(2) == s2.charAt(2) && s2.charAt(3) - s1.charAt(3) == 1)// same row,j right, i left
        {

            if (getRotatedTile(s2)[0] == 0) {
                return s2;
            } else
                return "";
        }
        if (s1.charAt(3) == s2.charAt(3) && s1.charAt(2) - s2.charAt(2) == 1)//same column,i below, j top
        {
            if (getRotatedTile(s2)[3] == 0) {
                return s2;
            } else
                return "";
        }
        if (s1.charAt(3) == s2.charAt(3) && s2.charAt(2) - s1.charAt(2) == 1)//same column,j below, i top
        {

            if (getRotatedTile(s2)[1] == 0) {
                return s2;
            } else
                return "";
        }
        return s2;
    }

    public static String removeRailway(String boardString) {
    String[] a = getPlacementStringArray(boardString);
    String b="";
    for (int i = 0; i < a.length; i++) {
        if (a[i].substring(0, 2).equals("S3") || a[i].substring(0, 2).equals("A0") ||
                a[i].substring(0, 2).equals("A1") || a[i].substring(0, 2).equals("A2"))
        {
            a[i] = "";
        }
    }
    for(int i=0;i<a.length;i++)
    {
        b+=a[i];
    }
    return b;
}
    public static String removeHignlway(String boardString) {
        String[] a = getPlacementStringArray(boardString);
        String b="";
        for (int i = 0; i < a.length; i++) {
            if (a[i].substring(0, 2).equals("S2") || a[i].substring(0, 2).equals("A3") ||
                    a[i].substring(0, 2).equals("A4") || a[i].substring(0, 2).equals("A5") )
            {
                a[i] = "";
            }
            if(a[i].substring(0,2).equals("S0"))

        }
        for(int i=0;i<a.length;i++)
        {
            b+=a[i];
        }
        return b;
    }

    /*public static HashMap<String, String> lineHighway(ArrayList<String> list, HashMap<String, String> map) {
        HashMap<String, String> newMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) != null) {
                for (int k = 0; k < list.size(); k++) {
                    if (areConnectedNeighbours(list.get(i), list.get(k))) {
                        String m = list.get(k);
                        list.set(k, handlelong(list.get(i), list.get(k)));
                        if (!map.containsKey(list.get(k))) {
                            list.add(list.get(k));
                            map.put(list.get(k), list.get(k).substring(2, 4));
                            newMap.put(list.get(k), list.get(k).substring(2, 4));
                        }
                        if (m.substring(0, 2).equals("B2")) {
                            list.set(k, m);
                        }
                    }
                }
            }
        }
        return newMap;
    }*/

    public static int getLongestRailway(String boardString)
    {
        String a=removeHignlway(boardString);
        ArrayList<HashMap<String,String>> b=exitsMapped(a);

    }
}