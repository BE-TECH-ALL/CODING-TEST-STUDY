/*
 * 문제 : 11660 - 구간 합 구하기 5 / 난이도 : Silver1
 * 누적합 배열 활용
 *
 * 메모리 : 124404KB / 시간 : 1708ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] cumSumArray = new int[n+1][n+1];

		// 누적합 배열 생성
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				cumSumArray[i+1][j+1] =
					cumSumArray[i][j+1] + cumSumArray[i+1][j] - cumSumArray[i][j]
						+ Integer.parseInt(st.nextToken());
			}
		}

		// x1, y1 부터 x2, y2 까지의 합은 누적합배열의 ((x2,y2) 값 - (x2,y1-1) 값 - (x1-1,y2) 값 + (x1-1,y1-1) 값) 과 같다
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(cumSumArray[x2][y2] - cumSumArray[x2][y1-1] - cumSumArray[x1-1][y2] + cumSumArray[x1-1][y1-1]);
		}
	}
}