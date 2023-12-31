public class Strings{
    public static void main(String[] args) {
        String m = "abccbc";
        // String n = "abccbc";
        
        
        // Interning
        // m and n point to the same string 
        // if a string of same value is present inside intern pool then new variable gets the address of that pre existing string to point at , this is called interning(Sharing memory by string to optimise space)
        // to avoid interning we can use 'new' keyword
        
        // Comparison
        // don't use == instead use .equals()
        // == checks for address they're pointing 

        // Immutability
        // Strings are immutable 
        // reference is mutable but instance is not 
        // its because of interning

        // Performance of Strings is not good
        // eg String s = "hello"
        // s += "e"
        // this would create a new space in heap copy "hello" in that and then add "e" at the end so we can see this is very resource intensive
         

        
        // subString(m);
        // System.out.println(isPalindrome(m));
        // System.out.println(asciiDiff(m));
        String s = "abc";
        allPermutation(s);
    }

    static void allPermutation(String str){
        int n = str.length();
        int f = factorial(n);

        for (int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for(int div = n;div>0;div--){
                int q = temp / div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;

            }
            System.out.println();
        }
    }

    static int factorial(int n){
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    static String asciiDiff(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            int gap = curr - prev;
            sb.append(gap);
            sb.append(curr);
        }
        return sb.toString();
    }

    static String stringCompression1(String str){
        String s = str.charAt(0)+"";
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            
            if(curr != prev){
                s += curr;
            }
            
        }
        return s;

    }

    static String stringCompresion2(String str){
        String s = str.charAt(0)+"";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            
            if(curr == prev){
                count++;
            }else{
                if(count>1){
                    s += count;
                }
                s += curr; 
            }
            
        }
        if(count>1){
            s += count;
            count = 1;
        }
        
        return s;
    }

    static void subString(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                // System.out.println(s.substring(i, j));
                String m = s.substring(i, j);
                if(isPalindrome(m)==true) System.out.println(m); // to print all palindromic substrings
            }
        }
    }

    static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Characters at left and right positions don't match
            }else{
                left++;
                right--;
            }
            
        }
        
        return true; 
    }
}


