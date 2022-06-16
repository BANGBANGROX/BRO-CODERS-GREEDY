// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S1 = read.readLine().split(" ");
            int N = Integer.parseInt(S1[0]);
            int K = Integer.parseInt(S1[1]);

            String[] S = read.readLine().split(" ");
            int[] A = new int[N];

            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minSteps(A,N,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private int upperBound(int[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] <= key) {
                l = mid + 1;
            }
            else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }

    public int minSteps(int[] nums, int n, int k) {
        // code here
        int[] prefix = new int[n];
        int ans = Integer.MAX_VALUE;
        int previousResult = 0;

        Arrays.sort(nums);

        prefix[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                ++i;
                ++count;
            }
            int target = nums[i] + k;
            int idx = upperBound(nums, target);
            int actualSum = prefix[n - 1] - prefix[idx - 1];
            int requiredSum = (n - idx + 1) * target;
            ans = Math.min(ans, actualSum - requiredSum + previousResult);
            previousResult += nums[i] * count;
        }

        return ans;
    }
}