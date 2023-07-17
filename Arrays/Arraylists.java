import java.util.*;
public class Arraylists {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(15);
        a.add(19);
        a.add(12);
        a.add(13);
        a.add(1);
        a.add(5);
        a.add(25);
        a.add(95);

        System.out.println(a);
        removePrimes(a);
        System.out.println(a);
        
    }

    static void removePrimes(ArrayList<Integer> a){
        for (int index = a.size()-1; index >= 0 ; index--) {
            int val = a.get(index);
            if(isPrime(val)) a.remove(index);
        }
    } 

    static boolean isPrime(int a){
        // a prime number is only divisible by 1 and itself 
        if(a <= 1) return false;
        for (int i = 2; i <= (int)Math.sqrt(a); i++) {
            if(a%i==0){
                // divisible by other numbers
                return false;
            }
        }
        return true;
    }
}
