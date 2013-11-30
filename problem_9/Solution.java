/*
  A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

  a2 + b2 = c2
  For example, 32 + 42 = 9 + 16 = 25 = 52.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc.
*/
class Solution {

  public static int callCounter = 0;

  public static void main(String[] args) {
     System.out.println(bruteForce());
//    int[] parentTriple = new int[3];
//    parentTriple[0] = 3;
//    parentTriple[1] = 4;
//    parentTriple[2] = 5;
//    assert(tripleSumm(parentTriple) == 12);
//    generatePythagoreanTriples(parentTriple);
//    System.out.printf("Calls count: %d\n", callCounter);
  }

  public static int bruteForce() {
    int e = 1000;
    int a = 0;
    int b = 0;
    int c = 0;
    // a<e/3, b<e/2
    for(a=1; a<e/3; a++) {
      for(b=a; b<e/2; b++) {
        c = e - a - b;
        if(a*a + b*b == c*c) {
          break;
        }
      }
      if(a*a + b*b == c*c) break;
    }
    System.out.printf("a: %d , b: %d, c: %d\n", a,b,c);
    return a * b * c;
  }

  public static void generatePythagoreanTriples(int[] triple) {
    callCounter++;
    int[] t1 = t1(triple);
    int[] t2 = t2(triple);
    int[] t3 = t3(triple);
    int t1Summ = tripleSumm(t1);
    int t2Summ = tripleSumm(t2);
    int t3Summ = tripleSumm(t3);
    if(t1Summ == 1000) System.out.printf("a: %d, b: %d, c: %d", t1[0], t1[1], t1[2]);
    if(t2Summ == 1000) System.out.printf("a: %d, b: %d, c: %d", t2[0], t2[1], t2[2]);
    if(t3Summ == 1000) System.out.printf("a: %d, b: %d, c: %d", t3[0], t3[1], t3[2]);
    if(t1Summ > 1000 && t2Summ > 1000 && t3Summ > 1000) return;
    generatePythagoreanTriples(t1);
    generatePythagoreanTriples(t2);
    generatePythagoreanTriples(t3);
  }

  public static int tripleSumm(int[] triple) {
    int result = 0;
    for(int i:triple) { result += i; }
    return result;
  }

  public static int[] t1(int[] triple) {
    int a = triple[0];
    int b = triple[1];
    int c = triple[2];
    int[] result = new int[3];
    result[0] = a - 2*b + 2*c;
    result[1] = 2*a - b + 2*c;
    result[2] = 2*a - 2*b + 3*c;
    return result;
  }

  public static int[] t2(int[] triple) {
    int a = triple[0];
    int b = triple[1];
    int c = triple[2];
    int[] result = new int[3];
    result[0] = a + 2*b + 2*c;
    result[1] = 2*a + b + 2*c;
    result[2] = 2*a + 2*b + 3*c;
    return result;
  }

  public static int[] t3(int[] triple) {
    int a = triple[0];
    int b = triple[1];
    int c = triple[2];
    int[] result = new int[3];
    result[0] = -a +2*b + 2*c;
    result[1] = -2*a + b + 2*c;
    result[2] = -2*a + 2*b + 3*c;
    return result;
  }
}
