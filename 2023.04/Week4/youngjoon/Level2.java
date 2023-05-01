package Week4.youngjoon;

import java.io.*;
import java.util.*;

/**
 * 10819번 차이를 최대로
 * 난이도 : 실버 2
 * 메모리 : 15188KB / 시간 : 148ms
 * 브루트포스, 백트래킹
 */

public class Level2 {

    static int N;
    static int[] arr;
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr2 = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
        System.out.println(max);
    }

    public static void backTracking(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(arr2[i] - arr2[i+1]);
            }
            max = Math.max(sum, max);
        }

        for (int i = 0; i < N; i++) { // 모든 경우의 수를 백트레킹으로 순회한다.
            if (visit[i]) continue;
            arr2[depth] = arr[i];
            visit[i] = true; // 일단 탐색하는 한가지 경우의 수에 들어간 경우 방문처리
            backTracking(depth + 1);
            visit[i] = false; // N까지 도달 후에는 다시 다른 경우의 수를 탐색하기 위해서
        }
    }
}