package com.singno.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class POIUtilsTest
{
	@Test
	public void svaeExcel() throws Exception
        {
		String[] columnNames = null;// new String[]{"key1", "key2", "key3"};
		List<String[]> columnVals = Lists.newArrayList();
		columnVals.add(new String[]{"val1_1", "val1_2", "val1_3"});
		columnVals.add(new String[]{"val2_1", "val2_2", "val2_3"});
		OutputStream out = new FileOutputStream(new File("C:/Users/txsb/Desktop/test.xls"));
		POIUtils.svaeExcel(columnNames, columnVals, out);
        }
	
	@Test
	public void readExcel() throws Exception
        {
		List<String[]> content = POIUtils.readExcel(new FileInputStream(new File("C:/Users/txsb/Desktop/test.xls")));
		System.out.println(JSON.toJSONString(content));
        }
}
