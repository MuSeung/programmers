package lv1.day6;

public class ex5 {

    private int check(String candy, int position) {
        int sum = 0;
        for (int i = 1; i <= position; i++) {
            boolean ok = true;
            for (int j = 0; j < i; j++) {
                ok = false;
                if (candy.charAt(j) != candy.charAt(position - i + j)) {
                    break;
                }
                ok = true;
            }
            if (ok) {
                sum++;
            }
        }
        return sum;
    }

    public int[] solution(String candy, int[] positions) {
        int[] answer = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            answer[i] = check(candy, positions[i]) - 1;
        }
        return answer;
    }
}
