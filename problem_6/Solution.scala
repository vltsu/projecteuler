object Solution {
  def main(args: Array[String]) {
    println(solution(100))
  }

  def solution(n:Int): Int = {
    scala.math.pow(sumOfSeries(n),2).toInt - sumOfSquaresInSeria(n)
  }

  def sumOfSeries(n:Int) = {
    n*(n+1) / 2
  }

  def sumOfSquaresInSeria(n:Int) = {
    ((2*n + 1)*(n+1) * n) / 6
  }
}
