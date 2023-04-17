
/*
 * 문제 : 14503 - 로봇 청소기 / 난이도 : Gold5
 * 북동남서 0123
 * 
 * 메모리 : 14428KB / 시간 : 128MS
 */
import java.io.*;
import java.util.StringTokenizer;

public class Level3 {
  static int N, M;
  static int[][] room;
  static int cnt = 1;
  static int[] dr = { -1, 0, 1, 0 }; // 북,동,남,서
  static int[] dc = { 0, 1, 0, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    room = new int[N][M];

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken()); // x 좌표
    int c = Integer.parseInt(st.nextToken()); // y 좌표
    int d = Integer.parseInt(st.nextToken()); // 방향

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cleanRoom(r, c, d);

    System.out.println(cnt);
  }

  public static void cleanRoom(int row, int col, int direction) {
    // 1. 현재 위치를 청소
    room[row][col] = 2;

    // 2. 왼쪽방향부터 차례대로 탐색 진행
    for (int i = 0; i < 4; i++) {
      direction = (direction + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)

      int next_r = row + dr[direction];
      int next_c = col + dc[direction];

      if (next_r >= 0 && next_c >= 0 && next_r < N && next_c < M) {
        if (room[next_r][next_c] == 0) {
          // 범위 안에 있고 아직 청소를 안했다면
          cnt++;
          cleanRoom(next_r, next_c, direction);
          return;
        }
      }
    }

    // 네 방향 모두 청소가 되어있거나 벽인 경우
    int next_d = (direction + 2) % 4; // 방향 뒤집기
    int next_br = row + dr[next_d];
    int next_bc = col + dc[next_d];

    if (next_br >= 0 && next_bc >= 0 && next_br < N && next_bc < M) {
      if (room[next_br][next_bc] != 1) {
        cleanRoom(next_br, next_bc, direction); // 바라보는 방향 유지한 채 후진
      }
    }
  }
}