package chapter21;

import java.util.Random;

public class Insertion {
	//插入排序
	public static void sort(Comparable[] a){
		//将a[]按升序排列
		int N = a.length;
		for(int i=0; i<N; i++){
			for(int j=i; j>0 && less(a[j], a[j-1]); j--)
				exch(a,j,j-1);
		}
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) throws InterruptedException {
		Integer[] s = new Integer[2000];
		Integer[] s1 = new Integer[2000];
		Random ran = new Random();
		for(int i=0; i<2000; i++){
			s[i] = ran.nextInt(10000);
			s1[i] = s[i];
		}
		
		Selection sl = new Selection();
		Insertion is = new Insertion();
		
		
		
		
//		long t1 = System.currentTimeMillis();
//		is.sort(s);
//		long isTime = System.currentTimeMillis() - t1;
//		System.out.println("插入排序用时："+isTime);
		
		long t2 = System.currentTimeMillis();
		sl.sort(s1);
		long slTime = System.currentTimeMillis() - t2;
		System.out.println("选择排序用时："+slTime);
	}
}
