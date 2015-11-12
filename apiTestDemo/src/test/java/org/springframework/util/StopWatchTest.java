package org.springframework.util;

import org.junit.Test;

public class StopWatchTest
{
        @Test
        public void testName() throws Exception
        {
                StopWatch stopWatch = new StopWatch();
                stopWatch.start("StopWatchTest");
                Thread.sleep(5000);
                System.out.println(stopWatch.prettyPrint());
                
                stopWatch.stop();
                System.out.println(stopWatch.prettyPrint());
        }
}
