package Week5.youngjoon;

/*
 * 2503번 - 숫자 야구
 * 브루트포스
 * 메모리: 83356KB / 시간: 400ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Level1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> numberList = new ArrayList<>();
        int[] strike = new int[N];
        int[] ball = new int[N];

        for (int i = 0; i < N; i++) { // 추측한 숫자와 결과 저장
            st = new StringTokenizer(br.readLine(), " ");
            numberList.add(Integer.parseInt(st.nextToken()));
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 123; i <= 987; i++) { // 브루트포스로 모두 검사

            int cnt = 0;

            if (String.valueOf(i).charAt(0) == String.valueOf(i).charAt(1) ||
                String.valueOf(i).charAt(1) == String.valueOf(i).charAt(2) ||
                String.valueOf(i).charAt(0) == String.valueOf(i).charAt(2) ||
                String.valueOf(i).charAt(1) == '0' ||
                String.valueOf(i).charAt(2) == '0') {
                continue; // 자릿수가 중복되는 숫자의 경우 제외 (ex : 244), 0 들어가는 경우 제외
            }

            for (int j = 0; j < N; j++) {

                int tempStrike = 0;
                int tempBall = 0;

                for (int k = 0; k < 3; k++) {
                    if (String.valueOf(numberList.get(j)).charAt(k) == String.valueOf(i).charAt(k)) {
                        tempStrike++; // 자리와 숫자 모두 일치하는 경우
                    }
                }

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (String.valueOf(numberList.get(j)).charAt(k) == String.valueOf(i).charAt(l)) {
                            if (k != l) { // 자리는 일치하지 않지만 숫자는 일치하는 경우
                                tempBall++;
                            }
                        }
                    }
                }

                if (tempStrike == strike[j] && tempBall == ball[j]) {
                    cnt++; // strike, ball 의 값과 일치하는 경우
                }
            }

            if (cnt == N) {
                ans++; // 추측한 숫자와 strike, ball 값까지 모두 만족하는 123 ~ 987 사이 숫자의 갯수
            }
        }

        System.out.println(ans);
    }
}
