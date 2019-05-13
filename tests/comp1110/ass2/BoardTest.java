package comp1110.ass2;

import org.junit.Test;

import java.util.*;

import static comp1110.ass2.Board.getEmptyGrids;
import static org.junit.Assert.assertTrue;

public class BoardTest {


    /**
     * Test method getBoard()
     */
    @Test
    public void testGetBoard() {

        //This is the correct result
        String expectedBoard = "A0[0]A1[0]A2[0]A3[0]A4[0]A5[0]A6[0]B0[0]B1[0]B2[0]B3[0]B4[0]B5[0]B6[0]C0[0]C1[0]C2[0]C3[0]C4[0]C5[0]C6[0]D0[0]D1[0]D2[0]D3[0]D4[0]D5[0]D6[0]E0[0]E1[0]E2[0]E3[0]E4[0]E5[0]E6[0]F0[0]F1[0]F2[0]F3[0]F4[0]F5[0]F6[0]G0[0]G1[0]G2[0]G3[0]G4[0]G5[0]G6[0]";

        //1.Create an object of Class Board
        Board board = new Board();
        //2.Call the method getBoard()
        LinkedHashMap<String, int[]> boardMap = board.getBoard();

        //Convert to String
        String result = getMapString(boardMap);

        assertTrue("Board.getBoard() " + "expect: " + expectedBoard + ", but returned invalid result: " + result, result.equals(expectedBoard));

        System.out.println("The result is:");
        //Print boardMap
        printMap(boardMap);

    }


