import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void drawStar(char[][] board, int height, int r, int c) {

        if(height == 3) {
            board[r][c] = '*';
            board[r+1][c-1] = '*';
            board[r+1][c+1] = '*';
            for(int i = c-2 ; i <= c+2 ; i++) board[r+2][i] = '*';
            return;
        }

        int delta =height/2;

        drawStar(board, height/2, r, c);
        drawStar(board, height/2, r+height/2, c-delta);
        drawStar(board, height/2, r+height/2, c+delta);
    }

    public static void initboard(char[][] board, int r, int c) {
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int n = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        char[][] board = new char[n][2*n-1];
        initboard(board, n, 2*n-1);
        drawStar(board, n, 0, n-1);

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < 2*n-1; j++){
                builder.append(board[i][j]);
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
