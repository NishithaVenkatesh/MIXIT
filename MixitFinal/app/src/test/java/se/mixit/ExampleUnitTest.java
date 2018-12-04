package se.mixit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test() throws Exception {
        Feistel f=new Feistel();
        String Plaintext="Hello";
        String Key="Key";
        String CipherText=f.encrypt(Plaintext,Key);
        String Plaincheck=f.decrypt(CipherText,Key);
        assertEquals(Plaintext,Plaincheck);
        System.out.println(Plaintext+"\n"+Key+"\n"+CipherText+"\n"+Plaincheck);
    }
}