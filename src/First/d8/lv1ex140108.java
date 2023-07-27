package First.d8;

public class lv1ex140108 {

    public int solution(String s) {
        int answer = 1;
        char now = '`';
        int nowCount = 0;
        int difCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (nowCount == 0) {
                now = s.charAt(i);
                nowCount++;
            } else if (now == s.charAt(i)) {
                nowCount++;
            } else {
                difCount++;
                if (difCount == nowCount) {
                    nowCount = 0;
                    difCount = 0;
                    answer++;
                }
            }
        }
        return answer;
    }
}
