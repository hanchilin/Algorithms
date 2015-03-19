package chapter11;

public class SimAlgo {

	public static boolean isPrime(int N) {
		//�ж�һ�����Ƿ�Ϊ����
		if(N < 2)
			return false;
		for(int i=2; i*i <=N; i++){
			if(N%i == 0)
				return false;
		}
		return true;
	}
	
	public static double sqrt(double b){
		//����ƽ������ţ�ٵ�������
		if(b < 0)
			return Double.NaN;
		double err = 1e-15;
		double sq = b;
		while(Math.abs(sq - b/sq) > err*b)
			sq = (b/sq + b) / 2.0;
		return sq;
	}
}
