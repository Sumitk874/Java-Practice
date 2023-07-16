import java.util.Arrays;

public class sorting{
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 8, 9, 15, 52, 59, 126};
        int[] nums = {0, 1, 4, 5, 9, 11, 19, 84, 89, 94, 984, 8151};
        int[] num = {5, 8, 2, 1, 9};
        // System.out.println(Arrays.toString(arr));
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // insertionSort(nums);
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(mergeArrays(arr, nums)));
        System.out.println(Arrays.toString(mergeSort(arr, 0, 5)));



    }

    static int[] mergeSort(int[] arr, int low, int high){
        if(low == high){
            int [] baseArray = new int[1];
            baseArray[0] = arr[low];
            return baseArray;
        }
        int mid = low+(high-low)/2;
        int[] firstSortedHalf = mergeSort(arr, low, mid); // first half
        int[] secondSortedHalf = mergeSort(arr, mid+1, high); // second half
        int[] fullSortedArray = mergeArrays(firstSortedHalf, secondSortedHalf);
        return fullSortedArray;

    }

    static int[] mergeArrays(int[] arr, int[] nums){
        int i=0;
        int j=0;
        int k=0;
        int size = arr.length+nums.length;

        int[] ans = new int[size];

        while(i<arr.length && j<nums.length){
            if(arr[i]>nums[j]){
                ans[k] = nums[j];
                j++;k++;
            }else{
                ans[k] = arr[i];
                i++;k++;
            }
            
        }

        while(i<arr.length){
            ans[k]=arr[i];
            i++; k++;
        }

        while(j<nums.length){
            ans[k]=nums[j];
            j++; k++;
        }
        

        return ans;
    }

    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }else{
                    break;
                }
            }
        }
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int min = i;
                if(arr[j]<arr[min]){
                    swap(arr, min, j);
                }
            }
        }
    }

    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}