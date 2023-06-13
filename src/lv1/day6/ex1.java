package lv1.day6;

public class ex1 {

    int[][] map;
    int[][] countingMap;

    int maxX;
    int maxY;

    class Quest {

        int xPosition;
        int yPosition;
        int moving;

        public Quest(int xPosition, int yPosition, int moving) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.moving = moving;
        }
        boolean isOkToMove(){
            if(map[yPosition][xPosition] == 0){
                return false;
            }
            if(moving < countingMap[yPosition][xPosition] || countingMap[yPosition][xPosition] == 0){
                countingMap[yPosition][xPosition] = moving;
                return true;
            }
            return false;
        }
    }

    private void makeCountingMap(){
        countingMap = new int[map.length][map[0].length];
        maxX = map[0].length - 1;
        maxY = map.length - 1;
    }

    private void move(Quest quest) {
        goRight(quest);
        goDown(quest);
        goLeft(quest);
        goUp(quest);
    }

    private void goRight(Quest quest) {
        if(quest.xPosition + 1 > maxX){
            return;
        }
        Quest rQuest = new Quest(quest.xPosition + 1, quest.yPosition, quest.moving + 1);
        if(rQuest.isOkToMove()){
            move(rQuest);
        }
    }

    private void goDown(Quest quest) {
        if(quest.yPosition + 1 > maxY){
            return;
        }
        Quest dQuest = new Quest(quest.xPosition, quest.yPosition + 1, quest.moving + 1);
        if(dQuest.isOkToMove()){
            move(dQuest);
        }
    }

    private void goLeft(Quest quest) {
        if(quest.xPosition - 1 < 0){
            return;
        }
        Quest lQuest = new Quest(quest.xPosition - 1, quest.yPosition, quest.moving + 1);
        if(lQuest.isOkToMove()){
            move(lQuest);
        }
    }

    private void goUp(Quest quest) {
        if(quest.yPosition - 1 < 0){
            return;
        }
        Quest uQuest = new Quest(quest.xPosition, quest.yPosition - 1, quest.moving + 1);
        if(uQuest.isOkToMove()){
            move(uQuest);
        }
    }

    public int solution(int[][] maps) {
        this.map = maps;
        makeCountingMap();
        move(new Quest(0,0,0));
        int answer = countingMap[maxY][maxX];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}
