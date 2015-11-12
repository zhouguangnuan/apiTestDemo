package org.springframework.util;

import org.junit.Test;

public class NumberUtilsTest
{
        
        
        @Test
        public void testName() throws Exception
        {
                Integer num1 = 1;
                Long num2 = NumberUtils.convertNumberToTargetClass(num1, Long.class);
                
                System.out.println(num2);
        }
}
