package practice;

public class practice {
    public static void main(String[] args) {
        // printName(0, 5);
        // printNum(1, 6);
        // printNumRev(5);
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

