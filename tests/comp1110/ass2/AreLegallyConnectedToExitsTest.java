package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertTrue;

public class AreLegallyConnectedToExitsTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testNoExitConnection(){
        for (int i = 0; i < NO_EXIT_CONNECTION.length; i ++){
            testExitConnection(NO_EXIT_CONNECTION[i], false);
        }
    }

    @Test
    public void testValidExitConnection(){
        for (int i = 0; i < VALID_EXIT_CONNECTION.length; i ++){
            testExitConnection(VALID_EXIT_CONNECTION[i], true);
        }
    }

    @Test
    public void testFalseExitConnection(){
        for (int i = 0; i < FASLE_EXIT_CONNECTION.length; i ++){
            testExitConnection(FASLE_EXIT_CONNECTION[i], false);
        }
    }

    private void testExitConnection(String boardString, boolean b){
        assertTrue("AreLegallyConnectedToExits.areLegallyConnectedToExits(\"" + boardString + "\") returned invalid validity: " + AreLegallyConnectedToExits.areLegallyConnectedToExits(boardString), AreLegallyConnectedToExits.areLegallyConnectedToExits(boardString) == b);
    }

    private String[] NO_EXIT_CONNECTION = {
            "A0A01B0B23S0G21",
            "B2C34A5D55",
            "S4E33"
    };

    private String[] VALID_EXIT_CONNECTION = {
            "S0A10",
            "S2D00",
            "S3A30"
    };

    private String[] FASLE_EXIT_CONNECTION = {
            "S3A10",
            "A1D01",
            "S0A30"
    };
}
