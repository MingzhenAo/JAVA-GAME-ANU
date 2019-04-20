package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static comp1110.ass2.RailroadInk.*;

public class test {
    public static void main(String[] args) {

        ArrayList<HashMap<String,String>> a=exitsMapped("A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02");
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
