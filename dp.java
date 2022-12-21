import java.util.*;


public class dp {
   /*q1 You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
*/
   

    //main function
    public static void main(String[] args) {
    
    }//end of void main function
   
   //way 1
   //TABULATION
    public static int minCostClimbingStairs(int[] cost) {
        //now here we will find our final ans
            int n=cost.length;
            int[] dp=new int[n+1];
            //base case
            dp[0]=cost[0];
            dp[1]=cost[1];
            for(int i=2;i<n;i++){
                int single=dp[i-1]+cost[i];
                int two=dp[i-2]+cost[i];
                dp[i]=Math.min(single,two);
            }
            return dp[n-1];
        }
   
   
   //way 2 using memoization
    public static int minCostClimbingStairs(int[] cost) {
    //now here we will find our final ans
    //MEMOIZATION
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int mini=Integer.MAX_VALUE;
        return Math.min(f(n-1,cost,dp),f(n-2,cost,dp));
    }
    public static int f(int index,int[] cost,int[] dp){
        //base case
        if(index==0 || index==1){
            return cost[index];
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        //recurrence
        int single=f(index-1,cost,dp)+cost[index];
        int two=f(index-2,cost,dp)+cost[index];
        return dp[index]=Math.min(single,two);


    }
   
   //q2 Number of Subsets
   
   // WAY 1 MEMOIZATION
    public static int f(int i,int k,int[] num,int[][] dp){
        //base cases
        if(k==0){
            return 1;
        }
        if(i==0){
            return (num[i]==k)?1:0;
        }
         if(dp[i][k]!=-1){
             return dp[i][k];
         }  
        
        //two options
        int np=f(i-1,k,num,dp);
        int p=0;
        if(num[i]<=k){
            p=f(i-1,k-num[i],num,dp);
        }
        //when we have to count we sum all of th options
        return dp[i][k]=p+np;
    }
    // way 2 Tabulation
    public static int findWays(int num[], int k) {
       
        // Write your code here..
        int n=num.length;
        int[][] dp=new int[n][k+1];
        //handle base cases first
        for(int i=0;i<n;i++){
            //0th column of each row
            dp[i][0]=1;
        }
        //second base case
        if(num[0]<=k){
            dp[0][num[0]]=1;
        }
        //nested for loops
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                int np=dp[i-1][j];
                int p=0;
                if(num[i]<=j){
                    p=dp[i-1][j-num[i]];
                }
                dp[i][j]=p+np;
            }
        }
        return dp[n-1][k];
        }
}//end of dp class
