package Week4.youngjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Level3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        Arrays.sort(arr); // 투 포인터 사용을 위해서 오름차순 정렬

        for (int i = 0; i < N; i++) {
            int l = 0;
            int r = N - 1;

            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    if (i == l) l++; // 본인이 아닌 다른 두 수의 합으로 나타내야 하므로, 본인의 자리인 경우 넘김
                    else if (i == r) r--;
                    else {
                        cnt++;
                        break;
                    }
                } else if (sum < arr[i]) l++; // sum 값이 작으면 오름차순에서 l값을 올려서 sum 값을 증가시킴
                else r--; // sum 이 큰경우에는 r값을 줄임
            }
        }
        System.out.println(cnt);
    }
}