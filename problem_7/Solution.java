/*
   By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
   What is the 10 001st prime number?
*/

class Solution {
  public static void main(String[] args) {
    assert(isPrime(2) == true);
    assert(isPrime(3) == true);
    assert(isPrime(4) == false);
    assert(isPrime(5) == true);

    System.out.println(nPrime(10001));
  }

  public static int nPrime(int n) {
    int primesCounter = 1;
    int i = 1;
    int largest_prime = 0;
    while(primesCounter != n) {
      if(isPrime(i)) {
        primesCounter++;
        largest_prime = i;
      }
      i+=2;
    }
    return largest_prime;
  }

  public static boolean isPrime(int number) {
    if (number ==1) return false;
    if (number ==2) return true;
    if (number % 2 == 0) return false;
    int sq_rt = (int) Math.sqrt(number);
    int i = 3;
    while(i<=sq_rt) {
      if (number % i == 0) return false;
      i += 2;
    }
    return true;
  }
}
