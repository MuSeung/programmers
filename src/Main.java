import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
            Main a = new Main();
            String[] players = {"mumu", "soe", "poe", "kai", "mine"};
            String[] callings = {"kai", "kai", "mine", "mine"};
            System.out.println(a.solution(players, callings));
    }
    public String[] solution(String[] players, String[] callings) {
        Map<String, String[]> racing = new HashMap<>();
        for (int i = 1; i < players.length - 1; i++) {
            racing.put(players[i], new String[] {players[i - 1], players[i + 1]});
        }
        String last = players[players.length - 1];
        String first = players[0];
        racing.put(first,new String[] {" ", players[1]});
        racing.put(last,new String[] {players[players.length - 2], " "});
        for (String calling : callings) {
            String front = racing.get(calling)[0];
            String back = racing.get(calling)[1];
            String frontOfFront = racing.get(front)[0];
            if(calling.equals(last)){
                last = racing.get(last)[0];
            }
            else {
                String backOfBack = racing.get(back)[1];
                racing.put(back, new String[]{front, backOfBack});
            }
            racing.put(front, new String[] {calling, back});
            racing.put(calling, new String[] {frontOfFront, front});
        }
        String[] answer = new String[players.length];
        answer[players.length - 1] = last;
        for (int i = players.length - 2; i > -1; i--) {
            answer[i] = racing.get(last)[0];
            last = answer[i];
        }
        return answer;
    }
}