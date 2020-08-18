import java.util.Scanner;

public class newName {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()) {
//            System.out.println(input.nextLine());
//        }

        String in = input.nextLine();

        String[] names = in.split(",");

        String name = names[1].split(" ")[1]+" ";

        String last = names[0].split(" ")[0];

        for(int i=last.length()-1; i>=0; i--) {
            name+= ""+ last.charAt(i);
        }

        System.out.println(name);

    }
}
