package comp1110.ass2;

import static java.lang.Character.getNumericValue;

public class Test {
    public static void main(String[] args) {
        String boardString = "A4A50A4G12B2G54A1G36";
        int count = boardString.length() / 5;
        String[] boardStringArray = new String[count];
        int z = 0;
        for (int i = 0; i < boardString.length(); i += 5) {
            boardStringArray[z] = boardString.substring(i, i + 5);
            z++;
        }
        int[] tile = new int[4];
        TileRotate r = new TileRotate();
        for (int i = 0; i < count; i++) {
            tile[0] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).left;
            tile[1] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).top;
            tile[2] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).right;
            tile[3] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).bottom;
            r.rotateTime(tile, getNumericValue(boardStringArray[i].charAt(4)));
            switch (boardStringArray[i].substring(0, 2)) {
                case "A1":
                case "A5":
                    if (tile[1] != 0)
                        System.out.println("false");
                case "D0":
                    if (tile[0] != 0)
                        System.out.println("false");
                case "D1":
                    if (tile[2] != 0)
                        System.out.println("false");
                case "G1":
                case "G5":
                    if (tile[3] != 0)
                        System.out.println("false");
                case "A3":
                    if (tile[1] != 1)
                        System.out.println("false");
                case "B0":
                case "F0":
                    if (tile[0] != 1)
                        System.out.println("false");
                case "B6":
                case "F6":
                    if (tile[2] != 1)
                        System.out.println("false");
                case "G3":
                    if (tile[3] != 1)
                        System.out.println("false");
            }
        }
        System.out.println("true");
    }
}
