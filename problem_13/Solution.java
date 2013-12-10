/*
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

37107287533902102798797998220837590246510135740250
46376937677490009712648124896970078050417018260538
74324986199524741059474233309513058123726617309629
91942213363574161572522430563301811072406154908250
23067588207539346171171980310421047513778063246676
...

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

class Solution {
  public static void main(String[] args) {
    firstTenDigitsOfSumm(readDataFromFile());
  }

  public static void firstTenDigitsOfSumm(String[] numbers) {
    Long summ = 0L;
    for(String number : numbers) {
      summ += Long.parseLong(number.substring(0,11));
    }
    System.out.println(summ.toString().substring(0,10));
  }

  public static String[] readDataFromFile() {
    BufferedReader br = null;
    String[] result = new String[100]; 
    try {
      br = new BufferedReader(new FileReader("file_with_numbers.txt"));
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      int i = 0;
      while (line != null) {
        result[i] = line;
        line = br.readLine();
        i++;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (br != null) br.close();
      } catch(IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  } 
}
