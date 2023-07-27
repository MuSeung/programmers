package First.d3;

public class lv1ex17682 {

    public int solution(String dartResult) {
        int answer = 0;
        int count = 0;
        int[] number = new int[3];
        for (int i = 0; i < 12; i++) {
            if (dartResult.charAt(i) <= '9' && dartResult.charAt(i) >= '0') {
                number[count] = dartResult.charAt(i) - '0';
                if (dartResult.charAt(i + 1) == '0') {
                    number[count] = 10;
                    i++;
                }
            }

            else if (dartResult.charAt(i) == 'D') {
                number[count] = number[count] * number[count];
            }
            else if (dartResult.charAt(i) == 'T') {
                number[count] = number[count] * number[count] * number[count];
            }

            else if (dartResult.charAt(i) == '*') {
                number[count] = number[count] * 2;
                if(count>0){
                    number[count - 1] = number[count - 1] * 2;
                }
            }
            else if (dartResult.charAt(i) == '#') {
                number[count] = -number[count];
            }

            if(i+1 >= dartResult.length()){
                break;
            }
            if(dartResult.charAt(i+1) <= '9' && dartResult.charAt(i+1) >= '0'){
                count++;
            }
        }
        //System.out.println("1: "+number[0]+" 2: "+number[1]+" 3: "+number[2]);
        answer = number[0]+number[1]+number[2];
        return answer;
    }
}