    /**
     * Test method getPlacementBoard(String boardString)
     */
    @Test
    public void testGetPlacementBoard() {

        //These are the boardString waiting for being passed
        String[] boardStrings = {
                "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52",
                "A4A50A0B61A3D60B1F60S0E61A0E52A5G52A4G61B2B50A0A30A1A21A5A10B2G31A3G41B0G12A0F13A2F01S1D03A2B02A1C00B0A00A3G21S3G00A1E00A4C50B1D50A0F51",
                "A3A53S0A44B1A35A0B03A0F07A0B61A4A61A1C00B0D02S4E00A4G10A4F10B1E12A2G31S3G20A4A10A4B10A4C10B0D10A5D62A0F61B1G56A2E67B0G41A2F22",
                "A1A30A1G30B0F30A4E30S2D30A1B30B0C32A4D41A1B61S1B50A1B01S5B10A1B21A4A10B0C10A1B41A1F61A4D61B0F53A4D51B0D21A1D11A1F01A4G10A1F11B0D03A1F21"
        };

        //These are the correct results for the boardStrings that with the same index;
        String[] expectedResults = {
                "A0[0]A1[5, 0, 5, 0]A2[0]A3[5, 1, 5, 1]A4[1, 0, 1, 0]A5[0]A6[0]B0[1, 5, 1, 5]B1[1, 0, 1, 0]B2[1, 5, 1, 5]B3[1, 1, 1, 0]B4[1, 0, 5, 5]B5[0]B6[0]C0[0]C1[5, 0, 5, 0]C2[0]C3[5, 0, 0, 5]C4[0, 5, 0, 5]C5[0, 5, 5, 0]C6[0]D0[0, 5, 0, 5]D1[0, 0, 0, 5]D2[0, 5, 5, 0]D3[0]D4[0]D5[5, 0, 0, 0]D6[0, 5, 0, 5]E0[0]E1[0]E2[5, 0, 5, 0]E3[5, 5, 0, 1]E4[0, 0, 0, 0]E5[0, 0, 1, 1]E6[0]F0[1, 5, 1, 5]F1[1, 5, 1, 1]F2[1, 0, 5, 5]F3[5, 1, 5, 1]F4[0]F5[5, 1, 1, 5]F6[1, 5, 1, 5]G0[0]G1[5, 1, 5, 0]G2[0]G3[5, 1, 1, 1]G4[1, 5, 1, 5]G5[1, 5, 5, 0]G6[0]",
                "A0[5, 0, 5, 1]A1[0, 0, 5, 5]A2[1, 5, 1, 5]A3[1, 1, 5, 5]A4[0]A5[5, 0, 5, 0]A6[0]B0[1, 1, 5, 1]B1[0]B2[0]B3[0]B4[0]B5[1, 0, 1, 0]B6[5, 1, 1, 5]C0[5, 1, 5, 1]C1[0]C2[0]C3[0]C4[0]C5[5, 0, 5, 0]C6[0]D0[0, 1, 1, 1]D1[0]D2[0]D3[0]D4[0]D5[5, 0, 1, 5]D6[5, 0, 0, 0]E0[5, 1, 5, 1]E1[0]E2[0]E3[0]E4[0]E5[5, 5, 1, 1]E6[1, 0, 0, 0]F0[1, 5, 1, 1]F1[1, 5, 5, 1]F2[0]F3[0]F4[0]F5[5, 1, 1, 5]F6[5, 0, 1, 5]G0[1, 1, 1, 1]G1[5, 1, 5, 0]G2[0, 5, 0, 0]G3[0, 1, 0, 1]G4[0, 5, 0, 0]G5[5, 5, 0, 0]G6[0, 5, 0, 5]",
                "A0[0]A1[5, 0, 5, 0]A2[0]A3[5, 1, 0, 5]A4[0, 0, 0, 1]A5[0, 0, 0, 5]A6[0, 5, 0, 5]B0[1, 5, 5, 1]B1[5, 0, 5, 0]B2[0]B3[0]B4[0]B5[0]B6[5, 1, 1, 5]C0[5, 1, 5, 1]C1[5, 0, 5, 0]C2[0]C3[0]C4[0]C5[0]C6[0]D0[5, 1, 5, 0]D1[5, 0, 5, 1]D2[0]D3[0]D4[0]D5[0]D6[5, 5, 0, 0]E0[0, 0, 1, 1]E1[1, 5, 5, 0]E2[0]E3[0]E4[0]E5[0]E6[1, 5, 1, 1]F0[1, 1, 5, 5]F1[5, 0, 5, 0]F2[1, 1, 5, 1]F3[0]F4[0]F5[0]F6[5, 1, 1, 5]G0[0]G1[5, 0, 5, 0]G2[1, 1, 1, 1]G3[1, 5, 1, 1]G4[1, 5, 0, 5]G5[5, 5, 1, 0]G6[0]",
                "A0[0]A1[5, 0, 5, 0]A2[0]A3[5, 1, 5, 1]A4[0]A5[0]A6[0]B0[1, 5, 1, 5]B1[1, 0, 1, 0]B2[1, 5, 1, 5]B3[5, 1, 5, 1]B4[1, 5, 1, 5]B5[1, 0, 1, 1]B6[1, 5, 1, 5]C0[0]C1[5, 0, 5, 1]C2[0]C3[5, 1, 5, 0]C4[0]C5[0]C6[0]D0[0, 5, 1, 5]D1[1, 5, 1, 5]D2[1, 5, 0, 5]D3[0, 0, 0, 0]D4[0, 5, 0, 5]D5[0, 5, 0, 5]D6[0, 5, 0, 5]E0[0]E1[0]E2[0]E3[5, 0, 5, 0]E4[0]E5[0]E6[0]F0[1, 5, 1, 5]F1[1, 5, 1, 5]F2[1, 5, 1, 5]F3[5, 0, 5, 1]F4[0]F5[0, 5, 1, 5]F6[1, 5, 1, 5]G0[0]G1[5, 0, 5, 0]G2[0]G3[5, 1, 5, 1]G4[0]G5[0]G6[0]"
        };


        testExpected01(boardStrings[0], expectedResults[0]);
        testExpected01(boardStrings[1], expectedResults[1]);
        testExpected01(boardStrings[2], expectedResults[2]);
        testExpected01(boardStrings[3], expectedResults[3]);

    }


    public void testExpected01(String boardString, String expectedResult) {

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getPlacementBoard(String boardString)
        LinkedHashMap<String, int[]> placementBoardMap = board.getPlacementBoard(boardString);

        //Convert to String
        String realResult = getMapString(placementBoardMap);

        assertTrue("Board.getPlacementBoard(\"" + boardString + "\") " + "expect: " + expectedResult + ", but returned invalid result: " + realResult, realResult.equals(expectedResult));

        System.out.println("The result is:");
        printMap(placementBoardMap);
    }


