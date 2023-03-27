/*
 * 문제 : 11659 - 구간합 구하기 / 난이도 : Silver3
 * 누적합 유형의 알고리즘
 * 이 문제에서 주어진 i와 j의 경우 인덱스 1부터 시작하는 부분에 주의해야한다.
 * 값을 받을 때, list[0] = 0으로 기본 세팅 해주고 진행한다.
 *
 * 메모리 : 58200KB / 시간 : 1488MS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level1 {
    public static int N;
    public static int M;

    public static int[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N + 1];
        list[0] = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < N + 1; i++) {
            list[i] = list[i - 1] + Integer.parseInt(st.nextToken()); // 누적합 적용
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(list[b] - list[a - 1]);
        }

    }
}
