package Week4.dalgorithm;

/*
 * 문제 : 10819 - 차이를 최대로 / 난이도 : Silver2
 * 백트래킹
 * 
 * 메모리 : 15148KB / 시간 : 152MS
 */

import java.util.*;
import java.io.*;

public class Level2 {
  static int N;
  static int[] arr;
  static boolean[] visited;
  static int ans = Integer.MIN_VALUE;
  static int[] generated;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    generated = new int[N];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    getPermutation(0);
    System.out.println(ans);
  }

  private static int getSum(int[] arr) {
    int ans = 0;
    for (int i = 0; i < N - 1; i++) {
      ans += Math.abs(arr[i] - arr[i + 1]);
    }
    return ans;
  }

  private static void getPermutation(int depth) { // 백트래킹
    if (depth == N) { // 갯수가 n인일 때, 차이 최대로
      ans = Math.max(ans, getSum(generated));
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        generated[depth] = arr[i];
        visited[i] = true;
        getPermutation(depth + 1);
        visited[i] = false;
      }
    }
  }
}