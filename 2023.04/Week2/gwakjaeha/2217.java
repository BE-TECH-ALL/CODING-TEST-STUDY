/*
 * 문제 : 2217 - 로프 / 난이도 : Silver4
 * 그리디 알고리즘 활용
 *
 * 메모리 : 26940KB / 시간 : 448ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] weights = new Integer[n];
		int maxWeight = 0;

		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(br.readLine());
		}

		// 무게 내림차순 정렬
		Arrays.sort(weights, Collections.reverseOrder());

		// 같은 수의 로프를 사용한다면 내림차순 정렬했을때 무게가 큰 로프들을 사용하는 것이 좋음
		// 반복문을 돌면서 특정 로프보다 무게가 큰 로프는 항상 이용하고, 그렇게 했을 때 최대 무게를 업데이트
		for (int i = 0; i < n; i++) {
			int curWeight = weights[i] * (i+1);
			if(curWeight >= maxWeight) maxWeight = curWeight;
		}

		System.out.println(maxWeight);
	}
}