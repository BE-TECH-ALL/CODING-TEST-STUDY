import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Level1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			long num = Long.parseLong(br.readLine());
			var bi = new BigInteger(String.valueOf(num));

			if (bi.isProbablePrime(10)) {
				// isProbablePrime();
				// 확률적 소수 판별 함수, 인자가 10인 경우 소수일 확률이 0.9990234375정도이므로 웬만한 큰 수의 소수는 판별할 수 있다.
				System.out.println(num);
			} else {
				System.out.println(bi.nextProbablePrime());
				// nextProbablePrime(), num 다음으로 큰 소수를 알려줌
			}
		}
		br.close();
	}
}