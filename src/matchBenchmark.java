import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class matchBenchmark {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            matchBenchmark.match(line);
        }
    }

    public static void match(String input) {
        // Access your code here. Feel free to create other classes as required
        String[] temp = input.split(":");
        Map<String, List<Integer>> port = new TreeMap<>();
        String[] shares = temp[0].split("\\|");
        String[] benchmarks = temp[1].split("\\|");

        for (String share : shares) {
            String[] company = share.split(",");
            port.putIfAbsent(company[0], new ArrayList<>(Arrays.asList(0, 0)));

            if (company[1].equals("BOND")) {
                port.get(company[0]).set(0, Integer.parseInt(company[2]));
            } else
                port.get(company[0]).set(1, Integer.parseInt(company[2]));
        }

        for (String benchmark : benchmarks) {
            String[] company = benchmark.split(",");
            if (port.containsKey(company[0])) {
                if (company[1].equals("BOND")) {
                    int val = port.get(company[0]).get(0);
                    port.get(company[0]).set(0, Integer.parseInt(company[2]) - val);
                } else {
                    int val = port.get(company[0]).get(1);
                    port.get(company[0]).set(1, Integer.parseInt(company[2]) - val);
                }
            } else {
                port.putIfAbsent(company[0], new ArrayList<>(Arrays.asList(0, 0)));
                if (company[1].equals("BOND")) {
                    port.get(company[0]).set(0, Integer.parseInt(company[2]));
                } else
                    port.get(company[0]).set(1, Integer.parseInt(company[2]));
            }
        }

        for (Map.Entry<String, List<Integer>> entry : port.entrySet()) {
            int stock = entry.getValue().get(1);
            int bond = entry.getValue().get(0);
            if (bond != 0) {
                if (bond > 0)
                    System.out.print("BUY,");
                else if (bond < 0)
                    System.out.print("SELL,");
                System.out.print(entry.getKey() + ",BOND," + Math.abs(bond));
                System.out.println();
            }
            if (stock != 0) {
                if (stock > 0)
                    System.out.print("BUY,");
                else if (stock < 0)
                    System.out.print("SELL,");
                System.out.print(entry.getKey() + ",STOCK," + Math.abs(stock));
                System.out.println();
            }

        }


    }

}