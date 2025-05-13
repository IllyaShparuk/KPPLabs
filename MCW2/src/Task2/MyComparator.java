package Task2;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return threeNumSum(a) - threeNumSum(b);
    }

    private int threeNumSum(int num) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
