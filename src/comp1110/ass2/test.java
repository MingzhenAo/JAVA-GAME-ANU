package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static comp1110.ass2.RailroadInk.*;

public class test {
    public static void main(String[] args) {

        ArrayList<HashMap<String,String>> a=exitsMapped("A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11");
        for(int i=0;i<a.size();i++)
        {
            System.out.println(a.get(i));
        }





/*
        String s = "B1A45";
        String boardString = "A0F00A0B00A0A31B1A14A0B61A0F61A0G32B1D61A0G43A0A62A0E61B1G56S1G60A0E03A0A03B1G12A0G02S0A50A0B50A5D03B1B40";
        String[] boardStringArray = getPlacementStringArray(boardString);
        HashMap<String, String> tilesMap = new HashMap<>();
        for (int i = 0; i < boardStringArray.length; i++) {
            tilesMap.put(boardStringArray[i].substring(2, 4), boardStringArray[i]);
        }
        if (canIplacetheStringHere(s,tilesMap))
            System.out.println("I can");
        else
            System.out.println("I can't");
*/
    }
}
// A0A40 yes
// A0A47
// B1A42 yes
// B1A44 yes
// B1A45 yes
// S4A42 yes
// S4A45
