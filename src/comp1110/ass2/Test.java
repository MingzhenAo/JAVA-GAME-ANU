package comp1110.ass2;

import java.security.Key;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        LinkedHashMap<String, int[]> board = new LinkedHashMap<>();
        int[] temp = {0};

        String[] first = {"A", "B", "C", "D", "E", "F", "G"};
        String[] second = {"0", "1", "2", "3", "4", "5", "6"};


        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < first.length; j++) {

                String s = first[i] + second[j];
                board.put(s, temp);

            }

        }


        Set<String> set = board.keySet();

        Iterator<String> it = set.iterator();


        while (it.hasNext()) {

            String key = it.next();

            int[] ints = board.get(key);

            System.out.println(key+""+ Arrays.toString(ints));

        }


    }
}
