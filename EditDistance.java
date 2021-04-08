//https://www.chegg.com/homework-help/questions-and-answers/given-two-strings-source-target-length-n-consisting-lowercase-english-letters-find-minimum-q54963738
  
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
