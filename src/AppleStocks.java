/**
 * Created by swu on 14/02/2017.
 */
public class AppleStocks {
  public static int best_profit(int[] prices) throws Exception {
    if (prices.length == 0) {
      throw new Exception("There is no price in the prices arr.");
    }
    if (prices.length == 1) {
      return -prices[0];
    }
    int best = prices[1] - prices[0];
    int min = Math.min(prices[0], prices[1]);
    for(int i = 2; i < prices.length; i++) {
      int current = prices[i] - min;
      best = Math.max(current, best);
      min = Math.min(prices[i], min);
    }
    return best;
  }

  public static void main(String[] arr) {
    int[] stock_prices = new int[] {10, 9, 7, 1, 12};
    try{
      System.out.print(best_profit(stock_prices));
    } catch(Exception e) {

    }
  }
}
