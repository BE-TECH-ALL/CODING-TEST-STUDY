/*
 * 문제 : 10819 - 차이를 최대로 / 난이도 : Silver2
 * DFS
 *
 * 메모리 : 15244KB / 시간 : 148ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] out;
	public static int maxNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		out = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(maxNum);
	}

	public static void dfs(int depth){
		if(depth == n){
			// 함수 값을 계산
			getValue();
			return;
		}

		// n 개의 숫자로 나타낼 수 있는 모든 순서쌍을 표현
		for (int i = 0; i < n; i++) {
			if(visited[i] != true){
				out[depth] = arr[i];
				visited[i] = true;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

	public static void getValue(){
		int value = 0;
		for (int i = 1; i < n; i++) {
			value += Math.abs(out[i] - out[i-1]);
		}
		if(maxNum < value) maxNum = value;
	}
}