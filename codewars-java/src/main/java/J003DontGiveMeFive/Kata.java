package J003DontGiveMeFive;

import java.util.stream.IntStream;

public class Kata {

    public static final int DIGIT_TO_FIND = 5;

    public static int dontGiveMeFive(int start, int end) {
        return (int) (long) IntStream.rangeClosed(start, end)
                .map(number -> number > 0 ? number : -number)
                .filter(number -> {
                    int numberAccumulator;
                    while (number != 0) {
                        numberAccumulator = number % 10;
                        number = number / 10;
                        if (numberAccumulator == DIGIT_TO_FIND) {
                            return false;
                        }
                    }
                    return true;
                })
                .count();
    }
}
