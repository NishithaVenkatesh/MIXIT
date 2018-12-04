package se.mixit;

/**
 * Created by root on 5/8/17.
 */
public class Feistel {
    public String encrypt(String Plaintext,String Key){
        if(Plaintext.length()%2!=0)
            Plaintext+=' ';
        char[] CipherTextArray = new char[Plaintext.length()];
        char Lo, Ln = 0;
        char Ro, Rn = 0;
        for (int j = 0; j < Plaintext.length(); j += 2) {
            Lo = Plaintext.charAt(j);
            Ro = Plaintext.charAt(j + 1);
            for (int i = 0; i < Key.length(); i++) {

                Ln = Ro;
                Rn = (char) (Lo ^ f(Ro,Key.charAt(i)));
                Ro = Rn;
                Lo = Ln;
            }
            //System.out.println((int)Rn+" "+(int)Ln);
            CipherTextArray[j] = Rn;
            CipherTextArray[j + 1] = Ln;
        }
        //System.out.println(CipherText);

        String CipherText=new String(CipherTextArray);
        return CipherText;
    }



    public String decrypt(String CipherText,String Key){
        char Lo,Ln=0;
        char Ro,Rn=0;
        char[] PlainTextArray = new char[CipherText.length()];
        for (int j = 0; j < CipherText.length(); j += 2) {
            Lo =CipherText.charAt(j);
            Ro = CipherText.charAt(j + 1);
            for (int i = Key.length() - 1; i >= 0; i--) {
                Ln = Ro;
                Rn = (char) (Lo ^ f(Ro, Key.charAt(i)));
                Ro = Rn;
                Lo = Ln;
            }

            PlainTextArray[j] += Rn;
            PlainTextArray[j + 1] = Ln;
        }
        String PlainText=new String(PlainTextArray);
        if(PlainText.endsWith(" "))
            return PlainText.substring(0,PlainText.length()-1);
        return PlainText;
    }



    //f function for the feistel network returns a modified P
    private static char f(char R,char K) {
            return (char) ((short) ((R *K)) <<2);

    }

}
