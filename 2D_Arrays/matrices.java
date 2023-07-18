import java.util.*;

public class matrices {
    public static void main(String[] args) {
    //    Scanner input = new Scanner(System.in);

    //    int n1 = input.nextInt();
    //    int m1= input.nextInt();
    //    int[][] arr1 = new int[n1][m1];

    //    for (int row = 0; row < arr1.length; row++) {
    //         for (int col = 0; col < arr1[row].length; col++) {
    //             arr1[row][col] = input.nextInt();
    //         }
    //    }

    //    int n2 = input.nextInt();
    //    int m2 = input.nextInt();
    //    int[][] arr2 = new int[n2][m2];

    //    for (int row = 0; row < arr2.length; row++) {
    //         for (int col = 0; col < arr2[row].length; col++) {
    //             arr2[row][col] = input.nextInt();
    //         }
    //    }

    //    if(m1!=n2){
    //         System.out.println("Invalid input");
    //         input.close();
    //         return;
    //    }

    //    // Matrix Multiplication
    //    int[][] ans = new int[n1][m2];
    //         for (int row = 0; row < ans.length; row++) {
    //             for (int col = 0; col < ans[row].length; col++) {
    //                 for (int j2 = 0; j2 < m1; j2++) {
    //                     ans[row][col] += arr1[row][j2] + arr2[j2][col];
    //                 }
    //             }
    //         }

    //         for (int row = 0; row < ans.length; row++) {
    //             for (int col = 0; col < ans[0].length; col++) {
    //                 System.out.print(ans[row][col] + " ") ;
    //             }System.out.println();
    //         }
    //     input.close();
        int[][] arr = { {1,2,3,9},
                        {4,5,6,6},
                        {7,8,9,6},
                        {7,8,9,6}
                        };
        //
        // diagonalTraversal(arr);
        //  print2D(arr);
        // System.out.println();
        // shellRotate(arr, 1, 3);

        // print2D(arr);

        // int[][] arr =   {   {1,2,3},
        //                     {4,5,6},
        //                     {7,8,9}
        //                 };
        
        // waveTraversal(arr);
        // spiralTraversal(arr);


        // int[][] binaryArray = {
        //     {1, 0, 1, 0, 1},
        //     {0, 1, 0, 1, 0},
        //     {1, 0, 1, 0, 1},
        //     {0, 1, 0, 1, 0}
        // };

        // System.out.println(Arrays.toString(exitPoint(binaryArray)));



    }

    static void diagonalTraversal(int[][] arr){
        for (int g = 0; g < arr.length; g++) {
            for (int i = 0,j=g; j < arr.length; i++,j++) {
                System.out.println(arr[i][j]);
            }
            
        }
    }

