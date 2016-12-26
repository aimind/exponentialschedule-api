package com.github.aimind.exponentialschedule_api.services;

import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class SecurityService {
	
	/**
	 * Function to encrypt a string in AES
	 * @param message
	 * @param passphrase
	 * @return The IV and the ciphertext in a list
	 * @throws Exception
	 */
	public static List<String> encryptAESMessage(String message, String passphrase) throws Exception{

		List<String> result = new ArrayList<String>();
		
		try{
			
			/* Derive the key, given password and salt. */
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), passphrase.getBytes(), 1, 128);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
			
			/* Encrypt the message. */
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secret);
			AlgorithmParameters params = cipher.getParameters();
			
			byte[] ciphertext = cipher.doFinal(message.getBytes("UTF-8"));
			byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
			
			/*Transform the byte arrays in strings*/
			String strCipherText = Base64.getEncoder().encodeToString(ciphertext);
			String strIV = Base64.getEncoder().encodeToString(iv);
			
			result.add(strCipherText);
			result.add(strIV);
		
		}catch(Exception ex){
			throw ex;
		}
		
		return result;
	}
	
	
	/**
	 * Function to decrypt an AES string
	 * @param ciphertext
	 * @param iv
	 * @param passphrase
	 * @return the string decrypted
	 * @throws Exception
	 */
	public static String decryptAESMessage(String ciphertext, String iv, String passphrase) throws Exception{
		
		String result="";
		
		try{
			
			/* Transforming the strings in base64 byte arrays */
			byte[] arrCipherText = Base64.getDecoder().decode(ciphertext);
			byte[] arrIv = Base64.getDecoder().decode(iv);
			
			/* Derive the key, given password and salt. */
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), passphrase.getBytes(), 1, 128);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
			
			/* Decrypt the message, given derived key and initialization vector. */
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(arrIv));
			result = new String(cipher.doFinal(arrCipherText), "UTF-8");
			
		}catch(Exception ex){
			throw ex;
		}
		
		return result;
	}
}
