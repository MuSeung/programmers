package lv1.day1;

import java.util.ArrayList;
import java.util.List;

public class ex2 {

    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        for (int item : lost) {
            lostList.add(item);
        }
        for (int item : reserve) {
            reserveList.add(item);
        }
        for (Integer item : lostList) {
            if (reserveList.contains(item)) {
                lostList.remove(item);
                reserveList.remove(item);
            }
        }
        int x = n;
        for(Integer item : lostList){
            if (reserveList.contains((Integer) (item - 1))) {
                x--;
                reserveList.remove((Integer) (item - 1));
            } else if (reserveList.contains(item + 1)) {
                x--;
                reserveList.remove((Integer) (item + 1));
            }
        }
        return x;
    }
}
