/*
 * 문제 : 1976 - 여행 가자 / 난이도 : Gold4
 * union-find 알고리즘 활용
 *
 * 메모리 : 55872KB / 시간 : 564ms
 * */

import java.util.Scanner;

public class Main {
	public static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		// parents 배열 초기화
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		// 연결되어 있는 도시 union
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if(graph[i][j] == 1) {
					union(i, j);
				}
			}
		}

		// 여행 계획에 있는 도시들이 모두 같은 그룹에 속해 있으면 YES, 아니면 NO
		int previous = find(sc.nextInt() - 1);
		for (int i = 1; i < m; i++) {
			int current = find(sc.nextInt() - 1);
			if (previous != current) {
				System.out.println("NO");
				break;
			}
			previous = current;
			if (i == m - 1) {
				System.out.println("YES");
			}
		}
	}

	// 두 노드를 결합시키는 union 메서드 정의
	public static void union(int a, int b){
		int aP = find(a);
		int bP = find(b);

		if(aP != bP){
			parents[aP] = bP;
		}
	}

	// 특정 노드의 최종 부모를 find 하는 메서드 정의
	public static int find(int a){
		if(a == parents[a]){
			return a;
		}

		return parents[a] = find(parents[a]);
	}
}



