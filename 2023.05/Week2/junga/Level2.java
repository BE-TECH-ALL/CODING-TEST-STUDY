// 2. 신규 아이디 추천 - 프로그래머스
// https://school.programmers.co.kr/learn/courses/30/lessons/72410

import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        // step 1
        new_id = new_id.toLowerCase();
        
        // step 2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // step 3
        new_id = new_id.replaceAll("[.]{2,}", ".");
        
        //step 4
        if (!new_id.equals("") && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        
        if (!new_id.equals("") && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // step 5
        if (new_id.equals("")) {
            new_id = "a";
        }
        
        // step 6
        if (new_id.length() >= 16) {
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            } else {
                new_id = new_id.substring(0, 15);
            }
        }
        
        // step 7
        if (new_id.length() <= 2) {
            char end = new_id.charAt(new_id.length() - 1);
            for (int len = new_id.length(); len < 3; len++) {
                new_id += String.valueOf(end);
            }
        }
        
        return new_id;
    }
}
