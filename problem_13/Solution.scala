object Solution {
  def main(args: Array[String]) {
    println(firstTenNumbersOfSum(readDataFromFile))
  }

  def firstTenNumbersOfSum(numbers : Array[String]): String = {
    numbers.map(_.substring(0,11).toLong).sum.toString.substring(0,10)
  }

  def readDataFromFile(): Array[String] = {
    val lines = scala.io.Source.fromFile("file_with_numbers.txt").getLines
    var result = new Array[String](100)
    var x = 0;
    for(line <- lines) {
      result(x) = line
      x+=1
    }
    result
  }
}
