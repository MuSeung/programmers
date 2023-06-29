package lv1.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ex1 {

    public String[] solution(String[] s1, String[] s2, String k) {
        HashMap<String, List<String>> classGraph = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (!classGraph.containsKey(s1[i])) {
                classGraph.put(s1[i], new ArrayList<>());
            }
            classGraph.get(s1[i]).add(s2[i]);
        }
        List<List<String>> classDepth = new ArrayList<>();
        classDepth.add(new ArrayList<>(classGraph.get(k)));
        int depth = 0;
        while (classDepth.get(depth).size() > 0) {
            classDepth.add(new ArrayList<>());
            for (String c : classDepth.get(depth)) {
                classDepth.get(depth + 1).addAll(classGraph.get(c));
            }
            depth++;
        }
        List<String> answerList = new ArrayList<>();
        for (int i = depth - 1; i > -1; i--) {
            answerList.addAll(classDepth.get(depth));
        }
        Set<String> anwerSet = new HashSet<>(answerList);
        String[] answer = anwerSet.toArray(new String[0]);
        return answer;
    }

}
