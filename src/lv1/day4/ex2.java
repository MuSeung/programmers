package lv1.day4;

import java.util.Arrays;

public class ex2 {

    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);
        int p = people.length - 1;
        int t = tshirts.length - 1;
        while (p >= 0 && t >= 0) {
            if(people[p]<=tshirts[t]){
                t--;
                p--;
                answer++;
            }
            else{
                t--;
            }
        }
        return answer;
    }
}
