import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
 * Given N number of product ids, number of purchases in the last 6 months
 
 * 10087(iphone 7) - 800
 * 10098 (samsung galaxy s7) - 400
 * Find the k most purchased items.
 
 * 1-300, 2-100, 3-600,4-700 N=4
 * k= 2
 * 
 * Output = 4, 3
 
 */

class TopKProductIds {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");
    
    Map<Long, List<Long>> input = new HashMap<>();
    
    List<Long> purchases = new ArrayList<>(); 
    purchases.add(1L);
    input.put(300L, purchases);
    
    purchases = new ArrayList<>(); 
    purchases.add(2L);
    input.put(100L, purchases);

    purchases = new ArrayList<>(); 
    purchases.add(3L);
    input.put(600L, purchases);

    purchases = new ArrayList<>(); 
    purchases.add(4L);
    input.put(700L, purchases);

    for(long ids : getTopKProductIds(input, 2, 4)){
      System.out.println(ids);
    }
    
  }
  // object[] - 
  // map<PurchaseNumber,List<Product>>
  
  
  public static List<Long> getTopKProductIds(Map<Long, List<Long>> PurchaseToProductMap, int k, int N)  {
    Queue<Long> maxHeap = new PriorityQueue<>(N, Collections.reverseOrder());
    for(Long purchaseNumber: PurchaseToProductMap.keySet()){
      maxHeap.offer(purchaseNumber);
    }
    List<Long> purchaseNumberList = new ArrayList<>();
    if(N < k){
        return purchaseNumberList;
    }
    int i=0;
    while(i<k){
      Long purchaseNumber = maxHeap.poll();
      List<Long> productNumbers = PurchaseToProductMap.get(purchaseNumber);
      for(Long productNumber : productNumbers){
        if(i<k){
          purchaseNumberList.add(productNumber);
          i++;
        }else{
          return purchaseNumberList;
        }
      }
    }
      return purchaseNumberList;
  }
  
}


