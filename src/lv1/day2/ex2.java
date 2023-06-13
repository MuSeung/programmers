package lv1.day2;

import java.util.ArrayList;

public class ex2 {

    public int[] solution(int[] sequence, int k) {
        ArrayList<Integer> que = new ArrayList<>();
        int[] answer = new int [2];
        int stopPoint = -1;
        for (int now = sequence.length; now > -1; now--) {
            if(stopPoint != -1 && stopPoint != sequence[now]){
                break;
            }
            if(sequence[now] == k){
                answer[1] = now;
                answer[0] = now;
                stopPoint = sequence[now];
            }
            int deletePoint = -1;
            for (int i = 0; i < que.size(); i++) {
                if (que.get(i) + sequence[now] > k) {
                    deletePoint = i;
                }
                if (que.get(i) + sequence[now] == k) {
                    deletePoint = i;
                    stopPoint = sequence[now];
                    answer[0] = now - i + que.size();
                    answer[1] = now;
                }
                if (que.get(i) + sequence[now] < k) {
                    que.set(i, que.get(i) + sequence[now]);
                }
            }
            for (int i = 0; i < deletePoint + 1; i++) {
                que.remove(0);
            }
            que.add(sequence[now]);
        }

        return answer;
    }
}
