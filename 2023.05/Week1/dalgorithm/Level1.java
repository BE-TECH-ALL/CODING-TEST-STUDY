package dalgorithm;

/*
 * 문제 : 43164 - 여행경로 / 난이도 : Level3
 * 깊이/너비 우선 탐색(DFS/BFS)
 */

import java.util.*;

public class Level1 {

  // 도시 형태로 문자열 잇기 위함
  static ArrayList<String> list = new ArrayList<>();

  // 티켓 사용 여부
  static boolean[] visited;

  public String[] solution(String[][] tickets) {
    visited = new boolean[tickets.length];
    dfs(0, "ICN", "ICN", tickets);

    // 알파벳 순서로 정렬
    Collections.sort(list);

    return list.get(0).split(" ");
  }

  static void dfs(int depth, String now, String path, String[][] tickets) {
    if (depth == tickets.length) {
      list.add(path);
      return;
    }

    for (int i = 0; i < visited.length; i++) {
      // 아직 사용하지 않은 티켓이고, 경로가 맞을 경우
      if (!visited[i] && now.equals(tickets[i][0])) {
        visited[i] = true;
        dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
        visited[i] = false;
      }
    }
  }

}
