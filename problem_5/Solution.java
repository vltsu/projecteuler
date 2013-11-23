/*
  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

import java.util.*;

class Solution {
  public static void main(String[] args) {
    assert( numberToPrimes(20).equals(new ArrayList<Integer>() {{ add(2);add(2);add(5); }} ) );
    assert( numberToPrimes(19).equals(new ArrayList<Integer>() {{ add(19); }} ) );

    ArrayList<Integer> a1 = new ArrayList<Integer>() {{ add(2);add(2);add(3); }};
    ArrayList<Integer> a2 = new ArrayList<Integer>() {{ add(2);add(5);add(4); }};
    assert(mergeArrays(a1,a2).equals(new ArrayList<Integer>() {{ add(2);add(2);add(3);add(5);add(4); }} ) );

    System.out.println(getSmallestNumberDivisibleBySeries());
  }

  public static Integer getSmallestNumberDivisibleBySeries() {
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> multipliers = new ArrayList<Integer>();
    for(int i = 20; i > 1; i--) {
      multipliers = numberToPrimes(i);
      result = mergeArrays(multipliers, result);
    }
    Integer resultNumber = 1;
    for(Integer m : result) {
      resultNumber *= m;
    }
    return resultNumber;
  }

  public static ArrayList<Integer> mergeArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Integer temp = 0;
    int index = 0;
    Iterator<Integer> itr = a.iterator();
    while(itr.hasNext()) {
      temp = itr.next();
      itr.remove();
      index = b.indexOf(temp);
      if(index >= 0) {
        b.remove(index);
      }
      result.add(temp);
    }
    result.addAll(b);
    return result;
  }

  public static ArrayList<Integer> numberToPrimes(Integer number) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Integer a = 2;
    Integer max = number;
    while(a<=max) {
      if(number % a == 0) {
        while(number % a == 0) {
          result.add(a);
          number /= a;
        }
      }
      a++;
    }
    return result;
  }
}
