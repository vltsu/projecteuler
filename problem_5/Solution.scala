import scala.collection.mutable.ListBuffer;

object Solution {
  def main(args: Array[String]) {
    println(numberToPrimes(20))
    println(mergeArrays(ListBuffer(2,2,3), ListBuffer(2,2)))
    println(getSmallestNumberDivisibleBySeries())
  }

  def getSmallestNumberDivisibleBySeries() = {
    var result = new ListBuffer[Int]
    var multipliers = new ListBuffer[Int]

    for (i <- 0 until 20) {
      multipliers = numberToPrimes(i)
      result = mergeArrays(multipliers, result)
    }
    var resultNumber = 1
    for (ii <- result) {
      resultNumber *= ii
    }
    resultNumber
  }

  def mergeArrays(a:ListBuffer[Int], b:ListBuffer[Int]) = {
    var result = new ListBuffer[Int]
    var index = 0
    var aa = a
    var bb = b
    for (el <- aa) {
      if(bb.indexOf(el) >= 0) {
        bb.remove(bb.indexOf(el))
      }
      result += el
      aa.remove(aa.indexOf(el))
    }
    result ++ bb
  }

  def numberToPrimes(number:Int) = {
    var result = new ListBuffer[Int]
    var nnumber = number
    var i = 2
    while(i<=number) {
      if(nnumber % i == 0) {
        while(nnumber % i ==0) {
          nnumber /= i
          result += i
        }
      }
      i += 1
    }
    result
  }
}
