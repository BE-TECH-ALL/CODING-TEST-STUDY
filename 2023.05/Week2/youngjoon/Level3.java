import java.util.*;

/*
 * 문제 : 키패드 누르기 / 난이도 : Level1
 */

class Solution {
    public String solution(int[] numbers, String hand) {

        ArrayList<String> list = new ArrayList<>();
        // 키패드 위치를 좌표로 이차원 배열에 할당
        int[][] arr = new int[12][2];
        arr[0][0] = 1; arr[0][1] = 0;
        arr[1][0] = 0; arr[1][1] = 3;
        arr[2][0] = 1; arr[2][1] = 3;
        arr[3][0] = 2; arr[3][1] = 3;
        arr[4][0] = 0; arr[4][1] = 2;
        arr[5][0] = 1; arr[5][1] = 2;
        arr[6][0] = 2; arr[6][1] = 2;
        arr[7][0] = 0; arr[7][1] = 1;
        arr[8][0] = 1; arr[8][1] = 1;
        arr[9][0] = 2; arr[9][1] = 1;

        int curLeft = 0; // 키패드를 누른뒤의 현재 손의 위치
        int curRight = 0;

        for (int i = 0; i < numbers.length; i++) {
            switch(numbers[i]) {
                case 1, 4, 7 : // 1,4,7은 왼손
                    list.add("L");
                    curLeft = numbers[i];
                    break;
                case 3, 6, 9 : // 3,6,9는 오른손
                    list.add("R");
                    curRight = numbers[i];
                    break;
                case 0, 2, 5, 8 : // 거리 비교후 왼손 오른손 결정
                    int leftLength // 멘하탄 거리 방식 사용. 각각의 좌표값을 뺀후 제곱후 제곱근 하는 원래 방식을 쓰면 틀리게 나옴.
                        // 왜 그런지 정확한 이유는 잘 모르겠음
                        = Math.abs(arr[numbers[i]][0] - arr[curLeft][0])
                        + Math.abs(arr[numbers[i]][1] - arr[curLeft][1]);
                    int rightLength
                        = Math.abs(arr[numbers[i]][0] - arr[curRight][0])
                        + Math.abs(arr[numbers[i]][1] - arr[curRight][1]);
                    if (leftLength < rightLength) {
                        list.add("L");
                        curLeft = numbers[i];
                    } else if (leftLength == rightLength) { // 거리가 같은 경우, 왼손잡이 오른손잡이로 판단
                        if (hand.equals("left")) {
                            list.add("L");
                            curLeft = numbers[i];
                        } else if (hand.equals("right")) {
                            list.add("R");
                            curRight = numbers[i];
                        }
                    } else {
                        list.add("R");
                        curRight = numbers[i];
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder(); // 빠른 출력을 위해서
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}