// Last updated: 8/14/2026, 9:58:10 AM
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;   // 2^11 > 1500

        boolean[] pairXor = new boolean[MAX];
        boolean[] tripletXor = new boolean[MAX];

        // All possible XORs of two elements
        for (int a : nums) {
            for (int b : nums) {
                pairXor[a ^ b] = true;
            }
        }

        // XOR each pair result with every element
        for (int x = 0; x < MAX; x++) {
            if (!pairXor[x]) continue;
            for (int c : nums) {
                tripletXor[x ^ c] = true;
            }
        }

        int ans = 0;
        for (boolean exists : tripletXor) {
            if (exists) ans++;
        }

        return ans;
    }
}