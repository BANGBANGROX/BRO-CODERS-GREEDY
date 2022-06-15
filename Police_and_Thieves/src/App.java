// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution {
    public int catchThieves(char arr[], int n, int k) {
        // Code here
        ArrayList<Integer> policePos = new ArrayList<>();
        ArrayList<Integer> thiefPos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                policePos.add(i);
            else
                thiefPos.add(i);
        }

        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < policePos.size() && j < thiefPos.size()) {
            int police = policePos.get(i);
            int thief = thiefPos.get(j);
            if (Math.abs(police - thief) <= k) {
                ++ans;
                ++i;
                ++j;
            } else if (police > thief) {
                ++j;
            } else {
                ++i;
            }
        }

        return ans;
    }
}

// { Driver Code Starts.
public class App {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char arr[] = new char[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.next().charAt(0);

            Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }

        sc.close();
    }
} // } Driver Code Ends