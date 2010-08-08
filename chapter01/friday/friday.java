/*
ID: huntca2
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

public class friday{
  public static void main (String args[]) throws Exception {
    Scanner scan = new Scanner(new File("friday.in"));
    int years = scan.nextInt();
    
    // January 1, 1900 is a Monday
    int days[] = new int[7];
    int dayOfWeek = 2;

    for(int i = 0; i < days.length; i++)
      days[i] = 0;

    for(int i = 0; i < years; i++){
      int thisYear = 1900 + i;

      boolean leapYear = false;
      if (((thisYear % 4 == 0) && (thisYear % 100 != 0)) || ((thisYear % 100 == 0) && (thisYear % 400 == 0)))
        leapYear = true;
      
      // Start with January
      int month = 1;

      while(month <= 12){
        int daysInMonth = 31;
        if (month == 4 ||
            month == 6 ||
            month == 9 ||
            month == 11) {
          daysInMonth = 30;
        } else if (month == 2) {
          if (leapYear)
            daysInMonth = 29;
          else
            daysInMonth = 28;
        }

        // Iterate through month, add 13th to days[]
        for (int j = 1; j<daysInMonth+1; j++){
          if(j == 13)
            days[dayOfWeek] = days[dayOfWeek] + 1;
          if(dayOfWeek == 6)
            dayOfWeek = 0;
          else
            dayOfWeek++;
        }
        
        month++;
      }
    }
    
    FileWriter out = new FileWriter(new File("friday.out"));
    for(int i=0; i<days.length-1; i++){
      System.out.print(days[i] + " ");
      out.write(days[i] + " ");
    }
    System.out.println(days[days.length-1]);
    out.write(days[days.length-1] + "\n");

    out.close();
    System.exit(0);
  }
}
