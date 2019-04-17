package comp1110.ass2;

import java.util.HashMap;
import java.util.Map;

import static comp1110.ass2.RailroadInk.*;

public class test {
    public static void main(String[] args) {

        String diceRoll = "A0A0A0B1";
        String boardString = "A0F00A0B00A0A31B1A14A0B61A0F61A0G32B1D61A0G43A0A62A0E61B1G56S1G60A0E03A0A03B1G12A0G02S0A50A0B50A5D03B1B40";
        String[] head = new String[4];
        head[0] = diceRoll.substring(0, 2);
        head[1] = diceRoll.substring(2, 4);
        head[2] = diceRoll.substring(4, 6);
        head[3] = diceRoll.substring(6, 8);
        if (head[0].equals(head[1]))
            head[1] = "";
        if (head[0].equals(head[2]))
            head[2] = "";
        if (head[1].equals(head[2]))
            head[2] = "";
        String[] boardStringArray = getPlacementStringArray(boardString);
        HashMap<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i++) {
            tilesMap.put(boardStringArray[i].substring(2, 4), boardStringArray[i]);
        }
        String check;
        String result = "";
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
                        if (canIplacetheStringHere(head[j] + row + column + orientation, tilesMap)){
                            result += head[j] + row + column + orientation;
                            System.out.println(result);
                        }
                    }
                }
            }
        }
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
                            if (canIplacetheStringHere("S" + order + row + column + orientation, tilesMap))
                                result += "S" + order + row + column + orientation;
                        }
                    }
                }
            }
        }
        System.out.println(result);

/*
        String s = "B1A45";
        String boardString = "A0F00A0B00A0A31B1A14A0B61A0F61A0G32B1D61A0G43A0A62A0E61B1G56S1G60A0E03A0A03B1G12A0G02S0A50A0B50A5D03B1B40";
        String[] boardStringArray = getPlacementStringArray(boardString);
        HashMap<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i++) {
            tilesMap.put(boardStringArray[i].substring(2, 4), boardStringArray[i]);
        }
        if (canIplacetheStringHere(s,tilesMap))
            System.out.println("I can");
        else
            System.out.println("I can't");
*/
    }
}
// A0A40 yes
// A0A47
// B1A42 yes
// B1A44 yes
// B1A45 yes
// S4A42 yes
// S4A45
