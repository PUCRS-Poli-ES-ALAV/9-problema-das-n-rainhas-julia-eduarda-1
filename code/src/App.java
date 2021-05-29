import java.util.Scanner;
public class App {
    private static int queens =0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Escolha a quantidade de rainhas");
            queens= in.nextInt();
        }while (queens<2);
        NQueens nQueens = new NQueens(queens);
        nQueens.solve();
        nQueens.print();

    }
}


