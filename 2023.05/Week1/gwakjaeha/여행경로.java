/*
 * 문제 : 프로그래머스 여행경로(Level3)
 * DFS
 * */

import java.util.*;

class Solution {
	public static boolean[] visited;
	public static List<String> allPath;
	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		// 모든 도시를 방문할 수 있는 경로들을 담아둠
		allPath = new ArrayList<String>();

		dfs("ICN", "ICN", tickets, 0);

		// 가능한 경로들 중 알파벳 순서가 가장 앞서는 경로를 추출하기 위함
		Collections.sort(allPath);

		String[] answer = allPath.get(0).split(" ");

		return answer;
	}

	public static void dfs(String start, String path, String[][] tickets, int cnt){
		// 모든 tickets 을 활용한 (즉, 모든 도시를 탐방) 경로들을 모아둠
		if(cnt == tickets.length){
			allPath.add(path);
			return;
		}

		for(int i = 0; i < tickets.length; i++){
			// 해당 도시에서 출발하는 티켓이고 아직 사용되지 않은 티켓인 경우
			if(start.equals(tickets[i][0]) && visited[i] == false){
				visited[i] = true;
				dfs(tickets[i][1], path + " " + tickets[i][1], tickets, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
