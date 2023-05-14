/*
 * 문제 : 프로그래머스 순위(Level3)
 * 플로이드워셜과 유사한 알고리즘 활용
 * */

class Solution {
	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] floyd = new int[n][n];

		// 승패 결과를 이차원 배열에 저장, i가 j를 이기면 floyd[i][j] = 1 지면 -1
		for(int i = 0; i < results.length; i++){
			floyd[results[i][0]-1][results[i][1]-1] = 1;
			floyd[results[i][1]-1][results[i][0]-1] = -1;
		}

		// i가 k를 이기고, k가 j를 이기면 i는 j를 이김, 지는 경우도 마찬가지
		// 위 원리를 바탕으로 이차원 배열을 채워넣음
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					if(floyd[i][k] == 1 && floyd[k][j] == 1){
						floyd[i][j] = 1;
						floyd[j][i] = -1;
					}
					if(floyd[i][k] == -1 && floyd[k][j] == -1){
						floyd[i][j] = -1;
						floyd[j][i] = 1;
					}
				}
			}
		}

		// 모든 상대방에 대해 자신의 승,패를 아는 경우가 n-1개 이면 자신의 순위를 결정할 수 있음
		for(int i = 0; i < n; i++){
			int count = 0;
			for(int j = 0; j < n; j++){
				if(floyd[i][j] != 0) count++;
			}

			if(count == n-1) answer++;
		}

		return answer;
	}
}