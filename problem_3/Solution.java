/*
  The prime factors of 13195 are 5, 7, 13 and 29.
  What is the largest prime factor of the number 600851475143
*/
class Solution {
  private static Long max = 600851475143L;
  public static void main(String[] args) {
    System.out.println(tailDivision());
  }

  public static int tailDivision() {
    Integer n_sq = (int) Math.sqrt(max);
    Long value = max;
    int maxPrime = 1;
    int i = 2;
    while(i < n_sq) {
      if(value % i == 0) {
        value = value / i;
        while(value % i ==0) {
          value = value / i;
        }
        maxPrime = i;
      }
      if(i>=3) {
        i += 2;
      } else {
        i++;
      }
    }
    return maxPrime;
  }
}
