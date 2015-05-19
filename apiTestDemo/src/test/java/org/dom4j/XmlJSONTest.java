/**
 * <p>项目名：</p>
 * <p>包名：org.dom4j</p>
 * <p>文件名：XmlJSONTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-13-上午10:30:29</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.dom4j;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>名称：XmlJSONTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-13 上午10:30:29
 * @version 1.0.0
 */
public class XmlJSONTest
{
	@Test
	public void testname1() throws Exception
	{
		String STR_JSON = "{'RESPONSE':{'BODY':[{'PCOUNT':['6'],'PERSON_INFOR':[{'AGE':['2岁6月'],'BEDNUMBER':['0713'],'DEPARTMENTS':['儿科'],'DIAGNOSERESULT':['新生儿黄疸 NOS,黄疸 NOS'],'DIAGNOSETIME':['2012-10-18 11:53'],'ENTERTIME':['2012-10-18 11:53'],'HOSPITALDAY':['935'],'HOSPITALNUMBER':['67962'],'ID':['00067551'],'MAINDOCTOR':['宁武云'],'NAME':['黄松'],'NURSINGLEVELS':['1'],'RN':['11'],'SEX':['1']},{'AGE':['2岁6月'],'BEDNUMBER':['0713'],'DEPARTMENTS':['儿科'],'DIAGNOSERESULT':['新生儿黄疸 NOS,黄疸 NOS'],'DIAGNOSETIME':['2012-10-18 11:53'],'ENTERTIME':['2012-10-18 11:53'],'HOSPITALDAY':['935'],'HOSPITALNUMBER':['67962'],'ID':['00067551'],'MAINDOCTOR':['宁武云'],'NAME':['黄松'],'NURSINGLEVELS':['1'],'RN':['11'],'SEX':['1']}],'PRCOUNT':['53']}],'HEADER':[{'RET_CODE':['0'],'RET_INFO':['成功']}]}}";
		     
		net.sf.json.JSONObject jobj = net.sf.json.JSONObject.fromObject(STR_JSON);
		
	        String xml =  new XMLSerializer().write(jobj);
	        
//	        String xml = new XMLSerializer().read(STR_JSON).toString();
//	        System.out.println("xml = "+xml);
//	        String json = new XMLSerializer().read(xml).toString();
//	        System.out.println("json="+json);
	        System.out.println(xml);
	}
	
	@Test
	public void testname2() throws Exception
	{
//		String xml = "<RESPONSE>   <HEADER>     <RET_CODE>0</RET_CODE>      <RET_INFO>成功</RET_INFO>   </HEADER>    <BODY>     <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PCOUNT>6</PCOUNT>      <PRCOUNT>53</PRCOUNT>   </BODY></RESPONSE>";
		String xml = "<?xml version='1.0' encoding='utf-8'?><RESPONSE>   <HEADER>     <RET_CODE>0</RET_CODE>      <RET_INFO>成功</RET_INFO>   </HEADER>    <BODY>     <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO></URLPHOTO>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR></BEDDOCTOR>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION></OPERATION>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO></URLPHOTO>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR> </BEDDOCTOR>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION></OPERATION>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PCOUNT>6</PCOUNT>      <PRCOUNT>53</PRCOUNT>   </BODY> </RESPONSE>";
		     
		JSON jsonObject = new XMLSerializer().read(xml);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
		
		JSONObject jsonObj = com.alibaba.fastjson.JSON.parseObject(jsonStr);
		Object obj = jsonObj.getJSONObject("BODY").getJSONArray("PERSON_INFOR").get(1);
//		Object obj = jsonObj.getJSONObject("BODY").get("PCOUNT");
//		Object obj = jsonObj.getJSONObject("BODY").getJSONObject("PERSON_INFOR");
		
		JSONObject jsonObj2 = (JSONObject)obj;
		obj = jsonObj2.get("RN");
		
		System.out.println(com.alibaba.fastjson.JSON.toJSONString(obj));
		
	}
	
	@Test
	public void testname3() throws Exception
	{
		String xml = "<REQUEST>  <HEADER>    <USERID>DOC_APP</USERID>    <PASSWORD>123</PASSWORD>    <TRANSNO>GET_DOC_HOS_SEARCH</TRANSNO>  </HEADER>  <BODY>    <GET_DOC_HOS_SEARCH>      <EMP_CODE>070807005</EMP_CODE>      <PATIENT_KEY>肖纳</PATIENT_KEY>      <SELECT_TYPE>1</SELECT_TYPE>      <PAGE_SIZE>10</PAGE_SIZE>      <PAGE_INDEX>0</PAGE_INDEX>    </GET_DOC_HOS_SEARCH>  </BODY></REQUEST>";
		     
		JSON jsonObject = new XMLSerializer().read(xml);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
		
		System.out.println("======================================================");
		
	}
}
