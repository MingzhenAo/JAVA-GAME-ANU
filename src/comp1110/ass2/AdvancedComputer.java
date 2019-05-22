package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import static comp1110.ass2.AreLegallyConnectedToExits.areLegallyConnectedToExits;
import static comp1110.ass2.Board.getEmptyGrids;
import static comp1110.ass2.DiceRoll.*;
import static comp1110.ass2.RailroadInk.*;

public class AdvancedComputer {


    //The Special Tile
    public static String special(String boardString) {

        ArrayList<String> list = new ArrayList();
        //找还剩几个空格,也就是还可以放置的地方
        String[] emptyGrid = getEmptyGrids(boardString);

        //添加特殊tiles
        String[] s = {"S0", "S1", "S2", "S3", "S4", "S5"};
        for (int i = 0; i < s.length; i++) {
            for (int k = 0; k < emptyGrid.length; k++) {

                for (int j = 0; j < 8; j++) {//j is the 8 kinds of orientation
                    list.add("" + s[i] + emptyGrid[k] + j);
                }
            }

        }

        return getFirstValidSpecial(boardString);
    }


    /**
     * Author: Zixin Ye
     *
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll    a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String getAdvancedMove(String boardString, String diceRoll) {


        ArrayList<String> list = new ArrayList(24);

        //1234的顺序
        String temp01 = "";
        String boardString01 = boardString;

        temp01 += special(boardString01);

        temp01 += dice01(boardString01, diceRoll);
        boardString01 += dice01(boardString01, diceRoll);

        temp01 += dice02(boardString01, diceRoll);
        boardString01 += dice02(boardString01, diceRoll);

        temp01 += dice03(boardString01, diceRoll);
        boardString01 += dice03(boardString01, diceRoll);

        temp01 += dice04(boardString01, diceRoll);
        boardString01 += dice04(boardString01, diceRoll);

        list.add(temp01);


        //1243的顺序
        String temp02 = "";
        String boardString02 = boardString;

        temp02 += special(boardString02);

        temp02 += dice01(boardString02, diceRoll);
        boardString02 += dice01(boardString02, diceRoll);

        temp02 += dice02(boardString02, diceRoll);
        boardString02 += dice02(boardString02, diceRoll);


        temp02 += dice04(boardString02, diceRoll);
        boardString02 += dice04(boardString02, diceRoll);

        temp02 += dice03(boardString02, diceRoll);
        boardString02 += dice03(boardString02, diceRoll);

        list.add(temp02);


        //1324的顺序
        String temp03 = "";
        String boardString03 = boardString;

        temp03 += special(boardString03);

        temp03 += dice01(boardString03, diceRoll);
        boardString03 += dice01(boardString03, diceRoll);

        temp03 += dice03(boardString03, diceRoll);
        boardString03 += dice03(boardString03, diceRoll);

        temp03 += dice02(boardString03, diceRoll);
        boardString03 += dice02(boardString03, diceRoll);

        temp03 += dice04(boardString03, diceRoll);
        boardString03 += dice04(boardString03, diceRoll);

        list.add(temp03);


        //1342的顺序
        String temp04 = "";
        String boardString04 = boardString;

        temp04 += special(boardString04);

        temp04 += dice01(boardString04, diceRoll);
        boardString04 += dice01(boardString04, diceRoll);

        temp04 += dice03(boardString04, diceRoll);
        boardString04 += dice03(boardString04, diceRoll);

        temp04 += dice04(boardString04, diceRoll);
        boardString04 += dice04(boardString04, diceRoll);

        temp04 += dice02(boardString04, diceRoll);
        boardString04 += dice02(boardString04, diceRoll);

        list.add(temp04);


        //1423的顺序
        String temp05 = "";
        String boardString05 = boardString;

        temp05 += special(boardString05);

        temp05 += dice01(boardString05, diceRoll);
        boardString05 += dice01(boardString05, diceRoll);


        temp05 += dice04(boardString05, diceRoll);
        boardString05 += dice04(boardString05, diceRoll);

        temp05 += dice02(boardString05, diceRoll);
        boardString05 += dice02(boardString05, diceRoll);

        temp05 += dice03(boardString05, diceRoll);
        boardString05 += dice03(boardString05, diceRoll);

        list.add(temp05);


        //1432的顺序
        String temp06 = "";
        String boardString06 = boardString;

        temp06 += special(boardString06);

        temp06 += dice01(boardString06, diceRoll);
        boardString06 += dice01(boardString06, diceRoll);

        temp06 += dice04(boardString06, diceRoll);
        boardString06 += dice04(boardString06, diceRoll);

        temp06 += dice03(boardString06, diceRoll);
        boardString06 += dice03(boardString06, diceRoll);

        temp06 += dice02(boardString06, diceRoll);
        boardString06 += dice02(boardString06, diceRoll);

        list.add(temp06);


        //2134的顺序
        String temp07 = "";
        String boardString07 = boardString;

        temp07 += special(boardString07);

        temp07 += dice02(boardString07, diceRoll);
        boardString07 += dice02(boardString07, diceRoll);

        temp07 += dice01(boardString07, diceRoll);
        boardString07 += dice01(boardString07, diceRoll);

        temp07 += dice03(boardString07, diceRoll);
        boardString07 += dice03(boardString07, diceRoll);

        temp07 += dice04(boardString07, diceRoll);
        boardString07 += dice04(boardString07, diceRoll);

        list.add(temp07);


        //2143的顺序
        String temp08 = "";

        String boardString08 = boardString;

        temp08 += special(boardString08);

        temp08 += dice02(boardString08, diceRoll);
        boardString08 += dice02(boardString08, diceRoll);

        temp08 += dice01(boardString08, diceRoll);
        boardString08 += dice01(boardString08, diceRoll);

        temp08 += dice04(boardString08, diceRoll);
        boardString08 += dice04(boardString08, diceRoll);

        temp08 += dice03(boardString08, diceRoll);
        boardString08 += dice03(boardString08, diceRoll);

        list.add(temp08);


        //2341的顺序
        String temp09 = "";
        String boardString09 = boardString;
        temp09 += special(boardString09);

        temp09 += dice02(boardString09, diceRoll);
        boardString09 += dice02(boardString09, diceRoll);

        temp09 += dice03(boardString09, diceRoll);
        boardString09 += dice03(boardString09, diceRoll);

        temp09 += dice04(boardString09, diceRoll);
        boardString09 += dice04(boardString09, diceRoll);

        temp09 += dice01(boardString09, diceRoll);
        boardString09 += dice01(boardString09, diceRoll);

        list.add(temp09);


        //2314的顺序
        String temp10 = "";
        String boardString10 = boardString;

        temp10 += special(boardString10);

        temp10 += dice02(boardString10, diceRoll);
        boardString10 += dice02(boardString10, diceRoll);

        temp10 += dice03(boardString10, diceRoll);
        boardString10 += dice03(boardString10, diceRoll);

        temp10 += dice01(boardString10, diceRoll);
        boardString10 += dice01(boardString10, diceRoll);

        temp10 += dice04(boardString10, diceRoll);
        boardString10 += dice04(boardString10, diceRoll);

        list.add(temp10);


        //2413的顺序
        String temp11 = "";
        String boardString11 = boardString;

        temp11 += special(boardString11);

        temp11 += dice02(boardString11, diceRoll);
        boardString11 += dice02(boardString11, diceRoll);

        temp11 += dice04(boardString11, diceRoll);
        boardString11 += dice04(boardString11, diceRoll);

        temp11 += dice01(boardString11, diceRoll);
        boardString11 += dice01(boardString11, diceRoll);

        temp11 += dice03(boardString11, diceRoll);
        boardString11 += dice03(boardString11, diceRoll);

        list.add(temp11);


        //2431的顺序
        String temp12 = "";
        String boardString12 = boardString;

        temp12 += special(boardString12);

        temp12 += dice02(boardString12, diceRoll);
        boardString12 += dice02(boardString12, diceRoll);

        temp12 += dice04(boardString12, diceRoll);
        boardString12 += dice04(boardString12, diceRoll);

        temp12 += dice03(boardString12, diceRoll);
        boardString12 += dice03(boardString12, diceRoll);

        temp12 += dice01(boardString12, diceRoll);
        boardString12 += dice01(boardString12, diceRoll);

        list.add(temp12);


        //3124的顺序
        String temp13 = "";
        String boardString13 = boardString;

        temp13 += special(boardString13);

        temp13 += dice03(boardString13, diceRoll);
        boardString13 += dice03(boardString13, diceRoll);

        temp13 += dice01(boardString13, diceRoll);
        boardString13 += dice01(boardString13, diceRoll);

        temp13 += dice02(boardString13, diceRoll);
        boardString13 += dice02(boardString13, diceRoll);

        temp13 += dice04(boardString13, diceRoll);
        boardString13 += dice04(boardString13, diceRoll);

        list.add(temp13);


        //3142的顺序
        String temp14 = "";
        String boardString14 = boardString;

        temp14 += special(boardString14);

        temp14 += dice03(boardString14, diceRoll);
        boardString14 += dice03(boardString14, diceRoll);

        temp14 += dice01(boardString14, diceRoll);
        boardString14 += dice01(boardString14, diceRoll);

        temp14 += dice04(boardString14, diceRoll);
        boardString14 += dice04(boardString14, diceRoll);

        temp14 += dice02(boardString14, diceRoll);
        boardString14 += dice02(boardString14, diceRoll);


        list.add(temp14);

        //3241的顺序
        String temp15 = "";

        String boardString15 = boardString;

        temp15 += special(boardString15);

        temp15 += dice03(boardString15, diceRoll);
        boardString15 += dice03(boardString15, diceRoll);

        temp15 += dice02(boardString15, diceRoll);
        boardString15 += dice02(boardString15, diceRoll);

        temp15 += dice04(boardString15, diceRoll);
        boardString15 += dice04(boardString15, diceRoll);

        temp15 += dice01(boardString15, diceRoll);
        boardString15 += dice01(boardString15, diceRoll);

        list.add(temp15);


        //3214的顺序
        String temp16 = "";

        String boardString16 = boardString;

        temp16 += special(boardString16);

        temp16 += dice03(boardString16, diceRoll);
        boardString16 += dice03(boardString16, diceRoll);

        temp16 += dice02(boardString16, diceRoll);
        boardString16 += dice02(boardString16, diceRoll);

        temp16 += dice01(boardString16, diceRoll);
        boardString16 += dice01(boardString16, diceRoll);

        temp16 += dice04(boardString16, diceRoll);
        boardString16 += dice04(boardString16, diceRoll);

        list.add(temp16);

        //3412的顺序
        String temp17 = "";
        String boardString17 = boardString;

        temp17 += special(boardString17);

        temp17 += dice03(boardString17, diceRoll);
        boardString17 += dice03(boardString17, diceRoll);

        temp17 += dice04(boardString17, diceRoll);
        boardString17 += dice04(boardString17, diceRoll);

        temp17 += dice01(boardString17, diceRoll);
        boardString17 += dice01(boardString17, diceRoll);

        temp17 += dice02(boardString17, diceRoll);
        boardString17 += dice02(boardString17, diceRoll);

        list.add(temp17);

        //3421的顺序
        String temp18 = "";

        String boardString18 = boardString;

        temp18 += special(boardString18);

        temp18 += dice03(boardString18, diceRoll);
        boardString18 += dice03(boardString18, diceRoll);

        temp18 += dice04(boardString18, diceRoll);
        boardString18 += dice04(boardString18, diceRoll);

        temp18 += dice02(boardString18, diceRoll);
        boardString18 += dice02(boardString18, diceRoll);

        temp18 += dice01(boardString18, diceRoll);
        boardString18 += dice01(boardString18, diceRoll);

        list.add(temp18);


        //4123的顺序
        String temp19 = "";
        String boardString19 = boardString;

        temp19 += special(boardString19);

        temp19 += dice04(boardString19, diceRoll);
        boardString19 += dice04(boardString19, diceRoll);

        temp19 += dice01(boardString19, diceRoll);
        boardString19 += dice01(boardString19, diceRoll);

        temp19 += dice02(boardString19, diceRoll);
        boardString19 += dice02(boardString19, diceRoll);

        temp19 += dice03(boardString19, diceRoll);
        boardString19 += dice03(boardString19, diceRoll);

        list.add(temp19);

        //4132的顺序
        String temp20 = "";
        String boardString20 = boardString;

        temp20 += special(boardString20);

        temp20 += dice04(boardString20, diceRoll);
        boardString20 += dice04(boardString20, diceRoll);

        temp20 += dice01(boardString20, diceRoll);
        boardString20 += dice01(boardString20, diceRoll);

        temp20 += dice03(boardString20, diceRoll);
        boardString20 += dice03(boardString20, diceRoll);

        temp20 += dice02(boardString20, diceRoll);
        boardString20 += dice02(boardString20, diceRoll);

        list.add(temp20);


        //4231的顺序
        String temp21 = "";
        String boardString21 = boardString;

        temp21 += special(boardString21);

        temp21 += dice04(boardString21, diceRoll);
        boardString21 += dice04(boardString21, diceRoll);

        temp21 += dice02(boardString21, diceRoll);
        boardString21 += dice02(boardString21, diceRoll);

        temp21 += dice03(boardString21, diceRoll);
        boardString21 += dice03(boardString21, diceRoll);

        temp21 += dice01(boardString21, diceRoll);
        boardString21 += dice01(boardString21, diceRoll);

        list.add(temp21);

        //4213的顺序
        String temp22 = "";
        String boardString22 = boardString;

        temp22 += special(boardString22);

        temp22 += dice04(boardString22, diceRoll);
        boardString22 += dice04(boardString22, diceRoll);

        temp22 += dice02(boardString22, diceRoll);
        boardString22 += dice02(boardString22, diceRoll);

        temp22 += dice01(boardString22, diceRoll);
        boardString22 += dice01(boardString22, diceRoll);

        temp22 += dice03(boardString22, diceRoll);
        boardString22 += dice03(boardString22, diceRoll);

        list.add(temp22);

        //4321的顺序
        String temp23 = "";
        String boardString23 = boardString;

        temp23 += special(boardString23);

        temp23 += dice04(boardString23, diceRoll);
        boardString23 += dice04(boardString23, diceRoll);

        temp23 += dice03(boardString23, diceRoll);
        boardString23 += dice03(boardString23, diceRoll);

        temp23 += dice02(boardString23, diceRoll);
        boardString23 += dice02(boardString23, diceRoll);

        temp23 += dice01(boardString23, diceRoll);
        boardString23 += dice01(boardString23, diceRoll);

        list.add(temp23);

        //4312的顺序
        String temp24 = "";
        String boardString24 = boardString;

        temp24 += special(boardString24);

        temp24 += dice04(boardString24, diceRoll);
        boardString24 += dice04(boardString24, diceRoll);

        temp24 += dice03(boardString24, diceRoll);
        boardString24 += dice03(boardString24, diceRoll);

        temp24 += dice01(boardString24, diceRoll);
        boardString24 += dice01(boardString24, diceRoll);

        temp24 += dice02(boardString24, diceRoll);
        boardString24 += dice02(boardString24, diceRoll);

        list.add(temp24);


        //the longest one must be true
        String longest = list.get(0);//将集合的第一个元素赋给longest


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > longest.length()) {//如果arr[i]大于最大值，就将arr[i]赋给最大值
                longest = list.get(i);
            }

        }

        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == longest.length()) {
                tempList.add(list.get(i));
            }

        }

        HashSet<String> set = new HashSet<>(tempList);
        //Get a new list after removing duplicate elements
        ArrayList<String> answerList = new ArrayList<>(set);


        // Increase randomness
        Random r = new Random();
        int a = r.nextInt(answerList.size());

        return answerList.get(a);
    }

    /**
     * Author: Zixin Ye
     * According to the boardingString passed, return the first placementString that can be connected.(Better Way)
     *
     * @param boardString
     * @param list        a list containing all placementString that theoretically a dice can generate
     * @return
     */
    public static String getAdvancedFirstValidPlacementString(String boardString, ArrayList<String> list) {

        //Get a String array that containing all placementString
        String[] placementStringArray = getPlacementStringArray(boardString);

        //The boardString may be ""
        if (placementStringArray.length == 0) {

            return getValidStringForEmptyBoardString(list);

        }


        //Get a String ArrayList
        ArrayList<String> placementList = new ArrayList<>();


        //Take all elements in the placementStringArray to the list
        for (String str : placementStringArray) {
            placementList.add(str);
        }


        //Preferentially determine whether to connect with existing tiles
        for (int i = 0; i < list.size(); i++) {

            boolean flag;

            for (int j = 0; j < placementList.size(); j++) {

                flag = areConnectedNeighbours(list.get(i), placementList.get(j));

                if (flag) {

                    //Determine whether a new boardString is valid, after added a new placementString
                    boolean b = isValidPlacementSequence(boardString + list.get(i));

                    if (b) {
                        return list.get(i);
                    }

                }
            }

            //If computer cannot connect to tiles that have been placed, consider Exits
            boolean exits = areLegallyConnectedToExits(list.get(i));
            if (exits) {
                if (isValidPlacementSequence(boardString + list.get(i)))
                    return list.get(i);
            }
        }
        return "";
    }


