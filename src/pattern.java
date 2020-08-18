import java.util.Scanner;

public class pattern {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()) {
//            System.out.println(input.nextLine());
//        }
        int n = input.nextInt();

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j< n; j++) {
                if( i > 0 && j == n-2)
                    System.out.print(i+" ");
                else
                    System.out.print(n+" ");
            }
            System.out.println();
        }

    }

}
