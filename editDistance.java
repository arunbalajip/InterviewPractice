/*
        Suppose we have  a string x of length n and a string y of length m, 
        and we want to find the edit distance between x and y. 
        
        we here have a function editDistance(a,b) that gives the edit distance between prefixes x[0...a] and y[0...b].
         Thus, using this function, the edit distance between x and y equals editDistance(n−1,m−1).
          We can calculate values of distance as follows: 
                        editDistance(a,b)=min(editDistance(a,b−1)+1, editDistance(a−1,b)+1, editDistance(a−1,b−1)+cost(a,b)) 
                        
                        Here cost(a,b) = 0 if x[a] = y[b], and otherwise cost(a,b) = 2(remove old charcter and add new one). 
                        
          The formula considers the following ways to edit the string x: 
                • distance(a,b−1): insert a character at the end of x 
                • distance(a−1,b): remove the last character from x 
                • distance(a−1,b−1): match or modify the last character of x            
        */
  
public static int editDistance(String source, String target) {
        int n1=source.length(), n2=target.length();
        int ans = Integer.MAX_VALUE ;
        char[] sourceArray = source.toCharArray();
        char[]  targetArray= target.toCharArray();
        for(int k=0; k<26; k++){
             int[][] dp = new int[n1+1][n2+1];
                for(int i=0; i<=n2; ++i) dp[0][i]=i;
                for(int j=0; j<=n1; ++j) dp[j][0]=j; 
                for(int j=0; j<n1; j++){
                        sourceArray[j] = (char)((sourceArray[j]-'a'+1)%26 + 'a');
                }
                int c;
                for(int i=1; i<=n1; ++i){
                        for(int j=1; j<=n2; ++j){
                            c=(sourceArray[i-1]==targetArray[j-1])?0:2; 
                            dp[i][j]=Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+c);
                        }
                }
                ans = Math.min(ans, dp[n1][n2]);
        }
        return ans;
    }
