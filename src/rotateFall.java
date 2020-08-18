public class rotateFall {
    public static void main(String args[]) {

        char[][] box = {{'#', '#', '*', '.', '.', '.', '.'},
                {'#', '.', '.', '*', '#', '.', '.'},
                {'#', '#', '.', '#', '.', '.', '*'}};

        for (int row = 0; row < box.length; row++) {
            for (int col = box[0].length - 1; col >= 0; col--) {
                if (box[row][col] == '#') {
                    int i = col + 1;
                    while (i < box[0].length && box[row][i] == '.') {
                        i++;
                    }
                    box[row][col] = '.';
                    box[row][i - 1] = '#';
                }
            }
        }

        char[][] matrix = new char[box[0].length][box.length];

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                matrix[j][i] = box[i][j];
            }
        }

        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
