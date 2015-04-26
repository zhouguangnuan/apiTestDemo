/*
 * @(#)SerializationUtils_Test.java 2015-1-28 下午12:50:35
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/**
 * <p>File：SerializationUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午12:50:35</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class SerializationUtils_Test
{
	/**
	 * Object --> byte[]
	 * byte[] --> Object
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testSerialize() throws Exception
	{
		Date date = new Date();  
        byte[] bytes = SerializationUtils.serialize(date);  
        System.out.println(ArrayUtils.toString(bytes));  
        System.out.println(date);  
        
        Date reDate = (Date) SerializationUtils.deserialize(bytes);  
        System.out.println(reDate);  
        System.out.println(ObjectUtils.equals(date, reDate));  
        System.out.println(date == reDate);
	}
	
	/**
	 * 序列化到输出流
	 * 反序列化从输入流
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testSerializeToOutputStream() throws Exception
	{
		Date date = new Date();  
        FileOutputStream fos = null;  
        FileInputStream fis = null;  
        try  
        {  
            fos = new FileOutputStream(new File("d:/test.txt"));  
            fis = new FileInputStream(new File("d:/test.txt"));  
            SerializationUtils.serialize(date, fos);  
            Date reDate2 = (Date) SerializationUtils.deserialize(fis);  
  
            System.out.println(date.equals(reDate2));  
  
        }  
        catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        finally  
        {  
            try  
            {  
                fos.close();  
                fis.close();  
            }  
            catch (IOException e)  
            {  
                e.printStackTrace();  
            }  
        }  
	}
}
