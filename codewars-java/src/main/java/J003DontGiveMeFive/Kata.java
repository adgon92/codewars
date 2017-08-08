package J003DontGiveMeFive;

import java.util.stream.IntStream;

public class Kata {

    public static final int DIGIT_TO_FIND = 5;

    public static int dontGiveMeFive(int start, int end) {
        return (int) (long) IntStream.rangeClosed(start, end)
                .map(number -> number > 0 ? number : -number)
                .filter(Kata::containsNoFive)
                .count();
    }

    private static boolean containsNoFive(final int number) {
        for (int x = Math.abs(number); x != 0; x /= 10) {
            if (x % 10 == DIGIT_TO_FIND) return false;
        }
        return true;
    }
}
