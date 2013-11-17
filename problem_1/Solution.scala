object Solution {
  private val i = 999;
  def main(args: Array[String]) {
    printf("Scala: Result is %d", sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15));
  }
  def sumDivisibleBy(n: Int): Int = {
    val p = i / n;
    n * (p*(p+1)) / 2;
  }
}
