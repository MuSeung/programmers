package lv1.day6;

public class ex3 {

    int[][] sum = new int[15][15];

    private int prove(int t, int y) {
        int a = t;
        int b = y;
        if (b > a) {
            b = a;
        }
        if (sum[a][b] == 0) {
            int x = 0;
            for (int i = 0; i <= b; i++) {
                x += prove(a - 1, i);
            }
            sum[a][b] = x;
        }
        return sum[a][b];
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i < 15; i++) {
            sum[i][0] = 1;
        }
        answer = prove(n - 1, n - 1);
        return answer;
    }
}
