package comp1110.ass2;

import static comp1110.ass2.TileRotate.getRotatedTile;

public class ConnectedNeighbours {
    public static boolean connectedNeighboursOrNot(String a, String b) {
        int[] tileA = getRotatedTile(a);
        int[] tileB = getRotatedTile(b);

        if (a.charAt(2) == b.charAt(2) && a.charAt(3) - b.charAt(3) == 1) //same row; a right; b left.
        {
            if (tileA[0] == tileB[2] && tileA[0] != 5)
                return true;
            /*
            It means that only the left edge of tilePlacementStringA should be the same with the
            right edge of tilePlacementStringB and the edges must exist(but we only need to determine one of them here).
            */
        }

        if (a.charAt(2) == b.charAt(2) && b.charAt(3) - a.charAt(3) == 1) // same row; b right; a left.
        {
            if (tileA[2] == tileB[0] && tileA[2] != 5)
                return true;
              /*
            It means that only the right edge of tilePlacementStringA should be the same with the
            left edge of tilePlacementStringB and the edges must exist(but we only need to determine one of them here).
            */
        }

        if (a.charAt(3) == b.charAt(3) && (int) a.charAt(2) - (int) b.charAt(2) == 1) // same column; b above; a below.
        {
            if (tileA[1] == tileB[3] && tileA[1] != 5)
                return true;

            /*
            It means that only the top edge of tilePlacementStringA should be the same with the
            bottom edge of tilePlacementStringB and the edges must exist(but we only need to determine one of them here).
            */
        }
        if (a.charAt(3) == b.charAt(3) && (int) b.charAt(2) - (int) a.charAt(2) == 1) //same column; a above; b below
        {
            if (tileA[3] == tileB[1] && tileA[3] != 5)
                return true;
              /*
            It means that only the bottom edge of tilePlacementStringA should be the same with the
            top edge of tilePlacementStringB and the edges must exist(but we only need to determine one of them here).
            */
        }

        //If all of these above are not satisfied, the placements are not connected neighbours.
        return false;
    }
}
