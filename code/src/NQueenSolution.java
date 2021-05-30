import java.util.Arrays;

class NQueenSolution {
    public static final int N = 4;

    public static void main(String[] args) {
        int[][] matriz = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(matriz[i], 0);
        }
        nQueen(matriz, 0);
    }

    private static boolean isSafe(int matriz[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            if (matriz[i][c] == 1) return false;
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (matriz[i][j] == 1) return false;
        }

        for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
            if (matriz[i][j] == 1) return false;
        }
        return true;
    }

    private static void printSolution(int matriz[][]) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(matriz[i]).replaceAll(",", ""));
        }
    }

    private static void nQueen(int mat[][], int r){
        if (r == N) {
            printSolution(mat);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(mat, r, i)) {
                mat[r][i] = 1;
                nQueen(mat, r + 1);
                mat[r][i] = 0;
            }
        }
    }
}