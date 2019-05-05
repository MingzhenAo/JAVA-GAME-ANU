package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.RailroadInk.getPlacementStringArray;
import static comp1110.ass2.getbasicscore.*;
import static org.junit.Assert.*;

public class getbasicscoremethodTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testcentraltilesScore() {
        String a = "A2F45";
        String b = "A3C31A3C20A5D21S2D33B2C41B2D41A5E40A3E33B2E21";
        assertEquals(centraltilesScore(a), 0);
        a += "B2E36";
        assertEquals(centraltilesScore(a), 1);
        a += "A3D30A3D41";
        assertEquals(centraltilesScore(a), 3);
        assertEquals(centraltilesScore(b), 9);

    }

    @Test
    public void handletest() {
        String a = "B2C31";
        String b = "A5C21";
        String c = "A1B30";
        String d = "A1D30";
        String e = "S5C41";
        assertEquals(handle(b, a), "A4C31");
        assertEquals(handle(a, b), "A5C21");
        assertEquals(handle(c, a), "A1C30");
        assertEquals(handle(d, a), "A1C30");
        assertEquals(handle(e, a), "A4C31");
    }

    @Test
    public void onelinetest() {
        ArrayList<String> a = new ArrayList<>();
        HashMap<String, String> b = new HashMap<>();
        HashMap<String, String> c = new HashMap<>();
        String d="A3C31A3C20A5D21S2D33B2C41B2D41A5E40A3E33B2E21";
        String [] m=getPlacementStringArray(d);
        for(int i=0;i<m.length;i++)
        {
            a.add(m[i]);
            c.put(m[i],m[i].substring(2,4));
        }
        b.put(m[0],m[0].substring(2,4));
        HashMap<String,String> h=line(a,b);
        h.put(m[0],m[0].substring(2,4));
        assertTrue(h.size()==c.size());
    }
    @Test
    public void twolinetest() {
        ArrayList<String> a = new ArrayList<>();
        HashMap<String, String> b = new HashMap<>();
        HashMap<String, String> c = new HashMap<>();
        String d="A3C31A3C20A5D21B2C41A5E40A3E33B2E21";
        String [] m=getPlacementStringArray(d);
        for(int i=0;i<m.length;i++)
        {
            a.add(m[i]);
            c.put(m[i],m[i].substring(2,4));
        }
        b.put(m[0],m[0].substring(2,4));
        HashMap<String,String> h=line(a,b);
        h.put(m[0],m[0].substring(2,4));
        assertFalse(h.size()==c.size());
    }
    @Test
    public void exitsmapped()
    {
        
    }

}






