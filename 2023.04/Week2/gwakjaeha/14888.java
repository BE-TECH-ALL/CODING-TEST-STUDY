/*
 * 문제 : 14888 - 연산자 끼워넣기 / 난이도 : Silver1
 * DFS 알고리즘 활용
 *
 * 메모리 : 15792KB / 시간 : 132ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int maxValue;
	public static int minValue;

	public static int n;
	public static int[] numbers;
	public static int[] mathSymbols;

	public static void main(String[] args) throws IOException {
		int curValue = 0;
		int count = 0;
		maxValue = Integer.MIN_VALUE;
		minValue = Integer.MAX_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		mathSymbols = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 숫자 입력
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		// 사용가능한 수학기호 입력
		for (int i = 0; i < 4; i++) {
			mathSymbols[i] = Integer.parseInt(st.nextToken());
		}

		curValue = numbers[0];
		DFS(curValue, count);

		System.out.println(maxValue);
		System.out.println(minValue);
	}

	public static void DFS(int curValue, int count){

		// 부호를 모두 채워넣었을 때 (n-1개) 최소, 최대를 업데이트하고 중지
		if (count == n-1){
			maxValue = Math.max(maxValue, curValue);
			minValue = Math.min(minValue, curValue);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(mathSymbols[i] <= 0) continue;
			mathSymbols[i] -= 1;
			count++;
			// 각 부호에 따라 DFS 진행
			if(i == 0) {
				DFS(curValue + numbers[count], count);
			} else if (i == 1) {
				DFS(curValue - numbers[count], count);
			} else if (i == 2) {
				DFS(curValue * numbers[count], count);
			} else if (i == 3) {
				DFS(curValue / numbers[count], count);
			}
			// 다른 부호로 변경할때 사용한 수학기호 개수와 count(= depth) 원상복귀
			mathSymbols[i] += 1;
			count--;
		}
	}
}