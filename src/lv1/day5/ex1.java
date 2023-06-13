package lv1.day5;

import java.util.HashMap;
import java.util.Map.Entry;

public class ex1 {

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (count.containsKey(clothes[i][1])) {
                count.put(clothes[i][1], count.get(clothes[i][1]) + 1);
            } else {
                count.put(clothes[i][1], 2);
            }
        }
        for (Entry<String, Integer> entrySet : count.entrySet()) {
            answer *= entrySet.getValue();
        }
        return answer - 1;
    }
}