    /**
     * Test method getAllGridsCondition(String boardString)
     */
    @Test
    public void testGetAllGridsCondition() {

        //These are the boardStrings waiting for being passed
        String[] boardStrings = {
                "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52",
                "A4A50A0B61A3D60B1F60S0E61A0E52A5G52A4G61B2B50A0A30A1A21A5A10B2G31A3G41B0G12A0F13A2F01S1D03A2B02A1C00B0A00A3G21S3G00A1E00A4C50B1D50A0F51",
                "A3A53S0A44B1A35A0B03A0F07A0B61A4A61A1C00B0D02S4E00A4G10A4F10B1E12A2G31S3G20A4A10A4B10A4C10B0D10A5D62A0F61B1G56A2E67B0G41A2F22",
                "A1A30A1G30B0F30A4E30S2D30A1B30B0C32A4D41A1B61S1B50A1B01S5B10A1B21A4A10B0C10A1B41A1F61A4D61B0F53A4D51B0D21A1D11A1F01A4G10A1F11B0D03A1F21"
        };

        //These are the correct results for the boardStrings that with the same index;
        String[] expectedResults = {
                "A0[0]A1[5, 0, 5, 0]A2[0]A3[5, 1, 5, 1]A4[1, 0, 1, 0]A5[0]A6[0]B0[1, 5, 1, 5]B1[1, 0, 1, 0]B2[1, 5, 1, 5]B3[1, 1, 1, 0]B4[1, 0, 5, 5]B5[0]B6[0]C0[0]C1[5, 0, 5, 0]C2[0]C3[5, 0, 0, 5]C4[0, 5, 0, 5]C5[0, 5, 5, 0]C6[0]D0[0, 5, 0, 5]D1[0, 0, 0, 5]D2[0, 5, 5, 0]D3[0]D4[0]D5[5, 0, 0, 0]D6[0, 5, 0, 5]E0[0]E1[0]E2[5, 0, 5, 0]E3[5, 5, 0, 1]E4[0, 0, 0, 0]E5[0, 0, 1, 1]E6[0]F0[1, 5, 1, 5]F1[1, 5, 1, 1]F2[1, 0, 5, 5]F3[5, 1, 5, 1]F4[0]F5[5, 1, 1, 5]F6[1, 5, 1, 5]G0[0]G1[5, 1, 5, 0]G2[0]G3[5, 1, 1, 1]G4[1, 5, 1, 5]G5[1, 5, 5, 0]G6[0]",
                "A0[5, 0, 5, 1]A1[0, 0, 5, 5]A2[1, 5, 1, 5]A3[1, 1, 5, 5]A4[0]A5[5, 0, 5, 0]A6[0]B0[1, 1, 5, 1]B1[0]B2[0]B3[0]B4[0]B5[1, 0, 1, 0]B6[5, 1, 1, 5]C0[5, 1, 5, 1]C1[0]C2[0]C3[0]C4[0]C5[5, 0, 5, 0]C6[0]D0[0, 1, 1, 1]D1[0]D2[0]D3[0]D4[0]D5[5, 0, 1, 5]D6[5, 0, 0, 0]E0[5, 1, 5, 1]E1[0]E2[0]E3[0]E4[0]E5[5, 5, 1, 1]E6[1, 0, 0, 0]F0[1, 5, 1, 1]F1[1, 5, 5, 1]F2[0]F3[0]F4[0]F5[5, 1, 1, 5]F6[5, 0, 1, 5]G0[1, 1, 1, 1]G1[5, 1, 5, 0]G2[0, 5, 0, 0]G3[0, 1, 0, 1]G4[0, 5, 0, 0]G5[5, 5, 0, 0]G6[0, 5, 0, 5]",
                "A0[0]A1[5, 0, 5, 0]A2[0]A3[5, 1, 0, 5]A4[0, 0, 0, 1]A5[0, 0, 0, 5]A6[0, 5, 0, 5]B0[1, 5, 5, 1]B1[5, 0, 5, 0]B2[0]B3[0]B4[0]B5[0]B6[5, 1, 1, 5]C0[5, 1, 5, 1]C1[5, 0, 5, 0]C2[0]C3[0]C4[0]C5[0]C6[0]D0[5, 1, 5, 0]D1[5, 0, 5, 1]D2[0]D3[0]D4[0]D5[0]D6[5, 5, 0, 0]E0[0, 0, 1, 1]E1[1, 5, 5, 0]E2[0]E3[0]E4[0]E5[0]E6[1, 5, 1, 1]F0[1, 1, 5, 5]F1[5, 0, 5, 0]F2[1, 1, 5, 1]F3[0]F4[0]F5[0]F6[5, 1, 1, 5]G0[0]G1[5, 0, 5, 0]G2[1, 1, 1, 1]G3[1, 5, 1, 1]G4[1, 5, 0, 5]G5[5, 5, 1, 0]G6[0]",
                "A0[0]A1[5, 0, 5, 0]A2[0]A3[5, 1, 5, 1]A4[0]A5[0]A6[0]B0[1, 5, 1, 5]B1[1, 0, 1, 0]B2[1, 5, 1, 5]B3[5, 1, 5, 1]B4[1, 5, 1, 5]B5[1, 0, 1, 1]B6[1, 5, 1, 5]C0[0]C1[5, 0, 5, 1]C2[0]C3[5, 1, 5, 0]C4[0]C5[0]C6[0]D0[0, 5, 1, 5]D1[1, 5, 1, 5]D2[1, 5, 0, 5]D3[0, 0, 0, 0]D4[0, 5, 0, 5]D5[0, 5, 0, 5]D6[0, 5, 0, 5]E0[0]E1[0]E2[0]E3[5, 0, 5, 0]E4[0]E5[0]E6[0]F0[1, 5, 1, 5]F1[1, 5, 1, 5]F2[1, 5, 1, 5]F3[5, 0, 5, 1]F4[0]F5[0, 5, 1, 5]F6[1, 5, 1, 5]G0[0]G1[5, 0, 5, 0]G2[0]G3[5, 1, 5, 1]G4[0]G5[0]G6[0]"
        };

        testExpected02(boardStrings[0], expectedResults[0]);
        testExpected02(boardStrings[1], expectedResults[1]);
        testExpected02(boardStrings[2], expectedResults[2]);
        testExpected02(boardStrings[3], expectedResults[3]);
    }


