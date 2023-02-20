package lv1.day1;


import java.util.ArrayList;
import java.util.List;

public class ex155652 {

    public String solution(String s, String skip, int index) {
        List<String> nonSkipList = new ArrayList<>();
        String answer = "";
        for (char i = 'a'; i <= 'z'; i++) {
            nonSkipList.add(""+i);
        }
        for (int i = 0; i < skip.length(); i++) {
            nonSkipList.remove(""+skip.charAt(i));
        }
        int size = nonSkipList.size();
        for (int i = 0; i < s.length(); i++) {
            int num = nonSkipList.indexOf(""+s.charAt(i)) + index;
            num = num % size;
            answer += nonSkipList.get(num);

        }
        return answer;
    }

}
