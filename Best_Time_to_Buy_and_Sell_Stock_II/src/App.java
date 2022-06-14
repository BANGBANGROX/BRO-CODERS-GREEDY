import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;

        for (int i = 1; i < n; ++i) {
            if (prices[i] > prices[i - 1]) {
                ans += (prices[i] - prices[i - 1]);
            }
        }

        return ans;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; ++i) {
                prices[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxProfit(prices));
        }

        sc.close();
    }
}
