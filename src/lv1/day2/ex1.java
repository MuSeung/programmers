package lv1.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ex1 {

    public class answerExpectation {

        int result1;
        int result2;

        answerExpectation(int a, int b) {
            result1 = a;
            result2 = b;
        }
    }

    public int[] solution(int[] sequence, int k) {
        ArrayList<Integer> que = new ArrayList<>();
        int minimum = 1000001;
        ArrayList<answerExpectation> answerList = new ArrayList<>();
        for (int now = 0; now < sequence.length; now++) {
            int deletePoint = -1;
            for (int i = 0; i < que.size(); i++) {
                if (que.get(i) + sequence[now] > k) {
                    deletePoint = i;
                }
                if (que.get(i) + sequence[now] == k) {
                    deletePoint = i;
                    answerList.add(new answerExpectation(now + i - que.size(), now));
                    if (minimum > que.size() - i) {
                        minimum = que.size() - i;
                    }
                }
                if (que.get(i) + sequence[now] < k) {
                    que.set(i, que.get(i) + sequence[now]);
                }
            }
            for (int i = 0; i < deletePoint + 1; i++) {
                que.remove(0);
            }
            if (minimum < que.size()) {
                for (int i = 0; i < minimum; i++) {
                    que.remove(0);
                }
            }
            que.add(sequence[now]);
        }
        if(que.get(que.size() - 1) == k){
            answerList.add(new answerExpectation(sequence.length - 1, sequence.length - 1));
        }
        Collections.sort(answerList, new Comparator<answerExpectation>() {
            @Override
            public int compare(answerExpectation o1, answerExpectation o2) {
                if ((o1.result2 - o1.result1) - (o2.result1 - o2.result2) == 0) {
                    return o1.result1 - o2.result1;
                }
                return (o1.result2 - o1.result1) - (o2.result2 - o2.result1);
            }
        });

        int[] answer = {answerList.get(0).result1, answerList.get(0).result2};
        return answer;
    }

}