    static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
 
            

                
    }

    static int[] fillOneDfromShell(int[][] arr, int shell){
        int minRow = shell-1;
        int minCol = shell-1;

        int maxRow = arr.length-shell;
        int maxCol = arr[0].length-shell;
        
        int size = 2*(maxRow-minRow+maxCol-minCol);

        int[] oneD = new int[size];
        int index = 0;

        // left wall
        for (int row = minRow,col=minCol; row <= maxRow; row++) {
            oneD[index] = arr[row][col];
            index++;
        }

        // bottom wall
        for (int row = maxRow,col=minCol+1; col <= maxCol; col++) {
            oneD[index] = arr[row][col];
            index++;
        }

        // right wall
        for (int row = maxRow-1,col=maxCol; row >= minRow; row--) {
            oneD[index] = arr[row][col];
            index++;
        }
        // top wall
        for (int row = minRow,col=maxCol-1; col >= minCol+1 ; col--) {
            oneD[index] = arr[row][col];
            index++;
        }


        return oneD;
    }

    static void fillShellFromOneD(int[][] arr, int shell,int[] oneD){
        int minRow = shell-1;
        int minCol = shell-1;

        int maxRow = arr.length-shell;
        int maxCol = arr[0].length-shell;
        
        // int size = 2*(maxRow-minRow+maxCol-minCol);

        // int[] oneD = new int[size];
        int index = 0;

        // left wall
        for (int row = minRow,col=minCol; row <= maxRow; row++) {
            // oneD[index] = arr[row][col];
            arr[row][col] = oneD[index];
            index++;
        }

        // bottom wall
        for (int row = maxRow,col=minCol+1; col <= maxCol; col++) {
            arr[row][col] = oneD[index];
            index++;
        }

        // right wall
        for (int row = maxRow-1,col=maxCol; row >= minRow; row--) {
            arr[row][col] = oneD[index];
            index++;
        }
        // top wall
        for (int row = minRow,col=maxCol-1; col >= minCol+1 ; col--) {
            arr[row][col] = oneD[index];
            index++;
        }
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

    static void rotate(int[] arr,int k){
        revArray(arr,0,arr.length-k-1);
        revArray(arr,arr.length-k, arr.length-1);    
        revArray(arr, 0, arr.length-1);
    }

    static void shellRotate(int[][] arr, int shell, int rotation){
        // fill 1-D array from shell 
        int[] oneD = fillOneDfromShell(arr,shell);
        rotate(oneD, rotation);
        fillShellFromOneD(arr,shell,oneD);
    }

    static void rev(int[][]arr){
        for(int i=0;i<arr.length;i++){
            int li = 0;
            int ri = arr[i].length-1;

            while(li<ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++; ri--;
            }
        }
    }

    static void transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    static int[] exitPoint(int[][] arr){
        // you have to tell the exit point 
        // binary matrix would be given if element is zero continue moving else take a right turn 90 degrees
        // we'll be entering matrix in east direction ->
       
       
       
        // dir =           0 => east
        //                 1 => south 
        //                 2 => west
        //                 3 => north
        //                 0 => east 
        //                  .... for 4 we'll take modulus

        int dir = 0;
        int row = 0;
        int col = 0;

        while(true){
            dir = (dir + arr[row][col])%4;

            if(dir==0){// east
                col++;
            }else if(dir == 1){//south
                row++;
            }else if(dir == 2){//west
                col--;
            }else if(dir == 3){//north
                row--;
            }

            if(row<0){
                row++;
                break;
            }else if(col<0){
                col++;
                break;
            }else if(row==arr.length){
                row--;
                break;
            }else if(col==arr[0].length){
                col--;
                break;
            }

        }

        return new int[]{row,col};
    }

    static void spiralTraversal(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;

    int minRow = 0;
    int minCol = 0;
    int maxRow = n - 1;
    int maxCol = m - 1;

    int totalElements = n * m;
    int count = 0;

    while (count < totalElements) {
        // Top wall => row fix
        for (int col = minCol; col <= maxCol && count < totalElements; col++) {
            System.out.println(arr[minRow][col]);
            count++;
        }
        minRow++;

        // Right wall => col fix
        for (int row = minRow; row <= maxRow && count < totalElements; row++) {
            System.out.println(arr[row][maxCol]);
            count++;
        }
        maxCol--;

        // Bottom wall => row fix
        for (int col = maxCol; col >= minCol && count < totalElements; col--) {
            System.out.println(arr[maxRow][col]);
            count++;
        }
        maxRow--;

        // Left wall => col fix
        for (int row = maxRow; row >= minRow && count < totalElements; row--) {
            System.out.println(arr[row][minCol]);
            count++;
        }
        minCol++;
    }
}

    static void waveTraversal(int[][] arr){
        for (int col = 0; col < arr[0].length; col++) {
            if(col%2==0){
                for (int row = 0; row < arr.length; row++) {
                    System.out.println(arr[row][col]);
                }
            }else{
                for (int row = arr.length-1; row >= 0; row--) {
                    System.out.println(arr[row][col]);
                }
            }
            
        }
    }
}
