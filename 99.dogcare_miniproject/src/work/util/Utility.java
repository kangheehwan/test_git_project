package work.util;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utility {

	public static String[] ascSort(String names[]) {

		System.out.println("\n## ������ �̸� ���(��������)");
		String temp1;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (names[i].compareTo(names[j]) < 0) {
					temp1 = names[i];
					names[i] = names[j];
					names[j] = temp1;
				}
			}
		}
		return names;
	}

	public static String[] descSort(String names[]) {

		System.out.println("\n## ������ �̸� ���(��������)");
		String temp1;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (names[i].compareTo(names[j]) > 0) {
					temp1 = names[i];
					names[i] = names[j];
					names[j] = temp1;
				}
			}
		}
		return names;
	}

	public static int[] ascSort(int names[]) {

		System.out.println("\n## int������ �̸� ���(��������)");
		int temp;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (names[i] < (names[j])) {
					temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}

			}
		}
		return names;
	}

	public static int[] descSort(int names[]) {

		System.out.println("\n## int������ �̸� ���(��������)");
		int temp;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (names[i] > (names[j])) {
					temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}

			}
		}
		return names;
	}
	//// System.out.println("\n## int������ �̸� ���(��������)" );
	//// String temp;
	//// for(int i =0; i<names.length; i++){
	//// for(int j=0; j<names.length; j++){
	//// if(names[i].compareTo(names[j])> 0){
	//// temp =names[i];
	//// names[i]=names[j];
	//// names[j]=temp;
	//// }
	////
	////

	public static String getSecureCode() {

		StringBuilder code = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			code.append((int) (Math.random() * 10));
		}
		return code.toString();
	}

	public static String getSecureCode(int length) {

		StringBuilder code = new StringBuilder();
		for (int i = 0; i < length; i++) {
			code.append((int) (Math.random() * 10));
		}
		return code.toString();
	}

	public static String convertSecureCode(String code, int i) {
		int l = code.length();
		if ((l - i) > 0 && (l > i)) {
			StringBuilder StringBuilder = new StringBuilder(code.substring(0, i));
			for (int j = i; j < l; j++) {
				StringBuilder.append("*");
			}
			return StringBuilder.toString();
		} else {
			return code;
		}
	}

	public static String convertSecureCode(String code) {
		return convertSecureCode(code, 2);
	}

	public static String getSecureAlphabet() {
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			char ch = (char) ((Math.random() * 26) + 65);
			code.append(ch);
		}
		return code.toString();

	}

	public static String getSecureNumberAndAlphabet() {
		StringBuilder code = new StringBuilder();
		char ch = (char) ((Math.random() * 26) + 65);
		code.append(ch);
		ch = (char) ((Math.random() * 26) + 65);
		code.append(ch);
		for (int i = 0; i < 2; i++) {
			code.append((int) (Math.random() * 10));
		}
		return code.toString();

	}

	public static String getSecureNumberAndAlphabet(int length) {
		StringBuilder code = new StringBuilder();
		char ch = (char) ((Math.random() * 26) + 65);
		code.append(ch);
		ch = (char) ((Math.random() * 26) + 65);
		code.append(ch);
		for (int i = 0; i < length - 2; i++) {
			code.append((int) (Math.random() * 10));
		}
		return code.toString();
	}

	public static String getCurrentDate() {

		// //��¥����(�⺻) ��4�ڸ�/ ��2�ڸ� /��2�ڸ�
		// String pattern ="yyyy/MM/dd";
		// //��¥���� ��ü ����
		// SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		// //��¥ ���İ�ü�� �޼��带 �̿��ؼ� ���糯¥�� ������ ������ ���ڿ� ��ȯ
		// return dateFormat.format(new Date());

		return getCurrentDate("yyyy/MM/dd");
	}

	public static String getCurrentDate(String pattern) {
		// //��¥����(�⺻) ��4�ڸ�/ ��2�ڸ� /��2�ڸ�
		// String pattern ="yyyy/MM/dd";
		// ��¥���� ��ü ����
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		// ��¥ ���İ�ü�� �޼��带 �̿��ؼ� ���糯¥�� ������ ������ ���ڿ� ��ȯ
		return dateFormat.format(new Date());

	}

	public static String getCurrentDate(String pattern, Locale locale) {
		// //��¥����(�⺻) ��4�ڸ�/ ��2�ڸ� /��2�ڸ�
		// String pattern ="yyyy/MM/dd";
		// ��¥���� ��ü ����
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
		// ��¥ ���İ�ü�� �޼��带 �̿��ؼ� ���糯¥�� ������ ������ ���ڿ� ��ȯ
		return dateFormat.format(new Date());

	}

	/**
	 * ���ڸ� ������ õ�������� �ĸ�ǥ�� ��ȯ
	 * 
	 * @see java.text.NumberFormat
	 * @param data
	 * @return
	 */
	public static String convertNumber(long data) {
		NumberFormat numberFormat = NumberFormat.getInstance();

		return numberFormat.getInstance().format(data);

	}

	public static String convertCurrency(int data, Locale locale) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		return NumberFormat.getCurrencyInstance().format(data);

	}

	public static String convertSecureCode(int length) {
		StringBuilder code = new StringBuilder();
		String userPw = "pass01";
		code = code.append(userPw.substring(0, 2));
		for (int i = 2; i < userPw.length(); i++) {
			code.append("*");
			// if(data !=null && data.length()>length){
			// StringBuilder convertData = new StringBuilder(0,length);
			// convertData.append("*");
			// }
			// return convertData
		}

		return code.toString();
	}

	/** �����Ð��̼��� get ����� �ѱ� ���ڵ� ��ȯ �޼��� */
	public static String toKor(String data) {
		try {
			return new String(data.getBytes("8859_1"), "euc-kr");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

}
