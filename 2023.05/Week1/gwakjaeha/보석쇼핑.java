/*
 * 문제 : 프로그래머스 보석 쇼핑(Level3)
 * 투포인트와 유사한 알고리즘 활용
 * */

import java.util.*;

class Solution {
	public int[] solution(String[] gems) {

		HashMap<String,Integer> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		int start = 0;
		int minSize = gems.length;
		int minStart = 0;

		// 총 보석의 종류 수를 확인함
		for(int i = 0; i < gems.length; i++){
			set.add(gems[i]);
		}

		for(int i = 0; i < gems.length; i++){
			// gems 에서 맨 앞에서부터 하나씩 꺼내 map 에 넣음
			map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
			// 구매를 시작하는 진열대 인덱스를 업데이트 함
			// 시작 인덱스에 해당하는 보석이 map 에 2개 이상 있으면, 시작 인덱스 값을 +1 함 (해당 인덱스의 보석은 필요없으므로)
			while(true){
				if(map.get(gems[start]) > 1){
					map.put(gems[start], map.get(gems[start]) - 1);
					start++;
					continue;
				}
				break;
			}
			// 만약 map 과 set 의 길이가 같으면 모든 보석 종류를 포함하는 시작, 끝 인덱스라는 것을 의미함
			if(map.size() == set.size()) {
				// 해당 시작, 끝 인덱스가 가장 짧은 구간인지 확인하고 업데이트함
				if(minSize > i - start + 1){
					minSize = i - start + 1;
					minStart = start;
				}
			}
		}


		int[] answer = new int[2];
		answer[0] = minStart + 1; // 진열대 번호 = 인덱스 + 1 이므로
		answer[1] = minStart + minSize;

		return answer;
	}
}
