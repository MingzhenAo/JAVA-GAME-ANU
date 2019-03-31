package comp1110.ass2;

import static java.lang.Character.getNumericValue;

public class Test {
    public static void main(String[] args) {
        TileRotate r = new TileRotate();
        String a = "A4B21";
        String b = "S1B37";

        int[] tileA = {TileEnum.valueOf(a.substring(0, 2)).left, TileEnum.valueOf(a.substring(0, 2)).top,
                TileEnum.valueOf(a.substring(0, 2)).right, TileEnum.valueOf(a.substring(0, 2)).bottom};

        int[] tileB = {TileEnum.valueOf(b.substring(0, 2)).left, TileEnum.valueOf(b.substring(0, 2)).top,
                TileEnum.valueOf(b.substring(0, 2)).right, TileEnum.valueOf(b.substring(0, 2)).bottom};

        r.rotatetime(tileA, getNumericValue(a.charAt(4)));
        r.rotatetime(tileB, getNumericValue(b.charAt(4)));

        if (a.charAt(2) == b.charAt(2) && a.charAt(3) - b.charAt(3) == 1) //same row;a right;b left.
        {
            if (tileA[0] == tileB[2] && tileA[0] != 5)
                System.out.println("true");
        }
        if (a.charAt(2) == b.charAt(2) && b.charAt(3) - a.charAt(3) == 1) // same row;b right;a left.
        {
            if (tileA[2] == tileB[0] && tileA[2] != 5)
                System.out.println("true");
        }
        if (a.charAt(3) == b.charAt(3) && (int) a.charAt(2) - (int) b.charAt(2) == 1) // same column;b above; a below.
        {
            if (tileA[1] == tileB[3] && tileA[1] != 5)
                System.out.println("true");
        }
        if (a.charAt(3) == b.charAt(3) && (int) b.charAt(2) - (int) a.charAt(2) == 1) //same column;a above; b below
        {
            if (tileA[3] == tileB[1] && tileA[3] != 5)
                System.out.println("true");
        }
        System.out.println("fasle");
    }

}
