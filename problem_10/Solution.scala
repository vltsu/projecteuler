import scala.collection.mutable.ListBuffer

object Solution {
  def main(args: Array[String]) {
    println(sumPrimes(2000000))
  }

  def sumPrimes(limit:Int): Long = {
    var sum = 0L;
    eratosthenesSievePrimes(limit).foreach(sum += _)
    sum
  } 

  def eratosthenesSievePrimes(limit:Int):ListBuffer[Int] = {
    var sieve = Array.fill[Boolean](limit+1)(true)
    val sqRt = scala.math.sqrt(limit).toInt
    for(k <- 2 to limit by 2) {
      sieve(k) = false
    }
    for(k <- 3 to sqRt by 2) {
      var j = 3
      while(j*k < limit) {
        sieve(k*j) = false
        j += 2
      }
    }
    var result = new ListBuffer[Int]
    result += 2
    for(i <- 3 to limit) {
      if(sieve(i)) result += i
    }
    result
  }
}
