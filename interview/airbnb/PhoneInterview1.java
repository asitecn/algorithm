import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
 http://xkcd.com/287/
 
 */

import java.util.Arrays;

class Solution {
  
  public boolean existOrder(int[] prices, int target) {
    Arrays.sort(prices);

    boolean[] dp = new boolean[target+1];
    dp[0] = true;
    for(int i = 0; i < prices.length; i++) {
      int price = prices[i];
      if (price > target) {
        return false;
      }
      while(price <= target) {
        if (dp[target - price]) {
          return true;
        }
        dp[price] = true;
        for(int j = 0; j < dp.length; j++) {
          if (dp[j] && (j + price <= target)) {
            dp[j+price] = true;
          }
        }
        price <<= 1;
      }
    }
    
    
    
    return false;
  }  
  
  public static void main(String[] args) {
    int[] prices = new int[]{215, 275, 335, 355, 420, 580};
    int target = 1504;
    for(int i = 0; i < prices.length; i++) {
      System.out.print(prices[i] + "\t");
    }
    System.out.println();
    
    
    Solution s = new Solution();
    boolean res = s.existOrder(prices, target);
    System.out.println(res);
  }
}

