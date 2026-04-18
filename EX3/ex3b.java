import java.io.*;
import java.util.*;

public class Solution {

    // Fast modular exponentiation
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Get prime factors of n
    static Set<Integer> primeFactors(int n) {
        Set<Integer> factors = new HashSet<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);

        return factors;
    }

    // Euler Totient function
    static int phi(int n) {
        int result = n;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                result -= result / i;
            }
        }
        if (n > 1) result -= result / n;

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine().trim());

        int phiVal = p - 1;

        // Step 1: find prime factors of (p-1)
        Set<Integer> factors = primeFactors(phiVal);

        int smallestPrimitiveRoot = -1;

        // Step 2: check for primitive root
        for (int g = 2; g < p; g++) {
            boolean isPrimitive = true;

            for (int factor : factors) {
                if (modPow(g, phiVal / factor, p) == 1) {
                    isPrimitive = false;
                    break;
                }
            }

            if (isPrimitive) {
                smallestPrimitiveRoot = g;
                break;
            }
        }

        // Step 3: count primitive roots
        int totalPrimitiveRoots = phi(phiVal);

        System.out.println(smallestPrimitiveRoot + " " + totalPrimitiveRoots);
    }
}
