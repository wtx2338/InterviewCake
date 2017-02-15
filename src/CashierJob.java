import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by swu on 15/02/2017.
 */
public class CashierJob {
  private static class Solution {
    LinkedList<Integer> denomination = new LinkedList<>();
    int sum;

    Solution (int initial_int) {
      denomination.add(initial_int);
      sum = initial_int;
    }

    Solution(Solution s) {
      denomination = new LinkedList<>(s.denomination);
      sum = s.sum;
    }

    Solution add_node(int node) {
      Solution result = new Solution(this);
      result.denomination.add(node);
      result.sum += node;
      return result;
    }

    @Override
    public String toString() {
      return denomination.toString() + " SUM:" + sum;
    }
  }

  public static LinkedList<Solution> solution(int[] inputs, int target_value) {
    LinkedList<Solution> solutions = new LinkedList<>();

    Queue<Solution> queue_of_potential_solution = new LinkedBlockingQueue<>();
    for (int i = 0; i < inputs.length; i++) {
      queue_of_potential_solution.add(new Solution(inputs[i]));
    }

    while (!queue_of_potential_solution.isEmpty()) {
      Solution potential_solution = queue_of_potential_solution.poll();
      // If the sum == target_value, this is a good solution
      if (potential_solution.sum == target_value) {
        solutions.push(potential_solution);

        // We may can get target value after
      } else if (potential_solution.sum < target_value) {
        for (int i = 0; i < inputs.length; i++) {
          queue_of_potential_solution.add(potential_solution.add_node(inputs[i]));
        }
      }
    }
    return solutions;
  }


}
