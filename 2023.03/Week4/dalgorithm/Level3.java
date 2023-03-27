/*
 * 문제 : 1253 - 좋다 / 난이도 : Gold4
 * 투포인터 활용하기
 * 둘 다 시작점으로 하면 안 풀린다. 처음과 끝으로 나눠서 해보기
 *
 * 메모리 : 14684KB / 시간 : 180MS
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Level3 {
  static int N;
  static int[] list;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    list = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int idx = 0;
    while (st.hasMoreTokens()) {
      list[idx++] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(list);

    for (int i = 0; i < N; i++) {
      int curNum = list[i];

      int start = 0; // 투포인터 시작
      int end = N - 1; // 투포인터 끝
      int sum = 0;

      while (start < end) {
        sum = list[start] + list[end];
        if (sum == curNum) {
          if (i == start)
            start++;
          else if (end == i) {
            end--;
          } else {
            answer++;
            break;
          }
        }

        if (list[start] + list[end] > curNum) { // 정렬된 상태이기 때문에 기준 숫자보다 크면 끝 idx를 줄여주기
          end--;
        } else if (list[start] + list[end] < curNum) {
          start++;
        }
      }

    }
    System.out.println(answer);
  }
}
