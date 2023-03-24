package Week4.ryureeru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Level3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			long sum = 0;
			while (left < right) {
				sum = arr[left] + arr[right];
				if (sum == arr[i]) {
					if (left != i && right != i) {
						count++;
						break;
					} else if (left == i) {
						left++;
					} else {
						right--;
					}

				} else if (sum < arr[i]) {
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println(count);
	}

}
