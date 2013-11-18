object Solution {
  private val limit = 4000000;
  private val phi = 1.6180339887;

  def main(args: Array[String]) {
    printf("Scala: brute force method result is: %d\n", bruteForce(1,1));
    printf("Scala: golden ratio method result is: %d\n", goldenRatio());
    printf("Scala: every third method result is: %d\n", everyThird());
  }

  def bruteForce(prev: Int, next: Int): Int = {
    var summ:Int = 0;
    var nnext:Int = prev + next;
    if(nnext > limit) return 0;
    if(nnext % 2 == 0) {
      summ = nnext;
    }
    summ += bruteForce(next, nnext);
    summ;
  }

  def goldenRatio(): Int = {
    var summ:Int = 0;
    var n:Int = 2;
    while(n<limit) {
      summ += n;
      n = (n * scala.math.pow(phi,3)).round.toInt;
    }
    summ;
  }

  def everyThird(): Int = {
    var summ:Int = 0;
    var a = 1;
    var b = 1;
    var c = a+b;
    while(c<limit) {
      summ += c;
      a = c + b;
      b = a + c;
      c = a + b;
    }
    summ;
  }

}
