package datastructure.main;

import datastructure.list.LinkedList;
import datastructure.node.TreeNode;
import datastructure.queue.Queue;
import datastructure.stack.Stack;
import datastructure.tree.BinarySortTree;
import datastructure.tree.BinaryTree;
import datastructure.tree.ThreadBinaryTree;

public class Main {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// LinkedList ����
		LinkedList<String> lst = new LinkedList<String>();
		lst.add("a");
		lst.add("ab");
		lst.add("abc");
		lst.add("abcd");
		System.out.println(lst.size());
		for(int i = 0; i < lst.size(); i++)
		{
			System.out.println(lst.get(i));
		}
		lst.remove();
		System.out.println(lst.size());
		
		//Stack ����
		Stack<String> stk = new Stack<String>();
		stk.init();
		stk.push("x");
		stk.push("y");
		stk.push("z");
		stk.push("m");
		stk.push("n");
		System.out.println("ջ��Ԫ�ظ�����" + stk.size());
		System.out.println(stk.getTop());
		System.out.println(stk.getTop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.isEmpty());
		System.out.println(stk.pop());
		System.out.println(stk.isEmpty() + "\n");
		
		// Queue ����
		Queue<String> queue = new Queue<String>();
		queue.init();
		System.out.println(queue.isEmpty() + " : " + queue.size());
		queue.add("aa");
		queue.add("bb");
		queue.add("cc");
		queue.add("dd");
		System.out.println(queue.getFront() + " size: " + queue.size());
		System.out.println(queue.getFront() + " size: " + queue.size());
		System.out.println(queue.deleteFront());
		System.out.println(queue.deleteFront());
		System.out.println(queue.deleteFront());
		System.out.println(queue.deleteFront() + " \nsize: " + queue.size());
		
		
		// Binary ����
		BinaryTree<Character> bTree = new BinaryTree<Character>();
		TreeNode<Character> root = bTree.createTree("A(B(D,E(F(H(I,J),),G(,K(L(N,),M(,P))))),C(Q(R(T,),S(U,V(,W(,X(Y,Z))))),))@");
		//TreeNode root = bTree.createTree("A(B(C(,F(,M(N,L))),D),G(E,I(J,K))))@");
		System.out.println("\n---------pre-------------");
		bTree.preorder(root);
		System.out.println("\n---------pre---nonrecursion----------");
		bTree.preorderNonRecursion(root);
		
		System.out.println("\n\n---------post-------------");
		bTree.postorder(root);
		System.out.println("\n---------post---nonrecursion----------");
		bTree.postorderNonRecursion(root);
		
		System.out.println("\n\n----------in------------");
		bTree.inorder(root);
		System.out.println("\n----------in---nonrecursion---------");
		bTree.inorderNonRecursion(root);
		
		System.out.println("\n\n----------layer------------");
		bTree.layerOrder(root);
		
		System.out.println("\n\n----------------------\n");
		TreeNode<Character> root2 = bTree.createTree("A(,B(,C(E,D)))@");
		//TreeNode root2 = bTree.createTree("A(B(C(D,E),),)@");
		System.out.println("\n---------pre-------------");
		bTree.preorder(root2);
		System.out.println("\n---------pre---nonrecursion----------");
		bTree.preorderNonRecursion(root2);
		
		System.out.println("\n\n---------post-------------");
		bTree.postorder(root2);
		System.out.println("\n---------post---nonrecursion----------");
		bTree.postorderNonRecursion(root2);
		
		System.out.println("\n\n----------in------------");
		bTree.inorder(root2);
		System.out.println("\n----------in---nonrecursion---------");
		bTree.inorderNonRecursion(root2);
		
		System.out.println("\n\n----------layer------------");
		bTree.layerOrder(root2);
		
		// ���Զ������ĸ��� �ȼ� ��� ĳһ�ڵ����ڲ��
		TreeNode<Character> root3 = bTree.copyBTree(root);
		Boolean equal = false;
		equal = bTree.equalBTree(root, root2);
		System.out.println("\n �Ƿ�ȼ�:" + equal);
		equal = bTree.equalBTree(root, root3);
		System.out.println("\n �Ƿ�ȼ�:" + equal);
		equal = bTree.equalBTree(root2, root3);
		System.out.println("\n �Ƿ�ȼ�:" + equal);
		
		int treeDepth = 0;
		treeDepth = bTree.depth(root);
		System.out.println("\n ���������:" + treeDepth);
		treeDepth = bTree.depth(root2);
		System.out.println("\n ���������:" + treeDepth);
		treeDepth = bTree.depth(root3);
		System.out.println("\n ���������:" + treeDepth);
		
