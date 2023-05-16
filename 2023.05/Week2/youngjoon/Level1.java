import java.util.*;

/*
 * 문제 : 크레인 인형뽑기 게임 / 난이도 : Level1
 */

class Solution {
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>(); // 바구니에 담는 형태여서 스택 사용
        int cnt = 0;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] != 0) { // moves 의 위치는 1부터 시작하므로 1을 빼준다.
                    if (stack.size() == 0) {
                        stack.push(board[j][moves[i] - 1]);
                    } else if (stack.peek() == board[j][moves[i] - 1]) {
                        stack.pop(); // 같으면 없어지니까
                        cnt += 2; // 터져서 없어지는 경우 2개가 없어지므로
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i] - 1] = 0; // 뽑고 난 후에는 인형이 없으니까 0으로 바꿔준다.
                    break; // moves 에서 하나 뽑았다면 더이상 순회할 필요없이 다음 move로 이동
                }
            }
        }

        return cnt;
    }
}