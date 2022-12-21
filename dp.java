import java.util.*;


public class dp {
   

    //main function
    public static void main(String[] args) {
    int[] a={1,100,1,1,1,100,1,1,100,1};
    int ans=minCostClimbingStairs(a);
        System.out.println(ans);

    }//end of void main function
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
}//end of dp class