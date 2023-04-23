package Week3.youngjoon;

import java.io.*;

/**
 * 13241번 다음 소수
 * 난이도 : 실버 4
 * 메모리 : 15092KB / 시간 : 296ms
 * 소수판정, 브루트포스
 */

public class Level1 {

    static int[] prime = new int[63250]; // 에라토네스의 채를 이용한다. 4 * 10^9 는 int 범위를 넘어가므로,
    // sqrt(4 * 10^9) = 약 63250 이므로 배열의 크기를 63250으로 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean isPrime = false;

        for (int i = 0; i < 63250; i++) {
            prime[i] = 1; // 일단 모든 숫자를 소수라고 표시. 1은 소수
        }

        prime[0] = 0;
        prime[1] = 0;

        for (int i = 2; i < 63250; i++) { // 소수는 2부터 시작하므로
            for (int j = 2; i * j < 63250; j++) { // 곱해서 나온 숫자는 모두 소수가 아니다.

                prime[i * j] = 0; // prime[i * j] 는 소수가 아니므로 0으로 값을 바꾼다.
            }
        }

        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(br.readLine());
            if (a <= 1) { // 0, 1 보다 큰 가장 작은 소수는 2
                System.out.println(2);
            } else {
                for (long j = a; ;  j++) { // j의 범위는 만들지 않는다. 대신에 ;를 안넣었더니 오류나서 넣어줌
                    int b = (int)Math.sqrt(j); // 에라토네스 채 이용. 게다가 sqrt 안하면 int 범위를 넘는다.
                    isPrime = true;

                    for (int k = 1; k <= b; k++) { // b 까지의 값을 돌린다.
                        // b 까지도 j의 약수가 아니라면 j는 소수이고, 그때의 j는 b보다 큰 가장 작은 소수가 된다.
                        if (prime[k] == 1) { // 만약 그값이 소수라면,
                            if (j % k == 0) { // j 의 약수인지 확인한다.
                                isPrime = false; // k 약수라면, j는 소수가 아니므로 false 처리
                                break;
                            }
                        }
                    }

                    if (isPrime) { // 위를 통과했는데 소수라면, 약수가 없었다는 말이니까, 출력한다.
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
    }
}
