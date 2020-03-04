package com.liyi.maven.common_utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @ClassName:  StringUtil   
 * @Description:�ַ���������    
 * @date:   2020��1��3�� ����9:08:16
 */
public class StringUtil {
	
	/**
	 * ����˵����ʵ���жϴ�����ַ����Ƿ�Ϊ����http��url��ַ
	 */
	public static boolean isHttpUrl(String src){
		return src.startsWith("http:");
	}
	
	/**
	 * @Title: isNull   
	 * @Description: �ж��ַ����Ƿ�Ϊ��   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNull(String str) {
		if(str==null) {
			return true;
		}
		/** ȥ�ո�����Ϊ"",����true **/
		str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
	/**
	 * @Title: isNotNull   
	 * @Description: �ж��ַ�����Ϊ��   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	/**
	 * @Title: isPhoneNum   
	 * @Description: �Ƿ�Ϊ�ֻ���   18618109887
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}
	/**
	 * @Title: isEmail   
	 * @Description: �ж��Ƿ�Ϊ���� zhanggm1002@qq.com   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isEmail(String str) {
		String regex = "\\w+@\\w+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	/**
	 * @Title: isLetter   
	 * @Description: �ж��Ƿ�ȫΪ��ĸ   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isLetter(String str) {
		if(isNull(str)) {
			return false;
		}
		str = str.toLowerCase();
		String regex = "[a-z]+";
		return str.matches(regex);
	}
	/**
	 * @Title: isNumber   
	 * @Description:    
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNumber(String str) {
		if(isNull(str)) {
			return false;
		}
		str = str.toLowerCase();
		String regex = "[0-9]+";
		return str.matches(regex);
	}
	/**
	 * @Title: getRandomChar   
	 * @Description: ������һ���ַ�   
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomChar() {
		Random random = new Random();
		char c = (char)('a'+random.nextInt(26));
		return c;
	}
	/**
	 * @Title: getRandomChar   
	 * @Description: ���ָ��λ��������ַ�   
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomChar(int num) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num;i++) {
			char c = getRandomChar();
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * @Title: getRandomNumber   
	 * @Description: ����������   
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomNumber() {
		Random random = new Random();
		char c = (char)('0'+random.nextInt(10));
		return c;
	}
	
	/**
	 * @Title: getRandomCharAndNumber   
	 * @Description: �������ַ���������+�ַ���   
	 * @param: @param num
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static String getRandomCharAndNumber(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<num;i++) {
			int randomNum = random.nextInt(36);
			if(randomNum>10) {
				char c = getRandomChar();
				sb.append(c);
			}else {
				char c = getRandomNumber();
				sb.append(c);
			}
		}
		return sb.toString();
	}
	/**
	 * @Title: randomChineseString   
	 * @Description: �������   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// λ�룬0xA0��ͷ����Χ��1~94��
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * @Title: randomChineseString   
	 * @Description: ����������   
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString(int num) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num;i++) {
			String randomChineseString = randomChineseString();
			sb.append(randomChineseString);
		}
		return sb.toString();
	}
	/**
	 * @Title: randomChineseName   
	 * @Description: �ټ��� ��������  
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseName() {
		String[] surname = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��",
				"ۺ", "��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��",
				"տ", "��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��",
				"��", "��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��",
				"÷", "ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��",
				"��", "¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��",
				"��", "��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ",
				"��", "��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��",
				"��", "̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "ȴ", "�", "ɣ", "��", "�", "ţ", "��", "ͨ",
				"��", "��", "��", "��", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ۣ", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "˧", "��", "��", "��", "�C", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��",
				"��", "��", "��", "١", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "չ", "��", "̴", "��", "��", "��", "��",
				"˴", "¥", "��", "ð", "��", "ֿ", "��", "��", "��", "��", "ԭ", "��", "��", "��", "��", "��", "�", "��", "��", "��", "�",
				"��", "��", "��", "��", "��", "��", "��", "ľ", "��", "��", "ۨ", "��", "ö", "��", "��", "�", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "�G", "��ٹ", "˾��", "�Ϲ�", "ŷ��",
				"�ĺ�", "���", "����", "����", "����", "�ʸ�", "����", "ξ��", "����", "�̨", "��ұ", "����", "���", "����", "����", "̫��", "����",
				"����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "أ��", "˾��", "����", "����", "�ӳ�",
				"���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����", "����", "΢��", "����",
				"����", "����", "����", "�Ϲ�", "����", "����", "����", "̫ʷ", "�ٳ�", "����", "��ͻ", "����", "����", "����", "��ĸ", "˾��", "����",
				"Ӻ��", "����", "����", "����", "��®", "����", "�Ϲ�", "����", "����" };
		// �����ȡ����
		String name1 = surname[RandomUtil.random(0, surname.length - 1)];
		// �����ȡ1-2������
		String name2 = randomChineseString(RandomUtil.random(1, 3));
		return name1 + name2;
	}
	
	/**
	 * @Title: randomSex 
	 * @Description: ��������Ա���|Ů��
	 * @return
	 * @return: String
	 */
	public static String randomSex() {
		String[] sex = { "��", "Ů"};
		return sex[RandomUtil.random(0, 1)];
	}
	
	/**
	 * @Title: getRandomPhone 
	 * @Description: ��ȡ����ĵ绰����13��ͷ
	 * @return
	 * @return: String
	 */
	public static String getRandomPhone() {
		String regex = "13";
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			char c = (char)('0'+random.nextInt(10));
			regex+=c;
		}
		return regex;
	}
	
	/**
	 * @Title: getRandomEmail 
	 * @Description: ��ȡ���������
	 * @return
	 * @return: String
	 */
	public static String getRandomEmail() {
		String[] sex = { "@qq.com", "@163.com", "@sian.com", "@gmail.com", "@sohu.com", "@hotmail.com", "@foxmail.com"};
		String email = "";
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			char c = (char)('0'+random.nextInt(10));
			email+=c;
			if(i>=3) {
				String[] suijishu = { "0", "1"};
				if(suijishu[RandomUtil.random(0, 1)].equals("0")) {
					break;
				}
				if(suijishu[RandomUtil.random(0, 1)].equals("1")) {
					continue;
				}
				
			}
		}
		return email+sex[RandomUtil.random(0, 6)];
	}
	
	/**
	 * @Title: getRandomBirthday 
	 * @Description: ��ȡ���������
	 * @return
	 * @return: String
	 */
	public static String getRandomBirthday() {
		Random random = new Random();
		String nian = "";
		String yue = "";
		String ri = "";
		nian = nian+random.nextInt(2020+1);
		yue=yue+random.nextInt(12-0+1);
		ri=ri+random.nextInt(30-0+1);
		return nian+"-"+yue+"-"+ri;
	}
	
	public static void main(String[] args) {
		String randomBirthday = getRandomBirthday();
		System.out.println(randomBirthday);
	}
}

