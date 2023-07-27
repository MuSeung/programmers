package First.d1;

public class lv1ex67256 {

    class position {

        int x;
        int y;

        position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        position(int number) {
            if (number == 0) {
                x = 3;
                y = 1;
            } else {
                x = (number - 1) / 3;
                y = (number - 1) % 3;
            }
        }

        int distance(position numberPosition) {
            return Math.abs(this.x - numberPosition.x) + Math.abs(this.y - numberPosition.y);
        }

        void clickPosition(position numberPosition) {
            this.x = numberPosition.x;
            this.y = numberPosition.y;
        }
    }

    String click(position lefHand, position rightHand, position numberPosition, String hand) {
        if(numberPosition.y==0){
            lefHand.clickPosition(numberPosition);
            return "L";
        }
        if(numberPosition.y==2){
            rightHand.clickPosition(numberPosition);
            return "R";
        }

        int leftDistance = lefHand.distance(numberPosition);
        int rightDistance = rightHand.distance(numberPosition);
        if (leftDistance < rightDistance) {
            lefHand.clickPosition(numberPosition);
            return "L";
        }
        if (leftDistance > rightDistance) {
            rightHand.clickPosition(numberPosition);
            return "R";
        }
        if (hand.equals("left")) {
            lefHand.clickPosition(numberPosition);
            return "L";
        }
        if (hand.equals("right")) {
            rightHand.clickPosition(numberPosition);
            return "R";
        }
        return "";
    }

    public String solution(int[] numbers, String hand) {
        position leftHand = new position(3, 0);
        position rightHand = new position(3, 2);
        String answer = "";
        for (int number : numbers) {
            position numberPosition = new position(number);
            answer += click(leftHand, rightHand, numberPosition, hand);
            //System.out.println("왼: "+leftHand.x +", "+ leftHand.y + "오른:"+ rightHand.x +", "+rightHand.y);
        }

        return answer;
    }

}
