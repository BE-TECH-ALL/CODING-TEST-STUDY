/*
 * 문제 : 크레인 인형뽑기 게임(Level1)
 * 스택 활용
 * */

import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int n = board.length;
		Stack<Integer> basketStack = new Stack<Integer>();
		int answer = 0;

		for(int i = 0; i < moves.length; i++){
			for(int j = 0; j < n; j++){
				// 칸의 값이 0 이 아닌 경우, 즉 인형이 있는 경우
				if(board[j][moves[i]-1] != 0){
					int doll = board[j][moves[i]-1];
					// 바구니 스택이 비어있지 않고 맨 위 인형이 일치하면 사라진 인형에 2를 더하고 바구니 스택에서 사라지게 함
					if(!basketStack.empty() && basketStack.peek() == doll){
						answer += 2;
						basketStack.pop();
					} else {
						// 스택이 비어있거나 맨위 인형이 일치하지 않으면 인형을 바구니 스택에 넣어줌
						basketStack.push(doll);
					}
					// 뽑은 인형에 대해서는 board 값을 0으로 처리함
					board[j][moves[i]-1] = 0;
					break;
				}
			}
		}

		return answer;
	}
}
