package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.HashMap;

import static comp1110.ass2.RailroadInk.generateDiceRoll;
import static comp1110.ass2.RailroadInk.getPlacementStringArray;
import static comp1110.ass2.getBasicScore.*;
import static org.junit.Assert.*;

public class task78test {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void generateDiceRolltest() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int error = 0;
        for (int i = 0; i < 10000; i++) {
            String k = generateDiceRoll();
            if (k.substring(1, 2).equals("5")) {
                a++;
            }
            if (k.substring(1, 2).equals("0")) {
                b++;
            }
            if (k.substring(3, 4).equals("5")) {
                c++;
            }
            if (k.substring(3, 4).equals("0")) {
                d++;
            }
            if (k.substring(5, 6).equals("5")) {
                e++;
            }
            if (k.substring(5, 6).equals("0")) {
                f++;
            }
            if (k.substring(7, 8).equals("2")) {
                g++;
            }
            if (k.substring(7, 8).equals("0")) {
                h++;
            }
            if (Integer.valueOf(k.substring(7, 8)) < 0 || Integer.valueOf(k.substring(7, 8)) >= 3) {
                error++;
            }
            if (Integer.valueOf(k.substring(5, 6)) < 0 || Integer.valueOf(k.substring(5, 6)) >= 6) {
                error++;
            }
            if (Integer.valueOf(k.substring(3, 4)) < 0 || Integer.valueOf(k.substring(3, 4)) >= 6) {
                error++;
            }
            if (Integer.valueOf(k.substring(3, 4)) < 0 || Integer.valueOf(k.substring(1, 2)) >= 6) {
                error++;
            }
        }
        assertFalse("out of range", error > 0);
        assertTrue("don't include all range", a > 0 && b > 0 && c > 0 && d > 0 && e > 0 && f > 0 && g > 0 && h > 0);
    }

    @Test
    public void testcentraltilesScore() {
        String a = "A2F45A1F51A1F61";
        String b = "A3C31A3C20A5D21S2D33B2C41B2D41A5E40A3E33B2E21A4D51A4D61";
        assertEquals("a is not in central", getCentralTilesScore(a), 0);
        a += "B2E45";
        assertEquals("one member in centre", getCentralTilesScore(a), 1);
        a += "A3E20A3E31";
        assertEquals("three memebers in centre", getCentralTilesScore(a), 3);
        assertEquals("b contains all the centraltiles", getCentralTilesScore(b), 9);

    }

    @Test
    public void handletest() {
        String a = "B2C31";
        String b = "A5C21";
        String c = "A1B30";
        String d = "A1D30";
        String e = "S5C41";
        assertEquals("a is B2 and hignway connection so B2 should change A4", handle(b, a), "A4C31");
        assertEquals("b is not B2 so they connected should keep b", handle(a, b), "A5C21");
        assertEquals("a is B2 and railway connection so B2 should change to A1", handle(c, a), "A1C30");
        assertEquals("a is B2 and railway connection so B2 should change to A1", handle(d, a), "A1C30");
        assertEquals("a is B2 and hignway connection so B2 should change to A4", handle(e, a), "A4C31");
    }

    @Test
    public void linetest() {
        ArrayList<String> a = new ArrayList<>();
        HashMap<String, String> b = new HashMap<>();
        HashMap<String, String> c = new HashMap<>();
        String d = "A3C31A3C20A5D21S2D33A5E40A3E33B2E21A4D41A4D51A4D61";
        String[] m = getPlacementStringArray(d);
        String e = "A3C31A3C20A5D21S2D33A5E40A3E33A4E21A4D41A4D51A4D61";
        String[] n = getPlacementStringArray(e);
        for (int i = 0; i < m.length; i++) {
            a.add(m[i]);
            c.put(n[i], n[i].substring(2, 4));
        }
        b.put(m[0], m[0].substring(2, 4));
        HashMap<String, String> h = line(a, b);
        h.put(m[0], m[0].substring(2, 4));
        assertTrue("this should contains the whole line and one B2 should change to A4 ", c.equals(h));
    }

    @Test
    public void exitsmapped() {
        String a = "A5A11S2A23A4B20A3C31A3C20A5D21B2C41A5E40A3E33B2E21A5D42A4D51A4D61";
        String[] a1 = getPlacementStringArray(a);
        HashMap<String, String> b = new HashMap<>();
        HashMap<String, String> b1 = new HashMap<>();
        ArrayList<HashMap<String, String>> d = exitsMapped(a);
        ArrayList<String> a2 = new ArrayList<>();
        for (int i = 0; i < a1.length; i++) {
            a2.add(a1[i]);
        }
        String d1 = "A5A11S2A23A4B20A3C31A3C20A5D21A4C41";
        String[] d11 = getPlacementStringArray(d1);
        for (int i = 0; i < d11.length; i++) {
            b.put(d11[i], d11[i].substring(2, 4));
        }
        assertFalse("the first line should be A5A11S2A23A4B20A3C31A3C20A5D21A4C41", !b.equals(d.get(0)));
        String d2 = "A5E40A3E33A4E21A5D42A4D51A4D61";
        String[] d22 = getPlacementStringArray(d2);
        for (int i = 0; i < d22.length; i++) {
            b1.put(d22[i], d22[i].substring(2, 4));
        }
        assertFalse("the second line should be A5E40A3E33A4E21A5D42A4D51A4D61", !b1.equals(d.get(1)));
    }

    @Test
    public void exitsgetscorestest() {
        String a = "A3D61";
        assertEquals("one line one exit test", getExitsScore(a), 0);
        a += "A3D53B0C52A0B52A2B63";
        assertEquals("one line two exits test", getExitsScore(a), 4);
        a += "A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32";
        assertEquals("one line four exits test", getExitsScore(a), 12);
        a += "A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11";
        assertEquals("two lines 7 exits  and 2 exits test", getExitsScore(a), 28);
    }

    @Test
    public void getendScorestest() {
        String a = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";
        assertFalse("5 dead lines", getEndsScore(a) != -5);
        String b = "A4A50A1F61A0B61S5F50B1F46A1F01S1F12A2F23A1E20B2D21A3D03A1C20A0B22B1A61A4D11A4G10B1G44A2G30A3C01A3C12B0B31A1B01A4B50B0C50A2F32A0E32A0E40A4D31B1D47A1B11";
        assertEquals("8 dead lines", getEndsScore(b), -8);
    }
}








