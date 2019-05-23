package comp1110.ass2;

import java.util.ArrayList;

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

        String a97 =special(boardString01);
        temp01 +=a97;
        boardString01 +=a97;

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

        String a98 =special(boardString02);
        temp02 +=a98;
        boardString02 +=a98;

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

        String a99 =special(boardString03);
        temp03 +=a99;
        boardString03 +=a99;

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

        String a100 =special(boardString04);
        temp04 +=a100;
        boardString04 +=a100;

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

        String a101 =special(boardString05);
        temp05 +=a101;
        boardString05 +=a101;

        String a102 =special(boardString05);
        temp05 +=a102;
        boardString05 +=a102;

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

        String a103 =special(boardString06);
        temp06 +=a103;
        boardString06 +=a103;

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

        String a104 =special(boardString07);
        temp07 +=a104;
        boardString07 +=a104;

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

        String a105 =special(boardString08);
        temp08 +=a105;
        boardString08 +=a105;

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

        String a106 =special(boardString09);
        temp09 +=a106;
        boardString09 +=a106;

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

        String a107 =special(boardString10);
        temp10 +=a107;
        boardString09 +=a107;

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

        String a108 =special(boardString11);
        temp11 +=a108;
        boardString09 +=a108;

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

        String a109 =special(boardString12);
        temp12 +=a109;
        boardString09 +=a109;

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

        String a110 =special(boardString13);
        temp13 +=a110;
        boardString13 +=a110;

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

        String a111 =special(boardString14);
        temp14 +=a111;
        boardString14 +=a111;

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

        String a112 =special(boardString15);
        temp15 +=a112;
        boardString15 +=a112;

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

        String a113 =special(boardString16);
        temp16 +=a113;
        boardString16 +=a113;

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

        String a114 =special(boardString17);
        temp17 +=a114;
        boardString17 +=a114;

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

        String a115 =special(boardString18);
        temp18 +=a115;
        boardString18 +=a115;

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

        String a116 =special(boardString19);
        temp19 +=a116;
        boardString19 +=a116;

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

        String a117 =special(boardString20);
        temp20 +=a117;
        boardString20 +=a117;

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

        String a118 =special(boardString21);
        temp21 +=a118;
        boardString21 +=a118;

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

        String a119 =special(boardString22);
        temp22 +=a119;
        boardString22 +=a119;

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

        String a120 =special(boardString23);
        temp23 +=a120;
        boardString23 +=a120;

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

        String a121 =special(boardString24);
        temp24 +=a121;
        boardString24 +=a121;

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


    /**
     * @param boardString
     * @return
     */
    public static String getFirstValidSpecial(String boardString) {

        String[] placementStringArray = getPlacementStringArray(boardString);

        //Get a String ArrayList
        ArrayList<String> placementList = new ArrayList<>();


        //Take all elements in the placementStringArray to the list
        for (String str : placementStringArray) {
            placementList.add(str);
        }


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

        //使用Special总计超过3次
        if (countS >= 3) {
            return "";
        }

        //每种Special超过1次
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
        String[] s = {"S5", "S0", "S3", "S1", "S2", "S4",};
        for (int i = 0; i < s.length; i++) {
            for (int k = 0; k < emptyGrid.length; k++) {

                for (int j = 0; j < 8; j++) {//j is the 8 kinds of orientation
                    list.add("" + s[i] + emptyGrid[k] + j);
                }
            }

        }


        //Increase randomness
        randomListSort(list);

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
            if (areLegallyConnectedToExits(list.get(i))) {
                if (isValidPlacementSequence(boardString + list.get(i)))
                    return list.get(i);
            }
        }
        return "";
}}
