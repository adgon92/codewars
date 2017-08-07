package J002xibonacci;

class Xbonacci {
    double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[]{};
        }
        return getTribonacciSequence(s, n);
    }

    private double[] getTribonacciSequence(double[] s, int n) {
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            if (i <= 2) {
                result[i] = s[i];
            } else {
                result[i] = getSequenceElement(result, i);
            }
        }
        return result;
    }

    private double getSequenceElement(double[] subResult, int i) {
        return subResult[i - 1] + subResult[i - 2] + subResult[i - 3];
    }
}
