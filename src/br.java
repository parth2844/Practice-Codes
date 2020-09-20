import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class br {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] splittedInput = line.split(";");
            String pattern = splittedInput[0];
            String blobs = splittedInput[1];
            doSomething(pattern, blobs);
        }
    }

    public static void doSomething(String pattern, String blobs) {
        // Write your code here. Feel free to create more methods and/or classes
        String[] arr = blobs.split("\\|");
        int[] output = new int[arr.length];

//        System.out.println(pattern);
//        System.out.println(blobs);
        int i = 0;
        for(String str : arr) {
            int lastIndex = 0;
            int count = 0;

            while(lastIndex != -1){

                lastIndex = str.indexOf(pattern,lastIndex);

                if(lastIndex != -1){
                    count ++;
                    lastIndex += pattern.length();
                }
            }
            output[i] = count;
            i++;
        }

        for (int j : output)
            System.out.print(j+ " ");
    }
}