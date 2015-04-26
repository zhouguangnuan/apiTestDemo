/*
 * @(#)MetaphoneTest.java 2015-2-11 下午2:54:14
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.language;

import org.junit.Test;

/**
 * <p>File：MetaphoneTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-11 下午2:54:14</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class MetaphoneTest
{
	@Test
	public void testname() throws Exception
	{
        Metaphone metaphone = new Metaphone();
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        Soundex soundex = new Soundex();

        for (int i=0; i<2; i++ ) {
            String str=(i==0)?"resume":"resin";

            String mString = null;
            String rString = null;
            String sString = null;

            try {
                mString = metaphone.encode(str);
                rString = refinedSoundex.encode(str);
                sString = soundex.encode(str);

            } catch (Exception ex) {
                ;
            }
            System.out.println("Original:"+str);
            System.out.println("Metaphone:"+mString);
            System.out.println("RefinedSoundex:"+rString);
            System.out.println("Soundex:"+sString +"\\n");
        }
    }
}
