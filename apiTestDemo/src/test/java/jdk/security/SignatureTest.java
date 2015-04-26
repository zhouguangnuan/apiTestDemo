/*
 * @(#)sdf.java 2015-2-10 上午10:40:13
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdk.security;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

/**
 * <p>File：sdf.java</p>
 * <p>Title: 测试数字签名</p>
 * <p>Description: 为数字信息添加防伪标签
 * 要证明这段数据是你发过来的，并且没有被别人改过，这就需要用到数字签名。
 * 首先我们对整个文档进行md5加密得到16个字节，然后把消息摘要和文档发过去。
 * 解密者首先对发过来的文档进行解密，解密后得到一个摘要(md5)，对接收的文档进行md5加密,
 * 得到的md5结果匹配解密后的摘要，如果匹配成功的话证明没有修改过，我们使用Signature进行签名
 * </p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午10:40:13</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class SignatureTest
{
	private static String algorithm = "SHA1withRSA";
	private static File publicKeyFile = FileUtils.getFile("publicKey.key");
	private static File signedDataFile = FileUtils.getFile("signedData.dat");
	private static String data = "你好";// 所需签名的数据
	
	/*  
	 * 使用私钥签名  
	 */    
	@Test
	public void signature()throws Exception {    
	    //实例化Key     
	    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");    
	    //获取一对钥匙     
	    KeyPair keyPair = keyPairGenerator.generateKeyPair();    
	    //获得公钥     
	    PublicKey publicKey = keyPair.getPublic();    
	    //获得私钥      
	    PrivateKey privateKey = keyPair.getPrivate();    
	      
	    //数字签名  
	    Signature signature = Signature.getInstance(algorithm);  
	    signature.initSign(privateKey);//用私钥签名  
	    signature.update(data.getBytes());//初始化签名对象   
	    byte [] signedData = signature.sign();//获取签名的结果  
      
	    //保存公钥并写入文件中   
	    FileOutputStream out1 = FileUtils.openOutputStream(publicKeyFile);
	    out1.write(SerializationUtils.serialize(publicKey));
	    IOUtils.closeQuietly(out1);
	    
	    //将签名后的数据写入到文件     
	    FileOutputStream out2 = FileUtils.openOutputStream(signedDataFile);
	    out2.write(signedData);
	    IOUtils.closeQuietly(out2);
	}  
	    
	/*  
	 * 公钥解密  
	 */    
	@Test
	public void verify() throws Exception {  
		//获取到公钥  
	    byte [] publicKeyByte = FileUtils.readFileToByteArray(publicKeyFile);
	    PublicKey publicKey = (PublicKey) SerializationUtils.deserialize(publicKeyByte);
	    
	    Signature signture = Signature.getInstance(algorithm);  
	    signture.initVerify(publicKey);//初始化校验    
	    signture.update(data.getBytes());//初始化签名对象    
	    byte [] signedData = FileUtils.readFileToByteArray(signedDataFile);//读数据源     
	    
	    boolean isYouSigned = signture.verify(signedData);//返回匹配结果  
	    //如果返回数据为true则数据没有发生修改，否则发生修改  
	    System.out.println(isYouSigned);  
	} 
}
