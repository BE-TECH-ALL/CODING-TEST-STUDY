/*
 * 문제 : 2217 - 로프 / 난이도 : Silver4
 * 그리디 알고리즘
 * 
 * 메모리 : 25812KB / 시간 : 328MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Level1 {
  static int n;
  static int max;
  static int[] array;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(array); // 로프 중량 오름차순 정렬
    max = Integer.MIN_VALUE;

    // 특정 로프를 사용할 경우,
    // 그 로프보다 무게가 큰 로프를 모두 사용하는 것이 이득이다.
    // 따라서, 최대 무게 w는 array[i] * (n - i)
    for (int i = 0; i < n; i++) {
      max = Math.max(max, array[i] * (n - i));
    }

    System.out.println(max);
  }
}
