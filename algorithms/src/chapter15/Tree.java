package chapter15;


public class Tree {
	static int count = 0;
	private Node root;	
	private class Node{
		private int val;
		private Node left;
		private Node right;
		public Node(){}
		public Node(int t){
			this.val = t;
			left = null;
			right = null;
		}
		
		public void setNode(int t, Node left, Node right){
			this.val = t;
			this.left = left;
			this.right = right;
		}	
		public int getVal() {
			return val;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setVal(int val) {
			this.val = val;
		}
	}
	public Tree(){}
	public Tree(int t){
		Node n = new Node(t);
		root = n;
	}
	//创建二叉树
	public void createTree(int[] a, int i){
		root = createTree(root, a, i);
	}
	private Node createTree(Node node, int[] a, int i){
		if(i<a.length){
			if(a[i]==0)
				node = null;
			else{
				Node n1 = new Node();
				Node n2 = new Node();
				node.setNode(a[i], createTree(n1,a,++count), createTree(n2,a,++count));
//				System.out.println(node.getVal());
			}
		}
		return node;		
	}
	//先序遍历
	public void preTraverse(){
		preTraverse(root);
	}
	private void preTraverse(Node node){
		if(node != null && node.getVal() != 0){
			System.out.println(node.val);
			preTraverse(node.getLeft());
			preTraverse(node.getRight());
		}
	}
	//后续遍历
	public void postTraverse(){
		postTraverse(root);
	}
	private void postTraverse(Node node){
		if(node != null && node.getVal() != 0){			
			postTraverse(node.getLeft());
			postTraverse(node.getRight());
			System.out.println(node.val);
		}
	}
	//中序遍历
	public void midTraverse(){
		midTraverse(root);
	}
	private void midTraverse(Node node){
		if(node != null && node.getVal() != 0){			
			midTraverse(node.getLeft());
			System.out.println(node.val);
			midTraverse(node.getRight());			
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int i = 0;
		Tree tree = new Tree(a[0]);
		tree.createTree(a, i);
		System.out.println("先序遍历");
		tree.preTraverse();	
		System.out.println("后序遍历");
		tree.postTraverse();
		System.out.println("中序遍历");
		tree.midTraverse();
	}
	
}
