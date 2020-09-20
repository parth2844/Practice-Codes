import java.util.HashMap;
import java.util.Map;

public class artifactsLocation {
    public static void main(String args[]) {
        String artifacts = "1A 1B,2C 2C";
        String searched = "";
        int N = 4;

        int[] answer = solution(N, artifacts, searched);
        for (int i : answer)
            System.out.print(i + " ");
    }

    private static int[] solution(int n, String artifacts, String searched) {
        if (searched.length() == 0 || artifacts.length() == 0)
            return new int[]{0, 0};

        int[][] map = new int[n][n];

        Map<Integer, Integer> artifactCount = new HashMap<>();
        Map<Integer, Integer> foundArtifacts = new HashMap<>();

        String[] locations = artifacts.split(",");
        String[] searchLocations = searched.split(" ");

        int artifactNumber = 1;

        // Filing up map with position of artifacts
        for (String location : locations) {
            String[] coordinates = location.split(" ");
            int[] endPoints = getCoordinates(coordinates);
            int count = 0;

            for (int i = endPoints[0]; i <= endPoints[2]; i++) {
                for (int j = endPoints[1]; j <= endPoints[3]; j++) {
                    map[i][j] = artifactNumber;
                    count++;
                }
            }
            artifactCount.put(artifactNumber, count);
            artifactNumber++;
        }

        // Printing Map for debugging
        print(map);

        // Storing locations searched and artifacts found
        for (String search : searchLocations) {
            int[] endPoint = getCoordinates(search);
            int num = map[endPoint[0]][endPoint[1]];
            if (num != 0) {
                foundArtifacts.putIfAbsent(num, 0);
                foundArtifacts.replace(num, foundArtifacts.get(num) + 1);
            }

        }

        //Print for debugging
        System.out.println(artifactCount);
        System.out.println(foundArtifacts);

        //Counting half and full found artifacts
        int half = 0, full = 0;

        for (int i = 1; i < artifactNumber; i++) {
            if (foundArtifacts.containsKey(i)) {
                if (artifactCount.get(i) == foundArtifacts.get(i))
                    full++;
                else
                    half++;
            }

        }

        return new int[]{full, half};
    }

    private static void print(int[][] map) {
        for (int[] row : map) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    }

    private static int[] getCoordinates(String coordinates) {
        int[] endPoints = new int[2];
        endPoints[0] = Integer.parseInt(coordinates.substring(0, coordinates.length() - 1)) - 1;
        endPoints[1] = coordinates.charAt(coordinates.length() - 1) - 'A';

        return endPoints;
    }

    private static int[] getCoordinates(String[] coordinates) {
        // System.out.println(coordinates[0]+"  "+coordinates[1]);
        int[] endPoints = new int[4];
        endPoints[0] = Integer.parseInt(coordinates[0].substring(0, coordinates[0].length() - 1)) - 1;
        endPoints[1] = coordinates[0].charAt(coordinates[0].length() - 1) - 'A';
        endPoints[2] = Integer.parseInt(coordinates[1].substring(0, coordinates[1].length() - 1)) - 1;
        endPoints[3] = coordinates[1].charAt(coordinates[1].length() - 1) - 'A';

        // for(int i: endPoints)
        //     System.out.print(i+" ");
        // System.out.println("Endpoint");
        return endPoints;
    }
}
