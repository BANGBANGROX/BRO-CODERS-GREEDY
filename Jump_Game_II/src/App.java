import java.util.Scanner;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 0;

        int jumps = 1;
        int maxReach = nums[0];
        int steps = nums[0];

        for (int i = 1; i < n; ++i) {
            if (i == n - 1)
                return jumps;
            maxReach = Math.max(maxReach, i + nums[i]);
            --steps;
            if (steps == 0) {
                ++jumps;
                steps = maxReach - i;
            }
        }

        return jumps;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.jump(nums));
        }

        sc.close();
    }
}
