/*
 * 문제 : 1717 - 집합의 표현 / 난이도 : Gold5
 * union-find 알고리즘 활용
 *
 * 메모리 : 55888KB / 시간 : 1192ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//parents 배열 초기화
		parents = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		ArrayList<String> answer = new ArrayList<>();

		//union-find 알고리즘 수행
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(st.nextToken().equals("0")){
				// 0 이면 합치기
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} else {
				// 1 이면 같은 집합인지 비교
				int a = find(Integer.parseInt(st.nextToken()));
				int b = find(Integer.parseInt(st.nextToken()));
				if (a == b) {
					answer.add("YES");
				} else {
					answer.add("NO");
				}
			}
		}

		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
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