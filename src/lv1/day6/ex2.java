package lv1.day6;

import java.util.ArrayList;

public class ex2 {

    class Person {

        ArrayList<Integer> contact;
        int count;
        boolean unSpent;

        public boolean GotEnoughMail(int k) {
            count++;
            if (count >= k && unSpent) {
                unSpent = false;
                return true;
            }
            return false;
        }

        Person() {
            contact = new ArrayList<>();
            count = 0;
            unSpent = true;
        }

    }

    public int solution(int n, int c, int k, int[][] contact) {
        int answer = 0;
        Person[] people = new Person[n - c + 1];
        for (int i = 0; i < n - c + 1; i++) {
            people[i] = new Person();
        }
        ArrayList<Integer> spendList = new ArrayList<>();
        for (int[] con : contact) {
            if (con[0] <= c) {
                //악동이 보내는거
                if (people[con[1] - c].GotEnoughMail(k)) {
                    spendList.add(con[1] - c);
                }
            }
            //마을사람의 각 연락책
            else {
                people[con[0] - c].contact.add(con[1] - c);
            }
        }
        while (spendList.size() > 1) {
            for (int j : people[spendList.get(0)].contact) {
                if (people[j - c].GotEnoughMail(k)) {
                    spendList.add(j - c);
                }
            }
            spendList.remove(0);
        }
        for (Person person : people) {
            if (person.count > 0) {
                answer++;
            }
        }
        return answer - 1;
    }
}
