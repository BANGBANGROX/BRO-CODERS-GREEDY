// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class App {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());

            int[] gallery = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(sc.next());
            Solution T = new Solution();
            System.out.println(T.min_sprinklers(gallery,n));
        }


    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int[] gallery, int n) {
        // code here
        ArrayList<ArrayList<Integer>> range = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (gallery[i] == -1) continue;
            range.add(new ArrayList<>(Arrays.asList(Math.max(0, i - gallery[i]), Math.min(n - 1, i + gallery[i]))));
        }

        range.sort((a, b) -> !Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));

        int start = 0;
        int i = 0;
        int ans = 0;

        while (start < n) {
            int end = Integer.MIN_VALUE;
            while (i < range.size()) {
                if (range.get(i).get(0) > start) break;
                end = Math.max(end, range.get(i).get(1));
                ++i;
            }
            if (end == Integer.MIN_VALUE) return -1;
            start = end + 1;
            ++ans;
        }

        return ans == 0 ? -1 : ans;
    }
}