    public void testExpected02(String boardString, String expectedResult) {

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getAllGridsCondition(String boardString)
        ArrayList<String> allGridsConditionList = board.getAllGridsCondition(boardString);

        //Convert to String
        String realResult = getListString(allGridsConditionList);

        assertTrue("Board.getAllGridsCondition(\"" + boardString + "\") " + "expect: " + expectedResult + ", but returned invalid result: " + realResult, realResult.equals(expectedResult));

        //Print
        System.out.println("The result is:");
        printList(allGridsConditionList);

    }


    /**
     * Test method getPlacementGrids(String boardString)
     */
    @Test
    public void testGetPlacementGrids() {

        //These are the boardStrings waiting for being passed
        String[] boardStrings = {
                "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52",
                "A4A50A0B61A3D60B1F60S0E61A0E52A5G52A4G61B2B50A0A30A1A21A5A10B2G31A3G41B0G12A0F13A2F01S1D03A2B02A1C00B0A00A3G21S3G00A1E00A4C50B1D50A0F51",
                "A3A53S0A44B1A35A0B03A0F07A0B61A4A61A1C00B0D02S4E00A4G10A4F10B1E12A2G31S3G20A4A10A4B10A4C10B0D10A5D62A0F61B1G56A2E67B0G41A2F22",
                "A1A30A1G30B0F30A4E30S2D30A1B30B0C32A4D41A1B61S1B50A1B01S5B10A1B21A4A10B0C10A1B41A1F61A4D61B0F53A4D51B0D21A1D11A1F01A4G10A1F11B0D03A1F21"
        };


        //These are the correct results for the boardStrings that with the same index;
        String[] expectedResults = {
                "A1[5, 0, 5, 0]A3[5, 1, 5, 1]A4[1, 0, 1, 0]B0[1, 5, 1, 5]B1[1, 0, 1, 0]B2[1, 5, 1, 5]B3[1, 1, 1, 0]B4[1, 0, 5, 5]C1[5, 0, 5, 0]C3[5, 0, 0, 5]C4[0, 5, 0, 5]C5[0, 5, 5, 0]D0[0, 5, 0, 5]D1[0, 0, 0, 5]D2[0, 5, 5, 0]D5[5, 0, 0, 0]D6[0, 5, 0, 5]E2[5, 0, 5, 0]E3[5, 5, 0, 1]E4[0, 0, 0, 0]E5[0, 0, 1, 1]F0[1, 5, 1, 5]F1[1, 5, 1, 1]F2[1, 0, 5, 5]F3[5, 1, 5, 1]F5[5, 1, 1, 5]F6[1, 5, 1, 5]G1[5, 1, 5, 0]G3[5, 1, 1, 1]G4[1, 5, 1, 5]G5[1, 5, 5, 0]",
                "A0[5, 0, 5, 1]A1[0, 0, 5, 5]A2[1, 5, 1, 5]A3[1, 1, 5, 5]A5[5, 0, 5, 0]B0[1, 1, 5, 1]B5[1, 0, 1, 0]B6[5, 1, 1, 5]C0[5, 1, 5, 1]C5[5, 0, 5, 0]D0[0, 1, 1, 1]D5[5, 0, 1, 5]D6[5, 0, 0, 0]E0[5, 1, 5, 1]E5[5, 5, 1, 1]E6[1, 0, 0, 0]F0[1, 5, 1, 1]F1[1, 5, 5, 1]F5[5, 1, 1, 5]F6[5, 0, 1, 5]G0[1, 1, 1, 1]G1[5, 1, 5, 0]G2[0, 5, 0, 0]G3[0, 1, 0, 1]G4[0, 5, 0, 0]G5[5, 5, 0, 0]G6[0, 5, 0, 5]",
                "A1[5, 0, 5, 0]A3[5, 1, 0, 5]A4[0, 0, 0, 1]A5[0, 0, 0, 5]A6[0, 5, 0, 5]B0[1, 5, 5, 1]B1[5, 0, 5, 0]B6[5, 1, 1, 5]C0[5, 1, 5, 1]C1[5, 0, 5, 0]D0[5, 1, 5, 0]D1[5, 0, 5, 1]D6[5, 5, 0, 0]E0[0, 0, 1, 1]E1[1, 5, 5, 0]E6[1, 5, 1, 1]F0[1, 1, 5, 5]F1[5, 0, 5, 0]F2[1, 1, 5, 1]F6[5, 1, 1, 5]G1[5, 0, 5, 0]G2[1, 1, 1, 1]G3[1, 5, 1, 1]G4[1, 5, 0, 5]G5[5, 5, 1, 0]",
                "A1[5, 0, 5, 0]A3[5, 1, 5, 1]B0[1, 5, 1, 5]B1[1, 0, 1, 0]B2[1, 5, 1, 5]B3[5, 1, 5, 1]B4[1, 5, 1, 5]B5[1, 0, 1, 1]B6[1, 5, 1, 5]C1[5, 0, 5, 1]C3[5, 1, 5, 0]D0[0, 5, 1, 5]D1[1, 5, 1, 5]D2[1, 5, 0, 5]D3[0, 0, 0, 0]D4[0, 5, 0, 5]D5[0, 5, 0, 5]D6[0, 5, 0, 5]E3[5, 0, 5, 0]F0[1, 5, 1, 5]F1[1, 5, 1, 5]F2[1, 5, 1, 5]F3[5, 0, 5, 1]F5[0, 5, 1, 5]F6[1, 5, 1, 5]G1[5, 0, 5, 0]G3[5, 1, 5, 1]"
        };

        testExpected03(boardStrings[0], expectedResults[0]);
        testExpected03(boardStrings[1], expectedResults[1]);
        testExpected03(boardStrings[2], expectedResults[2]);
        testExpected03(boardStrings[3], expectedResults[3]);
    }


