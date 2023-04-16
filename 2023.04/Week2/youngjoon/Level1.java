package Week2.youngjoon;

import java.io.*;
import java.util.*;

/**
 * 2217번 로프
 * 난이도 : 실버 4
 * 메모리 : 27192KB / 시간 : 416ms
 * 그리디
 */

public class Level1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }

        Collections.sort(list); // 작은 값부터 비교해보기 위해서 오름차순 정렬

        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i) * (list.size() - i);
            // 5, 10, 20 인 경우 5를 3번 하는 것보다 10을 2번하는 경우가 크므로,
            // 작은 값부터 비교하면서 max 를 바꿈
            if (sum >= max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
