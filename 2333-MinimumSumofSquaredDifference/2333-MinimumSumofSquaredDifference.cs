// Last updated: 10/10/2026, 10:06:08 PM
1public class Solution
2{
3    public long MinSumSquareDiff(
4        int[] nums1,
5        int[] nums2,
6        int k1,
7        int k2)
8    {
9        long k = (long)k1 + k2;
10
11        int maxDiff = 0;
12        int[] freq = new int[100001];
13
14        // Step 1: Count each absolute difference
15        for (int i = 0; i < nums1.Length; i++)
16        {
17            int diff = Math.Abs(nums1[i] - nums2[i]);
18
19            freq[diff]++;
20            maxDiff = Math.Max(maxDiff, diff);
21        }
22
23        // No operations are available
24        if (k == 0)
25        {
26            return CalculateScore(freq, maxDiff);
27        }
28
29        // Step 2: Reduce the largest differences by levels
30        for (int d = maxDiff; d > 0 && k > 0; d--)
31        {
32            if (freq[d] == 0)
33            {
34                continue;
35            }
36
37            if (k >= freq[d])
38            {
39                // Reduce every difference at level d by 1
40                k -= freq[d];
41
42                freq[d - 1] += freq[d];
43                freq[d] = 0;
44            }
45            else
46            {
47                // Not enough operations to reduce the whole level
48                freq[d] -= (int)k;
49                freq[d - 1] += (int)k;
50
51                k = 0;
52            }
53        }
54
55        // Step 3: Calculate the final sum of squares
56        return CalculateScore(freq, maxDiff);
57    }
58
59    private long CalculateScore(int[] freq, int maxDiff)
60    {
61        long score = 0;
62
63        for (int d = 1; d <= maxDiff; d++)
64        {
65            score += (long)d * d * freq[d];
66        }
67
68        return score;
69    }
70}