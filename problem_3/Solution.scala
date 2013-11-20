object Solution {
  private val max = 600851475143L;
  private val n_sq = scala.math.sqrt(max).toInt;

  def main(args: Array[String]) {
    printf("Scala: max prime is: %d\n", tailDivision());
  }

  def tailDivision(): Int = {
    var value:Long = max;
    var maxPrime:Int = 1;
    var i:Int = 2;
    while(i<n_sq) {
      if(value % i == 0) {
        value /= i;
        while(value % i == 0) {
          value /= i;
        }
        maxPrime = i;
      }
      if(i>=3) {
        i += 2;
      } else {
        i += 1;
      }
    }
    maxPrime;
  }
}
