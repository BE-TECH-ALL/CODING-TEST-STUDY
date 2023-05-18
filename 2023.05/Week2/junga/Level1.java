// 1. 크레인 인형뽑기 게임 - 프로그래머스
// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Queue<Integer>[] newBoard = new Queue[board.length + 1];

        // Queue 구조로 보드 만들기
        for (int i = 0; i < board.length; i++) {
            newBoard[i + 1] = new LinkedList();
            
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    newBoard[i + 1].add(board[j][i]);
                }
            }
        }
        
        // 바구니
        Stack<Integer> basket = new Stack();
        basket.push(-1);
        
        int result = 0;
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            Integer doll = newBoard[move].poll();
            
            if (doll == null) {
                continue;
            }
            
            if (doll.equals(basket.peek())) {
                basket.pop();
                result += 2;
            } else {
                basket.push(doll);
            }
        }

        return result;
    }
}
