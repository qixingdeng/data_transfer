package cn.cttic.core.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import cn.cttic.core.util.Base64;

public class Signaturer {
	public static byte[] sign(byte[] priKeyText, String plainText) {
		try {   
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(priKeyText));  
			KeyFactory keyf = KeyFactory.getInstance("RSA");   
			PrivateKey prikey = keyf.generatePrivate(priPKCS8);   // 用私钥对信息生成数字签名   
			java.security.Signature signet = java.security.Signature.getInstance("MD5withRSA");   
			signet.initSign(prikey);   
			signet.update(plainText.getBytes());   
			byte[] signed = Base64.encode(signet.sign());   
			return signed;  
			} catch (java.lang.Exception e) {  
				System.out.println("签名失败");   
				e.printStackTrace();  
			}  return null; 
		}
	
	
	public static boolean verify(byte[] pubKeyText, String plainText , byte[] signText) 
	{  
		try {  
			// 解密由base64编码的公钥,并构造X509EncodedKeySpec对象   
			java.security.spec.X509EncodedKeySpec bobPubKeySpec = new java.security.spec.X509EncodedKeySpec(     Base64.decode(pubKeyText));   
			// RSA对称加密算法   
			java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");   
			// 取公钥匙对象   
			java.security.PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);   
			// 解密由base64编码的数字签名   
			byte[] signed = Base64.decode(signText);   
			java.security.Signature signatureChecker = java.security.Signature.getInstance("MD5withRSA");   
			signatureChecker.initVerify(pubKey);   
			signatureChecker.update(plainText.getBytes());   // 验证签名是否正常  
			if (signatureChecker.verify(signed))    
				return true;  
			else    
				return false;  
			} catch (Throwable e){   
				System.out.println("校验签名失败");   
				e.printStackTrace();   
				return false;  
			} 
	}
	

}