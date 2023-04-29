/*
 * 문제 : 2294 - 동전 2 / 난이도 : Gold5
 * 다이나믹 프로그래밍
 *
 * 메모리 : 14308KB / 시간 : 136ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		int[] dp = new int[k+1];

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= k; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		// dp 배열에서 k 번째 값은 k 를 만들기 위해 필요한 최소 동전의 수
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				if(dp[j-coins[i]] != Integer.MAX_VALUE){
					dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
				}
			}
		}

		if (dp[k] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}

	}
}