package Detyra2;



import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

import javax.crypto.*;


public class EnAES
{
   
   public static void main(String[] args) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException,     

NoSuchPaddingException 
   {
       
      File fileName = new File("AES.txt");
        
      FileInputStream in = new FileInputStream(fileName);
        
      String text = "";
        
        
      int c;
        
      while((c = in.read()) != -1){
            
        text = text + (char)c;
            
        System.out.print((char)c);      
        }

        
      encrypt(text);
    }

   

   public static void encrypt(String text)  throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,     

BadPaddingException, IOException 
   {

        
     String fileName1 = "encrypted_text_AES.txt";
        
     String fileName2 = "decrypted_text_AES.txt";

        
     KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        
     keyGen.init(128);

        
     SecretKey secretKey = keyGen.generateKey();
       
     Cipher aesCipher = Cipher.getInstance("AES");

       
     byte[] byteText = text.getBytes();

        
     aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
       
     byte[] byteCipherText = aesCipher.doFinal(byteText);
        
     Files.write(Paths.get(fileName1),byteCipherText);

        
     byte[] cipherText= Files.readAllBytes(Paths.get(fileName1));

       
     aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
        
     byte[] bytePlainText = aesCipher.doFinal(cipherText);
       
     Files.write(Paths.get(fileName2), bytePlainText);
    
    }

}
