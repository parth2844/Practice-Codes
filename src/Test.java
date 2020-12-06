import java.util.Arrays;

public class Test {
    public static void main(String args[]) {
        int[] arr = {1,2, 3,4,5};
        int num = 1;
        method(arr, num);
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
    }

    private static void method(int[] arr, int num) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = ++arr[i];
        }
        num = 10;
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
    }
}