    public void testExpected03(String boardString, String expectedResult) {

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getPlacementGrids(String boardString)
        ArrayList<String> placementGridsList = board.getPlacementGrids(boardString);

        //Convert to String
        String realResult = getListString(placementGridsList);

        assertTrue("Board.getPlacementGrids(\"" + boardString + "\") " + "expect: " + expectedResult + ", but returned invalid result: " + realResult, realResult.equals(expectedResult));

        //Print
        System.out.println("The result is:");
        printList(placementGridsList);

    }


    /**
     * Test method getEmptyGrids(String boardString)
     */
    @Test
    public void testGetEmptyGrids() {
        //These are the boardStrings waiting for being passed
        String[] boardStrings = {
                "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52",
                "A4A50A0B61A3D60B1F60S0E61A0E52A5G52A4G61B2B50A0A30A1A21A5A10B2G31A3G41B0G12A0F13A2F01S1D03A2B02A1C00B0A00A3G21S3G00A1E00A4C50B1D50A0F51",
                "A3A53S0A44B1A35A0B03A0F07A0B61A4A61A1C00B0D02S4E00A4G10A4F10B1E12A2G31S3G20A4A10A4B10A4C10B0D10A5D62A0F61B1G56A2E67B0G41A2F22",
                "A1A30A1G30B0F30A4E30S2D30A1B30B0C32A4D41A1B61S1B50A1B01S5B10A1B21A4A10B0C10A1B41A1F61A4D61B0F53A4D51B0D21A1D11A1F01A4G10A1F11B0D03A1F21"
        };

        //These are the correct results for the boardStrings that with the same index;
        String[] expectedResults = {
                "[A0, A2, A5, A6, B5, B6, C0, C2, C6, D3, D4, E0, E1, E6, F4, G0, G2, G6]",
                "[A4, A6, B1, B2, B3, B4, C1, C2, C3, C4, C6, D1, D2, D3, D4, E1, E2, E3, E4, F2, F3, F4]",
                "[A0, A2, B2, B3, B4, B5, C2, C3, C4, C5, C6, D2, D3, D4, D5, E2, E3, E4, E5, F3, F4, F5, G0, G6]",
                "[A0, A2, A4, A5, A6, C0, C2, C4, C5, C6, E0, E1, E2, E4, E5, E6, F4, G0, G2, G4, G5, G6]"
        };

        testExpected04(boardStrings[0], expectedResults[0]);
        testExpected04(boardStrings[1], expectedResults[1]);
        testExpected04(boardStrings[2], expectedResults[2]);
        testExpected04(boardStrings[3], expectedResults[3]);
    }


