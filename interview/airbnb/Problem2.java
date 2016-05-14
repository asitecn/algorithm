// https://coderpad.io/444HZW42

import java.io.*;
import java.util.*;

/*
 Host Crowding

You are given an array of csv strings indicating search results.
Each has a host_id, listing_id, score, and city.  Initially, results
are sorted by highest score.

We’d like to display these search results on a web page.  Write a function
that returns groups of listings to be displayed on each page.  However,
note that a given host may have several listings that show up in the results.
Reorder the list so that a host shows up at most once on a page if possible,
but otherwise preserves the ordering.

Your program should return the new array and print out the results in
blocks representing the pages.


Input:
*  An array of csv strings, with sort score
*  number of results per page

*/

class Problem2 {
  
  public static List<List<String>> showPage(List<String> input, int PER_PAGE) {
    Set<String> set = new HashSet<>();
    Queue<String> leftover = new LinkedList<>();
    
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();      
    
    int count = 0;
    int index = 1;
    while(index < input.size()) {
      Iterator<String> iter = leftover.iterator();
      while(iter.hasNext()) {
        String leftoverStr = iter.next();
        if (count < PER_PAGE) {
          String hostId = leftoverStr.split(",")[0];
          if (!set.contains(hostId)) {
            path.add(leftoverStr);
            set.add(hostId);
            iter.remove();
            count++;
          }
        } else {
          break;
        }
      }
      for(; index < input.size(); index++) {        
        // continue to fill from main array
        String str = input.get(index);
        String hostId = str.split(",")[0];
        
        if (!set.contains(hostId)) {
          set.add(hostId);
          path.add(str);
          count++;
          if (count == PER_PAGE) {
            break;
          }
        } else {
          leftover.offer(str);
        }
      }
      if (count == PER_PAGE || index == input.size()) {
        // filled
        res.add(path);
        path = new ArrayList<String>();
        set = new HashSet<>();
        count = 0;
      }
    }
    
    return res;
  }
  
  public static void main(String [] args) {
    int PER_PAGE = 12;

    ArrayList<String> input = new ArrayList<String>();
    input.add("host_id,listing_id,score,city");
    input.add("1,28,300.1,San Francisco");
    input.add("4,5,209.1,San Francisco");
    input.add("20,7,208.1,San Francisco");
    input.add("23,8,207.1,San Francisco");
    input.add("16,10,206.1,Oakland");
    input.add("1,16,205.1,San Francisco");
    input.add("6,29,204.1,San Francisco");
    input.add("7,20,203.1,San Francisco");
    input.add("8,21,202.1,San Francisco");
    input.add("2,18,201.1,San Francisco");
    input.add("2,30,200.1,San Francisco");
    input.add("15,27,109.1,Oakland");
    input.add("10,13,108.1,Oakland");
    input.add("11,26,107.1,Oakland");
    input.add("12,9,106.1,Oakland");
    input.add("13,1,105.1,Oakland");
    input.add("22,17,104.1,Oakland");
    input.add("1,201,105.1,Oakland");
    input.add("1,202,104.1,Oakland");
    input.add("1,203,103.1,Oakland");
    input.add("28,24,102.1,Oakland");
    input.add("18,14,11.1,San Jose");
    input.add("6,25,10.1,Oakland");
    input.add("19,15,9.1,San Jose");
    input.add("3,19,8.1,San Jose");
    input.add("3,11,7.1,Oakland");
    input.add("27,12,6.1,Oakland");
    input.add("1,3,5.1,Oakland");
    input.add("25,4,4.1,San Jose");
    input.add("5,6,3.1,San Jose");
    input.add("29,22,2.1,San Jose");
    input.add("30,23,1.1,San Jose");
    
    
    List<List<String>> res = showPage(input, PER_PAGE);
    for(List<String> path : res) {
      for(String str : path) {
        System.out.println(str);
      }
      System.out.println("------------");
      System.out.println();

    }
  }
}


