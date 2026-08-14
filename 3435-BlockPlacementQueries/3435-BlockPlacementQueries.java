// Last updated: 8/14/2026, 9:58:54 AM
import java.util.*;

class Solution {
    // Segment tree for max gap between consecutive obstacles
    // We coordinate-compress on x values from type-1 queries + add sentinel 0
    
    int[] segTree; // max gap in segment tree
    int[] obstacles; // sorted obstacle positions (coordinate compressed)
    int n;
    
    // Build segment tree over sorted obstacle positions
    // Each leaf = gap before this obstacle (from previous obstacle)
    // We update gaps dynamically as obstacles are added
    
    // Actually, let's use a cleaner approach:
    // - Keep obstacles in a TreeSet
    // - Segment tree indexed by actual positions (up to 5*10^4)
    // - seg[i] = max gap in the "prefix" [0..i]
    
    // Simpler: Segment tree where position = obstacle x-value
    // Query: max gap using obstacles <= x, considering gap to x itself
    
    int[] tree;
    int SIZE = 150001; // max x value
    
    // seg tree: each node stores max gap value in that range of positions
    // When obstacle added at pos p, gap before p changes
    // We need: for all obstacles <= x, max consecutive gap
    
    // Let's store in seg tree: at index p, the gap FROM previous obstacle TO p
    // Then query max in [0, x]
    // But also need to handle the "tail" gap from last obstacle <= x to x
    
    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2*node, start, mid, idx, val);
        else update(2*node+1, mid+1, end, idx, val);
        tree[node] = Math.max(tree[2*node], tree[2*node+1]);
    }
    
    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return Math.max(
            query(2*node, start, mid, l, r),
            query(2*node+1, mid+1, end, l, r)
        );
    }
    
    public List<Boolean> getResults(int[][] queries) {
        tree = new int[4 * SIZE];
        // TreeSet to find prev/next obstacles
        TreeSet<Integer> obs = new TreeSet<>();
        obs.add(0); // virtual obstacle at origin
        
        // We store gap AT position p = (p - prevObstacle)
        // Initially only obstacle at 0, gap at 0 = 0
        update(1, 0, SIZE-1, 0, 0);
        
        List<Boolean> result = new ArrayList<>();
        
        for (int[] q : queries) {
            if (q[0] == 1) {
                // Add obstacle at x = q[1]
                int x = q[1];
                Integer prev = obs.floor(x - 1); // obstacle just before x
                Integer next = obs.ceiling(x + 1); // obstacle just after x
                
                // Gap at x = x - prev
                update(1, 0, SIZE-1, x, x - prev);
                
                // If there's a next obstacle, its gap was (next - prev), now becomes (next - x)
                if (next != null) {
                    update(1, 0, SIZE-1, next, next - x);
                }
                
                obs.add(x);
                
            } else {
                // Query: can we place block of size sz in [0, x]?
                int x = q[1], sz = q[2];
                
                // Max gap among obstacles <= x (gap stored AT each obstacle = dist from prev)
                int maxGap = query(1, 0, SIZE-1, 0, x);
                
                // Also consider tail: gap from last obstacle <= x to x itself
                Integer lastObs = obs.floor(x);
                if (lastObs != null) {
                    maxGap = Math.max(maxGap, x - lastObs);
                }
                
                result.add(maxGap >= sz);
            }
        }
        
        return result;
    }
}