/*
 * @(#)BeanFactory.java 2015-1-29 上午9:32:15
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package bean;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>File：BeanFactory.java</p>
 * <p>Title: bean工厂，方便测试时获得对象实例</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-29 上午9:32:15</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class BeanFactory
{
	public static SampleBean getSampleBean()
	{
		String[] array = new String[]{"array1", "array2", "array3"};
		List<String> list = Arrays.asList("list1", "list2", "list3");
		List<String> infos = Arrays.asList("infos1", "infos2", "infos3");
		Map<String, String>	map = new HashMap<String, String>();
		map.put("map1", "val1");
		map.put("map2", "val2");
		map.put("map3", "val3");
		
		NestedBean nestedBean = new NestedBean();
		nestedBean.setNestedProperty("nestedProperty");
		nestedBean.setInfos(infos);
		
		List<NestedBean> beans = Arrays.asList(nestedBean, nestedBean, nestedBean);
		
		SampleBean bean = new SampleBean();
		bean.setName("rensanning");
		bean.setAge(31);
		bean.setDate(new Date());
		bean.setArray(array);
		bean.setList(list);
		bean.setMap(map);
		bean.setBeans(beans);
		 
		return bean;
	}
	
	public static SampleBean2 getSampleBean2()
    {
            String[] array = new String[]{"array1", "array2", "array3"};
            List<String> list = Arrays.asList("list1", "list2", "list3");
            List<String> infos = Arrays.asList("infos1", "infos2", "infos3");
            Map<String, String>     map = new HashMap<String, String>();
            map.put("map1", "val1");
            map.put("map2", "val2");
            map.put("map3", "val3");
            
            NestedBean nestedBean = new NestedBean();
            nestedBean.setNestedProperty("nestedProperty");
            nestedBean.setInfos(infos);
            
            List<NestedBean> beans = Arrays.asList(nestedBean, nestedBean, nestedBean);
            
            SampleBean2 bean = new SampleBean2();
            bean.setName("rensanning");
            bean.setAge(31);
            bean.setDate(new Date());
            bean.setArray(array);
            bean.setList(list);
            bean.setMap(map);
            bean.setBeans(beans);
             
            return bean;
    }
}
