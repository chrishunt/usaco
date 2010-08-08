/*
ID: huntca2
LANG: JAVA
TASK: test
 */

import java.util.*;
import java.io.*;

public class test {
  public static void main (String args[]){
    Scanner scan = null;
    try{
      scan = new Scanner(new File("test.in"));
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
    
    int i = 0;
    while(scan.hasNext()){
      i += scan.nextInt();
    }

    try{
      FileWriter writer = new FileWriter(new File("test.out"));
      writer.write(i+"\n");
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

