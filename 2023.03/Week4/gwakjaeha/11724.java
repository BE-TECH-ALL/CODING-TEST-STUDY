/*
 * 문제 : 11724 - 연결 요소의 개수 / 난이도 : Silver2
 * union-find 알고리즘 활용
 *
 * 메모리 : 309084KB / 시간 : 1488ms
 * */

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		// union-find 알고리즘을 적용하기 위해 parents 배열 정의 및 초기화
		parents = new int[n+1];

		for (int i = 1; i < n+1; i++) {
			parents[i] = i;
		}

		// 연결된 노드를 union 메서드를 통해 결합함
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			union(u,v);
		}

		// parents 배열에서 각 노드별 최종 부모 노드의 수를 카운트 하면 연결 요소의 개수를 알 수 있음
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 1; i < n+1; i++) {
			hashSet.add(find(i));
		}

		// 답안 출력
		System.out.println(hashSet.size());
	}

	// 두 노드를 결합시키는 union 메서드 정의
	public static void union(int a, int b) {
		int aP = find(a);
		int bP = find(b);

		if (aP != bP) {
			parents[aP] = bP;
		}
	}

	// 특정 노드의 최종 부모를 find 하는 메서드 정의
	public static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
}
