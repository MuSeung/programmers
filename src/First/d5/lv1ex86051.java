package First.d5;

public class lv1ex86051 {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int number : numbers){
            answer -= number;
        }
        return answer;
    }

}
