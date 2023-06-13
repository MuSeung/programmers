package lv1.day2;

import java.util.ArrayList;

public class ex3 {

    public class state {

        int point1;
        int point2;
        int sum;

        public void addPoint(int[] sequence, int point, int k) {
            if (sequence[point] + sum > k) {
                minusPoint(point, sequence[point], sequence[point2]);
            } else {
                plusPoint(point, sequence[point]);
            }
        }

        public void plusPoint(int point, int x) {
            point1 = point;
            sum = sum + x;
        }

        public void minusPoint(int point, int x, int y) {
            point1 = point;
            point2 = point2 - 1;
            sum = sum + x - y;
        }

        public boolean isAnswer(int k) {
            return k == sum;
        }

        state(int lastPoint) {
            point1 = 0;
            this.point2 = lastPoint;
            sum = 0;
        }

    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        state nowState = new state(sequence.length - 1);
        for (int i = sequence.length - 1; i > -1; i++) {
            nowState.addPoint(sequence, i, k);
            if (nowState.isAnswer(k)) {
                break;
            }
        }
        answer[0] = nowState.point1;
        answer[1] = nowState.point2;
        if (sequence[nowState.point1] == sequence[nowState.point2]) {
            int difference = answer[1] - answer[0];
            for (int i = nowState.point1; i > -1; i--) {
                if (sequence[i] == sequence[nowState.point1]) {
                    answer[0] = i;
                    answer[1] = answer[1] + difference;
                }
            }
        }
        return answer;
    }

}
