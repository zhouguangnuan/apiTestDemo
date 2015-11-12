package org.springframework.util;

import org.junit.Test;

public class ObjectUtilsTest
{
        private String[] array = new String[]{"1", "2"};
        
        @Test
        public void addObjectToArray() throws Exception
        {
                array = ObjectUtils.addObjectToArray(array, "3");
                System.out.println(ObjectUtils.getDisplayString(array));
        }
        
        @Test
        public void containsElement() throws Exception
        {
                boolean iscontains = ObjectUtils.containsElement(array, "1");
                System.out.println(iscontains);
        }
}
