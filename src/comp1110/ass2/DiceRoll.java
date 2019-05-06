package comp1110.ass2;

import java.util.ArrayList;

import static comp1110.ass2.Board.getEmptyGrids;
import static comp1110.ass2.Board.getValidPlacementString;


/**
 * This class provides all methods about DiceRoll
 */

public class DiceRoll {


    //This first dice
    public static String dice01(String boardString, String diceRoll) {

        String[] head = new String[1];//A or B
        ArrayList<String> list = new ArrayList();

        head[0] = diceRoll.substring(0, 2);//e.g. A1

        //找还剩几个空格,也就是还可以放置的地方
        String[] emptyGrid = getEmptyGrids(boardString);

        //将所有空格与该骰子的组合下，所有可能贴图放入集合中,e.g.A1A53
        for (int i = 0; i < emptyGrid.length; i++) {

            for (int j = 0; j < 8; j++) {//j is the 8 kinds of orientation
                list.add("" + head[0] + emptyGrid[i] + j);

            }
        }

        //return those tiles that really can use
        return getValidPlacementString(boardString, list);
    }


    //This second dice
    public static String dice02(String boardString, String diceRoll) {

        String[] head = new String[1];
        ArrayList<String> list = new ArrayList();

        head[0] = diceRoll.substring(2, 4);

        String[] emptyGrid = getEmptyGrids(boardString);

        //将所有空格与该骰子的所有可能贴图放入集合中
        for (int i = 0; i < emptyGrid.length; i++) {

            for (int j = 0; j < 8; j++) {
                list.add("" + head[0] + emptyGrid[i] + j);

            }
        }
        return getValidPlacementString(boardString, list);
    }


    //This third dice
    public static String dice03(String boardString, String diceRoll) {

        String[] head = new String[1];
        ArrayList<String> list = new ArrayList();


        head[0] = diceRoll.substring(4, 6);

        String[] emptyGrid = getEmptyGrids(boardString);

        //将所有空格与该骰子的所有可能贴图放入集合中
        for (int i = 0; i < emptyGrid.length; i++) {

            for (int j = 0; j < 8; j++) {
                list.add("" + head[0] + emptyGrid[i] + j);

            }
        }
        return getValidPlacementString(boardString, list);
    }


    //This fourth dice
    public static String dice04(String boardString, String diceRoll) {

        String[] head = new String[1];
        ArrayList<String> list = new ArrayList();

        head[0] = diceRoll.substring(6, 8);

        String[] emptyGrid = getEmptyGrids(boardString);

        //将所有空格与该骰子的所有可能贴图放入集合中
        for (int i = 0; i < emptyGrid.length; i++) {

            for (int j = 0; j < 8; j++) {
                list.add("" + head[0] + emptyGrid[i] + j);
            }
        }
        return getValidPlacementString(boardString, list);
    }


    /**
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll    a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String getMove(String boardString, String diceRoll) {

        ArrayList<String> list = new ArrayList(24);


        //1234的顺序
        String temp01 = "";
        String boardString01 = boardString;

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
        String longest = list.get(0);//将数组的第一个元素赋给max

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > longest.length()) {//如果arr[i]大于最大值，就将arr[i]赋给最大值
                longest = list.get(i);
            }

        }

        return longest;
    }

}
