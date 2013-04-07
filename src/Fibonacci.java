import java.math.BigInteger;

import org.junit.Test;

public class Fibonacci {

    /**
     * Calculates n-th Fibonacci sequence element
     * Method: standard recursion as in definition
     * NOTE: Remember that Long.MAX_VALUE is 9223372036854775807L !
     * WILL WORK ONLY UP TO n=92
     *
     * @param n index of the sequence element to calculate
     * @return n-th Fibonacci sequence element
     */
    public static long fib(long n) {
        if (n < 3L)
            return 1;
        else
            return fib(n - 2) + fib(n - 1);
    }

    /**
     * Calculates n-th Fibonacci sequence element
     * Method: iteration
     * NOTE: Remember that Long.MAX_VALUE is 9223372036854775807L !
     * WILL WORK ONLY UP TO n=92
     *
     * @param n index of the sequence element to calculate
     * @return n-th Fibonacci sequence element
     */
    public static long fibIterative(long n) {
        long prev1 = 0, prev2 = 1;
        for (long i = 0; i < n; i++) {
            long savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    /**
     * Calculates n-th Fibonacci sequence element
     * overcomes the Long limit which is 9223372036854775807L
     *
     * @param n index of the sequence element to calculate
     * @return n-th Fibonacci sequence element
     */
    public static BigInteger fib(BigInteger n) {
        BigInteger prev1 = BigInteger.ZERO, prev2 = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1.add(prev2);
        }
        return prev1;
    }


    @Test
    public void checkExpectedValues() {
        assert fib(1) == 1;
        assert fib(2) == 1;
        assert fib(5) == 5;
        assert fib(8) == 21;

        assert fibIterative(50) == 12586269025L;
        assert fib(BigInteger.valueOf(500)).toString()
            .equals("139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125");
    }
}
