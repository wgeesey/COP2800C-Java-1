// LambaTester.java
// W. Geesey
// 4/2/2023
// Implements and tests SimpleDouble functional interface

import java.util.Arrays;
import java.util.ArrayList;

// Interface that returns doubled value of parameter d
interface SimpleDouble {

   double doubleValue(double d);
 
}

public class LambdaTester {

   public static void main(String[] args) {
   
      Double[] dArray = { 1.0, 1.5, 2.0, 2.5, 3.0, 10.0 };
      ArrayList<Double> dList = new ArrayList<>(Arrays.asList(dArray));
 
      SimpleDouble sd = val -> val * 2.0;
 
      for (int i = 0; i < dList.size(); i++) {
         Double d = dList.get(i);
         System.out.println("Double of " + d + ": " + sd.doubleValue(d));
      }
   }
}