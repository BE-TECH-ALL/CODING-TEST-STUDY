/*
 * 문제 : 2503 - 숫자 야구 / 난이도 : Silver3
 * 완전탐색 활용
 *
 * 메모리 : 18388KB / 시간 : 240ms
 * */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BaseBallInfo> baseBallInfos = new ArrayList<>();
		int n  = sc.nextInt();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			baseBallInfos.add(new BaseBallInfo(sc.next(), sc.nextInt(), sc.nextInt()));
		}

		for (int number = 123; number <= 987; number++) {
			if(hasSameNumberOrZero(number)) continue;
			int passCount = 0;
			for (BaseBallInfo baseBallInfo : baseBallInfos){
				int strike = countStrike(baseBallInfo.number, String.valueOf(number));
				int ball = countBall(baseBallInfo.number, String.valueOf(number));

				if(baseBallInfo.strike == strike && baseBallInfo.ball == ball) passCount++;
				else break;
			}
			if(passCount == n) answer++;
		}

		System.out.println(answer);
	}

	public static boolean hasSameNumberOrZero(int number){
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			numSet.add(number % 10);
			number /= 10;
		}
		return numSet.contains(0) || numSet.size() < 3;
	}

	public static int countStrike(String candidate, String prediction){
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(candidate.charAt(i) == prediction.charAt(i)) count++;
		}
		return count;
	}

	public static int countBall(String candidate, String prediction){
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == j) continue;
				if(candidate.charAt(i) == prediction.charAt(j)) count++;
			}
		}
		return count;
	}

	static class BaseBallInfo{
		String number;
		int strike;
		int ball;

		public BaseBallInfo(String number, int strike, int ball){
			this.number = number;
			this.strike = strike;
			this.ball = ball;
		}
	}
}



