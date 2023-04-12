/*
 * 문제 : 2193 - 이친수 / 난이도 : Silver3
 * 다이나믹 프로그래밍 활용
 *
 * 메모리 : 14292KB / 시간 : 128ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// n이 90까지 이므로 dp[90] 이 되었을때 int 를 사용할 경우 overflow 발생
		long[] dp = new long[n+1];

		//초기화 - 1자리수 이친수는 1개
		dp[1] = 1;

		//n자리 이친수는 n-1자리 이친수에 "0"을 붙이거나 n-2자리 이친수에 "01"을 붙여서 모두 만들 수 있음.
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		System.out.println(dp[n]);
	}
}