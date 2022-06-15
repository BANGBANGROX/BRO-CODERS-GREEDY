import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<ArrayList<Integer>> res = new LinkedList<>();
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int l = intervals[0][0];
        int r = intervals[0][1];

        res.add(new ArrayList<>(Arrays.asList(l, r)));

        for (int i = 1; i < n; ++i) {
            int currentL = intervals[i][0];
            int currentR = intervals[i][1];
            if (currentL > r) {
                res.add(new ArrayList<>(Arrays.asList(currentL, currentR)));
                r = currentR;
                l = currentL;
            }
            else {
                r = Math.max(currentR, r);
                res.pollLast();
                res.add(new ArrayList<>(Arrays.asList(l, r)));
            }
        }

        int[][] ans = new int[res.size()][2];

        for (int i = 0; i < res.size(); ++i) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }

        return ans;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; ++i) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[][] ans = solution.merge(intervals);
            for (int[] interval : ans) {
                System.out.println(interval[0] + " " + interval[1]);
            }
        }

        sc.close();
    }
}
