package d7;

public class lv1ex136798 {

    public int counting(int number) {
        int cnt = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                cnt++;
            } else if (number % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = counting(i);
            //System.out.print(i + ": " + cnt);
            if (cnt <= limit) {
                answer += cnt;
            } else {
                answer += power;
            }
            //System.out.println( ",  " + answer);
        }
        return answer;
    }

}
