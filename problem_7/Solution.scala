object Solution {
  def main(args: Array[String]) {
    tests()
    println(nPrime(10001))
  }

  def tests() = {
    assert(isPrime(1) == false)
    assert(isPrime(2) == true)
    assert(isPrime(4) == false)
    assert(isPrime(5) == true)
    assert(isPrime(8) == false)
    assert(isPrime(22) == false)
    assert(isPrime(29) == true)
  }

  def nPrime(number:Int): Int = {
    var primeCounter = 1
    var i = 1
    var nprime = 0
    do {
      if(isPrime(i)) {
        primeCounter += 1
        nprime = i
      }
      i += 2
    } while (primeCounter != number)
    nprime
  }

  def isPrime(n:Int): Boolean = {
    if(n==1) return false
    if(n==2) return true
    if(n%2 ==0) return false

    val sqRt = scala.math.sqrt(n).toInt
    var i = 3
    while(i<=sqRt) {
      if(n%i == 0) return false
      i += 2
    }
    return true
  }
}
