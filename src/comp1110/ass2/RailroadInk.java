package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.ConnectedNeighbours.connectedNeighboursOrNot;
import static comp1110.ass2.DiceRoll.getMove;
import static comp1110.ass2.TileRotate.getRotatedTile;
import static comp1110.ass2.getBasicScore.*;
import static java.lang.Character.getNumericValue;

public class RailroadInk {
    /**
     * Determine whether a tile placement string is well-formed:
     * - it consists of exactly 5 characters;
     * - the first character represents a die A or B, or a special tile S
     * - the second character indicates which tile or face of the die (0-5 for die A and special tiles, or 0-2 for die B)
     * - the third character represents the placement row A-G
     * - the fourth character represents the placement column 0-6
     * - the fifth character represents the orientation 0-7
     *
     * @param tilePlacementString a candidate tile placement string
     * @return true if the tile placement is well formed
     */
    public static boolean isTilePlacementWellFormed(String tilePlacementString) {
        // FIXME Task 2: determine whether a tile placement is well-formed

        if (tilePlacementString.length() != 5)
            return false;

        char[] t = tilePlacementString.toCharArray();

        if (t[2] >= 'A' && t[2] <= 'G') {                   //the third character represents the placement row A-G
            if (t[3] >= '0' && t[3] <= '6') {               //the fourth character represents the placement column 0-6
                if (t[4] >= '0' && t[4] <= '7') {           //the fifth character represents the orientation 0-7
                    if (t[0] == 'A' || t[0] == 'S') {
                        if (t[1] >= '0' && t[1] <= '5')
                            return true;
                    } else if (t[0] == 'B')
                        if (t[1] >= '0' && t[1] <= '2')
                            return true;
                }
            }
        }
        return false;
    }

    /**
     * Get a String array containing N five-character tile placements (where N = 1 .. 31)
     *
     * @param boardString a board string representing some placement sequence
     * @return a String array containing N five-character tile placements (where N = 1 .. 31)
     */
    public static String[] getPlacementStringArray(String boardString) {
        int number = boardString.length() / 5;
        String[] placementStringArray = new String[number];
        for (int i = 0; i < number; i++) {
            placementStringArray[i] = boardString.substring(5 * i, 5 * (i + 1));
        }
        return placementStringArray;
    }


    /**
     * Determine whether a board string is well-formed:
     * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
     * - each piece placement is well-formed
     * - no more than three special tiles are included
     *
     * @param boardString a board string describing the placement of one or more pieces
     * @return true if the board string is well-formed
     */
    public static boolean isBoardStringWellFormed(String boardString) {
        // FIXME Task 3: determine whether a board string is well-formed
    /*
    it consists of exactly N five-character tile placements (where N = 1 .. 31)
    */
        if (boardString == null || boardString.length() == 0 || boardString.length() % 5 != 0 || boardString.length() > 155) {
            return false;
        }

        /*
        no more than three special tiles are included
         */
        char[] bsc = boardString.toCharArray();
        int count1 = 0;

        for (int i = 0; i < bsc.length; i++) {
            if (bsc[i] == 'S') {
                count1++;
            }

        }


        if (count1 > 3) {
            return false;
        }

        /*
        each piece placement is well-formed
         */

        String[] boardStringArray = getPlacementStringArray(boardString);

        for (int i = 0; i < boardStringArray.length; i++) {
            if (!isTilePlacementWellFormed(boardStringArray[i])) {
                return false;
            }
        }

        return true;
    }


