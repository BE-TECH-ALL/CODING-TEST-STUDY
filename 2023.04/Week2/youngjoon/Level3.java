package Week2.youngjoon;

import java.io.*;
import java.util.*;

/**
 * 14503번 로봇 청소기
 * 난이도 : 골드 5
 * 메모리 : 	/ 시간 :
 * dfs
 */

public class Level3 {

    static int N, M;
    static int[][] map;
    static int cnt;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 1, 0 값들 저장
            }
        }
        cnt = 1; // 첫 자리는 청소하고 시작하므로

        dfs(r, c, d);
        System.out.println(cnt);
    }

    public static void dfs(int r, int c, int d) {
        map[r][c] = -1;

        for (int i = 0; i < 4; i++) { // 진행하는 방향이 있는 그래프 문제는 dfs 를 사용해야하는 것으로 알고있는데,
            // 방향이 정해진 경우는 어떻게 하는건지 잘 모르겠네요.
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
                cnt++;
                dfs(nr, nc, d);
            }
        }

        // 다시 후진하는 경우도 어떻게 하는 건지 잘 모르겠습니다.
        // 반시계 방향 회전도 잘모르겠습니다.
    }
}
