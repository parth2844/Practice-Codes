import java.util.*;

public class comparator {
    public static void main(String args[]) {
        Random rand = new Random();
        List<People> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new People(rand.nextInt(100)));
        }

        print(list);

        // Type 1:
        Collections.sort(list, (p1, p2) ->  p1.height - p2.height);
        print(list);

        // Type 2:
        Comparator<People> comp = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.height - o2.height;
            }
        };
        print(list);

        // Type 3:
        Collections.sort(list, new myComp());
        print(list);

    }

    public static class myComp implements Comparator<People> {
        @Override
        public int compare(People o1, People o2) {
            return o1.height - o2.height;
        }
    }

    private static void print(List<People> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).height + " ");
        }
        System.out.println();
    }

    public static class People {
        int height;
        public People(int height) {
            this.height = height;
        }
    }
}
