/*
 * 문제 : 키패드 누르기(Level1)
 * HashMap 활용
 * */

import java.util.*;

class Solution {

	public static HashMap<Integer, Integer[]> map;
	public static Integer[] leftPos;
	public static Integer[] rightPos;
	public static String answer;

	public String solution(int[] numbers, String hand) {
		answer = "";

		// 각 숫자별 자판의 위치 지정
		map = new HashMap<>();
		map.put(1, new Integer[]{0,0});
		map.put(2, new Integer[]{0,1});
		map.put(3, new Integer[]{0,2});
		map.put(4, new Integer[]{1,0});
		map.put(5, new Integer[]{1,1});
		map.put(6, new Integer[]{1,2});
		map.put(7, new Integer[]{2,0});
		map.put(8, new Integer[]{2,1});
		map.put(9, new Integer[]{2,2});
		map.put(0, new Integer[]{3,1});

		leftPos = new Integer[]{3,0};
		rightPos = new Integer[]{3,2};

		for(int i = 0; i < numbers.length; i++){
			moveCloseHand(numbers[i], hand);
		}

		return answer;
	}

	// 엄지손가락을 이동시키는 함수
	public static void moveCloseHand(Integer number, String hand){
		// 1, 4, 7 의 경우 왼손 엄지손가락 사용
		if(number == 1 || number == 4 || number == 7){
			leftPos = map.get(number);
			answer += "L";
			return;
		}

		// 3, 6, 9 의 경우 오른쪽 엄지손가락 사용
		if(number == 3 || number == 6 || number == 9){
			rightPos = map.get(number);
			answer += "R";
			return;
		}

		// 2, 5, 8, 0 의 경우 가까운 엄지손가락 사용
		int leftDistance = getDistance(leftPos, number);
		int rightDistance = getDistance(rightPos, number);

		if(leftDistance < rightDistance){
			leftPos = map.get(number);
			answer += "L";
		} else if (leftDistance > rightDistance){
			rightPos = map.get(number);
			answer += "R";
		} else {
			if(hand.equals("left")) {
				leftPos = map.get(number);
				answer += "L";
			} else {
				rightPos = map.get(number);
				answer += "R";
			}
		}
	}

	// 엄지손가락과 숫자 사이의 거리를 측정하는 함수
	public static int getDistance(Integer[] pos, Integer number){
		return Math.abs(pos[0] - map.get(number)[0])
			+ Math.abs(pos[1] - map.get(number)[1]);
	}

}