/*
  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

  Find the sum of all the primes below two million
*/

import java.util.*;

class Solution {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.printf("Eratoshthenes sieve solution: %d\n", primesSum(2000000));
    long endTime = System.currentTimeMillis();
    System.out.println("Eratosthenes sieve execution time: " + (endTime-startTime) + "ms");
    long startTime1 = System.currentTimeMillis();
    System.out.printf("Brute force solution: %d\n", bruteForcePrimesSumm(2000000));
    long endTime1 = System.currentTimeMillis();
    System.out.println("Brute forse solution execution time: " + (endTime1-startTime1) + "ms");
    tests();
  }
  
  public static void tests() {
    assert(isPrime(5) == true);
    assert(isPrime(678) == false);
  }
  
  /* The sieve of Eratosthenes solution */

  private static Long primesSum(int limit) {
    long result=0;
    for(int i: sieveOfEratosthenesPrimes(limit)) result += i;
    return result;
  }

  private static List<Integer> sieveOfEratosthenesPrimes(int limit) {
    boolean[] sieve = new boolean[limit+1];
    ArrayList<Integer> result = new ArrayList<>();
    int sqRt = (int) Math.sqrt(limit);
    int b = 2;
    sieve[1] = true; // 1 is not prime
    for(int m = 4; m < limit; m+=2) {
      sieve[m] = true;
    }
    for(int n = 3; n < sqRt; n+=2) {
      b = 2;
      while(b*n < limit) {
        sieve[n*b] = true;
	b++;
      }
    }
    for(int i = 1; i<limit; i++) {
      if(!sieve[i]) {
        result.add(i);
      }
    }
    return result;
  }

  /* Brute force solution */
  public static long bruteForcePrimesSumm(int limit) {
    long summ = 0L;
    int largestPrime = 0;
    for(int i=3; true; i+=2) {
      if(isPrime(i)) {
        if (i > limit) { return summ + 2; } 
        summ += i;
	largestPrime = i;
      }
    }
  }
  public static boolean isPrime(int number) {
    if (number == 1) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;
    if (number < 9) return true;
    int sqRt = (int) Math.sqrt(number);
    for(int i = 3; i <= sqRt; i+=2) {
      if(number % i == 0) return false;
    }
    return true;    
  }
}