		int nodeLayer = 0;
		nodeLayer = bTree.getNodeLayer(root2, 'A');
		System.out.println("\n �ڵ����ڲ��:" + nodeLayer);
		nodeLayer = bTree.getNodeLayer(root2, 'B');
		System.out.println("\n �ڵ����ڲ��:" + nodeLayer);
		nodeLayer = bTree.getNodeLayer(root2, 'C');
		System.out.println("\n �ڵ����ڲ��:" + nodeLayer);
		nodeLayer = bTree.getNodeLayer(root2, 'E');
		System.out.println("\n �ڵ����ڲ��:" + nodeLayer);
		
		// ���Զ��������Һ��ӽ��� ɾ��������Ϊ�������ݵĽڵ㼰������  ��ȡҶ�ڵ������
		System.out.println("\n\n----------����ǰ��α��������------------");
		bTree.layerOrder(root);
		bTree.exchangeBTreeLRChild(root);
		System.out.println("\n----------�������α��������------------");
		bTree.layerOrder(root);
		
		int leafNodesNum = 0;
		System.out.println("\n\n----------Ҷ�ڵ�������------------");
		leafNodesNum = bTree.getLeafNodesNumber(root);
		System.out.println(leafNodesNum);
		
		bTree.exchangeBTreeLRChild(root);
		System.out.println("\n\n----------ɾ��ǰ��α��������------------");
		bTree.layerOrder(root);
		bTree.deleteNodeAndItsSubtree(root, 'C');
		System.out.println("\n\n----------ɾ�����α��������------------");
		bTree.layerOrder(root);
		System.out.println("\n\n----------Ҷ�ڵ�������------------");
		leafNodesNum = bTree.getLeafNodesNumber(root);
		System.out.println(leafNodesNum);
		System.out.println("\n\n----------Ҷ�ڵ�������------------");
		leafNodesNum = bTree.getLeafNodesNumber(root2);
		System.out.println(leafNodesNum);
		
		// ���������������������ɡ�����
		ThreadBinaryTree<Character> threadTree = new ThreadBinaryTree<Character>();
		TreeNode<Character> threadRoot = threadTree.createTree2("A(B(D,E(F(H(I,J),),G(,K(L(N,),M(,P))))),C(Q(R(T,),S(U,V(,W(,X(Y,Z))))),))@");
		System.out.println("\n\n----------in------------");
		bTree.inorder(threadRoot);
		System.out.println("\n----------in---nonrecursion---------");
		bTree.inorderNonRecursion(threadRoot);
		TreeNode<Character> threadhead = threadTree.inorderThreadBTree(threadRoot);
		//System.out.println("\n" + threadhead.lBit  + " : " + threadhead.rBit + " : " + threadhead.rChild.lBit + " : " + threadhead);
		
		
		System.out.println("\n\n----------������������������------------");
		threadTree.inorderByThreadBTree(threadhead);
		
//		// ����ÿ�����뵥���ַ� ���ɶ�����
//		BinaryTree<Character> cTree = new BinaryTree<Character>();
//		TreeNode<Character> cRoot = null;
//		cRoot = cTree.createTreeByPreorder(cRoot);
//		System.out.println("\n\n----------ǰ�������------------");
//		cTree.inorder(cRoot);
		
		// ���� ����������
		BinarySortTree<Integer> sortTree = new BinarySortTree<Integer>();
		TreeNode<Integer> sortTreeRoot = null, sortTreeNode = null;
		Integer[] nodeSequence = new Integer[]{1,0,4,5,3,6,2,39,15,1000,500,3000,10,8,9,7};
		//sortTreeRoot = sortTree.createBinarySortTree(nodeSequence);  // �ݹ����ɶ���������
		sortTreeRoot = sortTree.createBinarySortTreeNonRecursion(nodeSequence); // �ǵݹ����ɶ���������
		System.out.println("\n\n----------������������������------------");
		sortTree.inorder(sortTreeRoot);
		sortTreeNode = sortTree.search(sortTreeRoot, 1000);
		sortTreeNode = sortTree.searchNonRecursion(sortTreeRoot, 15);
		if(sortTreeNode != null)
			System.out.println("\n\n�������������ҷ��ؽ���ֵ��" + sortTreeNode.data.intValue());
		
		sortTreeRoot = sortTree.deleteBinarySortTreeNode(sortTreeRoot, sortTree.search(sortTreeRoot, 1), sortTree.searchParentNode(sortTreeRoot, 1));
		System.out.println("\n\n----------ɾ���ڵ��������������������------------");
		sortTree.inorder(sortTreeRoot);
		System.out.println("\n\n----------ɾ���ڵ���α��������������------------");
		sortTree.layerOrder(sortTreeRoot);
		
		//sortTree.cr
		
	}

}























