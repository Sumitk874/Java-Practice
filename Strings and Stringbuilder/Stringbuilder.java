public class Stringbuilder {
    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder("hello");
        // this has some added features like strings don't have any setChar funtion but stringBuilder has 
        // sb.setCharAt(0, 'j');
        // sb.deleteCharAt(0);
        // sb.append("g");
        // System.out.println(sb.length());
        // System.out.println(sb);

        // sb.append("aabbccdddeeefff");
        // add this line
        
        System.out.println(toggleCase("HellLoOO"));

    }

    static String toggleCase(String str){
        // lowerCase -> upperCase
        // upperCase -> lowerCase

        // p - a = P - A
        // p = a + P - A 
        // lowerCase = a - A + upperCase 


        // P = A + p - a
        // upperCase = A - a + lowerCase
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c>='a' && c<='z'){
                // lowerCase
                char uppperCase = (char) ('A' - 'a' + c);
                sb.setCharAt(i, uppperCase);
            }else if (c>='A' && c<='Z'){
                char lowerCase = (char) ('a' - 'A' + c);
                sb.setCharAt(i, lowerCase); 
            }
        }
        return sb.toString();


    }
}
