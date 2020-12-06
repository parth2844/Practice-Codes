public class circularLeftShift {
    public static void main(String[] args) {
        String input = "accbb";
        int answer = countStrings(input);
        System.out.println(answer);
    }

//    public static int countStrings(String s) {
//        // Write your code here
//        int[] chars = new int[26];
//
//        for(int i = 0; i < s.length() - 1; i++) {
//            if(s.charAt(i) == s.charAt(i + 1))
//                chars[s.charAt(i) - 'a']++;
//        }
//
//        if(s.charAt(s.length() - 1) == s.charAt(0))
//            chars[s.charAt(0) - 'a']++;
//
//        int count = 0;
//        for(int i: chars)
//            count += i;
//
//        return count;
//    }

    private static int countStrings(String input) {
        int n = input.length() - 1;
        String s = input;
        int count = 0;
        while (n >= 0) {
            s = leftShift(s);
            //System.out.println(s);
            if(s.charAt(0) == s.charAt(s.length() - 1))
                count++;
            n--;
        }

        return count;
    }

    private static String leftShift(String s) {
        String str = s.substring(1);
        str += "" + s.charAt(0);
        return str;
    }

}
