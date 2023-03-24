package Week4.youngjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2 {

    static int N, M;
    static int cnt;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i); // 여기서 dfs 가 실행되면 연결된 부분을 모두 방문하게 된다.
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 1; i < N + 1; i++) {
            if (arr[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}