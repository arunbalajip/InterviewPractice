/*
Given an array of integers, and a number 'sum', find the pairs of integers in the array whose sum is equal to 'sum'.

Examples:
Input  :  arr[] = {}, sum = 0
Output :  ()

Input  :  arr[] = {1,1}, sum = 0
Output :  ()

Input  :  arr[] = {1,1}, sum = 2
Output :  (1,1)

Input  :  arr[] = {1,1,1,1}, sum = 2
Output :  ((1,1),(1,1))

Input  :  arr[] = {1,1,1,1,1}, sum = 2
Output :  ((1,1),(1,1))

Input  :  arr[] = {-2,-1,0,1,2}, sum = 0
Output :  ((-2,2),(-1,1))

Input  :  arr[] = {-2,2,-1,1,0}, sum = 0
Output :  ((-2,2),(-1,1))

*/
!map.containskey(arr[i])
Map => sum-arr[i],i
else
print map.get(arr[i]),i
map.remove(arr[i])

Class PairOfInteger{
private Map<Integer,Integer> sumMap = new HashMap<>();
private List<List<Integer>> findPairOfIntegerInSum(int [] arr, int sum){
    if(arr == null) throw new Exception("Input array is null");
    List<List<Integer>> output = new ArrayList<ArrayList<>>();
    for(int i=0; i<arr.length; i++){    
        if(!sumMap.containsKey(arr[i]){ // Array[arr[i]] == DEFAULT_VALUE
           sumMap.put(sum-arr[i],i);
        }else{
           List<Integer> subList = new ArrayList<>();
          subList.add(arr[sumMap.get
          
          )]);
          subList.add(arr[i]);
          output.add(subList);
          sumMap.remove(arr[i]);
        }
    }
    return output;
}
}



Class PairOfInteger{
private Set<Integer> sum = new HashSet<>();
private List<List<Integer>> findPairOfIntegerInSum(int [] arr, int sum){
    if(arr == null) throw new Exception("Input array is null");
    List<List<Integer>> output = new ArrayList<ArrayList<>>();
    for(int i=0; i<arr.length; i++){    
        if(!sumSet.contains(sum-arr[i]){
           sumSet.put(arr[i]);
        }else{
          List<Integer> subList = new ArrayList<>();
          subList.add(sum-arr[i]);
          subList.add(arr[i]);
          output.add(subList);
          sumSet.remove(sum-arr[i]);
        }
    }
    return output;
}
}

Map<Integer, Integer> map = new HashMap<>();
for (int i : arr) {
  map.put(i, map.getOrDefault(i, 0) + 1);
}
List<List<Integer>> results = new ArrayList<>;
for (int key : map) {
  if (map.get(key) > 0 && map.getOrDefault(sum-key) > 0) {
    if ((key == sum - key) && (map.get(key) < 2)) continue;
    List<Integer> result = new ArrayList<>();
    result.add(key);
    result.add(sum-key);
    results.add(result);
    map.put(key, map.get(key)-1);
    map.put(key, map.get(sum-key)-1);
  }
}
return results;
