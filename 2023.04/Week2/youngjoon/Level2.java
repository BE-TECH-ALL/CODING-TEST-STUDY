package Week2.youngjoon;

import java.io.*;
import java.util.*;

/**
 * 14888번 연산자 끼워넣기
 * 난이도 : 실버 1
 * 메모리 : 	15812KB / 시간 : 140ms
 * 백트레킹, 브루트포스
 */

public class Level2 {

    static int N;
    static int[] num;
    static int[] cal;

    static int max = Integer.MIN_VALUE; // 최솟값으로 설정
    static int min = Integer.MAX_VALUE; // 최댓값으로 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        cal = new int[4]; // 연산자는 4개이므로

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) { // 연산에 사용할 숫자 저장
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) { // 연산자 저장
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1); // 처음 숫자와 바로 다음 숫자를 연산하므로 idx 초기 값에 1 대입
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int number, int idx) { // 현재 숫자와 그 다음 숫자 매개변수로 입력
        if (idx == N) {
            max = Math.max(max, number);
            min = Math.min(min, number);
        }

        for (int i = 0; i < 4; i++) {
            if(cal[i] > 0) {
                cal[i]--; // 연산에 사용한 연산자는 -1 해준다.

                switch(i) {
                    case 0 : // idx++ 를 해버리면 현재 idx 값만 +1하고 idx+1 값을 dfs 에 대입하지 않게 된다.
                        dfs(number + num[idx], idx + 1);
                        break;
                    case 1 :
                        dfs(number - num[idx], idx + 1);
                        break;
                    case 2 :
                        dfs(number * num[idx], idx + 1);
                        break;
                    case 3 :
                        dfs(number / num[idx], idx + 1);
                        break;
                }
                cal[i]++; // dfs 를 빠져나오고 다른 경우의 수를 해봐야하므로 하나 전 상태로 만들기 위해서
                // 사용했던 연산자 숫자를 다시 +1 해준다.
            }
        }
    }
}
