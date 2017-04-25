package test.java.util.regex;

import java.util.regex.Pattern;

import org.junit.Test;

public class PatternTest {
	
	@Test
	public void testName() throws Exception {
		String val = "/admin/user/adminUserList?adminUserQuery.userType=3";
		
		String regex = "/admin/.*";
		Boolean caseSensitive = Boolean.TRUE;
		
		Pattern pattern = caseSensitive ? Pattern.compile(regex) : Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		System.out.println(pattern.matcher(val).matches());
	}
}
