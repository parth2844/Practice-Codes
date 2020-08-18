import java.util.*;

public class itemAssociation {
    public static void main(String args[]) {
        Solution1 mySolution = new Solution1();
        List<PairString> input = Arrays.asList(
                new PairString("item1", "item2"),
                new PairString("item1", "item4"),
                new PairString("item3", "item4"),
                new PairString("item4", "item5"));

        List<String> answer = mySolution.largestItemAssociation(input);

        System.out.println(answer);
    }
}


class Solution1 {
    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        Map<String, List<String>> assocmap = new HashMap<>();
        //Map with all items and child association of every item 1->2, 2-> , 3->4, 4->5 ,5->
        for (PairString p : itemAssociation) {
            if (!assocmap.containsKey(p.first)) {
                assocmap.put(p.first, new ArrayList<>());
            }
            assocmap.get(p.first).add(p.second);
            if (!assocmap.containsKey(p.second)) {
                assocmap.put(p.second, new ArrayList<>());
            }

        }
        //DFS for every item: Resultant map 1->{5},{2} 2->{1,2},{4,5} 3->{3,4,5}
        Map<Integer, List<List<String>>> sizemap = new HashMap<>();
        int maxassoc = Integer.MIN_VALUE;
        for (String key : assocmap.keySet()) {
            Queue<String> q = new LinkedList<>();
            TreeSet<String> temp = new TreeSet<>();
            q.offer(key);
            while (!q.isEmpty()) {
                String head = q.poll();
                temp.add(head);
                List<String> tail = assocmap.get(head);
                for (String t : tail) {
                    q.offer(t);
                }
            }
            int size = temp.size();
            maxassoc = Math.max(maxassoc, size);
            if (!sizemap.containsKey(size)) {
                sizemap.put(size, new ArrayList<>());
            }
            sizemap.get(size).add(new ArrayList<>(temp));
        }

        // Retrieve the maximum size lists and sort them lexiographically
        List<List<String>> maxassoclist = sizemap.get(maxassoc);

        Collections.sort(maxassoclist, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;
                for (int i = 0; i < o1.size() && result == 0; i++) {
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
            }
        });

        return maxassoclist.get(0);

    }
}

class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}