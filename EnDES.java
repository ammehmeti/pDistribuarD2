package Detyra2;


import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;

import javax.crypto.IllegalBlockSizeException;

import javax.crypto.KeyGenerator;

import javax.crypto.NoSuchPaddingException;

import javax.crypto.SecretKey;




public class EnDES {
    
    
public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException
 {
        
        
   File fileName = new File("DES.txt");
 
   FileInputStream in = new FileInputStream(fileName);
 
   String text = "";
        
        
   int c;
        
   while((c = in.read()) != -1){
            
     text = text + (char)c;
            
     System.out.print((char)c);      
        
   }

        
   encrypt(text);
   
 }

    

public static void encrypt(String text)  throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException 
{

        
   String fileName1 = "encrypted_text_DES.txt";
        
   String fileName2 = "decrypted_text_DES.txt";

        
   KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        
   keyGen.init(56);

        
   SecretKey secretKey = keyGen.generateKey();
        
   Cipher desCipher = Cipher.getInstance("DES");

       
   byte[] byteText = text.getBytes();

        
   desCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
   byte[] byteCipherText = desCipher.doFinal(byteText);
        
   Files.write(Paths.get(fileName1),byteCipherText);

        
   byte[] cipherText= Files.readAllBytes(Paths.get(fileName1));

        
   desCipher.init(Cipher.DECRYPT_MODE, secretKey);
        
   byte[] bytePlainText = desCipher.doFinal(cipherText);
        
   Files.write(Paths.get(fileName2), bytePlainText);
   
}
}
