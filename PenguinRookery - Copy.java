// PenguinRookery.java
// W. Geesey
// 02/20/2023
// Class representing a Penguin Rookery with different penguin species.

package edu.fscj.cop2800c.penguins;

import java.util.Arrays;
import edu.fscj.cop2800c.table.TableFormatter;
 
public class PenguinRookery implements TableFormatter {

   // Constant for the number of Penguin Species in the rookery.
   public static final int MAX_PENGUINS = 1000;
   
   // Array instance variable to hold the array passed to the constructor.
   private Penguin[] penguins;
   
   // Default constructor.
   public PenguinRookery() { }
   
   // Overloaded constructor.
   public PenguinRookery(int penguinCount, Penguin[] penguins) {
        this.penguins = new Penguin[penguinCount];
        for (int count = 0; count < penguinCount; count++) {
            this.penguins[count] = penguins[count];
        }
   }
   
   // toString
   @Override
   public String toString() {
        
        String retString = "Our rookery contains the following penguins:\n";
        
        for (int penguinCount = 0; penguinCount < this.penguins.length; 
             penguinCount++)
               retString += this.penguins[penguinCount] + "\n";

        return retString;
   }
   
   // return contents in tabular format
    public String table() {
      final String DATAFORMAT = "%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n";
      
      // Header
      String retString = "Palmer Penguin Rookery:\n";
      
      // Data Headers
      retString += String.format(DATAFORMAT, "SampleNum", "Species", "CulmenLen",
                                "CulmenDepth", "FlipperLen", "BodyMass", "Sex");
      
      // Data
      for (int penguinCount = 0; penguinCount < this.penguins.length; 
             penguinCount++) {
             
           String penguinStr = String.format(DATAFORMAT, this.penguins[penguinCount].getSampleNum(),
                           this.penguins[penguinCount].getSpecies(),
                           this.penguins[penguinCount].getCulmenLen(),
                           this.penguins[penguinCount].getCulmenDepth(),
                           this.penguins[penguinCount].getFlipperLen(),
                           this.penguins[penguinCount].getBodyMass(),
                           this.penguins[penguinCount].getSex());
           retString += penguinStr;
      }
      
      return retString;
    }

   public static void main(String[] args) {
      
        String[][] inputArray = PenguinReader.read(MAX_PENGUINS);
       
       // Creating an empty array to store the maximum specified elements
       Penguin[] penguinArray = new Penguin[MAX_PENGUINS];
       int penguinCount = 0;
       
       // Fill array with elements up to the number read 
       for (int rows = 1; rows < MAX_PENGUINS && inputArray[rows][0] != null; rows++) {
       
            Integer newSampleNum = Integer.parseInt(inputArray[rows][0]);
            PenguinSpecies newSpecies = PenguinSpecies.parseSpecies(inputArray[rows][1]);
            Double newCulmenLen = Double.parseDouble(inputArray[rows][2]);
            Double newCulmenDepth = Double.parseDouble(inputArray[rows][3]);
            Double newFlipperLen = Double.parseDouble(inputArray[rows][4]);
            Integer newBodyMass = Integer.parseInt(inputArray[rows][5]);
            Sex newSex = Sex.parseSex(inputArray[rows][6]);
       
            penguinArray[penguinCount++] = new Penguin(newSampleNum, newCulmenLen, 
                                                       newCulmenDepth, newBodyMass, 
                                                       newSex,newSpecies,newFlipperLen); 
       } 
      
       // Using the overloaded constructor to create our penguin rookery.
       PenguinRookery penRook = new PenguinRookery(penguinCount, penguinArray);
       
       // Tests for toString and equals.
       Penguin test1 = new Penguin(1400, 33.3, 15.1, 3800, Sex.F, PenguinSpecies.GENTOO, 200.4);
       Penguin test2 = new Penguin(1400, 33.3, 15.1, 3800, Sex.F, PenguinSpecies.GENTOO, 200.4);

      System.out.println("Penguin p1 and p2 == ? " + (test1 == test2)); 
//      System.out.println(test1);
//      System.out.println(test2);
      System.out.println("Penguin p1 and p2 equal ? " + test1.equals(test2));
        
      System.out.println(penRook);

       
       // Calling the table method to format output.
       System.out.println(penRook.table());

   }
}
