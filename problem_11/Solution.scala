object Solution {
  def main(args: Array[String]) {
    println(countMaxProduct())
  }

  def countMaxProduct():Int = {
    val data = readDataFromFile()
    var maxProduct = 0
    var product = 1
    // down direction
    for(i <- 0 until data.length-3) {
      for(j <- 0 until data(i).length) {
        product = 1
        for(k <- i until i+4) {
          product *= data(k)(i);
        }
        if (product > maxProduct) maxProduct = product
      }
    }

    // right direction
    for(i <- 0 until data.length) {
      for(j <- 0 until data(i).length-3) {
        product = 1
        for(k <- j until j+4) {
          product *= data(i)(k)
        }
        if(product > maxProduct) maxProduct = product
      }
    }

    // diagonal down-right
    for(i <- 0 until data.length-3) {
      for(j <- 0 until data.length-3) {
        product = 1
        for(k <- 0 until 4) {
          product *= data(i+k)(j+k)
        }
        if(product > maxProduct) maxProduct = product
      }
    }

    // diagonal down-left
    for(i <- 0 until data.length-3) {
      for(j <- 3 until data.length) {
        product = 1
        for(k <- 0 until 4) {
          product *= data(i+k)(j-k)
        }
        if(product > maxProduct) maxProduct = product
      }
    }
    maxProduct
  }

  def readDataFromFile(): Array[Array[Int]] = {
    val lines = scala.io.Source.fromFile("file_with_numbers.txt").getLines
    var result = new Array[Array[Int]](20)
    var x = 0;
    for(line <- lines) {
      result(x) = line.split(" ").map(_.toInt) 
      x+=1
    }
    result
  }
}
