package chapter15;

public class UF {
//union-find�㷨
	private int[] id;		//����id���Դ�����Ϊ������
	private int count;		//��������
	public UF(int N){
		count = N;
		id = new int[N];
		for(int i=0; i<N; i++)
			id[i] = i;
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p) {
		while(id[p] != p)
			p = id[p];
		return p;
	}
	
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot)
			return;
		id[qRoot] = pRoot;
		count--;
	}
	
	public static void main(String[] args) {
		int[][] a = new int[5][5];		//����һ�����飬1Ϊͨ��-1Ϊ��ͨ		
		for(int i =0; i<5; i++)
			for(int j=0; j<5; j++)
				a[i][j] = 1;
		//���ò�ͨ��λ��		
		a[0][1] = -1;
		a[2][1] = -1;
		a[1][3] = -1;
		a[2][3] = -1;
		a[3][3] = -1;
		a[4][2] = -1;
		a[2][4] = -1;
		
		UF b = new UF(25);		//��ʼ��union-findʵ��
		
		//��union-find������ͨ������λ
		for(int i =0; i<5; i++){
			for(int j=0; j<5; j++){
				if(i == 0){
					if(j > 0){
						if(a[i][j-1] == a[i][j])
							b.union(j-1, j);
					}					
				}
				else if (j>0) {					
					if(a[i][j-1] == a[i][j]){
						if(a[i-1][j] == a[i][j]){
							b.union(i*5+j-1, i*5+j);
							b.union(i*5+j-1, (i-1)*5+j);
						}
						else {
							b.union(i*5+j-1, i*5+j);
						}						
					}
					else {
						if (a[i-1][j] == a[i][j])
							b.union((i-1)*5+j, i*5+j);
					}																
				}
				else if(j==0) {
					if(a[i-1][j] == a[i][j])
						b.union((i-1)*5+j, i*5+j);					
				}				
			}
			
		}
		
		System.out.println("ԭʼ����");
		for(int i=0;i<5;i++){
			for(int j : a[i])
				System.out.printf("%3d",j);
			System.out.println();
		}
		System.out.println("======================");
		//��������λ�ã��ж��Ƿ���ͨ
		boolean re = b.connected(0, 4);
		System.out.println("�Ƿ���ͨ��"+re);
		int n = 0;
		for(int i :b.id){
			System.out.printf("b[%-2d]=%-4d",n,i);
			n++;			
			if(n%5 == 0)
				System.out.println();
		}
		
	}
}
