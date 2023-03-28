/*
 * 문제 : 11724 - 연결 요소의 개수 / 난이도 : Silver2
 * 문제가 처음에 이해가 잘 되지 않아, 연결 요소의 개수를 구하는 방법에 대해 찾아봤다.
 * 연결이 되어 있는 하나의 덩어리를 연결 요소 1개로 생각하고 count 진행
 * 예제 입력 1번을 보면 크게 2개의 덩어리로 분리된다.
 * 방문해서 연결이 되어있는지 아닌지 확인을 해봐야하기 때문에 bfs나 dfs로 접근 필요
 * dfs를 통해서, 방문 이력이 없을 경우 방문 처리와 count를 해주고,
 * 노드마다 이 과정을 반복해야한다.
 *
 * 메모리 : 141796KB / 시간 : 704MS
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Level2 {

  static int N; // 정점 수
  static int M; // 간선 수
  static ArrayList<Integer>[] adjList; // 인접리스트
  static boolean[] visited; // 방문 여부

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    adjList = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    int vert1, vert2, result = 0;

    for (int i = 1; i < N + 1; i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      // 간선 연결
      st = new StringTokenizer(br.readLine(), " ");
      vert1 = Integer.parseInt(st.nextToken());
      vert2 = Integer.parseInt(st.nextToken());
      adjList[vert1].add(vert2);
      adjList[vert2].add(vert1);
    }

    for (int i = 1; i < N + 1; i++) {
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }
    System.out.println(result);
  }

  static void dfs(int v) {
    if (visited[v])
      return; // 방문했다면 pass

    // 방문 이력 없다면, 탐색 진행
    visited[v] = true;
    for (int i : adjList[v]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
