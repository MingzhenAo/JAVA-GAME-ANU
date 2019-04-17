package comp1110.ass2;

import java.util.HashMap;
import java.util.Map;

import static comp1110.ass2.RailroadInk.areConnectedNeighbours;
import static comp1110.ass2.RailroadInk.getPlacementStringArray;

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
        Map<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i++) {
            tilesMap.put(boardStringArray[i].substring(2, 4), boardStringArray[i]);
        }
        String check;
        String checkLeft;
        String checkUp;
        String checkRight;
        String checkDown;
        String result = "";
        for (int j = 0; j < head.length; j++) {
            if (head[j] == "")
                continue;
            for (char row = 'A'; row <= 'G'; row++) {
                for (int column = 0; column <= 6; column++) {
                    check = "";
                    check += row;
                    check += column;
                    if (tilesMap.containsKey(check))
                        continue;
                    checkLeft = "";
                    checkUp = "";
                    checkRight = "";
                    checkDown = "";
                    checkLeft += row;
                    checkLeft += column - 1;
                    checkUp += row - 1;
                    checkUp += column;
                    checkRight += row;
                    checkRight += column + 1;
                    checkDown += row + 1;
                    checkDown += column;
                    for (int orientation = 0; orientation <= 7; orientation++) {
                        if (!tilesMap.containsKey(checkLeft))
                            if (!tilesMap.containsKey(checkUp))
                                if (!tilesMap.containsKey(checkRight))
                                    if (!tilesMap.containsKey(checkDown))
                                        continue;
                        if (tilesMap.containsKey(checkLeft)) {
                            if (!areConnectedNeighbours(tilesMap.get(checkLeft), head[j] + row + column + orientation))
                                continue;
                        }
                        if (tilesMap.containsKey(checkUp)) {
                            if (!areConnectedNeighbours(tilesMap.get(checkUp), head[j] + row + column + orientation))
                                continue;
                        }
                        if (tilesMap.containsKey(checkRight)) {
                            if (!areConnectedNeighbours(tilesMap.get(checkRight), head[j] + row + column + orientation))
                                continue;
                        }
                        if (tilesMap.containsKey(checkDown)) {
                            if (!areConnectedNeighbours(tilesMap.get(checkDown), head[j] + row + column + orientation))
                                continue;
                        }
                        result += head[j] + row + column + orientation;
                    }
                }
            }
        }
        System.out.println(result);;
    }
}
