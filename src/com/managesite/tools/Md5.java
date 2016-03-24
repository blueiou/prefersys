package com.managesite.tools;

import java.security.MessageDigest;

public class Md5 {
	public final static String getMD5(String s) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',

		'a', 'b', 'c', 'd', 'e', 'f' };

		try {

		byte[] strTemp = s.getBytes();

		// ʹ��MD5����MessageDigest����

		   MessageDigest mdTemp = MessageDigest.getInstance("MD5");

		   mdTemp.update(strTemp);

		byte[] md = mdTemp.digest();

		int j = md.length;

		char str[] = new char[j * 2];

		int k = 0;

		for (int i = 0; i < j; i++) {

		byte b = md[i];

		//System.out.println((int)b);

		// ��ÿ����(int)b����˫�ֽڼ���

		    str[k++] = hexDigits[b >> 4 & 0xf];

		    str[k++] = hexDigits[b & 0xf];

		   }

		return new String(str);

		  } catch (Exception e) {

		return null;

		  }

		 }

		 
}
