package lv1.day5;

import java.util.HashMap;

public class ex2 {

    private int bellColor(int bell) {
        if (bell == 2) {
            return -1;
        }
        return 1;
    }

    private int bigger(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int solution(int[] bell) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumHash = new HashMap<>();
        for (int i = 0; i < bell.length; i++) {
            sum += bellColor(bell[i]);
            System.out.print(sum +" ");
            if (sum == 0) {
                answer = bigger(answer, i + 1);
                continue;
            }

            if (sumHash.containsKey(sum)) {
                answer = bigger(answer, i - sumHash.get(sum));
            } else {
                sumHash.put(sum, i);
            }
        }
        return answer;
    }
}
