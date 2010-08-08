/*
ID: huntca2
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
  public static void main (String args[]) throws Exception{
    Scanner scan = new Scanner(new File("gift1.in"));
    int np = scan.nextInt();

    String order[] = new String[np];
    HashMap people = new HashMap();
    for(int i = 0; i < np; i++){
      String person = scan.next();
      people.put(person, 0);
      order[i] = person;
    }

    for(int i = 0; i < np; i++){
      String thisPerson = scan.next();
      System.out.println("NAME: " + thisPerson);

      int walletSize = scan.nextInt();
      System.out.println("MONEY: " + walletSize);

      int numOfGifts = scan.nextInt();
      System.out.println("GIFTS: " + numOfGifts);

      int giftSize = 0;
      if (numOfGifts > 0)
        giftSize = walletSize/numOfGifts;
      System.out.println("GIFT SIZE: " + giftSize);

      people.put(thisPerson, (Integer.parseInt(people.get(thisPerson).toString()) - (giftSize * numOfGifts)));
      System.out.println("MONEY LEFT IN WALLET: " + people.get(thisPerson));
      if (numOfGifts > 0)
        System.out.println("----- Giving Gifts -----");
      for(int j = 0; j < numOfGifts; j++){
        String giftReciever = scan.next();
        System.out.println("RECIEVER: " + giftReciever);

        people.put(giftReciever, (Integer.parseInt(people.get(giftReciever).toString()) + giftSize));
        System.out.println("AMOUNT: " + giftSize);
        System.out.println("TOTAL WALLET: " + people.get(giftReciever));
      }
      System.out.println();
    }

    FileWriter out = new FileWriter(new File("gift1.out"));
    System.out.println("----- TOTALS -----");
    for(int i = 0; i<np; i++){
      String name = order[i];
      int money = Integer.parseInt(people.get(order[i]).toString());
      out.write(name + " " + money + "\n");
      System.out.println(name + " " + money);
    } 

    out.close();

    System.exit(0);
  }
}
