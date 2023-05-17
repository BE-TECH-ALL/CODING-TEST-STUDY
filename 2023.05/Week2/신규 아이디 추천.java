/*
 * 문제 : 신규 아이디 추천(Level1)
 * 정규표현식 활용
 * */

class Solution {
	public String solution(String new_id) {

		// 1단계, 대문자를 소문자로 치환
		new_id = new_id.toLowerCase();

		// 2단계, []: 대괄호 내 문자 중 하나, ^: 괄호 안에 있는 경우 뒤의 패턴에 일치하지 않는 것을 선택(^가 괄호 밖에 있으면 문자열의 시작을 표현)
		new_id = new_id.replaceAll("[^-_.a-z0-9]","");

		// 3단계, {n,m}: n개 이상, m개 이하
		new_id = new_id.replaceAll("[.]{2,}",".");

		// 4단계, ^: 문자열의 시작을 표현, |: 또는, $: 문자열의 끝을 표현
		new_id = new_id.replaceAll("^[.]|[.]$","");

		// 5단계
		if(new_id.equals(""))
			new_id += "a";

		// 6단계
		if(new_id.length() >= 16){
			new_id = new_id.substring(0,15);
			new_id = new_id.replaceAll("[.]$","");
		}

		// 7단계
		if(new_id.length() <= 2)
			while(new_id.length() < 3)
				new_id += new_id.charAt(new_id.length()-1);

		return new_id;
	}
}
