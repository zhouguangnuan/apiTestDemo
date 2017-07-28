package test.orc;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;  
  
public class TestOCR {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	// 
    	
        String path = "C://Users//Administrator//Desktop//test/test1.jpg";     
        try {     
            String valCode = new OCR().recognizeText(new File(path), "jpg");     
            
            System.out.println(valCode);   
            
//            String[] temp = StringUtils.split(valCode, "\n");
//            // System.out.println(JSON.toJSONString(temp));
//            
//            // System.out.println(temp[12]);
//            
//            String[] temp2 = StringUtils.split(temp[12], "=");
//            // System.out.println(JSON.toJSONString(temp2));
//            
//            String regEx="[^0-9]";   
//            Pattern p = Pattern.compile(regEx);   
//            Matcher m = p.matcher(temp2[1]);
//            String temp3 = m.replaceAll("").trim();
//            // System.out.println(temp3);
//            
//            String year = StringUtils.substring(temp3, 0, 4);
//            String month = StringUtils.substring(temp3, temp3.length()-4, temp3.length()-2);
//            String day = StringUtils.substring(temp3, temp3.length()-2, temp3.length());
//            
//            System.out.println(year + "-" + month + "-" + day);
            
        } catch (IOException e) {     
            e.printStackTrace();     
        } catch (Exception e) {  
            e.printStackTrace();  
        }      
    }  
  
}  