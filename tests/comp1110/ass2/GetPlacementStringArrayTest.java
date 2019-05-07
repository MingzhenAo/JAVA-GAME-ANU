package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GetPlacementStringArrayTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testCutRandomQuantity(){
        Random r = new Random();
        int random = 0;
        for (int i = 0; i < 100; i ++){
            random = r.nextInt(101);
            byte[] array = new byte[random];
            new Random().nextBytes(array);
            String testString = new String(array, Charset.forName("UTF-8"));
            int validLength = testString.length() / 5;
            testCutRandom(testString, validLength);
        }
    }

    private void testCutRandom(String testString, int validLength){
        String[] resultString = RailroadInk.getPlacementStringArray(testString);
        assertTrue("RailroadInk.getPlacementStringArray(\"" + testString + "\") returned invalid cuts length: " + resultString.length, resultString.length == validLength);
    }

    @Test
    public void testCutStringSize(){
        Random r = new Random();
        int random = 0;
        for (int i = 0; i < 100; i ++){
            random = r.nextInt(101);
            byte[] array = new byte[random];
            new Random().nextBytes(array);
            String testString = new String(array, Charset.forName("UTF-8"));
            testCutSize(testString);
        }
    }

    private void testCutSize(String testString){
        String[] resultString = RailroadInk.getPlacementStringArray(testString);
        boolean b = true;
        int size = 0;
        for (int i = 0; i < resultString.length; i ++){
            if (resultString[i].length() != 5){
                b = false;
                size = resultString[i].length();
                break;
            }
        }
        assertTrue("RailroadInk.getPlacementStringArray(\"" + testString + "\") returned invalid string length: " + size, b);
    }

    @Test
    public void testCutString(){
        for (int i = 0; i < BOARD_STRINGS.length; i++) {
            String boardString = BOARD_STRINGS[i];
            String[] validCuts = VALID_CUTS[i];
            testCut(boardString, validCuts);
        }
    }

    private void testCut(String boardString, String[] validCuts) {
        String[] boardStringArray = RailroadInk.getPlacementStringArray(boardString);
        assertTrue("RailroadInk.getPlacementStringArray(\"" + boardString + "\") returned invalid cuts: " + Arrays.toString(boardStringArray), Arrays.equals(boardStringArray, validCuts));
    }

    private String[] BOARD_STRINGS = {
            "A4A50A0B61A3D60B1F60S0E61A0E52A5G52A4G61B2B50A0A30A1A21A5A10B2G31A3G41B0G12A0F13A2F01S1D03A2B02A1C00B0A00A3G21S3G00A1E00A4C50B1D50A0F51",
            "A3A53S0A44B1A35A0B03A0F07A0B61A4A61A1C00B0D02S4E00A4G10A4F10B1E12A2G31S3G20A4A10A4B10A4C10B0D10A5D62A0F61B1G56A2E67B0G41A2F22",
            "A1A30A1G30B0F30A4E30S2D30A1B30B0C32A4D41A1B61S1B50A1B01S5B10A1B21A4A10B0C10A1B41A1F61A4D61B0F53A4D51B0D21",
            "A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63"};

    private String[][] VALID_CUTS = {
            {"A4A50","A0B61","A3D60","B1F60","S0E61","A0E52","A5G52","A4G61","B2B50","A0A30","A1A21","A5A10","B2G31","A3G41","B0G12","A0F13","A2F01","S1D03","A2B02","A1C00","B0A00","A3G21","S3G00","A1E00","A4C50","B1D50","A0F51"},
            {"A3A53","S0A44","B1A35","A0B03","A0F07","A0B61","A4A61","A1C00","B0D02","S4E00","A4G10","A4F10","B1E12","A2G31","S3G20","A4A10","A4B10","A4C10","B0D10","A5D62","A0F61","B1G56","A2E67","B0G41","A2F22"},
            {"A1A30","A1G30","B0F30","A4E30","S2D30","A1B30","B0C32","A4D41","A1B61","S1B50","A1B01","S5B10","A1B21","A4A10","B0C10","A1B41","A1F61","A4D61","B0F53","A4D51","B0D21"},
            {"A3A10","B2A31","A1B30","A0F61","A4A21","B1B14","A4A41","A4D61","S2A50","A5A63","A2B01","A1C02","B0G52","S0B63","A0E63"}
    };
}
