package comp1110.ass2;

import static comp1110.ass2.RailroadInk.areConnectedNeighbours;
import static comp1110.ass2.RailroadInk.getBoardStringArray;
import static java.lang.Character.getNumericValue;

public class Test {
    public static void main(String[] args) {
        String boardString = "A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21";
        int count = boardString.length() / 5;

        String[] boardStringArray = getBoardStringArray(boardString);
        for (int i = 0; i < count; i ++){
            System.out.println("boardstringarray["+i+"] : "+boardStringArray[i]);
        }

        //testing are connected neighbours
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                System.out.println("try boardstringarray["+i+"] and boardstringarray["+j+"]");
                if (areConnectedNeighbours(boardStringArray[i], boardStringArray[j]) != true) {
                    if (boardStringArray[i].charAt(2) == boardStringArray[j].charAt(2) && boardStringArray[i].charAt(3) - boardStringArray[j].charAt(3) == 1)
                        System.out.println("false1");
                    else if (boardStringArray[i].charAt(2) == boardStringArray[j].charAt(2) && boardStringArray[j].charAt(3) - boardStringArray[i].charAt(3) == 1)
                        System.out.println("false2");
                    else if (boardStringArray[i].charAt(3) == boardStringArray[j].charAt(3) && (int) boardStringArray[i].charAt(2) - (int) boardStringArray[j].charAt(2) == 1)
                        System.out.println("false3");
                    else if (boardStringArray[i].charAt(3) == boardStringArray[j].charAt(3) && (int) boardStringArray[j].charAt(2) - (int) boardStringArray[i].charAt(2) == 1)
                        System.out.println("false4");
                }
            }
        }

        //testing are correctly connected to exit
        //String[] exitshighway = {"A1","A5","D0","D6","G1","G5"}; exits with highway
        //String[] exitsrailway = {"A3","B0","B6","F0","F6","G3"}; exits with railway
        TileRotate r = new TileRotate();
        int[] tile = new int[4];
        for (int i = 0; i < count; i++) {
            System.out.println("try boardstringarray["+i+"]");
            tile[0] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).left;
            tile[1] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).top;
            tile[2] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).right;
            tile[3] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).bottom;
            r.rotateTime(tile, getNumericValue(boardStringArray[i].charAt(4)));
            switch (boardStringArray[i].substring(3, 5)) {
                case "A1":
                case "A5":
                    if (tile[1] != 0)
                        System.out.println("false5");
                case "D0":
                    if (tile[0] != 0)
                        System.out.println("false6");
                case "D1":
                    if (tile[2] != 0)
                        System.out.println("false7");
                case "G1":
                case "G5":
                    if (tile[3] != 0)
                        System.out.println("false8");
                case "A3":
                    if (tile[1] != 1)
                        System.out.println("false9");
                case "B0":
                case "F0":
                    if (tile[0] != 1)
                        System.out.println("false10");
                case "B6":
                case "F6":
                    if (tile[2] != 1)
                        System.out.println("false11");
                case "G3":
                    if (tile[3] != 1)
                        System.out.println("false12");
            }
        }
        System.out.println("true");
    }
}
