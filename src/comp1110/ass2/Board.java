package comp1110.ass2;

import java.util.*;

import static comp1110.ass2.RailroadInk.*;
import static comp1110.ass2.TileRotate.getRotatedTile;

public class Board {

    public static LinkedHashMap<String, int[]> getBoard() {

        LinkedHashMap<String, int[]> board = new LinkedHashMap<>();
        int[] temp = {0};

        board.put("A0", temp);
        board.put("A1", temp);
        board.put("A2", temp);
        board.put("A3", temp);
        board.put("A4", temp);
        board.put("A5", temp);
        board.put("A6", temp);

        board.put("B0", temp);
        board.put("B1", temp);
        board.put("B2", temp);
        board.put("B3", temp);
        board.put("B4", temp);
        board.put("B5", temp);
        board.put("B6", temp);

        board.put("C0", temp);
        board.put("C1", temp);
        board.put("C2", temp);
        board.put("C3", temp);
        board.put("C4", temp);
        board.put("C5", temp);
        board.put("C6", temp);

        board.put("D0", temp);
        board.put("D1", temp);
        board.put("D2", temp);
        board.put("D3", temp);
        board.put("D4", temp);
        board.put("D5", temp);
        board.put("D6", temp);

        board.put("E0", temp);
        board.put("E1", temp);
        board.put("E2", temp);
        board.put("E3", temp);
        board.put("E4", temp);
        board.put("E5", temp);
        board.put("E6", temp);

        board.put("F0", temp);
        board.put("F1", temp);
        board.put("F2", temp);
        board.put("F3", temp);
        board.put("F4", temp);
        board.put("F5", temp);
        board.put("F6", temp);

        board.put("G0", temp);
        board.put("G1", temp);
        board.put("G2", temp);
        board.put("G3", temp);
        board.put("G4", temp);
        board.put("G5", temp);
        board.put("G6", temp);

        return board;

    }


    public static ArrayList<String> getAllPlacement(String boardString) {

        HashMap<String, int[]> placementBoard = getPlacementBoard(boardString);

        Set<Map.Entry<String, int[]>> set = placementBoard.entrySet();


        ArrayList<String> combo = new ArrayList<>();


        for (Map.Entry<String, int[]> entry : set) {

            String key = entry.getKey();
            int[] value = entry.getValue();

            combo.add(key + Arrays.toString(value));
        }


        //清除所有没有占的格子(一定要倒着遍历，不然会因为索引移动清除不干净)
        for (int i = combo.size() - 1; i >= 0; i--) {

            if (combo.get(i).length() == 5) {
                combo.remove(i);
            }
        }

        return combo;


    }


    public static String[] getEmptyGrid(String boardString) {

        HashMap<String, int[]> placementBoard = getPlacementBoard(boardString);

        Set<Map.Entry<String, int[]>> set = placementBoard.entrySet();


        ArrayList<String> combo = new ArrayList<>();


        for (Map.Entry<String, int[]> entry : set) {

            String key = entry.getKey();
            int[] value = entry.getValue();

            combo.add(key + Arrays.toString(value));
        }


        //清除所有已经占用的格子(一定要倒着遍历，不然会因为索引移动清除不干净)
        for (int i = combo.size() - 1; i >= 0; i--) {

            if (combo.get(i).length() != 5) {
                combo.remove(i);
            }
        }


        String[] a = new String[combo.size()];


        for (int i = 0; i < combo.size(); i++) {

            a[i] = combo.get(i).substring(0, 2);

        }

        return a;

    }


    public static LinkedHashMap<String, int[]> getPlacementBoard(String boardString) {

        String[] placementStringArray = getPlacementStringArray(boardString);

        LinkedHashMap<String, int[]> placementBoard = Board.getBoard();//获得游戏板


        //得到所有放置后的tile,并存入对应的格子里


        for (int i = 0; i < placementStringArray.length; i++) {

            placementBoard.put(placementStringArray[i].substring(2, 4), getRotatedTile(placementStringArray[i]));

        }

        return placementBoard;

    }


    /**
     * 根据boardingString，返回第一个可以拼接的placementString
     *
     * @param boardString 当前boardString,能反映还剩哪些空格，以及被占空格上贴纸的情况
     * @param list        该骰子理论上能过出现的所有placementString的集合
     * @return
     */
    public static String getValidPlacementString(String boardString, ArrayList<String> list) {


        String result = "";

        //获得所有placementString,放在一个数组中
        String[] placementStringArray = getPlacementStringArray(boardString);

        //定义一个容器list
        List<String> placementList = new ArrayList<>();

        //使用for循环将placementString数组，转换为存放字符串的list集合中
        for (String str : placementStringArray) {
            placementList.add(str);
        }

        //遍历，找出合规的字符串
        for (int i = 0; i < list.size(); i++) {

            boolean flag;

            for (int j = 0; j < placementList.size(); j++) {

                flag = areConnectedNeighbours(list.get(i), placementList.get(j));

                if (flag) {
                    //判断添加新placementString后,新的完整的boardString字符串是否合规
                    boolean b = isValidPlacementSequence(boardString + list.get(i));

                    if (b) {
                        result = list.get(i);
                        return result;
                    }

                }

            }

        }

        return result;
    }


}