    public static String getFirstValidSpecial(String boardString) {

        String[] placementStringArray = getPlacementStringArray(boardString);

        int countS = 0;
        int countS0 = 0;
        int countS1 = 0;
        int countS2 = 0;
        int countS3 = 0;
        int countS4 = 0;
        int countS5 = 0;
        for (int i = 0; i < placementStringArray.length; i++) {

            if (placementStringArray[i].substring(0, 1).equals("S")) {
                countS++;
            }

            //每种Tile只能使用一次
            switch (placementStringArray[i].substring(0, 2)) {
                case "S0":
                    countS0++;
                    break;
                case "S1":
                    countS1++;
                    break;
                case "S2":
                    countS2++;
                    break;
                case "S3":
                    countS3++;
                    break;
                case "S4":
                    countS4++;
                    break;
                case "S5":
                    countS5++;
                    break;
            }


        }

        //使用Special超过3次
        if (countS >= 3) {
            return "";
        }

        //每种Special超过3次
        if (countS0 >= 1) {
            return "";
        }
        if (countS1 >= 1) {
            return "";
        }
        if (countS2 >= 1) {
            return "";
        }
        if (countS3 >= 1) {
            return "";
        }
        if (countS4 >= 1) {
            return "";
        }
        if (countS5 >= 1) {
            return "";
        }


        ArrayList<String> list = new ArrayList();
        //找还剩几个空格,也就是还可以放置的地方
        String[] emptyGrid = getEmptyGrids(boardString);

        //添加特殊tiles
        String[] s = {"S0", "S1", "S2", "S3", "S4", "S5"};
        for (int i = 0; i < s.length; i++) {
            for (int k = 0; k < emptyGrid.length; k++) {

                for (int j = 0; j < 8; j++) {//j is the 8 kinds of orientation
                    list.add("" + s[i] + emptyGrid[k] + j);
                }
            }

        }

        for (int i = 0; i < list.size(); i++) {

            if (isValidPlacementSequence(boardString + list.get(i))) {
                return list.get(i);
            }

            //If computer cannot connect to tiles that have been placed, consider Exits
            if (areLegallyConnectedToExits(list.get(i))) {
                if (isValidPlacementSequence(boardString + list.get(i)))
                    return list.get(i);
            }
        }

        return "";
    }
}
