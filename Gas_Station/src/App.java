import java.util.*;

class Solution {
    private int findCandidate(List<Integer> fuel, List<Integer> expense) {
        int candidate = 0;
        int i = 0;
        int n = fuel.size();
        int gain = 0;
        int loss = 0;

        while (i < n - 1) {
            gain += fuel.get(i);
            loss += expense.get(i);
            if (loss > gain) {
                candidate = i + 1;
                loss = 0;
                gain = 0;
            }
            ++i;
        }

        return candidate;
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> fuel, final List<Integer> expense) {
        int fuelSum = fuel.stream().reduce(0, Integer::sum);
        int expenseSum = expense.stream().reduce(0, Integer::sum);

        if (expenseSum > fuelSum) return -1;

        return findCandidate(fuel, expense);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<Integer> fuel = new ArrayList<>();
            List<Integer> expense = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                fuel.add(x);
            }
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                expense.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.canCompleteCircuit(fuel, expense));
        }

        sc.close();
    }
}
