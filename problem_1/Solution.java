/*
  If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
  Find the sum of all the multiples of 3 or 5 below 1000.
*/
class Solution {

  private static Integer i = 999;

  public static void main(String[] args) {
    Integer sumDivBy3 = sumDivisibleBy(3);
    Integer sumDivBy5 = sumDivisibleBy(5);
    Integer sumDivBy15 = sumDivisibleBy(15);
    System.out.printf("Results is %d", sumDivBy3 + sumDivBy5 - sumDivBy15);
  }

  // if n = 5, then summ = 5 + 10 + 15 + ... + 995
  // it's equals to 5 * (1+2+3+4+...+199)
  // 1+2+3+4+...+p = 1/2 * p * (p+1)
  // so final result would be n * 1/2 * p * (p+1)
  public static Integer sumDivisibleBy(Integer n) {
    Integer p = i / n;
    return n * (p * (p+1)) / 2;
  }
}
