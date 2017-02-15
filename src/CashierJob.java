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

  /***
   * This is the first solution I'm thinking about,
   * this solution base on the graph navigation, BFS
   * if the length of the input is n
   * The complexity of this solution is < n^target_value
   *
   * There are some duplicate solution in the response
   *
   * @param inputs
   * @param target_value
   * @return
   */
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

  /***
   * After knowing the best soluiton is O(m * n), I'm thinking about greedy or dynamic programming, etc
   *
   * @param inputs
   * @param target_value
   * @return
   */
  public static LinkedList<Solution> solution2(int[] inputs, int target_value) {
    LinkedList<Solution>[] solutions = new LinkedList[target_value];
    for (int i = 1; i <= target_value; i ++) {
      solutions[i-1] = new LinkedList<>();

      for (int j = 0; j < inputs.length; j++) {
        int current_minus_input_j = i - inputs[j];
        // Current equals input_j
        if (current_minus_input_j == 0) {
          solutions[i-1].push(new Solution(inputs[j]));
          // Current > input_j
        } else if (current_minus_input_j > 0) {
          /**
           * For example current is 4, input_j is 2, to get the solution of 4
           * is the Solution of 2 union input_j
           *
           * 4 - 2 = 2, the solution of 2 is in index 2 - 1 = 1
           */
          for (Solution s : solutions[current_minus_input_j - 1]) {
            // The solution to get current_minus_input_j
            Solution new_solution = s.add_node(inputs[j]);
            solutions[i-1].push(new_solution);
          }
        }

      }
    }
    return solutions[target_value-1];
  }

  public static void main(String[] arg) {
    System.out.println(solution2(new int[] {1, 2, 3}, 4));
  }
}
