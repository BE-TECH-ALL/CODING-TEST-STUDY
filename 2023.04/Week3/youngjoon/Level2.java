package Week3.youngjoon;

import java.io.*;

/**
 * 4779번 칸토어 집합
 * 난이도 : 실버 3
 * 메모리 : 23976KB / 시간 : 328ms
 * 재귀, 분할 정복
 */

public class Level2 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            sb = new StringBuilder();
            int n = Integer.parseInt(s);

            int num = 1;
            for (int i = 0; i < n; i++) {
                num *= 3;
            }

            for (int i = 0; i < num; i++) { // 일단 '-' 를 넣어준다.
                sb.append('-');
            }

            recursion(1, num); // 3 으로 나누는 과정을 편하게 하려고 1부터 시작
            System.out.println(sb.toString());
        }
    }

    public static void recursion(int a, int b) { // 분할하려는 첫인덱스와 끝인덱스로 함수를 구성했다.
        if (a == b) { // 첫과 끝이 같으면 더이상 분할 가능하지 않으므로 return 한다.
            return;
        }

        int c = (b - a + 1) / 3; // 분할 하려는 구간의 크기를 구한다.
        // 예를 들어 1부터 27까지 있다면, 9가 잘라내야하는 크기이다.

        for (int i = ((a + b) / 2) - ((c - 1) / 2) - 1; i < ((a + b) / 2) + ((c - 1) / 2); i++) {
            sb.setCharAt(i, ' ');
        } // (a + b) / 2 는 자르는 구간의 중심이다. 중심으로 부터 (c - 1) / 2 만큼 작고, 큰 구간 까지 자른다.
        // 1 ~ 9 라면, 5가 중심이고, 1작은 4까지, 1큰 6까지 자른다.

        int d = ((a + b) / 2) - ((c - 1) / 2) - 1; // 자른 구간의 가장 작은 인덱스 보다 하나 더 작은 값.
        int e = ((a + b) / 2) + ((c - 1) / 2) + 1;// 자른 구간의 가장 작은 인덱스 보다 하나 더 큰 값.

        recursion(a, d); // 재귀를 돌린다.
        recursion(e, b);
    }
}
