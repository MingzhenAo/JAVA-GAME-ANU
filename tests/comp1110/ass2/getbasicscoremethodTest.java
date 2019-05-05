package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.getbasicscore.centraltilesScore;
import static comp1110.ass2.getbasicscore.handle;
import static org.junit.Assert.assertEquals;

public class getbasicscoremethodTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);
    @Test
    public void testcentraltilesScore()
    {
        String a="A2F45";
        String b="A3C31A3C20A5D21S2D33B2C41B2D41A5E40A3E33B2E21";
        assertEquals(centraltilesScore(a),0);
        a+="B2E36";
        assertEquals(centraltilesScore(a),1);
        a+="A3D30A3D41";
        assertEquals(centraltilesScore(a),3);
        assertEquals(centraltilesScore(b),9);
    }
    @Test
    public void handletest()
    {
        String a="B2C31";
        String b="A5C21";
        assertEquals(handle(b,a),"A4C31");
        assertEquals(handle(a,b),"A5C21");
    }
    @Test
    public void linetest()
    {
        ArrayList<String> a=new ArrayList<>();
        HashMap<String,String> b= new HashMap<>();
    }
}






