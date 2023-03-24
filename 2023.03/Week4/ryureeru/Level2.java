package Week4.ryureeru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2 {

	static int[][] edges; // 간선 연결 상태
	static boolean[] checked; // 확인 여부
	static int N; // 정점의 개수
	static int M; // 간선의 개수

	public static void dfs(int i) {
		checked[i] = true;
		for (int j = 1; j <= N; j++) {
			if (edges[i][j] == 1 && !checked[j]) {
				dfs(j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new int[N + 1][N + 1];
		checked = new boolean[N + 1];

		// 간선 연결상태 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 정점 u
			int v = Integer.parseInt(st.nextToken()); // 정점 v

			edges[u][v] = edges[v][u] = 1;
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(!checked[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
		br.close();

	}

}
