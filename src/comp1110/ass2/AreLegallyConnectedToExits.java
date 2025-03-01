package comp1110.ass2;

import static java.lang.Character.getNumericValue;

public class AreLegallyConnectedToExits {

    /**
     * Author: Yusen Wei
     * the method to test a given boardString are legally placed at the exits
     *
     * @param boardString
     * @return true if it's legal
     */
    public static boolean areLegallyPlacedToExits(String boardString) {
        String[] placementStringArray = RailroadInk.getPlacementStringArray(boardString);

        TileRotate r = new TileRotate();

        /*
        testing are correctly connected to exit
        String[] highwayExits = {"A1","A5","D0","D6","G1","G5"}; exits with highway
        String[] railwayExits = {"A3","B0","B6","F0","F6","G3"}; exits with railway
        */
        int b = 0;
        int[] tile = new int[4];

        for (int i = 0; i < placementStringArray.length; i++) {
            tile[0] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).left;
            tile[1] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).top;
            tile[2] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).right;
            tile[3] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).bottom;
            r.rotateTime(tile, getNumericValue(placementStringArray[i].charAt(4)));

            switch (placementStringArray[i].substring(2, 4)) {
                case "A1":
                    b++;
                    if (tile[1] != 0 && tile[1] != 5)
                        return false;
                    break;
                case "A5":
                    b++;
                    if (tile[1] != 0 && tile[1] != 5)
                        return false;
                    break;
                case "D0":
                    b++;
                    if (tile[0] != 0 && tile[0] != 5)
                        return false;
                    break;
                case "D6":
                    b++;
                    if (tile[2] != 0 && tile[2] != 5)
                        return false;
                    break;
                case "G1":
                    b++;
                    if (tile[3] != 0 && tile[3] != 5)
                        return false;
                    break;
                case "G5":
                    b++;
                    if (tile[3] != 0 && tile[3] != 5)
                        return false;
                    break;
                case "A3":
                    b++;
                    if (tile[1] != 1 && tile[1] != 5)
                        return false;
                    break;
                case "B0":
                    b++;
                    if (tile[0] != 1 && tile[0] != 5)
                        return false;
                    break;
                case "B6":
                    b++;
                    if (tile[2] != 1 && tile[2] != 5)
                        return false;
                    break;
                case "F0":
                    b++;
                    if (tile[0] != 1 && tile[0] != 5)
                        return false;
                    break;
                case "F6":
                    b++;
                    if (tile[2] != 1 && tile[2] != 5)
                        return false;
                    break;
                case "G3":
                    b++;
                    if (tile[3] != 1 && tile[3] != 5)
                        return false;
                    break;
            }
        }

        if (b == 0) {
            return false;
        }
        return true;
    }


    /**
     * Author: Zixin Ye
     * the method test whether a given placementString is legally placed at the exits
     *
     * @param placementString
     * @return true if it's legal
     */
    public static boolean areLegallyConnectedToExits(String placementString) {

        TileRotate r = new TileRotate();
        /*
        testing are correctly connected to exit
        String[] highwayExits = {"A1","A5","D0","D6","G1","G5"}; exits with highway
        String[] railwayExits = {"A3","B0","B6","F0","F6","G3"}; exits with railway
        */

        int[] tile = new int[4];

        tile[0] = TileEnum.valueOf(placementString.substring(0, 2)).left;
        tile[1] = TileEnum.valueOf(placementString.substring(0, 2)).top;
        tile[2] = TileEnum.valueOf(placementString.substring(0, 2)).right;
        tile[3] = TileEnum.valueOf(placementString.substring(0, 2)).bottom;
        r.rotateTime(tile, getNumericValue(placementString.charAt(4)));

        switch (placementString.substring(2, 4)) {
            case "A1":
                if (tile[1] == 0) {
                    return true;
                }
                break;
            case "A5":
                if (tile[1] == 0) {
                    return true;
                }
                break;
            case "D0":
                if (tile[0] == 0) {
                    return true;
                }
                break;
            case "D6":
                if (tile[2] == 0) {
                    return true;
                }
                break;
            case "G1":
                if (tile[3] == 0) {
                    return true;
                }
                break;
            case "G5":
                if (tile[3] == 0) {
                    return true;
                }
                break;
            case "A3":
                if (tile[1] == 1) {
                    return true;
                }
                break;
            case "B0":
                if (tile[0] == 1) {
                    return true;
                }
                break;
            case "B6":
                if (tile[2] == 1) {
                    return true;
                }
                break;
            case "F0":
                if (tile[0] == 1) {
                    return true;
                }
                break;
            case "F6":
                if (tile[2] == 1) {
                    return true;
                }
                break;
            case "G3":
                if (tile[3] == 1) {
                    return true;
                }
                break;
        }
        return false;
    }


}

