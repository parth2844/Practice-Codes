import java.util.*;

public class deleteProducts {
    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>();
        //l.add(4);
        l.add(1);
        l.add(2);
        l.add(3);

        l.add(1);l.add(2);l.add(2);
        //l.add(2);

        System.out.println(delete(l, 3));
    }

    public static int delete(List<Integer> ids, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: ids) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
//        System.out.println(map);
        List<Map.Entry<Integer, Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue())- (o2.getValue());
            }
        });
//        System.out.println(list);
        int size = list.size();
        for(Map.Entry<Integer, Integer> entry: list) {
            int val = entry.getValue();
            if(m<val){
                return size;
            }
            m-=val;
            size--;
        }
        return size;
    }
}
