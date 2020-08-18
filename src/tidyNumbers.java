import java.util.Scanner;

public class tidyNumbers {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()) {
//            System.out.println(input.nextLine());
//        }
        int n = input.nextInt();
        int[] number = getNum(""+n);

        while (!checkTidy(number)) {
            number = makeTidy(number);
        }

        int ans = getIntNum(number);

        System.out.println(ans);

    }

    private static int[] makeTidy(int[] number) {
        for(int i = number.length-2; i>=0; i--) {
            if(number[i] >= number[i+1]) {
                number[i]--;
                int temp = 9;
                for(int j= number.length-1; j>i; j--) {
                    number[j] = temp;
                    temp--;
                }
            }
        }
//        System.out.println(getIntNum(number));
        return  number;
    }


    private static int getIntNum(int[] number) {
        String ans="";
        for(int i: number)
            ans+= i;
        return Integer.parseInt(ans);
    }

    private static int[] getNum(String n) {
        int[] num = new int[n.length()];
        for(int i = 0; i<num.length; i++) {
            num[i] = Integer.parseInt(""+n.charAt(i));
        }
        return num;
    }

    private static boolean checkTidy(int[] n) {
        int min = 10;
        for(int i = n.length-1; i>=0; i--) {

            if(n[i] >= min)
                return false;
            min = n[i];

        }
        return true;
    }
}
