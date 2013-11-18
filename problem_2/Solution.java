/*
    Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
*/
class Solution {
  public static void main(String[] args) {
    System.out.printf("Checking number to even method result: %d \n", bruteForce(1,1));
    System.out.printf("Golden ratio method result is: %d\n", goldenRatio());
    System.out.printf("Every third member method result is: %d\n", everyThird());
  }

  private static int limit = 4000000;
  private static float phi = 1.6180339887F;

  public static int bruteForce(int prev, int next) {
    int summ = 0;
    int nnext = prev + next;
    if(nnext > limit) return 0;
    if(nnext % 2 == 0) summ += nnext;
    summ += bruteForce(next, nnext);
    return summ;
  }

  public static int goldenRatio() {
    int value = 2;
    int summ = 0;
    while(value<limit) {
      summ += value;
      value = (int) Math.round(value * Math.pow(phi, 3));
    }
    return summ;
  }

  public static int everyThird() {
    int a = 1;
    int b = 1;
    int c = a + b;
    int summ = 0;
    while(c < limit) {
      summ += c;
      a = c + b;
      b = a + c;
      c = a + b;
    }
    return summ;
  }
}
