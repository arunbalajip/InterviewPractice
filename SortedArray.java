/*Given a sorted mXn matrix for integer on each row and column, and one target number N
Help me to find all pairs from the matrix, whose sum equal to the target number

1 2 6 7
2 5 8  8
4 7 9 11

For give 10, return <1,9> <2,8> <2,8> <4,6>
Integer can be duplicated at most twice, and can be used only once or twice in the final result

constant memory if could*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static List<int[]> FindAllPairTargetNum(int[][] matrix, int target){
        List<int[]> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
         
        for(int col=0; col<n; col++){
            for(int row=0; row<m; row++){
                int curr = matrix[row][col];
                if(curr>0){
                    int rem = target-curr;
                    for(int i=0; i<m; i++){
                        int[] bin = Search(matrix, rem, i);
                        if(bin == null || bin[0] == row && bin[1] == col)
                            continue;
                        result.add(new int[]{curr, matrix[bin[0]][bin[1]]});
                        matrix[bin[0]][bin[1]] = matrix[bin[0]][bin[1]] * -1;
                        matrix[row][col] = matrix[row][col] * -1;
                    }
                }
            }
        }
        return result;
    }
    static int[] Search(int[][] matrix, int rem, int rowIndex){
            
          int[] bin = binarySearchOnCol(matrix, rem, 0, matrix[0].length-1, rowIndex);
          if(bin == null)
            return null;
          int remElem = matrix[bin[0]][bin[1]];
          if(Math.abs(remElem) == rem){
              int [][] direction = new int[][] { {0, -1}, {0, 1}};
              for(int[] dir: direction){
                  int newRow = bin[0];
                  int newCol = bin[1] + dir[1];
                   if(newCol >0 && newCol < matrix.length)
                        if(matrix[newRow][newCol] == rem)
                            return new int[]{newRow, newCol};
              }
              if(remElem == rem)
                return bin;
          }
          return null;
    }
    
    static int[] binarySearchOnCol(int[][] matrix, int rem,  int low, int high, int row){
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int curr = Math.abs(matrix[row][mid]);
            if ( curr== rem)
                return new int[] {row, mid};
            else if(curr < rem)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    

 public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 6, 7 },
                         { 2, 5, 8,  8},
                         { 4, 7, 9, 11  } };
            
           
        List<int[]> pairs = FindAllPairTargetNum(matrix, 10);
        System.out.println(pairs.size());
            pairs.forEach(s-> System.out.println(Arrays.toString(s)));
   }
}
