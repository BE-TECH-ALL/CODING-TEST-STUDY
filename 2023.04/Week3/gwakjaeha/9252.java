/*
 * 문제 : 9252 - LCS 2 / 난이도 : Gold4
 * 다이나믹 프로그래밍
 *
 * 메모리 : 19356KB / 시간 : 216ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		// 해당 칸에 현재까지의 문자열로 만들 수 있는 최대 LCS 길이를 입력하기 위한 2차원 dp 테이블 생성
		dp = new int[s1.length()+1][s2.length()+1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length() ; j++) {
				if(s1.charAt(i-1) != s2.charAt(j-1)){ // 비교 대상의 두 문자가 다른 경우, 위 칸과 왼쪽 칸의 수 중 최대 값을 가져옴
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				} else {
					dp[i][j] = dp[i-1][j-1] + 1; // 비교 대상의 두 문자가 같은 경우, 대각선 칸 수 + 1
				}
			}
		}

		System.out.println(dp[s1.length()][s2.length()]);

		int curRow = s1.length();
		int curCol = s2.length();
		List<Character> lcsList = new ArrayList<>();

		// dp 테이블의 맨 마지막 칸에서 출발하여 역으로 LCS 문자열을 가져옴
		while(dp[curRow][curCol] != 0){ // 칸의 숫자가 0인 경우 멈춤
			if(s1.charAt(curRow-1) != s2.charAt(curCol-1)){ // 비교 대상의 두 문자가 다른 경우, 왼쪽 칸과 위쪽 칸 중 수가 큰 쪽으로 이동
				if(dp[curRow-1][curCol] >= dp[curRow][curCol-1]){
					curRow--;
				} else {
					curCol--;
				}
			} else {
				lcsList.add(s1.charAt(curRow-1)); // 비교 대상의 두 문자가 같은 경우, 해당 문자를 출력하고 대각선으로 이동함
				curRow--;
				curCol--;
			}
		}

		// LCS 를 출력
		for (int i = lcsList.size() - 1; i >= 0; i--) {
			System.out.print(lcsList.get(i));
		}

		br.close();
	}
}