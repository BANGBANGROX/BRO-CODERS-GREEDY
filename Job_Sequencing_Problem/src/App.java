// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class App {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String[] inputLine = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job[] arr, int n) {
        // Your code here
        Arrays.sort(arr, Comparator.comparingInt(a -> -1 * a.profit));

        int maxDeadline = 0;
        int[] ans = new int[2];

        for (int i = 0; i < n; ++i) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        TreeSet<Integer> st = new TreeSet<>();

        for (int i = 1; i <= maxDeadline; ++i) {
            st.add(i);
        }

        for (int i = 0; i < n; ++i) {
            int deadline = arr[i].deadline;
            if (st.floor(deadline) == null) continue;
            ++ans[0];
            ans[1] += arr[i].profit;
            st.remove(st.floor(deadline));
        }

        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/