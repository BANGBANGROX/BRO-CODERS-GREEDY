// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class App {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minOperation(n));
        }
        sc.close();
    }
} // } Driver Code Ends

// User function Template for Java

class Solution {
    public int minOperation(int n) {
        // code here.
        int ans = 0;

        while (n > 0) {
            if ((n & 1) > 0)
                --n;
            else
                n /= 2;
            ++ans;
        }

        return ans;
    }
}