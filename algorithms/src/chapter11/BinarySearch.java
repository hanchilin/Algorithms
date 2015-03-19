package chapter11;

public class BinarySearch {
//二分查找
	public static int rank(int key, int[] a) {
		// 数组必须是有序的
		int lo = 0;
		int hi = a.length-1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid])
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else
				return a[mid];
		}
		return -1;
	}
}
