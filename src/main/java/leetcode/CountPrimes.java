package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/count-primes/
public class CountPrimes {

    /**
     * The Sieve of Eratosthenes
     * <p>
     * Time: O(NloglogN), N is a source number
     * Space: O(N)
     */
    private static int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        int primes = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i]) {
                continue;
            }

            primes++;
            for (int j = i; j < n; j = j + i) {
                nums[j] = true;
            }
        }

        return primes;
    }

    public static void main(String... args) {
        int primesCount = countPrimes(100);

        Assertions.assertEquals(primesCount, 25);
    }
}
