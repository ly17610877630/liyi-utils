package com.liyi.maven.common_utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:  FileUtil   
 * @Description: �ļ�������  
 * @date:   2020��1��3�� ����9:06:40
 */
public class FileUtil {
	/**
	 * @Title: getExtName   
	 * @Description: �ļ���չ��
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getExtName(String str) {
		if(StringUtil.isNull(str)) {
			return null;
		}
		if(!str.contains(".")) {
			throw new RuntimeException("�޷���ȡ�ļ���չ��");
		}
		return str.substring(str.indexOf("."));
	}
	/**
	 * @Title: delete   
	 * @Description: �ݹ�ɾ���ļ�   
	 * @param: @param file      
	 * @return: void      
	 * @throws
	 */
	public static void delete(File file) {
		/** ��ȡ�ļ��б� **/
		File[] listFiles = file.listFiles();
		for(File theFile : listFiles) {
			/** ������ļ��У��ݹ�ɾ�� **/
			if(theFile.isDirectory()) {
				delete(theFile);
				/** ɾ�����ļ��� **/
				theFile.delete();
			}else {
				/** ������ļ���ֱ��ɾ�� **/
				theFile.delete();
			}
			
		}
	}
	/**
	 * @Title: delete   
	 * @Description: �ݹ�ɾ���ļ�   
	 * @param: @param pathname      
	 * @return: void      
	 * @throws
	 */
	public static void delete(String pathname) {
		delete(new File(pathname));
	}
	/**
	 * ��ȡϵͳ��ǰ�û�Ŀ¼
	 * @return
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	/**
	 * @Title: getSystemTempDirectory   
	 * @Description: ����ϵͳ��ʱĿ¼
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	/**
	 * @Title: getFileSize   
	 * @Description: ����ļ���С
	 * �����ļ���ָ����λ��С��ʾ
	 * File a.txt=2k  
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getFileSize(File file) {
		long length = file.length();
		double len = length/1024.0;
		return String.format("%.2f",len)+"kb";
	}
	/**
	 * @Title: readTextFile   
	 * @Description: TODO(������һ�仰�����������������)   
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFile(File file) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			do {
				String readLine = br.readLine();
				sb.append(readLine);
				sb.append("\r\n");
			}while(br.read()!=-1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			StreamUtil.close(br);
		}
		return sb.toString();
	}
	/**
	 * @Title: readTextFileToList   
	 * @Description: ��ȡ�ı��ļ���list   
	 * @param: @param file
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> readTextFileToList(File file) {
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			do {
				String readLine = br.readLine();
				list.add(readLine);
			}while(br.read()!=-1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			StreamUtil.close(br);
		}
		return list;
	}
	/**
	 * @Title: readTextFileToList   
	 * @Description: ��ȡ�ı��ļ���list   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> readTextFileToList(String pathname){
		return readTextFileToList(new File(pathname));
	}
	
	/**
	 * @Title: writeFile
	 * @Description: ����ָ���ı��������д��ָ�����ļ���
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// ����д����ļ�
		File file = new File(path);
		// �жϸ�Ŀ¼�Ƿ����
		if (!file.getParentFile().exists()) {
			// ������Ŀ¼
			file.getParentFile().mkdirs();
		}
		// �������������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		if(content!=null) {
			bw.write(content);
		}
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: ��ȡ�ļ�����
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// �������������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// ���建�����
		StringBuffer sb = new StringBuffer();
		// �����ȡÿ�еĽ��
		String content = null;
		// ѭ����ȡ
		while ((content = br.readLine()) != null) {
			// ���뻺�����
			sb.append(content);
		}
		// �ر���
		br.close();
		// ���ؽ��
		return sb.toString();

	}
}
