package comp1110.ass2;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

        String a = tilePlacementStringA;
        String b = tilePlacementStringB;

         /*
        a.substring(0, 2) will return the object's name of TileEnum, such as A0, A1 etc.
        Then, by the method of valueOf(String name), we will get the corresponding object.
        */
        TileEnum tA = TileEnum.valueOf(a.substring(0, 2));
        TileEnum tB = TileEnum.valueOf(b.substring(0, 2));


        int[] tileA = {tA.left, tA.top, tA.right, tA.bottom};
        int[] tileB = {tB.left, tB.top, tB.right, tB.bottom};

        TileRotate r = new TileRotate();

        r.rotateTime(tileA, getNumericValue(a.charAt(4)));
        r.rotateTime(tileB, getNumericValue(b.charAt(4)));


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


    /**
     * it's basically areConnectedNeighbours but the occasion when nothing connects to anything returns true
     * only when highway connects railway returns false
     * @param tilePlacementStringA
     * @param tilePlacementStringB
     * @return fasle when highway connects railway
     */
    public static boolean areLegallyConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        String a = tilePlacementStringA;
        String b = tilePlacementStringB;

         /*
        a.substring(0, 2) will return the object's name of TileEnum, such as A0, A1 etc.
        Then, by the method of valueOf(String name), we will get the corresponding object.
        */
        TileEnum tA = TileEnum.valueOf(a.substring(0, 2));
        TileEnum tB = TileEnum.valueOf(b.substring(0, 2));


        int[] tileA = {tA.left, tA.top, tA.right, tA.bottom};
        int[] tileB = {tB.left, tB.top, tB.right, tB.bottom};

        TileRotate r = new TileRotate();

        r.rotateTime(tileA, getNumericValue(a.charAt(4)));
        r.rotateTime(tileB, getNumericValue(b.charAt(4)));


        if (a.charAt(2) == b.charAt(2) && a.charAt(3) - b.charAt(3) == 1) //same row; a right; b left.
        {
            if ((tileA[0] == 1 && tileB[2] == 0) || (tileA[0] == 0 && tileB[2] == 1))
                return false;
        }
        if (a.charAt(2) == b.charAt(2) && b.charAt(3) - a.charAt(3) == 1) // same row; b right; a left.
        {
            if ((tileA[2] == 0 && tileB[0] == 1) || (tileA[2] == 1 && tileB[0] == 0))
                return false;
        }
        if (a.charAt(3) == b.charAt(3) && (int) a.charAt(2) - (int) b.charAt(2) == 1) // same column; b above; a below.
        {
            if ((tileA[1] == 0 && tileB[3] == 1) && (tileA[1] == 1 && tileB[3] == 0))
                return false;
        }
        if (a.charAt(3) == b.charAt(3) && (int) b.charAt(2) - (int) a.charAt(2) == 1) //same column; a above; b below
        {
            if ((tileA[3] == 0 && tileB[1] == 1) && (tileA[3] == 1 && tileB[1] == 0))
                return false;
        }

        //If all of these above are satisfied, the placements are legally connected neighbours.
        return true;
    }


    /**
     * @param placementString
     * @return an int array containing 4 integers.
     * The fist element represents left;
     * The second element  represents top;
     * The third  element represents right;
     * The forth  element represents bottom;
     * <p>
     * 0 represents a highway; 1 represents a railway; 5 represents blank
     * <p>
     * For example if the array is [0,5,1,5],
     * it means the tile has a highway in the left, blank for top, a railway for right, blank for bottom
     */
    public static int[] getRotatedTile(String placementString) {

        TileRotate r = new TileRotate();
        int[] tile = new int[4];
        TileEnum tileName = TileEnum.valueOf(placementString.substring(0, 2));

        tile[0] = tileName.left;
        tile[1] = tileName.top;
        tile[2] = tileName.right;
        tile[3] = tileName.bottom;

        r.rotateTime(tile, getNumericValue(placementString.charAt(4)));

        return tile;
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

        String[] placementStringArray = getPlacementStringArray(boardString);

        TileRotate r = new TileRotate();


        //testing are legal connected
        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (areConnectedNeighbours(placementStringArray[i], placementStringArray[j]) == false) {//说明两个tile不是相邻且连接的

                    /*
                     * A tile may have one or more edges touching a blank edge of another tile; this is referred to as disconnected,
                     * but the placement is still legal.
                     *
                     */
                    if (placementStringArray[i].charAt(2) == placementStringArray[j].charAt(2) && placementStringArray[i].charAt(3) - placementStringArray[j].charAt(3) == 1) //same row,i right, j left
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[i])[0] != 5 && getRotatedTile(placementStringArray[j])[2] != 5) {
                            return false;
                        }

                    } else if (placementStringArray[i].charAt(2) == placementStringArray[j].charAt(2) && placementStringArray[j].charAt(3) - placementStringArray[i].charAt(3) == 1)// same row,j right, i left
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[j])[0] != 5 && getRotatedTile(placementStringArray[i])[2] != 5) {
                            return false;
                        }
                    } else if (placementStringArray[i].charAt(3) == placementStringArray[j].charAt(3) && (int) placementStringArray[i].charAt(2) - (int) placementStringArray[j].charAt(2) == 1)//same column,i below, j top
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[i])[1] != 5 && getRotatedTile(placementStringArray[j])[3] != 5) {
                            return false;
                        }
                    } else if (placementStringArray[i].charAt(3) == placementStringArray[j].charAt(3) && (int) placementStringArray[j].charAt(2) - (int) placementStringArray[i].charAt(2) == 1)//same column,j below, i top
                    {
                        //Determine whether a tile have one or more edges touching a blank edge of another tile
                        if (getRotatedTile(placementStringArray[j])[1] != 5 && getRotatedTile(placementStringArray[i])[3] != 5) {
                            return false;
                        }

                    }
                }
            }
        }

        /*
        testing are correctly connected to exit
        String[] highwayExits = {"A1","A5","D0","D6","G1","G5"}; exits with highway
        String[] railwayExits = {"A3","B0","B6","F0","F6","G3"}; exits with railway
        */

        int[] tile = new int[4];
        int b = 0;

        for (int i = 0; i < count; i++) {
            tile[0] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).left;
            tile[1] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).top;
            tile[2] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).right;
            tile[3] = TileEnum.valueOf(placementStringArray[i].substring(0, 2)).bottom;
            r.rotateTime(tile, getNumericValue(placementStringArray[i].charAt(4)));


            switch (placementStringArray[i].substring(2, 4)) {
                case "A1":
                    b++;
                    if (tile[1] != 0)
                        return false;
                    break;
                case "A5":
                    b++;
                    if (tile[1] != 0)
                        return false;
                    break;
                case "D0":
                    b++;
                    if (tile[0] != 0)
                        return false;
                    break;
                case "D6":
                    b++;
                    if (tile[2] != 0)
                        return false;
                    break;
                case "G1":
                    b++;
                    if (tile[3] != 0)
                        return false;
                    break;
                case "G5":
                    b++;
                    if (tile[3] != 0)
                        return false;
                    break;
                case "A3":
                    b++;
                    if (tile[1] != 1)
                        return false;
                    break;
                case "B0":
                    b++;
                    if (tile[0] != 1)
                        return false;
                    break;
                case "B6":
                    b++;
                    if (tile[2] != 1)
                        return false;
                    break;
                case "F0":
                    b++;
                    if (tile[0] != 1)
                        return false;
                    break;
                case "F6":
                    b++;
                    if (tile[2] != 1)
                        return false;
                    break;
                case "G3":
                    b++;
                    if (tile[3] != 1)
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
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Each die has faces numbered 0-5.
     * Each die roll is formed of 'A' or 'B' representing the dice, and '0'-'5' representing the face.
     *
     * @return a String representing the die roll e.g. A0A4A3B2
     */
    public static String generateDiceRoll() {
        // FIXME Task 7: generate a dice roll
        return "A" + (int) Math.random() * 6 + "A" + (int) Math.random() * 6 + "A" + (int) Math.random() * 6 + "B" + (int) Math.random() * 6;
    }


    /**
     *
     * @param d
     * @param c
     * @return
     */
    public static HashMap<String, String> line(String d[], HashMap<String, String> c) {
        HashMap<String, String> e = new HashMap<>();
        for (int i = 0; i < d.length; i++) {
            if (c.get(d[i]) != null) {
                for (int k = 0; k < d.length; k++) {
                    if (areConnectedNeighbours(d[i], d[k]) && c.get(d[k]) == null) {
                        c.put(d[k], d[k].substring(2, 4));
                        e.put(d[k], d[k].substring(2, 4));
                    }
                }
                for (int j = 0; j < d.length; j++) {
                    if (c.get(d[j]) != null) {
                        for (int l = 0; l < d.length; l++) {
                            if (areConnectedNeighbours(d[j], d[l]) && c.get(d[l]) == null) {
                                c.put(d[l], d[l].substring(2, 4));
                                e.put(d[l], d[l].substring(2, 4));
                            }
                        }
                    }
                }
            }
        }
        return c;
    }


    /**
     *
     * @param boardString
     * @return
     */
    public static ArrayList<HashMap<String, String>> exitsMapped(String boardString) {
        String[] boardStringArray = getPlacementStringArray(boardString);
        HashMap<String, String> a = new HashMap<>();
        ArrayList<HashMap<String, String>> b = new ArrayList<>();
        while (a.size() != boardStringArray.length) {
            for (int i = 0; i < boardStringArray.length; i++) {
                if (a.get(boardStringArray[i]) == null) {
                    a.put(boardStringArray[i], boardStringArray[i].substring(2, 4));
                    HashMap<String, String> m = line(boardStringArray, a);
                    m.put(boardStringArray[i], boardStringArray[i].substring(2, 4));
                    b.add(m);
                }
            }
        }
        return b;
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
        String[] boardStringArray = getPlacementStringArray(boardString);
        //central tiles
        for (int i = 0; i < boardStringArray.length; i++) {
            if (boardStringArray[i].charAt(2) >= 'C' && boardStringArray[i].charAt(2) <= 'E') {
                if (boardStringArray[i].charAt(3) >= '2' && boardStringArray[i].charAt(3) <= '4') {
                    score++;
                }
            }
        }

        //exits mapped

        //add the score according to the exits mapped
        ArrayList<Integer> f = new ArrayList<>();
        for (int i = 0; i < exitsMapped(boardString).size(); i++) {
            HashMap<String, String> a = exitsMapped(boardString).get(i);
            int count = 0;
            for (int j = 0; j < boardStringArray.length; j++) {
                switch (a.get(boardStringArray[j])) {
                    case "A1":
                        count++;
                        break;
                    case "A5":
                        count++;
                        break;
                    case "D0":
                        count++;
                        break;
                    case "D6":
                        count++;
                        break;
                    case "G1":
                        count++;
                        break;
                    case "G5":
                        count++;
                        break;
                    case "A3":
                        count++;
                        break;
                    case "B0":
                        count++;
                        break;
                    case "B6":
                        count++;
                        break;
                    case "F0":
                        count++;
                        break;
                    case "F6":
                        count++;
                        break;
                    case "G3":
                        count++;
                        break;
                }
            }
            f.add(count);
        }

        for (int j = 0; j < f.size(); j++) {
            switch (f.get(j)) {
                case 2:
                    score += 4;
                    break;
                case 3:
                    score += 8;
                    break;
                case 4:
                    score += 12;
                    break;
                case 5:
                    score += 16;
                    break;
                case 6:
                    score += 20;
                    break;
                case 7:
                    score += 24;
                    break;
                case 8:
                    score += 28;
                    break;
                case 9:
                    score += 32;
                    break;
                case 10:
                    score += 36;
                    break;
                case 11:
                    score += 40;
                    break;
                case 12:
                    score += 45;
                    break;
            }
        }
        //dead ends
        TileRotate m = new TileRotate();
        for (int i = 0; i < boardStringArray.length; i++) {
            score -= 4; //assume every time it's got 4 dead ends
            //get rid of the end that's blank or empty with the number 5
            if (TileEnum.valueOf(boardStringArray[i].substring(0, 2)).left == 5)
                score++;
            if (TileEnum.valueOf(boardStringArray[i].substring(0, 2)).top == 5)
                score++;
            if (TileEnum.valueOf(boardStringArray[i].substring(0, 2)).right == 5)
                score++;
            if (TileEnum.valueOf(boardStringArray[i].substring(0, 2)).bottom == 5)
                score++;
            //if the tile was connected to the exit then plus 1
            switch (boardStringArray[i].substring(2, 3)) {
                case "A":
                    if (getRotatedTile(boardStringArray[i])[1] != 5)
                        score++;
                    break;
                case "G":
                    if (getRotatedTile(boardStringArray[i])[3] != 5)
                        score++;
                    break;
            }
            switch (boardStringArray[i].substring(3, 4)) {
                case "0":
                    if (getRotatedTile(boardStringArray[i])[0] != 5)
                        score++;
                    break;
                case "6":
                    if (getRotatedTile(boardStringArray[i])[2] != 5)
                        score++;
                    break;
            }
            //any connected neighbors then plus 1
            for (int j = 0; j < boardStringArray.length; j++) {
                if (areConnectedNeighbours(boardStringArray[i], boardStringArray[j]))
                    score++;
            }
        }

        return score;
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
        String[] head = new String[4];
        head[0] = diceRoll.substring(0,2);
        head[1] = diceRoll.substring(2,4);
        head[2] = diceRoll.substring(4,6);
        head[3] = diceRoll.substring(6,8);
        if (head[0].equals(head[1]))
            head[1] = "";
        if (head[0].equals(head[2]))
            head[2] = "";
        if (head[1].equals(head[2]))
            head[2] = "";
        String[] boardStringArray = getPlacementStringArray(boardString);
        Map<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i ++) {
            tilesMap.put(boardStringArray[i].substring(2,4), boardStringArray[i]);
        }
        String check;
        String checkLeft;
        String checkUp;
        String checkRight;
        String checkDown;
        String result = "";
        for (int j = 0; j < head.length; j ++) {
            if (head[j] == "")
                continue;
            for (char row = 'A'; row <= 'G'; row ++) {
                for (int column = 0; column <= 6; column ++) {
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
                    for (int orientation = 0; orientation <= 7; orientation ++) {
                        if (tilesMap.containsKey(checkLeft)){
                            if (!areConnectedNeighbours(tilesMap.get(checkLeft), head[j] + row + column + orientation))
                                continue;
                        }
                        if (tilesMap.containsKey(checkUp)){
                            if (!areConnectedNeighbours(tilesMap.get(checkUp), head[j] + row + column + orientation))
                                continue;
                        }
                        if (tilesMap.containsKey(checkRight)){
                            if (!areConnectedNeighbours(tilesMap.get(checkRight), head[j] + row + column + orientation))
                                continue;
                        }
                        if (tilesMap.containsKey(checkDown)){
                            if (!areConnectedNeighbours(tilesMap.get(checkDown), head[j] + row + column + orientation))
                                continue;
                        }
                        result += head[j] + row + column + orientation;
                    }
                }
            }
        }
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
}
