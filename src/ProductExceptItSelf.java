/**
 * Created by swu on 14/02/2017.
 */
public class ProductExceptItSelf {
  public static int[] product_except_it_self(int[] inputs) {
    /*
     * Ex:
     * inputs   2 3  4 5
     * mid      2 6 24 120
     * midResult store the product for all number from 0 to i
     *
     * */
    int[] result = new int[inputs.length];
    int product = 1;
    int[] midResult = new int[inputs.length];
    if (inputs.length < 2) return result;
    for (int i = 0; i < inputs.length; i++) {
      product *= inputs[i];
      midResult[i] = product;
    }
    product = 1;
    for (int i = inputs.length-1; i > 0; i--) {
      result[i] = midResult[i-1] * product;
      product *= inputs[i];
    }
    result[0] = product;
    return result;
  }

  public static int[] product_except_it_self_improvement(int[] inputs) {
    int[] result = new int[inputs.length];
    int product = 1;
    for (int i = 0; i < inputs.length; i++) {
      result[i] = product;
      product *= inputs[i];
    }
    product = 1;
    for (int i = inputs.length-1; i>=0 ; i--) {
      result[i] *= product;
      product *= inputs[i];
    }
    return result;
  }

  public static void main(String[] arr) {
    int[] inputs = new int[] {};
    int[] result = product_except_it_self_improvement(inputs);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }
}
