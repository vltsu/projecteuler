object Solution {
  def main(args: Array[String]) {
    println(getLargestPalindrome());
    println(counter);
  }

  var counter = 0;

  def getLargestPalindrome(): Int = {
    var largestPalindrome:Int = 0;
    var a = 999;
    var b = 0;
    var product = 0;
    while(a>100) {
      b = a;
      while(b>100) {
        product = a*b;
        counter += 1;
        if (product < largestPalindrome) b=1; // instead of break
        if(isPalindrome(product)) {
          if(product > largestPalindrome) largestPalindrome = product;
        }
        b -= 1;
      }
      a -= 1;
    }
    largestPalindrome;
  }

  def isPalindrome(number:Int): Boolean = {
    number == reverseNumber(number);
  }

  def reverseNumber(number:Int): Int = {
    var reversedNumber = 0;
    var nnumber = number;
    while(nnumber != 0) {
      reversedNumber = (nnumber % 10) + (reversedNumber * 10);
      nnumber /= 10;
    }
    reversedNumber;
  }
}
