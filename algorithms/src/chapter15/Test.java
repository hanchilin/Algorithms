package chapter15;
/**
 *@author   CW 
 *@Email    cw_jdmc@126.com
 *@date     2014年9月2日下午8:14:10
 *@version  0.1
 */
public class Test {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		int num = 100;
		System.out.println(i == num);
		
		String s = new String("sss");
		String sr = "sss";
		System.out.println(s == sr);
		
		
		Integer i4=100,i1=100;
		Integer i2=188,i3=188;
		System.out.println(i4 == i1);
		System.out.println(i2 == i3);
		
		Integer m = new Integer(100);
		
		
		
		Long l1=100l,l2=100l;
		Long l3=188l,l4=188l;
		System.out.println(l1 == l2);
		System.out.println(l3 == l4);
	}
	

}