    public void testExpected04(String boardString, String expectedResult) {

        //1.Create an object of Class Board
        Board board = new Board();

        //2.Call the method getEmptyGrids(String boardString)
        String[] emptyGrids = board.getEmptyGrids(boardString);

        //Convert to String
        String realResult = Arrays.toString(emptyGrids);

        assertTrue("Board.getEmptyGrids(\"" + boardString + "\") " + "expect: " + expectedResult + ", but returned invalid result: " + realResult, realResult.equals(expectedResult));

        //Print
        System.out.println("The result is:");
        System.out.println(realResult);
    }


    /**
     * Test method getFirstValidPlacementString(String boardString, ArrayList<String> list)
     */
    @Test
    public void testGetFirstValidPlacementString() {

        //These are the boardStrings waiting for being passed
        String[] boardStrings = {
                "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52",
                "A4A50A0B61A3D60B1F60S0E61A0E52A5G52A4G61B2B50A0A30A1A21A5A10B2G31A3G41B0G12A0F13A2F01S1D03A2B02A1C00B0A00A3G21S3G00A1E00A4C50B1D50A0F51",
                "A3A53S0A44B1A35A0B03A0F07A0B61A4A61A1C00B0D02S4E00A4G10A4F10B1E12A2G31S3G20A4A10A4B10A4C10B0D10A5D62A0F61B1G56A2E67B0G41A2F22",
                "A1A30A1G30B0F30A4E30S2D30A1B30B0C32A4D41A1B61S1B50A1B01S5B10A1B21A4A10B0C10A1B41A1F61A4D61B0F53A4D51B0D21A1D11A1F01A4G10A1F11B0D03A1F21"
        };

        //These are the correct results for the boardStrings that with the same index;
        String[] expectedResults = {
                "A1A51",
                "A1A60",
                "A1B40",
                "A1C50"
        };


        testExpected05(boardStrings[0], expectedResults[0]);
        testExpected05(boardStrings[1], expectedResults[1]);
        testExpected05(boardStrings[2], expectedResults[2]);
        testExpected05(boardStrings[3], expectedResults[3]);
    }


    public void testExpected05(String boardString, String expectedResult) {

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

        //2.Call the method getFirstValidPlacementString(String boardString)
        String realResult = board.getFirstValidPlacementString(boardString, list);

        assertTrue("Board.getFirstValidPlacementString(\"" + boardString + "\") " + "expect: " + expectedResult + ", but returned invalid result: " + realResult, realResult.equals(expectedResult));

        //Print
        System.out.println("The result is:");
        System.out.println(realResult);
    }


    /**
     * This method is used to pint a Map
     *
     * @param map
     */
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


    /**
     * This method is used to convert a Map to a String
     *
     * @param map
     * @return
     */
    public static String getMapString(Map<String, int[]> map) {
        //Get set by method keySet()
        Set<String> set = map.keySet();

        //Get an object of Iterator via set
        Iterator<String> it = set.iterator();

        String s = "";
        while (it.hasNext()) {
            //Get a key
            String key = it.next();

            //Get relevant value by key
            int[] value = map.get(key);

            s += key + Arrays.toString(value);
        }

        return s;
    }


    /**
     * This method is used to pint a List
     *
     * @param list
     */
    public static void printList(List list) {

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }
    }


    /**
     * This method is used to convert a List to a String
     *
     * @param list
     * @return
     */
    public static String getListString(List list) {

        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);
        }

        return s;
    }


}
