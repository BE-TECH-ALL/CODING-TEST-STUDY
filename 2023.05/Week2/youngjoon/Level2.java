/*
 * 문제 : 신규 아이디 추천 / 난이도 : Level1
 * 정규식
 */

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); // 1단계 : 소문자로 변경
        new_id = new_id.replaceAll("[^-_.a-z0-9]", ""); // 2단계 : '!', '@', '#', '*' 문자 제거
        new_id = new_id.replaceAll("[.]{2,}", "."); // 3단계 : . 이 2개 이상인 것들을 . 하나로 변경
        new_id = new_id.replaceAll("^[.]|[.]$", ""); // 4단계 : . 이 처음이나 끝에 있으면 제거

        if (new_id.equals("")) { // 5단계 : 위의 과정을 거쳐서 빈 문자열이 된다면 a 대입
            new_id += "a";
        }

        if (new_id.length() >= 16) { // 6단계 : 16자 이상인 경우
            new_id = new_id.substring(0, 15); // 첫 15개 문자 제외하고 전부 제거
            new_id = new_id.replaceAll("[.]$",""); // 제거 후 끝에 . 이 있으면 제거
        }

        if (new_id.length() <= 2) { // 7단계 : 2자 이하인 경우
            while (new_id.length() < 3) { // 길이가 3이 될때까지
                new_id += new_id.charAt(new_id.length()-1); // 마지막 문자를 이어 붙임
            }
        }

        return new_id;

    }
}