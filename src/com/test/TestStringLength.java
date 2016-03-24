package com.test;

import java.util.ArrayList;
import java.util.List;


public class TestStringLength {

	
	public static List<String> splitString(String str,int length){
		List<String> ret=new ArrayList<String>();
		if(length>=str.length()){
		ret.add(str);
		}else{
		//�����д��δ���?
			while(length<str.length())
			{
			ret.add(str.substring(0,length));
			str = str.substring(length,str.length());
			}
			ret.add(str);
			
		}
		return ret;

		}
	public static void main(String args[]){
		
		
	//	System.out.print(splitString("111111122222222221111211121212121212121212121212221121111121211111",6));
		List dataList=splitString("11111112222222222111121112121211212121212121212221121111121211111", 1);
	
		
		String temp="";
		//String tb="";
		for(int i=0;i<dataList.size();i++){
			//System.out.print("{"+dataList.get(i)+"},");
			//temp=temp+"{"+dataList.get(i)+"},";
			//temp.substring(0,temp.length()-1);
			//String aa= dataList.get(i)).substring(0,dataList.get(i).length()-1);
			temp=temp+dataList.get(i)+",";
			
			
		}
		
		//String source="1,1,1,1,1,11,2,2,2,2,2,21,1,1,1,1";	
		//String s1=temp;
	/*	List dataList2=splitString(temp,11);
		String temp2="";
		for(int j=0;j<dataList2.size();j++){
			//System.out.print("{"+dataList.get(i)+"},");
			//temp=temp+"{"+dataList.get(i)+"},";
			temp2=temp2+dataList2.get(j)+";";
		}*/
		System.out.print(temp);
		//String[] a = temp2.split(",&&;");
		
//		int j;
//		j=dataList.size();
//		List daList=splitString(temp, j/12);
//		for(int i=0;i<j;i++){
//			tb=tb+temp+";";
//		}
	//	String datalistString
	//	System.out.print("��ݣ�"+temp);
		
	}
	
	public static void main1(String args[]){
	String source="1,1,1,1,1,11,2,2,2,2,2,21,1,1,1,1";	
	int needLength=10;
	List<String> resultList = new ArrayList<String>(source.length()% needLength + 1);
    String subStr;
    int endIndex = 0;
    while (source.length() > 0) {
        // �жϽ�ȡ�ĳ���
        endIndex = source.length() > needLength?needLength: source.length();
        // ��ý����ĳ���
        subStr = source.substring(0, endIndex);
        // ��ȡʣ����ַ�
        source = source.substring(endIndex);
        resultList.add(subStr);
    }
    System.out.println(resultList);
	}
}
