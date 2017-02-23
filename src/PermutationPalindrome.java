import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by swu on 22/02/2017.
 */
public class PermutationPalindrome {
  /**
   * Return true if the input string have a palindrome permutation
   *
   * civic : true
   * ivicc: true
   * civil: false
   * livci: false
   *
   * If a permutation of a String is palindrome, inside this String, can not have more than one no-paired characters
   *
   * @param input
   * @return
   */
  public static boolean hasPermutationPalindrome(String input) {
    int nbOfNoPaired = 0;
    // We can use HashSet
    HashMap<Character, Boolean> isPaired = new HashMap(input.length());
    for (int index = 0; index < input.length(); index++) {
      char c = input.charAt(index);
      Boolean cIsParied = isPaired.get(c);
      if (cIsParied == null) {
        isPaired.put(c, false);
        nbOfNoPaired ++;
      } else {
        if (cIsParied) {
          nbOfNoPaired ++;
        } else {
          nbOfNoPaired --;
        }
        isPaired.put(c, !cIsParied);
      }
    }
    return nbOfNoPaired < 2;
  }

  public static boolean hasPermutationPalindromeHashSet(String input) {
    Set<Character> noPaired = new HashSet<Character>();
    for (int index = 0; index < input.length(); index++) {
      char c = input.charAt(index);
      if (noPaired.contains(c)) {
        noPaired.remove(c);
      } else {
        noPaired.add(c);
      }
    }
    return noPaired.size() < 1;
  }

  public static void main(String[] args) {
    System.out.println(hasPermutationPalindrome("civic"));
    System.out.println(hasPermutationPalindrome("ivicc"));
    System.out.println(hasPermutationPalindrome("civil"));
    System.out.println(hasPermutationPalindrome("livci"));

    System.out.println(hasPermutationPalindrome(""));
    System.out.println(hasPermutationPalindrome("asddsa"));
    System.out.println(hasPermutationPalindrome("adsdsa"));
    System.out.println(hasPermutationPalindrome("gadsdsaz"));
    System.out.println(hasPermutationPalindrome("adsadssdasda"));
    System.out.println(hasPermutationPalindrome("assadssddada"));
  }
}
