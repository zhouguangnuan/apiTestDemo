package org.springframework.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AntPathMatcherTest
{
        @Test
        public void testName() throws Exception
        {
                PathMatcher matcher = new AntPathMatcher();

                // 完全路径匹配
                String requestPath = "/user/list.htm?username=aaa&id=2&no=1&page=20";
                String patternPath = "/user/list.htm*";
                assertTrue(matcher.match(patternPath, requestPath));

                // 不完整路径匹配
                requestPath = "/app/pub/login.do";
                patternPath = "/**/login.do";
                assertTrue(matcher.match(patternPath, requestPath));
                
                // 不完整路径匹配
                requestPath = "/app/pub/login.do";
                patternPath = "/*/pub/login.do";
                assertTrue(matcher.match(patternPath, requestPath));

                // 模糊路径匹配
                requestPath = "/app/pub/login.do";
                patternPath = "/**/*.do";
                assertTrue(matcher.match(patternPath, requestPath));

                // 模糊单字符路径匹配
                requestPath = "/app/pub/login.do";
                patternPath = "/**/lo?in.do";
                assertTrue(matcher.match(patternPath, requestPath));
        }
}
