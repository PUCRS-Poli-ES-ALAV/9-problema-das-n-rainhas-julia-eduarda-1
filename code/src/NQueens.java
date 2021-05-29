public class NQueens {
    final int queens;
    private int board[][];
    public NQueens(int queens){
        this.queens =queens;
        this.board = createBoard();
    }

    private int[][] createBoard(){
        int board[][] = new int [queens][queens];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }

    public boolean solve(){
        if (!solve(0)) {
            System.out.print("Solução não encontrada");
            return false;
        }
        return true;
    }
    private boolean solve(int col){
        if (col >= queens)
            return true;
        for (int i = 0; i < queens; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solve(col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int linha, int col){
        int i, j;

        for (i = 0; i < col; i++)
            if (board[linha][i] == 1)
                return false;

        for (i = linha, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = linha, j = col; j >= 0 && i < queens; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public void print(){
        for (int i = 0; i < queens; i++) {
            for (int j = 0; j < queens; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }
}
