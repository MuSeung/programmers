/*
도착 시간(분)
예약 여부(boolean)

1. 도착 시간으로 정렬하기
2. now를 기준으로 now보다 작은 시간이 있는 경우 예약 여부 먼저 하기.
3. now를 기준으로 now보다 작은 시간이 없는 경우 그저 도착 시간여부로만 한명 하기

한 명 받으면 now+10;

대기열이라는 arrayList 만들기

대기열 ArrayList 특징
1. now가 변할 때 마다 업데이트를 해준다.
 1-1 index를 가지며, index는 now가 변할 때 도착 시간과 비교하여
      해당 도착 시간보다 적은 경우를 ArrayList에 추가하며, index는 늘려간다.
 1-2 대기열.size는 밀린 예약이며 0이 될 수 도 있다.
 1-3 대기열을 2개를 만드는 데, 하나는 booked 하나는 unbooked로 하며
      그냥 시간 순서대로 넣어주면 되며, booked먼저 뺸다.(무조건 delete(0))




자 예약 프로토콜

1. now를 기준으로 poeple를 훑어서 now보다 작은 time이 있는지 확인해서 대기열 추가
 1) 대기열이 있는 경우 대기열에 추가하기
   1)-1 대기열을 훑으면서 booked먼저 빼고 아니면
 2) 대기열이 없는 경우
   2) -1 get(0)해서 now업뎃하고 끝내기





 */


package lv1.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ex1 {

    class Person {

        int minute;
        boolean booking;
        String name;

        Person(int minute, boolean booking, String name) {
            this.minute = minute;
            this.booking = booking;
            this.name = name;
        }
    }

    private int toMinute(String time) {
        return (time.charAt(0) - '0') * 600 + (time.charAt(1) - '0') * 60
            + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }

    public String[] solution(String[][] booked, String[][] unbooked) {
        int allPeopleNumber = booked.length + unbooked.length;
        String[] answer = new String[allPeopleNumber];
        int count = 0;
        int now;

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Person> bookedQueue = new ArrayList<>();
        ArrayList<Person> unbookedQueue = new ArrayList<>();
        for (String[] person : booked) {
            people.add(new Person(toMinute(person[0]), true, person[1]));
        }
        for (String[] person : unbooked) {
            people.add(new Person(toMinute(person[0]), false, person[1]));
        }
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.minute - o2.minute;
            }
        });

        answer[count++] = people.get(0).name;
        now = people.get(0).minute + 10;
        people.remove(0);

        while (count < allPeopleNumber) {
            int index = 0;
            while (index < people.size()) {
                Person nowPerson = people.get(index);
                if (nowPerson.minute <= now) {
                    if (nowPerson.booking) {
                        bookedQueue.add(nowPerson);
                    } else {
                        unbookedQueue.add(nowPerson);
                    }
                    people.remove(0);
                } else {
                    break;
                }
            }
            if (bookedQueue.size() + unbookedQueue.size() > 0) {
                if(bookedQueue.size() > 0){
                    answer[count++] = bookedQueue.get(0).name;
                    bookedQueue.remove(0);
                }
                else{
                    answer[count++]=unbookedQueue.get(0).name;
                    unbookedQueue.remove(0);
                }
                now = now + 10;
            }
            else {
                answer[count++] = people.get(0).name;
                now = people.get(0).minute + 10;
                people.remove(0);
            }
        }

        return answer;
    }
}
