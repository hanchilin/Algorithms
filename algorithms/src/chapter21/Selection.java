package chapter21;

import java.util.Random;

public class Selection {
	//选择排序
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void sort(Comparable[] a){
		//将a[]按升序排列
		int N = a.length;
		for(int i = 0; i < N; i++){
			int min = i;
			for(int j=i+1; j<N; j++){
				if(less(a[j],a[min]))
					min = j;
			}
			exch(a,min,i);
		}
	}
	
	public static void main(String[] args) {
		Integer[] s = new Integer[20];
		Random ran = new Random();
		for(int i=0; i<20; i++)
			s[i] = ran.nextInt(100);
		for(int i : s)
			System.out.print(i + " ");
		System.out.println();
		
		Selection sl = new Selection();
		sl.sort(s);
		for(int i : s)
			System.out.print(i + " ");
	}
}
