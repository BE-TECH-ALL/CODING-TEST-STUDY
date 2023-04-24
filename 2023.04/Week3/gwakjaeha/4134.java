/*
 * 문제 : 4134 - 다음 소수 / 난이도 : Silver4
 * 소수 판별
 *
 * 메모리 : 101844KB / 시간 : 892ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			BigInteger n = new BigInteger(st.nextToken());

			if(n.isProbablePrime(10)){ // 해당 숫자가 소수인지 판별
				System.out.println(n);
			} else {
				System.out.println(n.nextProbablePrime()); // 해당 숫자 바로 다음의 소수 출력
			}
		}
		br.close();
	}
}