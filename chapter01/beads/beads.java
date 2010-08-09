/*
ID: huntca2
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class beads{
  public static void main(String args[]) throws Exception{
    Scanner scan = new Scanner(new File("beads.in"));
    int numOfBeads = scan.nextInt();
    String[] beads = new String[numOfBeads];
    String necklace = scan.next();

    for(int i = 0; i < numOfBeads; i++){
      String nextBead = necklace.substring(i, i+1);
      beads[i] = nextBead;
    }

    int maxBeads = 0;

    for(int i = 0; i<numOfBeads; i++){
      int countForward = 1;
      int countBackward = 1;

      String beadColor = beads[i];
      int index = i + 1;
      if(index >= numOfBeads)
        index = index - numOfBeads;
      while((beadColor.equals(beads[index]) || beads[index].equals("w")) && (index != i)){
        countForward++;
        index++;
        if (index >= numOfBeads)
          index = index - numOfBeads;
      }
      
      System.out.println(countForward);

      int j = i-1;
      if(j < 0)
        j = j + numOfBeads;
      beadColor = beads[j];
      index = j - 1;
      if(index < 0)
        index = index + numOfBeads;
      while((beadColor.equals(beads[index]) || beads[index].equals("w")) && ((index != j) && (index))){
        countBackward++;
        index--;
        if (index < 0)
          index = index + numOfBeads;
      }

      System.out.println(countBackward);

      int totalBeads = countForward + countBackward;
      if(totalBeads > maxBeads)
        maxBeads = totalBeads;
    }

    FileWriter out = new FileWriter(new File("beads.out"));
    out.write(maxBeads + "\n");
    out.close();

    System.out.println(maxBeads);
    System.exit(0);
  }
}
