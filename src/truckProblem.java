import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class truckProblem {
    public static void main(String[] args) {

        // ===================================================
        int num = 2;
        ArrayList<Integer> boxes = new ArrayList<>(List.of(2, 2));
        int unitSize = 2;
        ArrayList<Integer> unitsPerBox = new ArrayList<>(List.of(3, 1));
        int truckSize = 3;

        // ===================================================

        System.out.println(getMaxUnit(num,boxes,unitSize,unitsPerBox,truckSize));

    }

    public static int getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int n= boxes.get(i);
            for(int j=0;j<n;j++){
                PQ.add(unitsPerBox.get(i));
                if(PQ.size()>truckSize) PQ.remove();
            }
        }
        int max=0;
        while(!PQ.isEmpty()){
            max += PQ.remove();
        }
        return max;
    }
}
