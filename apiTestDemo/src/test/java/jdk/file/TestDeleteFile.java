package jdk.file;

import java.io.File;

/**
 * �yԇ �h���ļ���Ŀ¼
 * @author Administrator
 *
 */
public class TestDeleteFile {

	public static void main(String[] args) {
		File file = new File("a");
		deleteFile(file);
	}
	
	public static void deleteFile(File file){
		if(file==null){
			throw new RuntimeException("�ļ�Ϊ�գ�");
		}
		if(!file.exists()){
			throw new RuntimeException("�ļ���Ŀ¼�����ڣ�");
		}
		//�����ļ�ֱ��ɾ��
		if(file.isFile()){
			if(!file.delete()){
				throw new RuntimeException(file.getName() + "�ļ�ɾ��ʧ�ܣ�");
			}
		//����Ŀ¼
		}else{
			File[] subs = file.listFiles();
			for(File sub : subs){
				//�ݹ���õ�ǰ����ɾ��
				deleteFile(sub);
			}
			//�����Ŀ¼�µ����������ɾ����ɾ����Ŀ¼
			if(!file.delete()){
				throw new RuntimeException(file.getName() + "Ŀ¼ɾ��ʧ��");
			}
		}
	}
	
//	public static void deleteFile(File dir){
//		while(dir.exists()){
//			dir.delete();
//			if(!dir.exists()){
//				return;
//			}else{
//				File[] files = dir.listFiles();
//				for(File file : files){
//					deleteFile(file);
//				}
//			}
//		}
//	}
	
//	/**
//	 * Ҫ�󣺴����File��һ��Ŀ¼��Ҫ�����ɹ�����Ŀ¼ɾ����ǰ���Ǹ�Ŀ¼�ڲ��ж༶Ŀ¼���ļ�	
//	 * ˼·:
//	 * 	1��ɾ�ڲ��ļ����ļ���(û�����ļ���Ŀ¼)
//	 * 	2ѭ��1���裬ֱ����ǰ�ļ���û�����ļ�������ɾ��
//	 */
//	
//	/**
//	 * ѭ������deleteFileNexine()������ֱ����ǰ�ļ���ɾ��
//	 */
//	public static void deleteFile(File dir){
//		while(dir.exists()){
//			deleteFileNexine(dir);
//		}
//	}
//	/**
//	 * �ݹ����ɾ����ǰ�ļ����ڲ��ļ����ļ���(û�����ļ���Ŀ¼)
//	 * @param dir
//	 */
//	private static void deleteFileNexine(File dir){
//		dir.delete();
//		if(!dir.exists()){
//			return;
//		}else{
//			File[] files = dir.listFiles();
//			for(File file : files){
//				deleteFile(file);
//			}
//		}
//	}
}













