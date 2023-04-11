/*
 * 문제 : 2193 - 이친수 / 난이도 : Silver3
 * 1 <= N <= 90
 * 점화식 사용
 * 
 * 메모리 : 14220KB / 시간 : 128MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level1 {
  public static int N;
  public static long[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dp = new long[91][2];
    dp[1][0] = 0; // dp[i][i] : dp i자리에서 j로 끝나는 이친수의 개수
    dp[1][1] = 1; // 초기값

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
      dp[i][1] = dp[i - 1][0];
    }
    System.out.println(dp[N][0] + dp[N][1]);
  }

}
