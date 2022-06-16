// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int[] start = new int[n];
            int[] end = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public int maxMeetings(int[] start, int[] end, int n) {
        // add your code here
        ArrayList<ArrayList<Integer>> meetingIntervals = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            meetingIntervals.add(new ArrayList<>(Arrays.asList(start[i], end[i])));
        }

        meetingIntervals.sort((a, b) ->
                (!Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1)));

        int ans = 1;
        int maxR = meetingIntervals.get(0).get(1);

        for (int i = 1; i < n; ++i) {
            int l = meetingIntervals.get(i).get(0);
            int r = meetingIntervals.get(i).get(1);
            if (l > maxR) {
                ++ans;
                maxR = r;
            }
            else {
                maxR = Math.min(maxR, r);
            }
        }

        return ans;

    }
}
