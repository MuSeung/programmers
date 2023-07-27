package First.d17;

import java.util.ArrayList;

public class lv1ex12906 {

    public int[] solution(int[] arr) {
        int before = -1;
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int number : arr) {
            if (before != number) {
                answerList.add(number);
                before = number;
            }
        }
        return answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

}
