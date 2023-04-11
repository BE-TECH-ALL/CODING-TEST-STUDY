package youngjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2193번 이친수
 * dp
 * 메모리: 14276KB  / 시간: 132ms
 */

public class Level1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        if (N == 1) {
            System.out.println("1");
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}

