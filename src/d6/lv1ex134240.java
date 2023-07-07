package d6;

public class lv1ex134240 {

    public String solution(int[] food) {
        String answer = "";
        String foodList = "";
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                foodList += i;
            }
        }
        answer = foodList + "0";
        for (int i = 0; i < foodList.length(); i++) {
            answer += foodList.charAt(foodList.length() - i - 1);
        }

        return answer;
    }
}
