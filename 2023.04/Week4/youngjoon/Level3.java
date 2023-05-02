package Week4.youngjoon;

import java.io.*;
import java.util.*;

/**
 * 2294번 동전 2
 * 난이도 : 골드 5
 * 메모리 : 14216KB / 시간 : 140ms
 * DP
 */

public class Level3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) { // 동전의 가치 입력
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) { // 해당 인덱스는 해당 값까지 필요한 최소의 동전갯수를 의미한다.
            dp[i] = 10001; // 동전의 가치는 10000까지 입력이 주어지므로, 그보다 큰값으로 초기값을 잡는다.
        }

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            } // 만약 1원 짜리 동전과 5원 짜리 동전이 있다면, i = 0 일때는 dp[5] = 5 가 된다.
            // 그 이후 i = 1 일 때는 5원을 맞추기 위해서 1원짜리는 5개 필요하지만, 5원 짜리 동전으로는 1개면 되므로,
            // dp[5] = 1 이 된다.
        }

        if (dp[k] == 10001) System.out.println(-1); // k값을 만들 수 없는 경우.
        else System.out.println(dp[k]);
    }
}
