package jdk.file;

import java.io.File;
import java.io.IOException;

/**
 * �����༶Ŀ¼
 * @author Administrator
 *
 */
public class TestFile3 {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"a" + File.separator + 
				"b" + File.separator + 
				"c" + File.separator + 
				"d"
		);
		if(!file.exists()){
			/**
			 * �÷���Ҳ�����ڴ���Ŀ¼
			 * ���ǻ�����Ǵ������в����ڵĸ�Ŀ¼
			 */
			file.mkdirs();
		}
		
		File sub = new File(file,"test.txt");
		if(!sub.exists()){
			sub.createNewFile();
		}
		
		System.out.println("������ϣ�");
	}
}
