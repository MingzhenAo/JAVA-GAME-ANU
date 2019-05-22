/*
package comp1110.ass2;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreLegallyConnectedNeighboursTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testNotNeighbour(){
        for (int i = 0; i < NO_NEIGHBOUR.length; i ++){
            testNeighbour(NO_NEIGHBOUR[i][0], NO_NEIGHBOUR[i][1], true);
        }
    }

    @Test
    public void testIllegalNeighbour(){
        for (int i = 0; i < ILLEGAL_NEIGHBOUR.length; i ++){
            testNeighbour(ILLEGAL_NEIGHBOUR[i][0], ILLEGAL_NEIGHBOUR[i][1], false);
        }
    }

    @Test
    public void testLegalNeighbour(){
        for (int i = 0; i < LEGAL_NEIGHBOUR.length; i ++){
            testNeighbour(LEGAL_NEIGHBOUR[i][0], LEGAL_NEIGHBOUR[i][1], true);
        }
    }

    private void testNeighbour(String placementA, String placementB, boolean b){
        assertTrue("AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(\"" + placementA + " and " + placementB + "\") returned invalid validity: " + AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(placementA, placementB), AreLegallyConnectedNeighbours.areLegallyConnectedNeighbours(placementA, placementB) == b);
    }

    private String[][] NO_NEIGHBOUR = {
            {"A0B13","B1C52"},
            {"S5G56","A3D51"},
            {"A0A11","A0A13"},
            {"S3A21","S1C21"}
    };

    private String[][] ILLEGAL_NEIGHBOUR = {
            {"A2A10","A3A22"},
            {"S3A10","S2B17"},
            {"S0A10","S0A21"}
    };

    private String[][] LEGAL_NEIGHBOUR = {
            {"A0A10","S5A20"},
            {"B0A11","S3B15"},
            {"A3C31","A2B31"},
            {"A0A15","A0A26"}
    };
}
*/
