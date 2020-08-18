import java.util.*;

public class debtProblem {
    public static void main(String args[]) {
        Solution mySolution = new Solution();
        List<debtRecord> debts = new ArrayList<>();

        debts.add(new debtRecord("Blake", "Casey", 7));
        debts.add(new debtRecord("Alex", "Blake", 4));
        debts.add(new debtRecord("Alex", "Casey", 4));
        debts.add(new debtRecord("Alex", "Blake", 2));
        debts.add(new debtRecord("Blake", "Alex", 2));
        debts.add(new debtRecord("Casey", "Alex", 5));

        List<String> answer = mySolution.smallestNegativeBalance(debts.size(), 3, debts);

        for (String s : answer)
            System.out.println(s);
    }
}

class Solution {
    public List<String> smallestNegativeBalance(int numRows, int numCols, List<debtRecord> debts) {

        Map<String, Integer> balance = new TreeMap<>();
        for (int i = 0; i < numRows; i++) {
            String borrower = debts.get(i).borrower;
            String lender = debts.get(i).lender;
            int amount = debts.get(i).amount;
            balance.putIfAbsent(borrower, 0);
            balance.putIfAbsent(lender, 0);
            balance.replace(borrower, balance.get(borrower) - amount);
            balance.replace(lender, balance.get(lender) + amount);
        }

        List<String> names = new ArrayList<>(balance.keySet());

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return balance.get(o1) - balance.get(o2);
            }
        });

        List<String> answer = new ArrayList<>();
        int min = balance.get(names.get(0));

        if (min >= 0)
            answer.add("Nobody has a negative balance");
        else {
            for (String name : names) {
                if (balance.get(name) == min)
                    answer.add(name);
                else
                    break;
            }
        }


        return answer;
    }


}

class debtRecord {
    String borrower = "";
    String lender = "";
    int amount = 0;

    debtRecord() {
        // empty constructor
    }

    debtRecord(String borrower, String lender, int amount) {
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }
}
