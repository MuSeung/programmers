package First.d2;

public class lv1ex77484 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0;
        int count = 0;
        for (int lotto : lottos) {
            if (0 == lotto) {
                count++;
            }
        }
        for (int num : win_nums) {
            for (int lotto : lottos) {
                if (num == lotto) {
                    match++;
                }
            }
        }
        answer[0] = 7 - match - count;
        answer[1] = 7 - match;
        if (answer[0] > 5) {
            answer[0] = 6;
        }
        if (answer[1] > 5) {
            answer[1] = 6;
        }
        return answer;
    }

}
