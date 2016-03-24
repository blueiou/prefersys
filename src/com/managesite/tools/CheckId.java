package com.managesite.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CheckId {

public static boolean checkId(String pid){
	//int id=-1;
	 //pid="121212sdas";
	String regStr = "^[+-]?[1-9][0-9]*$|^0$";
	if(pid.matches(regStr)){
		//id=Integer.parseInt(pid);
		return true;
	   }else{
		  // id=1;
		   //System.out.print(pid);
		   return false;
	   }
}
//������ȷ��Ϊ��ֵ��
public static boolean checkPage(String str){
	boolean result=str.matches("[0-9]+");
	if (result == true) return true;
	else return false;
}

public static boolean checkData(String str){
	boolean result=str.matches("[1-2]+");
	if (result == true) {
	return true;}
	else return false;
}
/*
 * 
 * 
 * ������ʽ��ֻ��������ĸ,����,�»���
 */
public static boolean checkUN(String str){
	return str.matches("[A-Za-z0-9_]+");
	
}
/*public static void main(String args[])
{
	CheckId checkId=new CheckId();
System.out.print(checkId.checkPage("12121224o"));}	*/
//	String str="121211112222220222222222222222222222222222222222222222222222222222222222222";
//	boolean result=str.matches("[1-2]+");
//	if (result == true) {
//	System.out.println("���ַ��Ǵ�����");}
//	else{System.out.println("���ַ��Ǵ�����");}
/*String str="1 2 1 1 1 1,1 1 1 1 1 1,1 1 1 1 1 1,1 1 1 2 2 1,2 1 2 1 2,2 2 2 2 2 2,2 2 2 2 2 2,2 2 2 2 2 2,2 2 2 2 2 2,2 2 2 2 2 2,1";
str = str.replace(" ","");
str = str.replace(",","");
String tabBegin = "���Ϊ��";

str = tabBegin + str;
//	
	System.out.print(str);*/
//	String [] dataStrings = str.split("1");
//	List<String> cls = new ArrayList<String>();
//	for(int i=0;i<dataStrings.length;i++){
//	    cls.add(dataStrings[i]);
//
//	}
	
/*	
	String  str = "121111111111111111111221212122222222222222222222222222222221";
	
	char data[] = str.toCharArray();

	 for(int i=0;i<data.length;i++)
     {
         System.out.print(data[i]);
		 
     }*/

	 //string str="afdsafasdfaaafddabadsdfdfd";  
/*	    List temp=Regex.Split(str,"(?<=\G.{4})(?!$)");  
	//    temp.ToList().ForEach(t=>Console.WriteLine(t));  
	
	    temp.ToList();
	    for(var i=0;i<temp.ToList().length;i++){
	    	
	    	
	    	alert(temp.ToList()[i]);
	    }*/
	
	
	
	
	
	
	//CheckId checkId=new CheckId();

  //System.out.print(checkId.getClass().getClassLoader().getResource(".").getPath());
//	String datasString="111111122222222221111211121212121212121212121212221121111121211111";
//	System.out.println("-----------��ݳ���:"+datasString.length()+"------------------");
//	if (datasString.length()>60) {
//		datasString=datasString.substring(1, 60);
//	}

//	System.out.println(datasString);
	
//	String str="11111622222622221111211121212121212121212121212221121111121211111" ;
//	String temp="";
//	for( int i = 0 ; i < str.length() ; i++ ){
//	  //  System.out.print( str.charAt( i )+" ;" );
//	    temp=temp+str.charAt( i )+";";
//	}
//	System.out.print(temp.substring(0,str.length()-1));
	/*
	for(int i=0;i<8;i++){
		
		for (int j=0;j<8-i;j++){
			System.out.print(" ");
		}
		for (int j=0;j<i;j++){
			System.out.print(i+1+" ");
		}
		System.out.println();
	}*/
	/*	int line = 6; // ���ε�������(5��5��)
	int kuan=10;
	
	for (int i = 1; i <= line; i++) { // ������
	for (int j = 1; j <= kuan; j++) { // ������
	if (i == 1 || i == line) { // ����ǵ�һ�л��������һ�����ӡ�Ǻ�
	System.out.print("*");
	} else if (j == 1 || j == kuan) { // ����ǵ�һ�л��������һ�����ӡ�Ǻ�
	System.out.print("*");
	} else {
	System.out.print(" "); // ����ǵ�һ�С����һ�С���һ�С����һ�����ӡ�ո�
	}
	}*/
/*		 if (j <= kuan) { // ����ǵ�һ�л��������һ�����ӡ�Ǻ�
			//System.out.print("*");
			 String str="11111622222622221111211121212121212121212121212221121111121211111" ;
				for( int x = 0 ; x < 6 ; x++ ){
					System.out.println( str.charAt( i ) );
				}
			
			} else {
			System.out.print(" "); // ����ǵ�һ�С����һ�С���һ�С����һ�����ӡ�ո�
			}
			}	
	System.out.print("\n"); // ����
	}*/
	
	
	
	
//}

}
