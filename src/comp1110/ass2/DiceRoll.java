package comp1110.ass2;

import java.util.ArrayList;
import java.util.Random;

import static comp1110.ass2.Board.getEmptyGrids;
import static comp1110.ass2.Board.getFirstValidPlacementString;
import static comp1110.ass2.TileRotate.getRotatedTile;


/**
 * Author: Zixin Ye
 * This class provides all methods about DiceRoll
 */

public class DiceRoll {


    //The first dice
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
        return getFirstValidPlacementString(boardString, list);
    }


    //The second dice
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
        return getFirstValidPlacementString(boardString, list);
    }


    //The third dice
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

        return getFirstValidPlacementString(boardString, list);
    }


    //The fourth dice
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

        return getFirstValidPlacementString(boardString, list);
    }

    /**
     * This method give a random new order for a list
     *
     * @param list
     * @return
     */
    public static void randomListSort(ArrayList<String> list) {
        //Increase randomness
        Random r = new Random();
        int time = 0;
        while (time < list.size()) {

            int a = r.nextInt(list.size());

            String temp;
            temp = list.get(a);
            list.remove(list.get(a));
            list.add(temp);

            time++;
        }
    }

    /**
     * Author: Zixin Ye
     * This method return the first valid String for an empty boardString at the start of the turn
     *
     * @param list
     * @return
     */
    public static String getValidStringForEmptyBoardString(ArrayList<String> list) {

        //Increase randomness
        randomListSort(list);

        ArrayList<int[]> tileList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            tileList.add(getRotatedTile(list.get(i)));
        }


        for (int i = 0; i < list.size(); i++) {

            switch (list.get(i).substring(2, 4)) {
                case "A1":
                    if (tileList.get(i)[1] == 0) {
                        return list.get(i);
                    }
                    break;
                case "A5":

                    if (tileList.get(i)[1] == 0) {
                        return list.get(i);
                    }
                    break;
                case "D0":

                    if (tileList.get(i)[0] == 0) {
                        return list.get(i);
                    }
                    break;
                case "D6":

                    if (tileList.get(i)[2] == 0) {
                        return list.get(i);
                    }
                    break;
                case "G1":
                    if (tileList.get(i)[3] == 0) {
                        return list.get(i);
                    }
                    break;
                case "G5":

                    if (tileList.get(i)[3] == 0) {
                        return list.get(i);
                    }
                    break;
                case "A3":

                    if (tileList.get(i)[1] == 1) {
                        return list.get(i);
                    }
                    break;
                case "B0":

                    if (tileList.get(i)[0] == 1) {
                        return list.get(i);
                    }
                    break;
                case "B6":

                    if (tileList.get(i)[2] == 1) {
                        return list.get(i);
                    }
                    break;
                case "F0":

                    if (tileList.get(i)[0] == 1) {
                        return list.get(i);
                    }
                    break;
                case "F6":

                    if (tileList.get(i)[2] == 1) {
                        return list.get(i);
                    }
                    break;
                case "G3":

                    if (tileList.get(i)[3] == 1) {
                        return list.get(i);
                    }
                    break;
            }


        }
        return "";
    }


    /**
     * Author: Zixin Ye
     *
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
        String a1 = dice01(boardString01, diceRoll);
        temp01 += a1;
        boardString01 += a1;
        String a2 = dice02(boardString01, diceRoll);
        temp01 += a2;
        boardString01 += a2;
        String a3 = dice03(boardString01, diceRoll);
        temp01 += a3;
        boardString01 += a3;
        String a4 = dice04(boardString01, diceRoll);
        temp01 += a4;
        boardString01 += a4;

        list.add(temp01);


        //1243的顺序
        String temp02 = "";
        String boardString02 = boardString;
        String a5 = dice01(boardString02, diceRoll);
        temp02 += a5;
        boardString02 += a5;
        String a6 = dice02(boardString02, diceRoll);
        temp02 += a6;
        boardString02 += a6;

        String a7 = dice04(boardString02, diceRoll);
        temp02 += a7;
        boardString02 += a7;
        String a8 = dice03(boardString02, diceRoll);
        temp02 += a8;
        boardString02 += a8;

        list.add(temp02);


        //1324的顺序
        String temp03 = "";
        String boardString03 = boardString;
        String a9 = dice01(boardString03, diceRoll);
        temp03 += a9;
        boardString03 += a9;
        String a10 = dice03(boardString03, diceRoll);
        temp03 += a10;
        boardString03 += a10;
        String a11 = dice02(boardString03, diceRoll);
        temp03 += a11;
        boardString03 += a11;
        String a12 = dice04(boardString03, diceRoll);
        temp03 += a12;
        boardString03 += a12;

        list.add(temp03);


        //1342的顺序
        String temp04 = "";
        String boardString04 = boardString;
        String a13 = dice01(boardString04, diceRoll);
        temp04 += a13;
        boardString04 += a13;
        String a14 = dice03(boardString04, diceRoll);
        temp04 += a14;
        boardString04 += a14;
        String a15 = dice04(boardString04, diceRoll);
        temp04 += a15;
        boardString04 += a15;
        String a16 = dice02(boardString04, diceRoll);
        temp04 += a16;
        boardString04 += a16;

        list.add(temp04);


        //1423的顺序
        String temp05 = "";
        String boardString05 = boardString;
        String a17 = dice01(boardString05, diceRoll);
        temp05 += a17;
        boardString05 += a17;

        String a18 = dice04(boardString05, diceRoll);
        temp05 += a18;
        boardString05 += a18;
        String a19 = dice02(boardString05, diceRoll);
        temp05 += a19;
        boardString05 += a19;
        String a20 = dice03(boardString05, diceRoll);
        temp05 += a20;
        boardString05 += a20;


        list.add(temp05);


        //1432的顺序
        String temp06 = "";
        String boardString06 = boardString;
        String a21 = dice01(boardString06, diceRoll);
        temp06 += a21;
        boardString06 += a21;
        String a22 = dice04(boardString06, diceRoll);
        temp06 += a22;
        boardString06 += a22;
        String a23 = dice03(boardString06, diceRoll);
        temp06 += a23;
        boardString06 += a23;
        String a24 = dice02(boardString06, diceRoll);
        temp06 += a24;
        boardString06 += a24;

        list.add(temp06);


        //2134的顺序
        String temp07 = "";
        String boardString07 = boardString;
        String a25 = dice02(boardString07, diceRoll);
        temp07 += a25;
        boardString07 += a25;
        String a26 = dice01(boardString07, diceRoll);
        temp07 += a26;
        boardString07 += a26;
        String a27 = dice03(boardString07, diceRoll);
        temp07 += a27;
        boardString07 += a27;
        String a28 = dice04(boardString07, diceRoll);
        temp07 += a28;
        boardString07 += a28;

        list.add(temp07);


        //2143的顺序
        String temp08 = "";
        String boardString08 = boardString;
        String a29 = dice02(boardString08, diceRoll);
        temp08 += a29;
        boardString08 += a29;
        String a30 = dice01(boardString08, diceRoll);
        temp08 += a30;
        boardString08 += a30;
        String a31 = dice04(boardString08, diceRoll);
        temp08 += a31;
        boardString08 += a31;
        String a32 = dice03(boardString08, diceRoll);
        temp08 += a32;
        boardString08 += a32;

        list.add(temp08);


        //2341的顺序
        String temp09 = "";
        String boardString09 = boardString;
        String a33 = dice02(boardString09, diceRoll);
        temp09 += a33;
        boardString09 += a33;
        String a34 = dice03(boardString09, diceRoll);
        temp09 += a34;
        boardString09 += a34;
        String a35 = dice04(boardString09, diceRoll);
        temp09 += a35;
        boardString09 += a35;
        String a36 = dice01(boardString09, diceRoll);
        temp09 += a36;
        boardString09 += a36;

        list.add(temp09);


        //2314的顺序
        String temp10 = "";
        String boardString10 = boardString;
        String a37 = dice02(boardString10, diceRoll);
        temp10 += a37;
        boardString10 += a37;
        String a38 = dice03(boardString10, diceRoll);
        temp10 += a38;
        boardString10 += a38;
        String a39 = dice01(boardString10, diceRoll);
        temp10 += a39;
        boardString10 += a39;
        String a40 = dice04(boardString10, diceRoll);
        temp10 += a40;
        boardString10 += a40;

        list.add(temp10);


        //2413的顺序
        String temp11 = "";
        String boardString11 = boardString;
        String a41 = dice02(boardString11, diceRoll);
        temp11 += a41;
        boardString11 += a41;
        String a42 = dice04(boardString11, diceRoll);
        temp11 += a42;
        boardString11 += a42;
        String a43 = dice01(boardString11, diceRoll);
        temp11 += a43;
        boardString11 += a43;
        String a44 = dice03(boardString11, diceRoll);
        temp11 += a44;
        boardString11 += a44;

        list.add(temp11);


        //2431的顺序
        String temp12 = "";
        String boardString12 = boardString;
        String a45 = dice02(boardString12, diceRoll);
        temp12 += a45;
        boardString12 += a45;
        String a46 = dice04(boardString12, diceRoll);
        temp12 += a46;
        boardString12 += a46;
        String a47 = dice03(boardString12, diceRoll);
        temp12 += a47;
        boardString12 += a47;
        String a48 = dice01(boardString12, diceRoll);
        temp12 += a48;
        boardString12 += a48;

        list.add(temp12);


        //3124的顺序
        String temp13 = "";
        String boardString13 = boardString;
        String a49 = dice03(boardString13, diceRoll);
        temp13 += a49;
        boardString13 += a49;
        String a50 = dice01(boardString13, diceRoll);
        temp13 += a50;
        boardString13 += a50;
        String a51 = dice02(boardString13, diceRoll);
        temp13 += a51;
        boardString13 += a51;
        String a52 = dice04(boardString13, diceRoll);
        temp13 += a52;
        boardString13 += a52;

        list.add(temp13);


        //3142的顺序
        String temp14 = "";
        String boardString14 = boardString;
        String a53 = dice03(boardString14, diceRoll);
        temp14 += a53;
        boardString14 += a53;
        String a54 = dice01(boardString14, diceRoll);
        temp14 += a54;
        boardString14 += a54;
        String a55 = dice04(boardString14, diceRoll);
        temp14 += a55;
        boardString14 += a55;
        String a56 = dice02(boardString14, diceRoll);
        temp14 += a56;
        boardString14 += a56;

        list.add(temp14);

        //3241的顺序
        String temp15 = "";
        String boardString15 = boardString;
        String a57 = dice03(boardString15, diceRoll);
        temp15 += a57;
        boardString15 += a57;
        String a58 = dice02(boardString15, diceRoll);
        temp15 += a58;
        boardString15 += a58;
        String a59 = dice04(boardString15, diceRoll);
        temp15 += a59;
        boardString15 += a59;
        String a60 = dice01(boardString15, diceRoll);
        temp15 += a60;
        boardString15 += a60;

        list.add(temp15);


        //3214的顺序
        String temp16 = "";
        String boardString16 = boardString;
        String a61 = dice03(boardString16, diceRoll);
        temp16 += a61;
        boardString16 += a61;
        String a62 = dice02(boardString16, diceRoll);
        temp16 += a62;
        boardString16 += a62;
        String a63 = dice01(boardString16, diceRoll);
        temp16 += a63;
        boardString16 += a63;
        String a64 = dice04(boardString16, diceRoll);
        temp16 += a64;
        boardString16 += a64;

        list.add(temp16);

        //3412的顺序
        String temp17 = "";
        String boardString17 = boardString;
        String a65 = dice03(boardString17, diceRoll);
        temp17 += a65;
        boardString17 += a65;
        String a66 = dice04(boardString17, diceRoll);
        temp17 += a66;
        boardString17 += a66;
        String a67 = dice01(boardString17, diceRoll);
        temp17 += a67;
        boardString17 += a67;
        String a68 = dice02(boardString17, diceRoll);
        temp17 += a68;
        boardString17 += a68;

        list.add(temp17);

        //3421的顺序
        String temp18 = "";
        String boardString18 = boardString;
        String a69 = dice03(boardString18, diceRoll);
        temp18 += a69;
        boardString18 += a69;
        String a70 = dice04(boardString18, diceRoll);
        temp18 += a70;
        boardString18 += a70;
        String a71 = dice02(boardString18, diceRoll);
        temp18 += a71;
        boardString18 += a71;
        String a72 = dice01(boardString18, diceRoll);
        temp18 += a72;
        boardString18 += a72;

        list.add(temp18);


        //4123的顺序
        String temp19 = "";
        String boardString19 = boardString;
        String a73 = dice04(boardString19, diceRoll);
        temp19 += a73;
        boardString19 += a73;
        String a74 = dice01(boardString19, diceRoll);
        temp19 += a74;
        boardString19 += a74;
        String a75 = dice02(boardString19, diceRoll);
        temp19 += a75;
        boardString19 += a75;
        String a76 = dice03(boardString19, diceRoll);
        temp19 += a76;
        boardString19 += a76;

        list.add(temp19);

        //4132的顺序
        String temp20 = "";
        String boardString20 = boardString;
        String a77 = dice04(boardString20, diceRoll);
        temp20 += a77;
        boardString20 += a77;
        String a78 = dice01(boardString20, diceRoll);
        temp20 += a78;
        boardString20 += a78;
        String a79 = dice03(boardString20, diceRoll);
        temp20 += a79;
        boardString20 += a79;
        String a80 = dice02(boardString20, diceRoll);
        temp20 += a80;
        boardString20 += a80;

        list.add(temp20);


        //4231的顺序
        String temp21 = "";
        String boardString21 = boardString;
        String a81 = dice04(boardString21, diceRoll);
        temp21 += a81;
        boardString21 += a81;
        String a82 = dice02(boardString21, diceRoll);
        temp21 += a82;
        boardString21 += a82;
        String a83 = dice03(boardString21, diceRoll);
        temp21 += a83;
        boardString21 += a83;
        String a84 = dice01(boardString21, diceRoll);
        temp21 += a84;
        boardString21 += a84;

        list.add(temp21);

        //4213的顺序
        String temp22 = "";
        String boardString22 = boardString;
        String a85 = dice04(boardString22, diceRoll);
        temp22 += a85;
        boardString22 += a85;
        String a86 = dice02(boardString22, diceRoll);
        temp22 += a86;
        boardString22 += a86;
        String a87 = dice01(boardString22, diceRoll);
        temp22 += a87;
        boardString22 += a87;
        String a88 = dice03(boardString22, diceRoll);
        temp22 += a88;
        boardString22 += a88;

        list.add(temp22);

        //4321的顺序
        String temp23 = "";
        String boardString23 = boardString;
        String a89 = dice04(boardString23, diceRoll);
        temp23 += a89;
        boardString23 += a89;
        String a90 = dice03(boardString23, diceRoll);
        temp23 += a90;
        boardString23 += a90;
        String a91 = dice02(boardString23, diceRoll);
        temp23 += a91;
        boardString23 += a91;
        String a92 = dice01(boardString23, diceRoll);
        temp23 += a92;
        boardString23 += a92;

        list.add(temp23);

        //4312的顺序
        String temp24 = "";
        String boardString24 = boardString;
        String a93 = dice04(boardString24, diceRoll);
        temp24 += a93;
        boardString24 += a93;
        String a94 = dice03(boardString24, diceRoll);
        temp24 += a94;
        boardString24 += a94;
        String a95 = dice01(boardString24, diceRoll);
        temp24 += a95;
        boardString24 += a95;
        String a96 = dice02(boardString24, diceRoll);
        temp24 += a96;
        boardString24 += a96;

        list.add(temp24);


        //the longest one must be true
        String longest = list.get(0);//将集合的第一个元素赋给longest


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > longest.length()) {//如果arr[i]大于最大值，就将arr[i]赋给最大值
                longest = list.get(i);
            }

        }


        return longest;
    }

}