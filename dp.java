import java.util.*;


public class dp {
   /*q1 You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
*/
   

    //main function
    public static void main(String[] args) {
    int[] a={1,100,1,1,1,100,1,1,100,1};
    int ans=minCostClimbingStairs(a);
        System.out.println(ans);

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
}//end of dp class
