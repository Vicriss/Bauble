package MD;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vicriss on 2015/09/05.
 */
public class MDTest {

    private static String src = "hello world";

    public static void main(String[] args){
        jdkMD5();
    }

    public static   void jdkMD5(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println("JDK MD5: "+ Hex.encodeHexString(md5Bytes));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
