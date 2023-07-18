package practice;

public class practice {
    public static void main(String[] args) {
        // printName(0, 5);
        // printNum(1, 6);
        // printNumRev(5);
        // printDecInc(5);
        pzz(2);
    }

    static void pzz(int n){
        if(n==0) return;
        System.out.println("pre "+ n );
        pzz(n-1);
        System.out.println("in "+ n );
        pzz(n-1);
        System.out.println("post "+ n );
    }

    static int factorial(int n){

        int fact = factorial(n-1); // gives factorial of (n-1)
        int ans = n * fact; // multiply with n to make factorial of n 

        return ans;
    }



    static void printDecInc(int n){
        if(n==0) return;
        System.out.println(n);
        printDecInc(n-1);
        System.out.println(n);
    }


    // print something n times
    static void printName(int i,int n){
        if(i>=n){
            return;
        }
        System.out.println("hello");
        printName(i+1, n);
    }


    // print linearly from 1->N
    static void printNum(int i, int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        printNum(i+1, n);
    }


    // print from N->1
    static void printNumRev(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNumRev(n-1);
    }






}

