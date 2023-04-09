// PalmerPenguins.java
// W. Geesey
// 01/15/2023
// Program to introduce the Palmer Penguin Species.

public class PalmerPenguins {
   
// Variables to represent the penguin species and the numer of species in the dataset.
   public static final int NUMBER_OF_SPECIES = 3;
   public static final String SPECIES_CHINSTRAP = "Chinstrap";
   public static final String SPECIES_GENTOO = "Gentoo";
   public static final String SPECIES_ADELIE = "Adelie";
     
   public static void main(String[] args) {
      System.out.println("Introducing the Palmer Penguins:");
      System.out.printf("%16s", SPECIES_CHINSTRAP + "!\n");
      System.out.printf("%13s", SPECIES_GENTOO + "!\n");
      System.out.println("and last but not least...");
      System.out.printf("%13s", SPECIES_ADELIE + "!\n");
      System.out.println("There are a total of " + NUMBER_OF_SPECIES + 
                         " penguin species in this dataset.");
   }
}