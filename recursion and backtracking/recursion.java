// import java.util.Arrays;
import java.util.*;

public class recursion {
    static String[] codes = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        // printDecreasing(5);
        // printIncreasing(8);
        // System.out.println(factorial(5));
        // System.out.println(power(5, 3));
        // System.out.println(powerLog(5, 3)); 
        // pzz(2);
        // towerOfHanoi(3, 1, 2, 3);
        int [] arr = {1,2,3,4,4,4,5,5,5,5,6,7,8,9};
        // printArray(arr, 6);
        // printArrayRev(arr, 0);
        // System.out.println(maxOfArray(arr, 0));
        // System.out.println(fibonacci(50));
        // System.out.println(binarySearch(arr, 5, 0, arr.length-1));
        // System.out.println(firstIndexOccurence(arr, 0, 5));
        // System.out.println(lastIndexOccurence(arr, 0, 4));
        // System.out.println(Arrays.toString(allIndices(arr, 0, 5, 0)));
        // System.out.println(getSubSequence("abcdefc"));
        System.out.println(letterCombinations("567"));

    }


    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        return letterCombinationsHelper(digits);
    }

    static List<String> letterCombinationsHelper(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            ans.add("");
            return ans;
        }

        char ch = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> recRes = letterCombinationsHelper(ros);
        String chFromCodes = codes[ch - '2'];

        for (int i = 0; i < chFromCodes.length(); i++) {
            char chCode = chFromCodes.charAt(i);
            for (String m : recRes) {
                ans.add(chCode + m);
            }
        }

        return ans;
    }

    static ArrayList<String> getSubSequence(String str){

        if(str.length()==0){
            // empty string has a subsequence ""
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        // bc ->    [--,-c,b-,bc]
        // abc ->   [---,--c,-b-,-bc,a--,a-c,ab-,abc]
        char ch = str.charAt(0);//a
        //separating out starting charater and rest of string
        String restOfString = str.substring(1);//bc
        ArrayList<String> result = getSubSequence(restOfString); // bc ->    [--,-c,b-,bc]

        ArrayList<String> myResult = new ArrayList<>();
        for(String rstr:result){
            myResult.add(""+rstr);
        }
        for(String rstr:result){
            myResult.add(ch+rstr);
        }
        
        return myResult;
    }

    static int[] allIndices(int[] arr, int idx, int data, int foundSoFar){
        if(idx==arr.length){
            return new int[foundSoFar];
        }
        if(arr[idx]==data){
            int[]iarr = allIndices(arr, idx+1, data, foundSoFar+1);
            iarr[foundSoFar] = idx;
            return iarr;
        }else{
            int[]iarr = allIndices(arr, idx+1, data, foundSoFar);
            return iarr;
        }
    }

    static int lastIndexOccurence(int[] arr,int idx,int data){
        if(idx==arr.length){
            return -1;
        }
        int lastIndexInSmallerArray = lastIndexOccurence(arr, idx+1, data);
        if(lastIndexInSmallerArray==-1){
            if(arr[idx]==data){
                return idx;
            }else{
                return -1;
            }
        }else{
            return lastIndexInSmallerArray;
        }
        
    }

    static int binarySearch(int[] arr, int target, int low, int high){
        if(low>high){
            return -1;
        }
        int mid = low + (high-low)/2;

        if(arr[mid]==target){   
            return mid;
        }

        if(target<arr[mid]){
            return binarySearch(arr, target, low, mid-1);
        }

        return binarySearch(arr, target, mid+1 , high);
    }

    static int fibonacci(int n){
        if(n<2){
            return n;
        }
        int fib = fibonacci(n-1)+fibonacci(n-2);
        return fib;
    }

    static int firstIndexOccurence(int[] arr, int idx, int data){
        // if(idx==arr.length){
        //     return -1;
        // }
        // int firstIndexInSmallArray = firstIndexOccurence(arr, idx+1, data);
        // if(arr[idx]==data){
        //     return idx;
        // }else{
        //     return firstIndexInSmallArray;
        // }
        
        // previous code was doing comparisons while coming down in stack , modified code does comparison while going up and hence is faster and more efficient



        // modified 
        if(idx==arr.length){
            return -1;
        }

        if(arr[idx]==data){
            return idx;
        }else{
            int firstIndexInSmallArray = firstIndexOccurence(arr, idx+1, data);
            return firstIndexInSmallArray;
        }
    }

    static int maxOfArray(int[] arr,int idx){
        // Expectation => maxOfArray(arr, idx) should compare all items from idx to end and find max
        // Faith => maxOfArray(arr, idx+1) can compare all items from idx+1 to end
        // maxOfArray(arr, 0) = arr[0] vs maxOfArray(arr,1)
        if(idx==arr.length-1){
            return arr[idx];
        }   
        int maxInSmallerArray = maxOfArray(arr, idx+1);
        if(maxInSmallerArray>arr[idx]){
            return maxInSmallerArray;
        }else{
            return arr[idx];
        }

    }

    static void printArrayRev(int[] arr, int idx){
        // Expectation => printArrayRev(arr, idx); will print array from end -> idx;
        // Faith => printArrayRev(arr, idx+1); can print from end-1 -> start;
        if(idx==arr.length){
            return;
        }
        printArrayRev(arr, idx+1);
        System.out.println(arr[idx]);
    }

    static void printArray(int[] arr, int idx){
        // Expectation => printArray() will print from idx -> end;
        // Faith => printArray(idx+1) knows to print from idx+1 -> end
        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);
        printArray(arr, idx+1);
    }

    static void towerOfHanoi(int disks,int tower_one,int tower_two,int tower_three){
        if(disks==0){
            return;
        }
        towerOfHanoi(disks-1, tower_one, tower_three, tower_two);
        System.out.println(disks + "["+tower_one+" -> "+tower_two+"]");
        towerOfHanoi(disks-1, tower_three, tower_two, tower_one);
    }

    static void pzz(int n){
        if(n==0){
            return;
        }
        System.out.println("pre "+n);
        pzz(n-1);
        System.out.println("In "+n);
        pzz(n-1);
        System.out.println("post "+n);
    }

    static int powerLog(int x, int n){
        if(n<1){
            return 1;
        }
        int xp2 = powerLog(x, n/2);
        
        int xn = xp2*xp2;

        if(n%2!=0){
            xn *= x;
        }
        return xn;
    }

    static int power(int x, int n){
        if(n<1){
            return 1;
        }
        int x_n1 = power(x, n-1);
        int xn = x * x_n1;
        return xn;
    }

    static int factorial(int n){
        if (n < 1) {
            return 1;
        }
        int fn_1 = factorial(n - 1);
        int fn = n * fn_1;
        return fn;
    }

    static void printDecreasing(int n){
        // print decreasing numbers from n->1
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    static void printIncreasing(int n){
        if (n<1) return;
        printIncreasing(n-1);
        System.out.println(n);
    }


}


