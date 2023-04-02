/*
 * 문제 : 2178 - 미로 탐색 / 난이도 : Silver1
 * BFS 활용
 *
 * 메모리 : 18496KB / 시간 : 244ms
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		//버퍼 지우기
		sc.nextLine();

		int[][] graph = new int[n][m];

		//맵 초기화
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}

		//BFS 호출
		BFS(graph, n, m);
	}

	public static void BFS(int[][] graph, int n, int m){
		//이동가능한 방향 초기화
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(0,0));

		while(!queue.isEmpty()){
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				//새로운 좌표로 이동
				int newX = node.x + dx[i];
				int newY = node.y + dy[i];

				//이동한 곳이 맵에서 벗어나거나 0으로 접근할 수 없는 경우 제외
				if(newX < 0 || newY < 0 || newX >= n || newY >= m || graph[newX][newY] == 0) continue;

				//한번도 접근한 적이 없는 칸만 접근 가능 (이미 접근해본 칸은 최소 경로일 수 없음)
				if(graph[newX][newY] == 1){
					graph[newX][newY] = graph[node.x][node.y] + 1;
					queue.add(new Node(newX, newY));
				}
			}
		}
		System.out.println(graph[n-1][m-1]);
	}

	static class Node{
		int x;
		int y;

		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}



