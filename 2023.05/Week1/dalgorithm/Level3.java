package dalgorithm;

/*
 * 문제 : 67258 - 보석 쇼핑 / 난이도 : Level3
 * 2020 카카오 인턴십
 */

import java.util.*;

public class Level3 {
  public int[] solution(String[] gems) {
    Map<String, Integer> gemCount = new HashMap<>();
    Queue<String> selectedGems = new LinkedList<>();
    Set<String> gemSet = new HashSet<>(Arrays.asList(gems));

    int start = 0;
    int end = Integer.MAX_VALUE;
    int startPoint = 0; // 시작지점(answer)

    for (String gem : gems) {
      gemCount.put(gem, gemCount.getOrDefault(gem, 0) + 1);
      selectedGems.add(gem); // 선택한 보석리스트에 gem 추가

      while (true) {
        // selectedGems에 제거할만한 gem있는지 확인
        String targetGem = selectedGems.peek();

        if (gemCount.get(targetGem) <= 1) {
          break;
        }

        // 제거 조건 : gem 2개이상 보유
        selectedGems.poll();
        start++;
        gemCount.put(targetGem, gemCount.get(targetGem) - 1);
      }

      // 모든 종류 보석 다 가지고 있고 사이즈 동일 시,
      if (gemCount.size() == gemSet.size() && end > selectedGems.size()) {
        startPoint = start;
        end = selectedGems.size();
      }
    }
    return new int[] { startPoint + 1, startPoint + end };
  }
}