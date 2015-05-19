/**
 * <p>项目名：</p>
 * <p>包名：net.sf.json.xml</p>
 * <p>文件名：XMLSerializerTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-13-下午10:37:40</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package net.sf.json.xml;

import net.sf.json.JSON;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>名称：XMLSerializerTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-13 下午10:37:40
 * @version 1.0.0
 */
public class XMLSerializerTest
{
	@Test
	public void testXml2Json() throws Exception
	{
//		String xml = "<RESPONSE>   <HEADER>     <RET_CODE>0</RET_CODE>      <RET_INFO>成功</RET_INFO>   </HEADER>    <BODY>     <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PCOUNT>6</PCOUNT>      <PRCOUNT>53</PRCOUNT>   </BODY></RESPONSE>";
		String xml = "<?xml version='1.0' encoding='utf-8'?><RESPONSE>   <HEADER>     <RET_CODE>0</RET_CODE>      <RET_INFO>成功</RET_INFO>   </HEADER>    <BODY>     <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO></URLPHOTO>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR></BEDDOCTOR>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION></OPERATION>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO></URLPHOTO>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR> </BEDDOCTOR>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION></OPERATION>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PCOUNT>6</PCOUNT>      <PRCOUNT>53</PRCOUNT>   </BODY> </RESPONSE>";
		     
		JSON jsonObject = new XMLSerializer().read(xml);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
	}
	
	@Test
	public void testJson2Xml() throws Exception
	{
		String STR_JSON = "{'RESPONSE':{'BODY':[{'PCOUNT':['6'],'PERSON_INFOR':[{'AGE':['2岁6月'],'BEDNUMBER':['0713'],'DEPARTMENTS':['儿科'],'DIAGNOSERESULT':['新生儿黄疸 NOS,黄疸 NOS'],'DIAGNOSETIME':['2012-10-18 11:53'],'ENTERTIME':['2012-10-18 11:53'],'HOSPITALDAY':['935'],'HOSPITALNUMBER':['67962'],'ID':['00067551'],'MAINDOCTOR':['宁武云'],'NAME':['黄松'],'NURSINGLEVELS':['1'],'RN':['11'],'SEX':['1']},{'AGE':['2岁6月'],'BEDNUMBER':['0713'],'DEPARTMENTS':['儿科'],'DIAGNOSERESULT':['新生儿黄疸 NOS,黄疸 NOS'],'DIAGNOSETIME':['2012-10-18 11:53'],'ENTERTIME':['2012-10-18 11:53'],'HOSPITALDAY':['935'],'HOSPITALNUMBER':['67962'],'ID':['00067551'],'MAINDOCTOR':['宁武云'],'NAME':['黄松'],'NURSINGLEVELS':['1'],'RN':['11'],'SEX':['1']}],'PRCOUNT':['53']}],'HEADER':[{'RET_CODE':['0'],'RET_INFO':['成功']}]}}";

		net.sf.json.JSONObject jobj = net.sf.json.JSONObject.fromObject(STR_JSON);

		String xml = new XMLSerializer().write(jobj);

		// String xml = new XMLSerializer().read(STR_JSON).toString();
		// System.out.println("xml = "+xml);
		// String json = new XMLSerializer().read(xml).toString();
		// System.out.println("json="+json);
		System.out.println(xml);
	}
}
