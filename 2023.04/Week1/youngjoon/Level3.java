package youngjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1717번 집합의 표현
 * 유니온 파인드
 * 메모리: 53832KB  / 시간: 1452ms
 */

public class Level3 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union(a, b);
            } else {
                if (isUnion(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }

    public static int find(int x) {
        if (arr[x] == x) return x;

        return arr[x] = find(arr[x]);
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        arr[B] = A;
    }

    public static boolean isUnion(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return true;

        return false;
    }
}