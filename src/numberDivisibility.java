import java.util.Scanner;

public class numberDivisibility {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()) {
//            System.out.println(input.nextLine());
//        }
        int n = input.nextInt();
        String in = input.next();

        String[] convertedInput = in.split(",");

        int count = 0;

        for (String s : convertedInput) {
            int number = Integer.parseInt(s, 2);
//            System.out.println(s+"---"+number);
//            System.out.println(number % n);
            if (number % n == 0)
                count++;

//            System.out.println(count);

        }

        System.out.println(count);
    }
}
