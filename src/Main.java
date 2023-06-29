import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
            Main a = new Main();
            String[] players = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
            String[] callings = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
            System.out.println(a.solution(players, callings, "B"));
            for(String x : a.solution(players, callings, "B")){
                System.out.println(x);
            }
    }
    public String[] solution(String[] s1, String[] s2, String k) {
        HashMap<String, List<String>> classGraph = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (!classGraph.containsKey(s2[i])) {
                classGraph.put(s2[i], new ArrayList<>());
            }
            classGraph.get(s2[i]).add(s1[i]);
        }
        List<List<String>> classDepth = new ArrayList<>();
        classDepth.add(new ArrayList<>());
        classDepth.get(0).addAll(classGraph.get(k));

        int depth = 0;
        while (classDepth.get(depth).size() > 0) {
            classDepth.add(new ArrayList<>());
            for (String c : classDepth.get(depth)) {
                if(classGraph.containsKey(c)){
                    classDepth.get(depth + 1).addAll(classGraph.get(c));
                }
            }
            depth++;
        }
        System.out.println("depth 마지막 : " + classDepth + " 크기 :" + classDepth.size());
        List<String> answerList = new ArrayList<>();
        for (int i = depth ; i > -1; i--) {
            System.out.println("깊이 "+i+" :"+classDepth.get(i));
            answerList.addAll(classDepth.get(i));
        }
        System.out.println("리스트" + answerList);
        answerList = answerList.stream().distinct().collect(Collectors.toList());
        String[] answer = answerList.toArray(new String[answerList.size()]);
        System.out.println("정답"+Arrays.toString(answer));
        return answer;
    }
}