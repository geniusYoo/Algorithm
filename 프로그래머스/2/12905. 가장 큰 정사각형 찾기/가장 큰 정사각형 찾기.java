import java.util.Arrays;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        int N = board.length;
        int M = board[0].length;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                // 위, 왼쪽, 대각선 확인해서 최솟값이랑 현재 블록의 값 더해주면 됨
                if (board[i][j] > 0) {
                    board[i][j] += Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer * answer;
    }
}