import java.util.*;

class Solution {
    public int solve(ArrayList<ArrayList<Integer>> intervals) {
        int n = intervals.size();

        intervals.sort((a, b) -> (!Objects.equals(a.get(0), b.get(0)) ?
                a.get(0) - b.get(0) : a.get(1) - b.get(1)));

        int r = intervals.get(0).get(1);
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < n; ++i) {
            int newL = intervals.get(i).get(0);
            int newR = intervals.get(i).get(1);
            if (newL > r) {
                ++currentLength;
                r = newR;
            }
            else {
                r = Math.min(r, newR);
            }
        }

        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
}


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                intervals.add(new ArrayList<>(Arrays.asList(l, r)));
            }

            Solution solution = new Solution();
            System.out.println(solution.solve(intervals));
        }

        sc.close();
    }
}
