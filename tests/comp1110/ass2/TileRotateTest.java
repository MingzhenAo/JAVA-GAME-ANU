package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TileRotateTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testNoRotate(){
        HashMap<String, Integer[]> noRotateValidTileMap = new HashMap<>(){{
            put("S0B10", new Integer[] {0,0,0,1});
            put("S1B40", new Integer[] {1,0,1,1});
            put("S2B40", new Integer[] {0,0,0,0});
            put("S3B40", new Integer[] {1,1,1,1});
            put("S4B40", new Integer[] {0,0,1,1});
            put("S5B40", new Integer[] {1,0,1,0});
            put("A0B10", new Integer[] {1,1,5,5});
            put("A1B40", new Integer[] {5,1,5,1});
            put("A2B40", new Integer[] {5,1,1,1});
            put("A3B40", new Integer[] {5,0,0,0});
            put("A4B40", new Integer[] {5,0,5,0});
            put("A5B40", new Integer[] {0,0,5,5});
            put("B0B40", new Integer[] {5,0,5,1});
            put("B1B40", new Integer[] {5,0,1,5});
            put("B2B40", new Integer[] {1,0,1,0});
        }};
        for (var v : noRotateValidTileMap.keySet()){
            testRotate(v, noRotateValidTileMap.get(v));
        }
    }

    @Test
    public void testRotateTimes(){
        HashMap<String, Integer[]> rotateTimesValidTileMap = new HashMap<>(){{
            put("S0B11", new Integer[] {1,0,0,0});
            put("S1B42", new Integer[] {1,1,1,0});
            put("S4B43", new Integer[] {0,1,1,0});
            put("S5B44", new Integer[] {1,0,1,0});
            put("A0B15", new Integer[] {5,5,1,1});
            put("A1B46", new Integer[] {5,1,5,1});
            put("A2B47", new Integer[] {1,5,1,1});
            put("A3B41", new Integer[] {0,5,0,0});
            put("A4B42", new Integer[] {5,0,5,0});
            put("A5B43", new Integer[] {0,5,5,0});
            put("B0B44", new Integer[] {5,0,5,1});
            put("B1B45", new Integer[] {5,1,0,5});
            put("B2B46", new Integer[] {1,0,1,0});
        }};
        for (var v : rotateTimesValidTileMap.keySet()){
            testRotate(v, rotateTimesValidTileMap.get(v));
        }
    }

    private void testRotate(String placement, Integer[] validTile) {
        int[] resultTile = TileRotate.getRotatedTile(placement);
        Integer[] resultIntegerTile = new Integer[4];
        for (int i = 0; i < 4; i ++){
            resultIntegerTile[i] = Integer.valueOf(resultTile[i]);
        }
        assertFalse("TileRotate.getRotatedTile(\"" + placement + "\") returned invalid tile: " + Arrays.toString(resultIntegerTile) + ", while the valid tile is: " + Arrays.toString(validTile), !Arrays.equals(validTile, resultIntegerTile));
        //assertTrue("TileRotate.getRotatedTile(\"" + placement + "\") returned invalid tile: " + Arrays.toString(resultIntegerTile) + ", while the valid tile is: " + Arrays.toString(validTile), Arrays.toString(resultIntegerTile).equals(Arrays.toString(validTile)));
    }

    @Test
    public void testPerfectStation() {
        String perfectStationS2 = "S2";
        int[] s2Tile = {0,0,0,0};
        String perfectStationS3 = "S3";
        int[] s3Tile = {1,1,1,1};
        perfectStationS2 += "XX";
        perfectStationS3 += "XX";
        for (int i = 0; i < 8; i ++) {
            perfectStationS2 = perfectStationS2.substring(0, 4);
            perfectStationS2 += i;
            testStation(perfectStationS2, s2Tile);
        }
        for (int i = 0; i < 8; i ++) {
            perfectStationS3 = perfectStationS3.substring(0, 4);
            perfectStationS3 += i;
            testStation(perfectStationS3, s3Tile);
        }
    }

    private void testStation (String placement, int[] validTile) {
        int[] resultTile = TileRotate.getRotatedTile(placement);
        assertFalse("TileRotate.getRotatedTile(\"" + placement + "\") returned invalid tile: " + Arrays.toString(resultTile) + ", while the valid tile is: " + Arrays.toString(validTile), !Arrays.equals(validTile, resultTile));
    }
}
