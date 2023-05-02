package Week4.youngjoon;

import java.util.*;
import java.io.*;

/**
 * 11660번 구간 합 구하기 5
 * 난이도 : 실버 1
 * 메모리 : 128804KB / 시간 : 1892ms
 * DP, 누적합
 */

public class Level1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] sum = new int[N + 1][N + 1]; // 인덱스의 값이 x,y 까지의 합인 누적합 2차원 배열을 생성

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[i + 1][j + 1] = arr[i][j] // 새로 더하게 되는 부분
                    + sum[i][j + 1] + sum[i + 1][j] // 그전 까지의 누적합 부분
                    - sum[i][j]; // 겹치는 부분은 제외
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1]
                + sum[x1 - 1][y1 - 1]); // 두번 빼는 부분은 다시 더해준다.
        }
    }
}
