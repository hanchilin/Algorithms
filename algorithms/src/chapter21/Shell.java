package chapter21;

import java.util.Random;

public class Shell {
	//Ï£¶ûÅÅĞò
	public static void sort (Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h < N/3)
			h = 3*h+1;
		while(h>=1){
			for(int i=0; i<N; i++){
				for(int j=i; j>=h && less(a[j], a[j-h]); j-=h)
					exch(a,j,j-h);
			}
			h = h/3;
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
	
	public static void main(String[] args) {
		Integer[] s = new Integer[20];
		Random ran = new Random();
		for(int i=0; i<20; i++)
			s[i] = ran.nextInt(100);
		for(int i : s)
			System.out.print(i + " ");
		System.out.println();
		
		Shell sl = new Shell();
		sl.sort(s);
		for(int i : s)
			System.out.print(i + " ");
	}
}
