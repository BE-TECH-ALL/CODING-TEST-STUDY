package Week3.youngjoon;

import java.io.*;
import java.util.*;

/**
 * 9252번 LCS2
 * 난이도 : 골드 4
 * 메모리 : 18436KB / 시간 : 156ms
 * dp
 */

public class Level3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c1 = br.readLine().toCharArray(); // 문자열의 단어를 비교하므로 char 배열로 자료구조 구성
        char[] c2 = br.readLine().toCharArray();

        int[][] dp = new int[c1.length + 1][c2.length + 1];

        //   A C A Y K P
        // C 0 1 1 1 1 1
        // A 1 1 2 2 2 2
        // P 1 1 2 2 2 3
        // C 1 2 2 2 2 3
        // A 1 2 3 3 3 3
        // K 1 2 3 3 4 4

        // 위와같은 2차원 배열을 dp 라고 만든다.
        // 문자가 같으면 숫자를 1 증가시킨다.
        // 아닌 경우에는 하나작은 열이나 행의 크기를 비교해서 큰 값을 넣는다.
        // 전의 값으로 다음 값을 구하므로 DP 문제

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[c1.length][c2.length]);
        // 가장 마지막은 가장 큰값에서 옆이나 아래로 이동한 경우이므로
        // c1.length, c2.length 와 같이 끝값을 대입한다.

        // 여기서부터는 다시 역으로 찾아올라간다.
        // 열과 행의 문자가 같다면, 리스트에 추가후 대각선으로 이동한다.
        // (열 크기 - 1, 행 크기 - 1)
        // 다르다면 하나 작은 열과 행을 비교해서 dp의 값이 큰 인덱스 좌표로 간다.
        // 열 - 1 의 크기가 큰 경우 -> 열 크기 - 1
        // 행 - 1 의 크기가 큰 경우 -> 행 크기 - 1

        int col = c1.length;
        int row = c2.length;

        ArrayList<Character> list = new ArrayList<>();

        while(dp[col][row] != 0) {
            if (c1[col - 1] == c2[row - 1]) {
                list.add(c1[col - 1]);
                col--;
                row--;
            } else {
                if (dp[col - 1][row] >= dp[col][row - 1]) {
                    col--;
                } else {
                    row--;
                }
            }
        }
        StringBuilder sb = new StringBuilder(); // 빠른 속도를 위해서
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        } // 역으로 출력한다.

        System.out.println(sb);
    }
}
