object Solution {
  def main(args: Array[String]) {
    bruteForce();
  }

  def bruteForce() = {
    // a < 1000/3, b < 1000/2
    var c = 0;
    for(a <- 1 to 333) {
      for(b <- a to 500) {
        c = 1000 - a - b;
        if(a*a + b*b == c*c) {
          printf("result found: a = %d, b = %d, c = %d\n", a, b, c);
        }
      }
    }
  }
}
