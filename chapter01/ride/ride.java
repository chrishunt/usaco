/*
ID: huntca2
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

public class ride {
  public static void main (String args[]) throws Exception {
    Scanner scan = new Scanner(new File("ride.in"));
    char comet[] = scan.nextLine().trim().toCharArray();
    char group[] = scan.nextLine().trim().toCharArray();

    int cometValue = 1;
    for (char c : comet){
      cometValue *= ((int)c - 64);
    }

    int groupValue = 1;
    for (char c : group){
      groupValue *= ((int)c - 64);
    }
    
    FileWriter out = new FileWriter(new File("ride.out"));
    if ((cometValue % 47) == (groupValue % 47))
      out.write("GO\n");
    else
      out.write("STAY\n");

    out.close();

    System.exit(0);
  }
}
