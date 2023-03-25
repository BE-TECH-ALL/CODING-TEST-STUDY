import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		int answer = 0;

		//n 개 숫자 입력
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		//입력된 배열 오름차순 정렬
		Arrays.sort(arr);

		//투포인트 알고리즘 사용
		for (int i = 0; i < n; i++) {
			int p1 = 0;
			int p2 = n - 1;
			while(p1 < p2){
				if(arr[p1] + arr[p2] < arr[i]) p1++;
				else if (arr[p1] + arr[p2] > arr[i]) p2--;
				else {
					//해당 숫자를 제외한 나머지 두수의 합으로 좋은 수를 결정해야 하므로 자신의 인덱스는 넘김
					if(i == p1) p1++;
					else if(i == p2) p2--;
					else{
						answer++;
						break;
					}
				}
			}
		}

		//출력
		System.out.println(answer);
	}
}
