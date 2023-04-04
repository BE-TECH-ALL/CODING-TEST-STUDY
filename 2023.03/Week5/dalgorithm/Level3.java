package Week5.dalgorithm;

/*
 * 문제 : 1976 - 여행 가자 / 난이도 : Gold4
 * 경로 중복 가능, 되돌아가기 가능
 * union-find 이번 기회에 공부해서 적용..!
 *
 * 메모리 : 18032KB / 시간 : 204MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level3 {
  static int N; // 도시의 수
  static int M; // 여행 계획에 속한 도시 수
  static int[] route; // 그룹의 대표를 나타내는 배열
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    route = new int[N + 1]; // [해당노드] = 최상위 부모값
    for (int i = 1; i <= N; i++) {
      route[i] = i;
    }

    for (int i = 1; i <= N; i++) { // 경로 잇기
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        int flag = Integer.parseInt(st.nextToken());
        if (flag == 1) { // 방문 가능하다면 연결하기
          union(i, j);
        }
      }
    }

    // 여행 계획
    st = new StringTokenizer(br.readLine());
    int root = -1;
    for (int i = 1; i <= M; i++) {
      int now = Integer.parseInt(st.nextToken());
      if (root == -1)
        root = find(now);
      if (root != find(now)) {
        System.out.println("NO"); // 다른 대표를 갖고 있다면 no 출력
        return;
      }
    }
    System.out.println("YES");
  }

  private static void union(int x, int y) { // 도시 묶기
    x = find(x); // 그룹의 대표 찾기
    y = find(y); // 동일
    if (x != y) { // 대표가 다를 경우, 수정하기
      route[y] = x;
    }
  }

  private static int find(int x) { // 도시의 대표 찾기
    if (route[x] == x) { // 대표가 곧 자신일 때 (그룹의 가장 작은 수)
      return x;
    }

    return route[x] = find(route[x]);
  }
}
