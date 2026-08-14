// Last updated: 8/14/2026, 9:57:21 AM
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] multiplier = new long[n];
        Arrays.fill(multiplier, 1);

        int threshold = (int) Math.sqrt(n);

        // Group queries by k
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(new int[]{l, r, v});
        }

        for (int k : map.keySet()) {
            List<int[]> list = map.get(k);

            // 🔸 Case 1: Large k → brute force
            if (k > threshold) {
                for (int[] q : list) {
                    int l = q[0], r = q[1];
                    long v = q[2];

                    for (int i = l; i <= r; i += k) {
                        multiplier[i] = (multiplier[i] * v) % MOD;
                    }
                }
            } 
            // 🔸 Case 2: Small k → optimized
            else {
                for (int rem = 0; rem < k; rem++) {

                    int size = (n - rem + k - 1) / k;
                    long[] temp = new long[size];
                    Arrays.fill(temp, 1);

                    // Apply queries with range multiplication trick
                    for (int[] q : list) {
                        int l = q[0], r = q[1];
                        long v = q[2];

                        if (l % k != rem) continue;

                        int start = (l - rem) / k;
                        int end = (r - rem) / k;

                        temp[start] = (temp[start] * v) % MOD;

                        if (end + 1 < size) {
                            temp[end + 1] = (temp[end + 1] * modInverse(v)) % MOD;
                        }
                    }

                    // Prefix multiplication
                    for (int i = 1; i < size; i++) {
                        temp[i] = (temp[i] * temp[i - 1]) % MOD;
                    }

                    // Map back to original indices
                    int idx = rem;
                    for (int i = 0; i < size && idx < n; i++, idx += k) {
                        multiplier[idx] = (multiplier[idx] * temp[i]) % MOD;
                    }
                }
            }
        }

        // Apply multipliers and compute XOR
        int result = 0;
        for (int i = 0; i < n; i++) {
            long val = (nums[i] * multiplier[i]) % MOD;
            result ^= (int) val;
        }

        return result;
    }

    // Fast exponentiation
    long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    // Modular inverse using Fermat's theorem
    long modInverse(long x) {
        return power(x, MOD - 2);
    }
}