import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Arrays;
public class Array {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Scanner input = new Scanner(System.in);

        // int[] nums = {1,2,3,4,6,7,9,10,56,89};
        int [] nums = {3,4,-1,2,5};
        // System.out.p,,,rintln(Arrays.toString(nums));
        // rotate(num,4);
        // revArray(nums, 0, nums.length-1);
        // inverse(nums);
        // System.out.println(Arrays.toString(inverse(nums)));

        // subSet(nums);
        // System.out.println(bs(nums, 48));
        // System.out.println(ceil(nums, 8));
        // System.out.println(floor(nums, 8));
        // subArray(nums);
        // System.out.println(suBArray(nums));
        // String s = "abc";
        // s = "pwq";

        // BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(input.readLine());

        // prefixSum(nums);
        // suffixSum(nums);
        System.out.println(Arrays.toString(nums));
        

    }

    static void suffixSum(int[] arr){
        for (int j = arr.length-2; j >= 0; j--) {
            arr[j] += arr[j+1];
        }
    }

    static void prefixSum(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
    }

    static ArrayList<Integer> suBArray(int[] arr){
        // outer loop i
        // j for inner loop
        // and k travels from i to j and prints all elements between them
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    // System.out.print(arr[k] + "\t");
                    sum += arr[k];
                    
                }  
                // System.out.println();
                myList.add(sum); 
            }
             
       }
       return myList;
    }

    // ceil and floor functions 
    // assume floor => -∞
    // assume ceil => +∞
    // or both can be assumed to zero as well
    // low is changing => change floor
    // high is changing => change ceil
    
    static int ceil(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        int ceil = Integer.MAX_VALUE;
        // int floor = Integer.MIN_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target>arr[mid]){
                low = mid + 1;
                // floor = arr[mid];
            }else if(target<arr[mid]){
                high = mid -1;
                ceil = arr[mid];
            }else{
                return arr[mid];
            }
        }

        return ceil;
        
    }

    static int floor(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        // int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target>arr[mid]){
                low = mid + 1;
                floor = arr[mid];
            }else if(target<arr[mid]){
                high = mid -1;
                // ceil = arr[mid];
            }else{
                return arr[mid];
            }
        }

        return floor;
        
    }

    static int bs(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        System.out.println("target = "+target);

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>target){
                high = mid-1;
            }else if (arr[mid]<target){
                low = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static void subSet(int[] arr){
        int limit = (int) Math.pow(2,arr.length); // total no. of subsets
        // System.out.println(limit);
        for (int i = 0; i < limit; i++) {
            // convert i to binary and use 0 or 1 to know whether to print element or not
            String set = "";
            int temp = i;
            System.out.print("[");
            for (int j = arr.length-1; j >= 0; j--) {
                int r = temp%2;
                temp=temp/2;

                if(r==0){
                    set = " \t" + set;
                }else{
                    set = arr[j] + "\t" + set;
                }

               
            }
            System.out.println(set + "]");
            
            
        }
    }

    static int[] inverse(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            ans[temp] = i;
        }
        return ans;
    }

    static void subArray(int[] arr){
        // outer loop i
        // j for inner loop
        // and k travels from i to j and prints all elements between them
       for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + "\t");
                }  
                System.out.println(); 
            }
             
       }
    }
   
    // example arr = {a,b,c,d,e,f,g,h}
    // and k = 3;
    // make two parts {a,b,c,d,e} | {f,g,h}
    // reverse both parts {e,d,c,b,a} | {h,g,f};
    // combine and reverse whole
    // {f,g,h,a,b,c,d,e}
    // hence the required rotated array
    static void rotate(int[] arr,int k){
        revArray(arr,0,arr.length-k-1);
        revArray(arr,arr.length-k, arr.length-1);    
        revArray(arr, 0, arr.length-1);
    }

    static void revArray(int[] arr,int i,int j) {
        int n = arr.length;
        // int i = 0;
        // int j = n - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    static void addArrays(int[] a,int[] b){
      int n1 = a.length;
      int n2 = b.length;
      int[] sum = new int[n1 > n2? n1 : n2];

      int carry = 0;
      int i = a.length-1;
      int j = b.length-1;
      int k = sum.length-1;

      while(k>=0){
        int digit = carry;

        if(i>=0){
          digit += a[i];
        }

        if(j>=0){
          digit += b[j];
        }

        carry = digit/10; 
        digit = digit % 10;

        sum[k] = digit;

        i--;j--;k--;
        
        
      }
      if(carry!=0){
        System.out.print(carry);
      }

      for(int val : sum){
        System.out.print(val);
      }
    }


}
