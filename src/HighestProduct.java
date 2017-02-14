/**
 * Created by swu on 14/02/2017.
 */
public class HighestProduct {
  public static int highest_product_3(int[] inputs) {
    if (inputs.length < 3) return 0;
    int highest = Math.max(inputs[0], inputs[1]);
    int lowest = Math.min(inputs[0], inputs[1]);
    int highest_product_of_2 = inputs[0] * inputs[1];
    int lowest_product_of_2 = inputs[0] * inputs[1];
    int best = highest_product_of_2 * inputs[2];

    for (int i = 2; i < inputs.length; i ++) {
      int current = inputs[i];
      best = Math.max(best, Math.max(highest_product_of_2 * current, lowest_product_of_2 * current));
      highest_product_of_2 = Math.max(highest_product_of_2, Math.max(highest * current, lowest * current));
      lowest_product_of_2 = Math.min(lowest_product_of_2, Math.min(highest * current, lowest * current));
      highest = Math.max(highest, current);
      lowest = Math.min(lowest, current);
    }
    return best;
  }

  public static void main(String[] arg) {
    int[] inputs = new int[] {-1, 2, 5, 11, -10000};
    int result = highest_product_3(inputs);
    System.out.println(result);
  }
}
