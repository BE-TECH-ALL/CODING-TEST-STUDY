import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] accumulatedSum = new int[n+1];

		//입력한 n개 숫자의 누적합을 저장
		for (int k = 1; k <= n; k++) {
			accumulatedSum[k] = accumulatedSum[k-1] + sc.nextInt();
		}

		int[] answer = new int[m];

		//누적합의 차이를 통해 i 부터 j 까지의 합을 계산
		for (int k = 0; k < m; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			answer[k] = accumulatedSum[j] - accumulatedSum[i-1];
		}

		for (int k = 0; k < m; k++) {
			System.out.println(answer[k]);
		}
	}
}
