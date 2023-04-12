import java.io.*;
import java.util.*;

// 백준 1717 집합의 표현
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 원소 개수
		int n = Integer.parseInt(st.nextToken());
		// 연산 개수
		int m = Integer.parseInt(st.nextToken());

		// 원소 배열
		arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		// 연산
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (question == 0) {
				union(a, b);
			} else {
				String result = find(a) == find(b) ? "YES" : "NO";
				System.out.println(result);
			}
		}
	}
	// 집합 연결
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			arr[b] = a;
		}
	}

	// 부모 노드 찾기
	static int find(int a) {
		if (a == arr[a]) {
			return a;
		} else {
			return arr[a] = find(arr[a]);
		}
	}
}