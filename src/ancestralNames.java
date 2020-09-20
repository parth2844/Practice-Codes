import java.util.*;

public class ancestralNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Louis IX");
        names.add("Louis VIII");
        System.out.println(sortRoman(names));
    }

    public static List<String> sortRoman(List<String> names) {
        Collections.sort(names, new myComp());
        return names;
    }
}

class myComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] name1 = s1.split(" ");
        String[] name2 = s2.split(" ");
        if(name1[0].equals(name2[0])) {
            int n1 = getInt(name1[1]);
            int n2 = getInt(name2[1]);
            return n1 - n2;
        }

        return name1[0].compareTo(name2[0]);
    }

    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    private int getInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                // Check if this is the length-2 symbol case.
                if (values.containsKey(doubleSymbol)) {
                    sum += values.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            // Otherwise, it must be the length-1 symbol case.
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i += 1;
        }
        return sum;
    }
}
