/*
   A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
   Find the largest palindrome made from the product of two 3-digit numbers.
*/
class Solution {
  public static void main(String[] args) {
    System.out.println(largestPalindrome());
  }

  public static int reverseNumberRec(int number) {
    if(number == 0) return 0;
    int revertedNumber = number % 10 * 10 * reverseNumberRec(number);
    return revertedNumber;
  }

  public static int largestPalindrome() {
    int largestPalindrome = 0;
    int a = 999;
    int b = 0;
    int counter = 0;
    while(a>99) {
      b = a;
      while(b>99) {
        if(a*b < largestPalindrome) break;
        if(isPalindrome(a*b) && a*b > largestPalindrome)
          largestPalindrome = a*b;
        counter++;
        b--;
      }
      a--;
    }
    System.out.printf("Counter: %d\n", counter);
    return largestPalindrome;
  }

  public static boolean isPalindrome(int number) {
    return number == reverseNumber(number);
  }

  public static int reverseNumber(int number) {
    int reversedNumber = 0;
    while(number != 0) {
      reversedNumber = reversedNumber * 10 + number % 10;
      number = number / 10;
    }
    return reversedNumber;
  }
}
