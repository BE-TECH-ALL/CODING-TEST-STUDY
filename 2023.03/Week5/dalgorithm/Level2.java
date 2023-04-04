package Week5.dalgorithm;

/*
 * 문제 : 2178 - 미로 탐색 / 난이도 : Silver1
 * 미로 탐색 - bfs 시도
 * 좌표마다 이동 가능성 확인 필요
 *
 * 메모리 : 14740KB / 시간 : 140MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Level2 {
  static int N, M;
  static int[][] maze;
  static boolean[][] visited;
  static int[] dirX = { 0, 0, -1, 1 };
  static int[] dirY = { -1, 1, 0, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 행
    M = Integer.parseInt(st.nextToken()); // 열

    maze = new int[N][M]; // 미로
    visited = new boolean[N][M]; // 방문여부 확인
    visited[0][0] = true; // 첫 시작점 위치 true

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String cur = st.nextToken(); // 미리 안 빼주면 런타임 에러 발생
      for (int j = 0; j < M; j++) {
        maze[i][j] = cur.charAt(j) - '0';
      }
    }

    bfs(0, 0);
    System.out.println(maze[N - 1][M - 1]);
  }

  static void bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));
    visited[x][y] = true;

    while (!queue.isEmpty()) { // 큐에 들어간 좌표의 탐색이 모두 끝날 때까지 진행
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nextX = node.x + dirX[i];
        int nextY = node.y + dirY[i];

        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]
            && maze[nextX][nextY] != 0) { // 좌표 유효성 검사

          queue.add(new Node(nextX, nextY));

          // 탐색 비용 + 1
          maze[nextX][nextY] = maze[node.x][node.y] + 1;

          // 탐색 처리
          visited[nextX][nextY] = true;
        }
      }

    }
  }

  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
