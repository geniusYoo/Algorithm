import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Block {
    int i, j;

    public Block(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Main {

    private static int[][] board;
    public static void main(String[] args) throws IOException {
        board = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k=0; k<9; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        for (int i=0; i<9; i++) {
            for (int k=0; k<9; k++) {
                System.out.print(board[i][k] + " ");
            }
            System.out.println();
        }

    }
    private static boolean isInBox(int r, int c, int num) {
        int row = (r / 3) * 3;
        int col = (c / 3) * 3;

        for (int i=row; i<row+3; i++) {
            for (int k=col; k<col+3; k++) {
                if (board[i][k] == num) return true;
            }
        }
        return false;
    }

    private static boolean isInRow(int r, int num) {
        return Arrays.stream(board[r]).anyMatch(k -> k == num);
    }

    private static boolean isInCol(int c, int num) {
        for (int i=0; i<9; i++) {
            if(board[i][c] == num) return true;
        }
        return false;
    }

    private static Block findEmpty() {
        for (int i=0; i<9; i++) {
            for (int k=0; k<9; k++) {
                if (board[i][k] == 0) return new Block(i, k);
            }
        }
        return null;
    }

    private static boolean isValid(int r, int c, int num) {
        return !(isInBox(r, c, num) || isInCol(c, num) || isInRow(r, num));
    }

    private static boolean solution() {
        Block emptyBlock = findEmpty();
        if (emptyBlock == null) return true;

        int r = emptyBlock.i;
        int c = emptyBlock.j;

        for (int num = 1; num <=9; num++) {
            if (isValid(r, c, num)) {
                board[r][c] = num;
                if(solution()) {
                    return true;
                }
                board[r][c] = 0;
            }
        }
        return false;
    }
}