package Week5.dalgorithm;

/*
 * 문제 : 2503 - 숫자 야구 / 난이도 : Silver3
 * 완전탐색(Brute Force) 알고리즘
 * 중복되지 않는 케이스 확인 필요
 * 
 * 메모리 : 14640KB / 시간 : 136MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Level1 {
  static int N;
  static boolean[] check = new boolean[1000];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    List<BaseBallInfo> input = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      input.add(new BaseBallInfo(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    System.out.println(result(input));
  }

  private static int result(List<BaseBallInfo> input) {
    int answer = 0;

    for (int number = 123; number <= 987; number++) { // Bruteforce
      if (hasSameOrContainsZero(number)) { // 중복 숫자 or 0 포함 케이스
        continue;
      }

      int allPass = 0;
      for (BaseBallInfo baseBallInfo : input) {
        String src = baseBallInfo.number;
        String current = String.valueOf(number);

        int strike = checkStrike(src, current);
        int ball = checkBall(src, current);

        if (strike == baseBallInfo.strike && ball == baseBallInfo.ball) {
          allPass++;
        } else {
          break;
        }
      }

      if (allPass == input.size()) {
        answer++;
      }
    }
    return answer;
  }

  private static int checkStrike(String src, String target) { // 스트라이크 갯수
    int strike = 0;
    for (int i = 0; i < 3; i++) {
      if (src.charAt(i) == target.charAt(i)) {
        strike++;
      }
    }
    return strike;
  }

  private static int checkBall(String src, String target) { // 볼 갯수
    int ball = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j)
          continue;
        if (src.charAt(i) == target.charAt(j)) {
          ball++;
        }
      }
    }
    return ball;
  }

  private static boolean hasSameOrContainsZero(int number) { // 같은 숫자나 0이 포함될 경우
    String sNum = String.valueOf(number);
    Set<Character> chars = new HashSet<>();
    for (int i = 0; i < sNum.length(); i++) {
      chars.add(sNum.charAt(i));
    }
    return chars.contains('0') || chars.size() != 3;
  }

  static class BaseBallInfo {
    String number;
    int strike;
    int ball;

    public BaseBallInfo(String number, int strike, int ball) {
      this.number = number;
      this.strike = strike;
      this.ball = ball;
    }
  }
}
