package comp1110.ass2;

import org.junit.Test;

import java.util.*;

import static comp1110.ass2.Board.getEmptyGrids;

public class BoardTest {


    public static void printMap(Map<String, int[]> map) {
        //Get set by method keySet()
        Set<String> set = map.keySet();

        //Get an object of Iterator via set
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            //Get a key
            String key = it.next();

            //Get relevant value by key
            int[] value = map.get(key);

            //Print
            System.out.println(key + Arrays.toString(value));
        }
    }


    /*
     Test method getBoard()
     */
    @Test
    public void TestGetBoard() {
        //1.Create an object of Class Board
        Board board = new Board();
        //2.Call the method getBoard()
        LinkedHashMap<String, int[]> boardMap = board.getBoard();

        //Print boardMap
        printMap(boardMap);
    }


    /*
     Test method getPlacementBoard(String boardString)
     */
    @Test
    public void TestGetPlacementBoard() {

        //This is the boardString waiting for being passed
        String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getPlacementBoard(String boardString)
        LinkedHashMap<String, int[]> placementBoardMap = board.getPlacementBoard(boardString);

        //Print placementBoardMap
        printMap(placementBoardMap);
    }


    /*
      Test method getAllGridsCondition(String boardString)
    */
    @Test
    public void TestGetAllGridsCondition() {

        //This is the boardString waiting for being passed
        String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getAllGridsCondition(String boardString)
        ArrayList<String> allGridsConditionList = board.getAllGridsCondition(boardString);

        //Print
        for (int i = 0; i < allGridsConditionList.size(); i++) {
            System.out.println(allGridsConditionList.get(i));
        }

    }


    /*
      Test method getPlacementGrids(String boardString)
    */
    @Test
    public void TestGetPlacementGrids() {
        //This is the boardString waiting for being passed
        String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getPlacementGrids(String boardString)
        ArrayList<String> placementGridsList = board.getPlacementGrids(boardString);

        //Print
        for (int i = 0; i < placementGridsList.size(); i++) {
            System.out.println(placementGridsList.get(i));
        }
    }


    /*
      Test method getEmptyGrids(String boardString)
    */
    @Test
    public void TestGetEmptyGrids() {
        //This is the boardString waiting for being passed
        String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getEmptyGrids(String boardString)
        String[] emptyGridsArray = board.getEmptyGrids(boardString);

        for (int i = 0; i < emptyGridsArray.length; i++) {
            System.out.println(emptyGridsArray[i]);
        }

    }


    /*
      Test method getFirstValidPlacementString(String boardString, ArrayList<String> list)
    */
    @Test
    public void TestGetFirstValidPlacementString() {
        //This is the boardString waiting for being passed
        String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";

        //This is the list waiting for being passed
        ArrayList<String> list = new ArrayList();

        //Get all empty grids
        String[] emptyGrid = getEmptyGrids(boardString);

        //Put all potential placemenString into the list
        for (int i = 0; i < emptyGrid.length; i++) {

            for (int j = 0; j < 8; j++) {//j is the 8 kinds of orientation
                list.add("A1" + emptyGrid[i] + j);

            }
        }

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getEmptyGrids(String boardString)
        String validPlacementString = board.getFirstValidPlacementString(boardString, list);

        System.out.println(validPlacementString);
    }


}

