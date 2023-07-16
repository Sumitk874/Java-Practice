import java.util.*;
public class Arraylists {
    public static void main(String[] args) {
        
    }

    static boolean isPrime(int a){
        if(a <= 1) return false;
        for (int i = 1; i <= (int)Math.sqrt(a); i++) {
            if(a%1==0){
                // divisible by other numbers
                return false;
            }
        }
        return true;
    }
}
