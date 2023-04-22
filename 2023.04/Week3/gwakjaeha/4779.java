/*
 * 문제 : 4779 - 칸토어 집합 / 난이도 : Silver3
 * 구현 문제
 *
 * 메모리 : 22844KB / 시간 : 356ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder lines;
	public static int n;
	public static int lineLength;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NumStr;

		while((NumStr = br.readLine()) != null){ // 입력이 null 이면 종료
			n = Integer.parseInt(NumStr);
			lineLength = (int) Math.pow(3,n);
			lines = new StringBuilder();

			for (int i = 0; i < lineLength; i++) {
				lines.append("-");
			}

			cantorSet(0, lineLength);

			System.out.println(lines);
		}

		br.close();
	}

	public static void cantorSet(int start, int end){ // start: 시작 인덱스, end: 끝 인덱스 + 1

		// 문자열 길이가 1 이면 종료
		if(end - start == 1) return;

		// 앞에서 1/3 지점과 2/3 지점 사이의 문자열을 공백으로 변경함
		for (int i = start + (end - start) / 3; i < end - (end - start) / 3; i++) {
			lines.setCharAt(i, ' ');
		}

		// 맨 앞부터 3/1 지점까지의 문자열에 대해 cantorSet 함수 실행
		cantorSet(start, start + (end - start) / 3);
		// 3/2 지점부터 맨 끝까지의 문자열에 대해 cantorSet 함수 실행
		cantorSet(end - (end - start) / 3, end);
	}
}