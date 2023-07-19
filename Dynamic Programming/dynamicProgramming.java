public class dynamicProgramming{
    public static void main(String[] args) {
        System.out.println(fibonacci(10, new int[55+1]));
    }

    static int fibonacci(int n, int[] dp){
        if(n<2){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int fib1 = fibonacci(n-1, dp);
        int fib2 = fibonacci(n-2, dp);
        int fibn = fib1 + fib2;

        dp[n] = fibn;
        return fibn;
    }
}