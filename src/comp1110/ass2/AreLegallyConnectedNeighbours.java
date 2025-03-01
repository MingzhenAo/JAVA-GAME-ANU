package comp1110.ass2;

import static comp1110.ass2.TileRotate.getRotatedTile;

public class AreLegallyConnectedNeighbours {
    /**
     * Author: Yusen Wei
     * It is basically same as method 'areConnectedNeighbours' but the two tiles should be next to each other
     * and when a highway connects a railway, it returns false.
     *
     * @param boardString
     * @return false only wen highway to railway
     */
    public static boolean areLegallyConnectedNeighbours(String boardString) {

        int count = boardString.length() / 5;

        String[] placementStringArray = RailroadInk.getPlacementStringArray(boardString);


        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (!RailroadInk.areConnectedNeighbours(placementStringArray[i], placementStringArray[j])) {//说明两个tile不是相邻且连接的

                    /*
                     * A tile may have one or more edges touching a blank edge of another tile; this is referred to as disconnected,
                     * but the placement is still legal.
                     *
                     */
                    if (placementStringArray[i].charAt(2) == placementStringArray[j].charAt(2) && placementStringArray[i].charAt(3) - placementStringArray[j].charAt(3) == 1) //same row,i right, j left
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[i])[0] != 5 && getRotatedTile(placementStringArray[j])[2] != 5) {
                            if(!areLegallyConnectedNeighbours(placementStringArray[i],placementStringArray[j]))
                            return false;
                        }

                    } else if (placementStringArray[i].charAt(2) == placementStringArray[j].charAt(2) && placementStringArray[j].charAt(3) - placementStringArray[i].charAt(3) == 1)// same row,j right, i left
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[j])[0] != 5 && getRotatedTile(placementStringArray[i])[2] != 5) {
                            if(!areLegallyConnectedNeighbours(placementStringArray[i],placementStringArray[j]))
                                return false;
                        }
                    } else if (placementStringArray[i].charAt(3) == placementStringArray[j].charAt(3) && (int) placementStringArray[i].charAt(2) - (int) placementStringArray[j].charAt(2) == 1)//same column,i below, j top
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[i])[1] != 5 && getRotatedTile(placementStringArray[j])[3] != 5) {
                            if(!areLegallyConnectedNeighbours(placementStringArray[i],placementStringArray[j]))
                                return false;
                        }
                    } else if (placementStringArray[i].charAt(3) == placementStringArray[j].charAt(3) && (int) placementStringArray[j].charAt(2) - (int) placementStringArray[i].charAt(2) == 1)//same column,j below, i top
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[j])[1] != 5 && getRotatedTile(placementStringArray[i])[3] != 5) {
                            if(!areLegallyConnectedNeighbours(placementStringArray[i],placementStringArray[j]))
                                return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    /**
     * Author: Yusen Wei
     * It is basically same as method 'areConnectedNeighbours' but when nothing connects to anything it returns true
     * and only when a highway connects a railway, it returns false.
     *
     * @param tilePlacementStringA
     * @param tilePlacementStringB
     * @return false when highway connects railway
     */
    public static boolean areLegallyConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        String a = tilePlacementStringA;
        String b = tilePlacementStringB;


        int[] tileA = getRotatedTile(a);
        int[] tileB = getRotatedTile(b);


        if (a.charAt(2) == b.charAt(2) && a.charAt(3) - b.charAt(3) == 1) //same row; a left; b right.
        {
            if ((tileA[2] == 1 && tileB[0] == 0) || (tileA[0] == 0 && tileB[2] == 1))
                return false;
        }

        if (a.charAt(2) == b.charAt(2) && b.charAt(3) - a.charAt(3) == 1) // same row; b left; a right.
        {
            if ((tileA[0] == 0 && tileB[2] == 1) || (tileA[2] == 1 && tileB[0] == 0))
                return false;
        }

        if (a.charAt(3) == b.charAt(3) && (int) a.charAt(2) - (int) b.charAt(2) == 1) // same column; b above; a below.
        {
            if ((tileA[1] == 0 && tileB[3] == 1) || (tileA[1] == 1 && tileB[3] == 0))
                return false;
        }

        if (a.charAt(3) == b.charAt(3) && (int) b.charAt(2) - (int) a.charAt(2) == 1) //same column; a above; b below
        {
            if ((tileA[3] == 0 && tileB[1] == 1) || (tileA[3] == 1 && tileB[1] == 0))
                return false;
        }

        //If all of these above are satisfied, the placements are legally connected neighbours.
        return true;
    }
}
