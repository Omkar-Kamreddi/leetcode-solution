// Last updated: 8/14/2026, 9:59:22 AM
class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();

        int max = 0;
        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
            max = Math.max(max, num);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long start : freq.keySet()) {

            if (start == 1L) continue;

            long curr = start;
            int len = 0;

            while (true) {

                int count = freq.getOrDefault(curr, 0);

                if (count >= 2) {
                    len += 2;

                    // Next square cannot exist
                    if (curr > (long) max / curr) {
                        len--;
                        break;
                    }

                    curr *= curr;
                } else if (count == 1) {
                    len++;
                    break;
                } else {
                    len--;
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}