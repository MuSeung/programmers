package First.d24;

public class lv1ex12934 {

    public long solution(long n) {
        if (Math.sqrt(n) > (int) Math.sqrt(n)) {
            return -1;
        }
        return (long) Math.pow(Math.sqrt(n) + 1, 2);
    }
}
