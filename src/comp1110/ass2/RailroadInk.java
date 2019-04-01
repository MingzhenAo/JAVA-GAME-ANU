package comp1110.ass2;

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
    public static String[] getBoardStringArray(String boardString) {
        int number = boardString.length() / 5;

        String[] boardStringArray = new String[number];

        for (int i = 0; i < number; i++) {
            if (i <= number - 1) {
                boardStringArray[i] = boardString.substring(5 * i, 5 * (i + 1));
            }

            if (i == number) {
                boardStringArray[i] = boardString.substring(5 * i, 5 * (i + 1) + 1);
            }
        }
        return boardStringArray;
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

        String[] boardStringArray = getBoardStringArray(boardString);

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
        TileRotate r = new TileRotate();
        String a = tilePlacementStringA;
        String b = tilePlacementStringB;

        int[] tileA = {TileEnum.valueOf(a.substring(0, 2)).left, TileEnum.valueOf(a.substring(0, 2)).top,
                TileEnum.valueOf(a.substring(0, 2)).right, TileEnum.valueOf(a.substring(0, 2)).bottom};

        int[] tileB = {TileEnum.valueOf(b.substring(0, 2)).left, TileEnum.valueOf(b.substring(0, 2)).top,
                TileEnum.valueOf(b.substring(0, 2)).right, TileEnum.valueOf(b.substring(0, 2)).bottom};

        r.rotatetime(tileA, getNumericValue(a.charAt(4)));
        r.rotatetime(tileB, getNumericValue(b.charAt(4)));

        if (a.charAt(2) == b.charAt(2) && a.charAt(3) - b.charAt(3) == 1) //same row;a right;b left.
        {
            if (tileA[0] == tileB[2] && tileA[0] != 5)
                return true;
        }
        if (a.charAt(2) == b.charAt(2) && b.charAt(3) - a.charAt(3) == 1) // same row;b right;a left.
        {
            if (tileA[2] == tileB[0] && tileA[2] != 5)
                return true;
        }
        if (a.charAt(3) == b.charAt(3) && (int) a.charAt(2) - (int) b.charAt(2) == 1) // same column;b above; a below.
        {
            if (tileA[1] == tileB[3] && tileA[1] != 5)
                return true;
        }
        if (a.charAt(3) == b.charAt(3) && (int) b.charAt(2) - (int) a.charAt(2) == 1) //same column;a above; b below
        {
            if (tileA[3] == tileB[1] && tileA[3] != 5)
                return true;
        }
        return false;
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
        int count = boardString.length() / 5;

        String[] boardStringArray = getBoardStringArray(boardString);

        //testing are connected neighbours
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (areConnectedNeighbours(boardStringArray[i], boardStringArray[j]) != true) {
                    if (boardStringArray[i].charAt(2) == boardStringArray[j].charAt(2) && boardStringArray[i].charAt(3) - boardStringArray[j].charAt(3) == 1)
                        return false;
                    else if (boardStringArray[i].charAt(2) == boardStringArray[j].charAt(2) && boardStringArray[j].charAt(3) - boardStringArray[i].charAt(3) == 1)
                        return false;
                    else if (boardStringArray[i].charAt(3) == boardStringArray[j].charAt(3) && (int) boardStringArray[i].charAt(2) - (int) boardStringArray[j].charAt(2) == 1)
                        return false;
                    else if (boardStringArray[i].charAt(3) == boardStringArray[j].charAt(3) && (int) boardStringArray[j].charAt(2) - (int) boardStringArray[i].charAt(2) == 1)
                        return false;
                }
            }
        }

        //testing are correctly connected to exit
        //String[] exitshighway = {"A1","A5","D0","D6","G1","G5"}; exits with highway
        //String[] exitsrailway = {"A3","B0","B6","F0","F6","G3"}; exits with railway
        TileRotate r = new TileRotate();
        int[] tile = new int[4];
        for (int i = 0; i < count; i++) {
            tile[0] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).left;
            tile[1] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).top;
            tile[2] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).right;
            tile[3] = TileEnum.valueOf(boardStringArray[i].substring(0, 2)).bottom;
            r.rotatetime(tile, getNumericValue(boardStringArray[i].charAt(4)));
            switch (boardStringArray[i].substring(3, 5)) {
                case "A1":
                case "A5":
                    if (tile[1] != 0)
                        return false;
                case "D0":
                    if (tile[0] != 0)
                        return false;
                case "D1":
                    if (tile[2] != 0)
                        return false;
                case "G1":
                case "G5":
                    if (tile[3] != 0)
                        return false;
                case "A3":
                    if (tile[1] != 1)
                        return false;
                case "B0":
                case "F0":
                    if (tile[0] != 1)
                        return false;
                case "B6":
                case "F6":
                    if (tile[2] != 1)
                        return false;
                case "G3":
                    if (tile[3] != 1)
                        return false;
            }
        }
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
        return "";
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
        return -1;
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
        return null;
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
}

