package d15;

public class lv1ex77884 {

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer += i;
            if (Math.sqrt(i) == (int) Math.sqrt(i)) {
                answer -= i * 2;
            }
        }
        return answer;
    }

}
