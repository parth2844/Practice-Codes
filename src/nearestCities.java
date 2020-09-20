import java.lang.reflect.Array;
import java.util.*;

public class nearestCities {
    public static void main(String args[]) {
        String[] cities = {"green", "red", "blue", "yellow", "pink"};
        int[] xCoordinates = {100, 200, 300, 400, 500};
        int[] yCoordinates = {100, 200, 300, 400, 500};
        String[] queries = {"green", "red", "blue", "yellow", "pink"};

        Map<String, List<Integer>> locations = new HashMap<>();
        Map<Integer, List<String>> xLocations = new HashMap<>();
        Map<Integer, List<String>> yLocations = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            // Creating a map of city and its location
            locations.put(cities[i], new ArrayList<Integer>(List.of(xCoordinates[i], yCoordinates[i])));

            // Map of x location and cities having same x coordinates
            List<String> xList = xLocations.getOrDefault(xCoordinates[i], new ArrayList<String>());
            xList.add(cities[i]);
            xLocations.put(xCoordinates[i], xList);

            // Map of y location and cities having same y coordinates
            List<String> yList = yLocations.getOrDefault(yCoordinates[i], new ArrayList<String>());
            yList.add(cities[i]);
            yLocations.put(yCoordinates[i], yList);

        }

//        System.out.println(locations);
//        System.out.println(xLocations);
//        System.out.println(yLocations);

        List<String> nearest = new ArrayList<>(queries.length);

        for (String city : queries) {
            int x = locations.get(city).get(0);
            int y = locations.get(city).get(1);

            List<String> xNeighbors = xLocations.get(x);
            List<String> yNeighbors = yLocations.get(y);

            int min = Integer.MAX_VALUE;
            String ans = "NONE";

            for (String xNeighbor : xNeighbors) {
                if (xNeighbor == city)
                    continue;
                int dist = Math.abs(y - locations.get(xNeighbor).get(1));
                if (dist < min) {
                    min = dist;
                    ans = xNeighbor;
                } else if (dist == min)
                    ans = getSmaller(ans, xNeighbor);
            }

            for (String yNeighbor : yNeighbors) {
                if (yNeighbor == city)
                    continue;
                int dist = Math.abs(x - locations.get(yNeighbor).get(0));
                if (dist < min) {
                    min = dist;
                    ans = yNeighbor;
                } else if (dist == min)
                    ans = getSmaller(ans, yNeighbor);
            }

            nearest.add(ans);
        }

        System.out.println(nearest);
    }

    private static String getSmaller(String ans, String xNeighbor) {
        int diff = ans.compareTo(xNeighbor);
        if (diff < 0)
            return ans;
        else if (diff > 0)
            return xNeighbor;
        return ans;
    }

}
