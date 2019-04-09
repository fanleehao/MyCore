package Leetcode;

import javax.annotation.Resource;

/** 
 * @author fanleehao
 * @date 创建时间：2019年2月28日 下午7:52:31 
 * @desc 
 **/
public class StringMultiply_43 {
	
	public static String multiply(String num1, String num2) {
		char[] ret = new char[num1.length() + num2.length()];
		for(int i = num1.length() - 1; i >= 0; i--){
			for(int j = num2.length() - 1; j >= 0; j--){
				ret[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		int carry = 0;
		for(int i = ret.length-1; i >= 0; i--){   //char类型会自动转成int进行计算
			ret[i] += carry;
			carry = ret[i] / 10;
			ret[i] = (char) (ret[i] % 10);
		}
		int index = 0;
		while(ret[index]==0 && index < ret.length - 1){  //char默认初始值为空，与0相等的,与' '字符不等
			index++;
		}
		for(int i = index;i<ret.length;i++){
			ret[i] += '0';   //把数组结果转成一个字符结果，如3-》'3';
		}		
		return new String(ret, index, ret.length - index);
	}
	/**
	 * 
	 * @return
	 */
	public static String multiply2(String num1, String num2) {
		int[] ret = new int[num1.length() + num2.length()];
		for(int i = num1.length() - 1; i >= 0; i--){
			for(int j = num2.length() - 1; j >= 0; j--){
				int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');  //直接处理每次的进位
				tmp += ret[i+j+1];
				ret[i+j] += tmp / 10;
				ret[i+j+1] = tmp % 10;				
			}
		}
		//去前缀0
		int index = 0;
		while(index < ret.length - 1 && ret[index] == 0)   //ret.length - 1是因为要保留最后一个0
			index++;
		StringBuilder sb = new StringBuilder();
		for(;index<ret.length;index++){
			sb.append(ret[index]);
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		char c[] = new char[10];
		int a = 10;
		System.out.println(c[0]==0);   //true
		String  string = "435";
		c[1] = (char) ((string.charAt(0)-'0')*(string.charAt(1)-'0'));
		System.out.println(c[1]);    //非打印字符
		c[2] += (string.charAt(0)-'0')*(string.charAt(1)-'0');
		System.out.println(c[2]);     //非打印字符
		c[2] %= 10;
		System.out.println(c[2]+'0');  //50   -> 2+48
		
		System.out.println(multiply("100", "100"));  //10000
		System.out.println(multiply2("100", "99"));  
	}

}
