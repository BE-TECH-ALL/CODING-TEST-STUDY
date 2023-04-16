/*
 * 문제 : 14888 - 연산자 끼워넣기 / 난이도 : Silver1
 * 재귀호출 사용
 * 
 * 메모리 : 15464KB / 시간 : 136MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2 {
  public static int MAX = Integer.MIN_VALUE;
  public static int MIN = Integer.MAX_VALUE;
  public static int N; // 수의 개수
  public static int[] number; // A1, A2, ---
  public static int[] operator = new int[4]; // 연산자 +, - , X, /

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    number = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }

    dfs(number[0], 1);

    System.out.println(MAX);
    System.out.println(MIN);
  }

  public static void dfs(int num, int idx) {
    if (idx == N) { // 수 개수 끝나면 리턴
      MAX = Math.max(MAX, num);
      MIN = Math.min(MIN, num);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operator[i] > 0) {
        operator[i]--; // 연산자 개수 하나씩 처리

        switch (i) {
          case 0 -> dfs(num + number[idx], idx + 1);
          case 1 -> dfs(num - number[idx], idx + 1);
          case 2 -> dfs(num * number[idx], idx + 1);
          case 3 -> dfs(num / number[idx], idx + 1);
        }
        operator[i]++;
      }
    }
  }
}
