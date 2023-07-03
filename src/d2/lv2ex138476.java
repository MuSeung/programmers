package d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lv2ex138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerineCount = new HashMap<>();
        for(int t : tangerine){
            if(tangerineCount.containsKey(t)){
                tangerineCount.put(t,tangerineCount.get(t)+1);
            }
            else{
                tangerineCount.put(t,1);
            }
        }
        List<Integer> valueList = new ArrayList<>(tangerineCount.values());
        Collections.sort(valueList, Collections.reverseOrder());
        int val = 0;
        for(int t : valueList){
            val += t;
            answer++;
            if(val>=k){
                break;
            }
        }
        return answer;
    }

}
