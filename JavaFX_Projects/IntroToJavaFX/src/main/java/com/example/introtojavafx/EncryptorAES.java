package com.example.introtojavafx;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptorAES {


    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue={ 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
    
    
    public static String encrypt(String plainText) throws Exception{
        Key key=generateKey();// generate key dynamically 
        Cipher c=Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptData=c.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptData);
    }

    private static Key generateKey() throws Exception{
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyValue, ALGORITHM);
        return secretKeySpec;
        
    }
    
    public static  String decrypt(String cipherText) throws Exception{
        Key key=generateKey();// generate key dynamically
        Cipher c=Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue=Base64.getDecoder().decode(cipherText);
        byte[] decVal=c.doFinal(decodedValue);

        String s = new String(decVal);
        return s;
        
    }
    
}