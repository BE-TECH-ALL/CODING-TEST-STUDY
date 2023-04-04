package Week5.youngjoon;

/*
 * 1976번 - 여행가자
 * 유니온 파인드
 * 메모리: 17468KB / 시간: 192ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level3 {
    
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i; // union 기본 세팅
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int visit = Integer.parseInt(st.nextToken());
                if (visit == 1) { // 연결되어있는지 확인
                    union(i, j); // 연결되어있다면 하나의 union 으로 묶는다.
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        
        int init = find(Integer.parseInt(st.nextToken())); // 처음 출발하는 도시
        for (int i = 1; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());

            if (init != find(city)) { // 처음 출발하는 도시와 같은 union 에 있는지 확인한다.
                System.out.println("NO"); // 하나라도 같은 union 이 아니라면 NO 출력
                return;
            }
        }

        System.out.println("YES"); // for 문을 통과했다면 전부 이어져 있으므로 YES 출력
    }

    static int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        
        arr[B] = A;
    }
}
