package lv1.day6;

public class ex4 {
    public int solution(int[][] triangle) {

        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j],triangle[i][j+1]);
            }
        }
        int answer = triangle[0][0];
        return answer;
    }
}