    /**
     * Determine whether the provided placements are neighbours connected by at least one validly connecting edge.
     * For example,
     * - areConnectedNeighbours("A3C10", "A3C23") would return true as these tiles are connected by a highway edge;
     * - areConnectedNeighbours("A3C23", "B1B20") would return false as these neighbouring tiles are disconnected;
     * - areConnectedNeighbours("A0B30", "A3B23") would return false as these neighbouring tiles have an
     * invalid connection between highway and railway; and
     * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
     *
     * @return true if the placements are connected neighbours
     */
    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        // FIXME Task 5: determine whether neighbouring placements are connected
        return connectedNeighboursOrNot(tilePlacementStringA, tilePlacementStringB);
    }


    /**
     * Given a well-formed board string representing an ordered list of placements,
     * determine whether the board string is valid.
     * A board string is valid if each tile placement is legal with respect to all previous tile
     * placements in the string, according to the rules for legal placements:
     * - A tile must be placed such that at least one edge connects to either an exit or a pre-existing route.
     * Such a connection is called a valid connection.
     * - Tiles may not be placed such that a highway edge connects to a railway edge;
     * this is referred to as an invalid connection.
     * Highways and railways may only join at station tiles.
     * - A tile may have one or more edges touching a blank edge of another tile;
     * this is referred to as disconnected, but the placement is still legal.
     *
     * @param boardString a board string representing some placement sequence
     * @return true if placement sequence is valid
     */
    public static boolean isValidPlacementSequence(String boardString) {
        // FIXME Task 6: determine whether the given placement sequence is valid
        if (!AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(boardString))
            return false;
        if (!AreLegallyConnectedToExits.areLegallyConnectedToExits(boardString))
            return false;
        return true;

    }

    /**
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Each die has faces numbered 0-5.
     * Each die roll is formed of 'A' or 'B' representing the dice, and '0'-'5' representing the face.
     *
     * @return a String representing the die roll e.g. A0A4A3B2
     */
    public static String generateDiceRoll() {
        // FIXME Task 7: generate a dice roll
        int[] m = new int[3];
        String a = "";
        for (int i = 0; i < 3; i++) {
            m[i] = (int) (Math.random() * 6);
            a = a + "A" + m[i];
        }
        a = a + "B" + (int) (Math.random() * 3);
        return a;
    }

    /**
     * Given the current state of a game board, output an integer representing the sum of all the following factors
     * that contribute to the player's final score.
     * <p>
     * * Number of exits mapped
     * * Number of centre tiles used
     * * Number of dead ends in the network
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for score *not* considering longest rail/highway
     */
    public static int getBasicScore(String boardString) {
        // FIXME Task 8: compute the basic score
        int score = 0;
        //central tiles
        score += centralTilesScore(boardString);
        //exits mapped
        //add the score according to the exits mapped
        score += exitsScore(boardString);
        //dead ends
        score += getEndScore(boardString);
        return score;
    }


    /**
     * @param placementString
     * @param tilesMap
     * @return
     */
    public static boolean canIPlaceTheStringHere(String placementString, HashMap<String, String> tilesMap) {
        String checkLeft = "";
        String checkUp = "";
        String checkRight = "";
        String checkDown = "";

        char row = placementString.charAt(2);
        int column = placementString.charAt(3);

        checkLeft += row;
        checkLeft += (char) (column - 1);
        checkUp += (char) ((int) row - 1);
        checkUp += (char) column;
        checkRight += row;
        checkRight += (char) (column + 1);
        checkDown += (char) ((int) row + 1);
        checkDown += (char) column;
        boolean b = false;

        //They should legally connect all the near tiles and have at lest one connected neighbour
        if (tilesMap.containsKey(checkLeft)) {
            if (!AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(tilesMap.get(checkLeft), placementString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkLeft), placementString))
                b = true;
        }
        if (tilesMap.containsKey(checkUp)) {
            if (!AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(tilesMap.get(checkUp), placementString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkUp), placementString))
                b = true;

        }
        if (tilesMap.containsKey(checkRight)) {
            if (!AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(tilesMap.get(checkRight), placementString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkRight), placementString))
                b = true;
        }
        if (tilesMap.containsKey(checkDown)) {
            if (!AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(tilesMap.get(checkDown), placementString))
                return false;
            if (areConnectedNeighbours(tilesMap.get(checkDown), placementString))
                b = true;
        }

        return b;
    }


    /**
     * Given a valid boardString and a dice roll for the round,
     * return a String representing an ordered sequence of valid piece placements for the round.
     *
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll    a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String generateMove(String boardString, String diceRoll) {
        // FIXME Task 10: generate a valid move
        String result = getMove(boardString, diceRoll);

        return result;
    }


    /**
     * Given the current state of a game board, output an integer representing the sum of all the factors contributing
     * to `getBasicScore`, as well as those attributed to:
     * <p>
     * * Longest railroad
     * * Longest highway
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for final score (not counting expansion packs)
     */
    public static int getAdvancedScore(String boardString) {
        // FIXME Task 12: compute the total score including bonus points
        return -1;
    }

    public static int getLongestRailway(String boardString) {
        String[] boardStringArray = getPlacementStringArray(boardString);
        /*
        ArrayList<String> railwayList = new ArrayList<>();
        railwayList.add("B0");
        railwayList.add("F0");
        railwayList.add("A3");
        railwayList.add("G3");
        railwayList.add("B6");
        railwayList.add("F6");
         */
        ArrayList<String> railwayTileList = new ArrayList<>();
        railwayTileList.add("S0");
        railwayTileList.add("S1");
        railwayTileList.add("S3");
        railwayTileList.add("S4");
        railwayTileList.add("S5");
        railwayTileList.add("A0");
        railwayTileList.add("A1");
        railwayTileList.add("A2");
        railwayTileList.add("B0");
        railwayTileList.add("B1");
        railwayTileList.add("B2");
        ArrayList<String> routList = new ArrayList<>();
        HashMap<String, ArrayList<String>> routMap = new HashMap<>();
        for (var v : boardStringArray) {
            if (railwayTileList.contains(v.substring(0, 2))) {
                for (var v2 : boardStringArray) {
                    routList.clear();
                    if (areConnectedNeighbours(v2, v)) {

                    }
                }
            }
        }
        return 0;
    }
}
