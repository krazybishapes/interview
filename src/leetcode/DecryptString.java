package leetcode;

public class DecryptString {

    public static void main(String[] args) {

        String s = "bcd";
        int k=2;

        System.out.println(decryptString(s,k));
    }

    private static String decryptString(String s, int k){

        k = k%26;

        StringBuilder decryptedString = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){

                char base = Character.isLowerCase(c)? 'a': 'A';
                char decryptChar = (char) (base + (c-base-k+26)%26);
                decryptedString.append(decryptChar);
            }else{
                decryptedString.append(c);
            }


        }


        return decryptedString.toString();

    }
}
