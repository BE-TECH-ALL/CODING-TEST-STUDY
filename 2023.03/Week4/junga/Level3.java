import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1253
public class Level3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        // 배열
        long [] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(A);

        // 투 포인터
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            long curN = A[i];

            while (start < end) {
                long sum = A[start] + A[end];
                if (sum == curN) { // curN은 좋은 수, 반복문 종료
                    if (start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                } else if (sum < curN) { // sum이 더 작으므로 start++
                    start++;
                } else { // sum이 더 크므로 end--
                    end--;
                }
            }
        }
        System.out.println(cnt);
    }
}
