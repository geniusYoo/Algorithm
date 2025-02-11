import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int i=0; i<moves.length; i++) {
            for (int k=0; k<board.length; k++) {
                if (board[k][moves[i] - 1] != 0) {
                    if (!basket.isEmpty() && basket.peek() == board[k][moves[i] - 1]) {
                        
                        basket.pop();
                        answer += 2;
                    }
                    else {
                        basket.push(board[k][moves[i] - 1]);
          
                    }
                    
                    board[k][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}