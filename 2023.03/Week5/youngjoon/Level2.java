package Week5.youngjoon;

/*
 * 2178번 - 미로탐색
 * BFS
 * 메모리: 14632KB / 시간: 140ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Level2 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) { // 2차원 배열로 1,0 값을 넣는다.
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]); // bfs 를 순회하고 n,m 의 값을 출력
    }

    static void bfs(int x, int y) { // 최단거리이므로 dfs 가 아닌 bfs 를 사용한다.
        Queue<Integer> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(x);
        q.offer(y);

        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();

            for (int i = 0; i < 4; i++) { // 상하좌우 4방향 움직이는 경우
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { // 범위안에서만 움직여야 한다.
                    if (map[nx][ny] > 0 && !visited[nx][ny]) { // 0이 아니어야 하고, 방문하지 않은 곳만 갈 수 있다.
                        visited[nx][ny] = true; // 처음 방문한 곳은 방문처리
                        map[nx][ny] = map[x][y] + 1; // 최단거리 확인을 위해서 이동한 곳은 값을 1증가 시킨다.
                        // 즉, 임의의 좌표의 값은 첫 좌표로부터의 거리를 나타낸다.
                        q.offer(nx); // 다시 poll 하기 위해서 offer 로 자료구조에 넣는다.
                        q.offer(ny);
                    }
                }
            }
        }
    }
}
