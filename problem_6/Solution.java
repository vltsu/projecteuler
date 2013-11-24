/*
  The sum of the squares of the first ten natural numbers is,
  12 + 22 + ... + 102 = 385
  The square of the sum of the first ten natural numbers is,

  (1 + 2 + ... + 10)2 = 552 = 3025
  Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.

  Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

class Solution {
  public static void main (String[] args) {
    System.out.println(bruteForce(100));
    System.out.println(mathSolution(100));
  }

  public static int mathSolution(int n) {
    return (int) Math.pow(sumOfSeries(n),2) - sumOfSquares(n);
  }

  public static int bruteForce(int n) {
    int sumOfSquares = 0;
    int sum = 0;
    for(int i=1; i<=n;i++) {
      sumOfSquares += Math.pow(i,2);
      sum += i;
    }
    return (int) Math.pow(sum,2) - sumOfSquares;
  }

  public static int sumOfSeries(int n) {
    return (n * (n+1)) / 2;
  }

  public static int sumOfSquares(int n) {
    return ((2*n+1) * (n+1) * n)/6;
  }
}
