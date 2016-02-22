package datastructure.tree;

import java.util.Scanner;

import datastructure.node.TreeNode;
import datastructure.queue.Queue;
import datastructure.stack.Stack;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class BinaryTree<T> {
	
	
	private static final int STACK_LENGTH = 1000;
	/**
	 * ������������by myself��
	 * �ô����㷨�������ڴ��������������Ϊchar����
	 * 
	 * @param str
	 * @return
	 */
	public TreeNode<Character> createTree(String str)
	{
		TreeNode<Character> root = null;
		TreeNode<Character> p = null;
		char[] nodeSquence = str.toCharArray();
		Object[] nodeStack = new Object[STACK_LENGTH];
		int flag = -1;
		int k = 0;
		
		if(nodeSquence.length < 1)
		{
			return null;
		}else{
			for(int i = 0; i < nodeSquence.length; i++)
			{
				switch(nodeSquence[i])
				{
				case '@': return root;
				case '(': 
					p = ((TreeNode<Character>)nodeStack[k++]);
					flag = 1;
					break;
				case ')':	
					break;
				case ',':		
					p = ((TreeNode<Character>)nodeStack[--k]);
					flag = 0;
					break;
				default:
					nodeStack[k] = new TreeNode<T>();
					((TreeNode<Character>)nodeStack[k]).data = nodeSquence[i];
					((TreeNode<Character>)nodeStack[k]).lBit = 1;
					((TreeNode<Character>)nodeStack[k]).rBit = 1;
					((TreeNode<Character>)nodeStack[k]).lChild = null;
					((TreeNode<Character>)nodeStack[k]).rChild = null;
					if(root == null)
					{
						root = ((TreeNode<Character>)nodeStack[k]);
						
					}
					if(flag == 1)
					{
						p.lChild = ((TreeNode<Character>)nodeStack[k]);
					}
					if(flag == 0)
					{
						p.rChild = ((TreeNode<Character>)nodeStack[k]);
					}	
				}			
			}
			return root;
		}
		
	}
	
	/**
	 * ������������from book��
	 * �ô����㷨�������ڴ��������������Ϊchar����
	 * @param str
	 * @return
	 */
	public TreeNode<Character> createTree2(String str)
	{
		TreeNode<Character> root = null;
		TreeNode<Character> p = null;
		char[] nodeSquence = str.toCharArray();
		Object[] nodeStack = new Object[STACK_LENGTH];
		int flag = -1;
		int top = -1;
		if(nodeSquence.length < 1)
		{
			return null;
		}else{
			for(int i = 0; i < nodeSquence.length; i++)
			{
				switch(nodeSquence[i])
				{
				case '@': return root;
				case '(': 
					nodeStack[++top] = p;
					flag = 1;
					break;
				case ')':		
					top--;
					break;
				case ',':
					flag = 0;
					break;
				default:
					p = new TreeNode<Character>();
					p.data = nodeSquence[i];
					p.lBit = 1;
					p.rBit = 1;
					p.lChild = null;
					p.rChild = null;
					if(root == null)
					{
						root = p;
					}
					if(flag == 1)
					{
						((TreeNode<Character>)nodeStack[top]).lChild = p;
					}
					if(flag == 0)
					{
						((TreeNode<Character>)nodeStack[top]).rChild = p;
					}	
				}			
			}
			return root;
		}
		
	}
	
	/**
	 *  ÿ�����뵥���ַ���ʽ ����������
	 * �ô����㷨�������ڴ��������������Ϊchar����
	 * ���㷨�� ��������copy�㷨copyBTree(TreeNode<T> root)����һ��
	 * 
	 * @param root
	 * @return
	 */
	protected TreeNode<Character> createTreeByPreorder(TreeNode root)
	{
		char ch;
		Scanner in = new Scanner(System.in); // �Ӽ��̶����ַ�
		ch = (char)in.next().charAt(0);
		//System.out.print("�ַ���" + ch);
		if(ch == '*')// ��������ַ�Ϊ * ����ýڵ�Ϊ�սڵ�
		{
			root = null;
		}
		else{
			root = new TreeNode<Character>();
			root.data = ch;
			root.lChild = createTreeByPreorder(root.lChild);
			root.rChild = createTreeByPreorder(root.rChild);
		}
		return root;
	}
	
	/**
	 * ǰ������ݹ��㷨
	 * 
	 * @param root
	 */
	public void preorder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data);
		preorder(root.lChild);
		preorder(root.rChild);
	}
	
	/**
	 * ǰ������ǵݹ��㷨
	 * 
	 * @param root
	 */
	public void preorderNonRecursion(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		TreeNode<T> p = root;
		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();
		while(p != null)
		{
			System.out.print(p.data); // ���ʵ�ǰ�ڵ�
			if(p.rChild != null) // ��ǰ�ڵ��Һ��Ӳ�Ϊ�գ����Һ��ӽ�ջ
			{
				nodeStack.push(p.rChild);		
			}
			if(p.lChild != null) // ��ǰ�ڵ����Ӳ�Ϊ�գ���������Ϊ��ǰ�ڵ㣬����ջ�ڽڵ��ջ
			{
				p = p.lChild;
			}else{
				p = nodeStack.pop();
			}
		}	
		
	}
	
	/**
	 * ��������ݹ��㷨
	 * 
	 * @param root
	 */
	public void postorder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		postorder(root.lChild);
		postorder(root.rChild);
		System.out.print(root.data);
	}
	
	/**
	 * ��������ǵݹ��㷨
	 * 
	 * @param root
	 */
	public void postorderNonRecursion(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		TreeNode<T> p = root;
		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();
		Stack<Integer> nodeFlagStack = new Stack<Integer>(); // ��־nodeStack�нڵ�Ϊ�ڼ��ν�ջ
		while(p != null)
		{
			if(p.lChild != null)
			{
				nodeStack.push(p);
				nodeFlagStack.push(1);
				p = p.lChild;
			}
			else{
				if(p.rChild != null)
				{
					nodeStack.push(p); // ����ǰ�ڵ������Ϊ�����Һ��Ӳ�Ϊ�գ���ô��ǰ�ڵ��ջ��������ջ��־��Ϊ�ڶ��ν�ջ
					nodeFlagStack.push(2); 
					p = p.rChild;
				}
				else{
					System.out.print(p.data); // ��ǰ�ڵ����Һ��Ӷ�Ϊ�գ�����ʸýڵ�
					int flag = -1;
					p = nodeStack.pop();
					if(p != null)
					{
						flag = nodeFlagStack.pop().intValue();
						// ��ջѭ��
						while(p != null)
						{
							if(flag == 2 || (flag == 1 && p.rChild == null))
							{	
								System.out.print(p.data);
								p = nodeStack.pop();
								if(p == null)
								{
									break;
								}
								flag = nodeFlagStack.pop().intValue();
							}
							if(flag ==1 && p != null && p.rChild != null) // �������ڵ���Һ��Ӳ�Ϊ��ʱ�������ڵ�ڶ��ν�ջ�������Һ�����Ϊ��ǰ�ڵ㣬��������ǰѭ��
							{
								nodeStack.push(p);
								nodeFlagStack.push(2);
								p = p.rChild;
								break;
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * ��������ݹ��㷨
	 * 
	 * @param root
	 */
	public void inorder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		inorder(root.lChild);
		System.out.print(" " + root.data + " ");
		inorder(root.rChild);
		
	}
	
	/**
	 * ��������ǵݹ��㷨
	 * 
	 * @param root
	 */
	public void inorderNonRecursion(TreeNode<T> root)
	{
		TreeNode<T> p = root;
		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();
		
		while(p != null)
		{
			if(p.lChild != null) // �����ǰ�ڵ����Ӳ�Ϊ�գ� ��ǰ�ڵ��ջ��������ʵ�ǰ�ڵ㣬����������Ϊ��ǰ�ڵ�
			{
				nodeStack.push(p);
				p = p.lChild;
			}else{
				System.out.print(p.data);
				if(p.rChild != null)
				{
					p = p.rChild;
				}else{
					p = nodeStack.pop();
					if(p != null)
					{
						System.out.print(p.data);
						// ��ջѭ��
						while(p.rChild == null) // ����ýڵ��Һ���Ϊ�� ��������� ֱ��ջΪ�ջ��� �ýڵ��Һ��Ӳ�Ϊ��
						{
							p = nodeStack.pop();
							if(p == null)
							{
								break;
							}	
							System.out.print(p.data);
						}
						if(p != null && p.rChild != null) // ��ջ�Ľڵ㲻Ϊ�����Һ��Ӳ�Ϊ�� ���Һ�����Ϊ ��ǰ�ڵ�
						{		
							p = p.rChild;
						}
					}
				}
			}
		}
	}
	
	/**
	 * ��α����㷨���ǵݹ飩
	 * 
	 * @param root
	 */
	public void layerOrder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		Queue<TreeNode<T>> nodeQueue = new Queue<TreeNode<T>>();
		nodeQueue.init();
		TreeNode<T> p = root;
		while(p != null)
		{
			System.out.print(" " + p.data + " ");
			if(p.lChild != null)
			{	
				nodeQueue.add(p.lChild);
				//System.out.print(" :" + p.lChild.data + ": ");
			}
			if(p.rChild != null)
			{
				nodeQueue.add(p.rChild);
				//System.out.print(" :" + p.rChild.data + ": ");
			}
			p = nodeQueue.deleteFront();
		}	
	}
	
	/**
	 * ����������ÿ���ڵ�����Һ���
	 * 
	 * @param root
	 */
	public void exchangeBTreeLRChild(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		Queue<TreeNode<T>> nodeQueue = new Queue<TreeNode<T>>();
		nodeQueue.init();
		TreeNode<T> p = root;
		while(p != null)
		{
			TreeNode<T> temp = null;
			temp = p.lChild;
			p.lChild = p.rChild;
			p.rChild = temp;
			if(p.lChild != null)
			{
				nodeQueue.add(p.lChild);
			}
			if(p.rChild != null)
			{
				nodeQueue.add(p.rChild);
			}
			p = nodeQueue.deleteFront();

		}
	}
	
	/**
	 * ����ȵĵݹ��㷨
	 * 
	 * @param root
	 * @return
	 */
	public int depth(TreeNode<T> root)
	{
		int lDepth = 0, rDepth = 0;
		if(root == null)
		{
			return 0;
		}
		lDepth = depth(root.lChild) + 1;
		rDepth = depth(root.rChild) + 1;
		
		return lDepth > rDepth ? lDepth : rDepth ;
	}
	
	/**
	 *  ���ƶ�����
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode<T> copyBTree(TreeNode<T> root)
	{
		TreeNode<T> newRoot = null;
		if(root == null)
		{
			return null;
		}
		else{
			newRoot = new TreeNode<T>();
			newRoot.data = root.data;
			newRoot.lChild = copyBTree(root.lChild);
			newRoot.rChild = copyBTree(root.rChild);
			return newRoot;
		}
	}
	
	/**
	 * ����������Ϊ �������� �Ľڵ������еĲ��
	 * 
	 * @param root
	 * @param item
	 * @return
	 */
	public int getNodeLayer(TreeNode<T> root, T item)
	{
		if(root == null)
		{
			return -1;
		}
		TreeNode<T> p = root;
		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();
		Stack<Integer> nodeFlagStack = new Stack<Integer>(); // ��־nodeStack�нڵ�Ϊ�ڼ��ν�ջ
		while(p != null)
		{
			if(p.lChild != null)
			{
				nodeStack.push(p);
				nodeFlagStack.push(1);
				p = p.lChild;
			}
			else{
				if(p.rChild != null)
				{
					nodeStack.push(p); // ����ǰ�ڵ������Ϊ�����Һ��Ӳ�Ϊ�գ���ô��ǰ�ڵ��ջ��������ջ��־��Ϊ�ڶ��ν�ջ
					nodeFlagStack.push(2); 
					p = p.rChild;
				}
				else{
					System.out.print(p.data); // ��ǰ�ڵ����Һ��Ӷ�Ϊ�գ�����ʸýڵ�
					if(p.data == item)
					{
						return nodeStack.size() + 1;
					}
					int flag = -1;
					p = nodeStack.pop();
					if(p != null)
					{
						flag = nodeFlagStack.pop().intValue();
						// ��ջѭ��
						while(p != null)
						{
							if(flag == 2 || (flag == 1 && p.rChild == null))
							{	
								System.out.print(p.data);
								if(p.data == item)
								{
									return nodeStack.size() + 1;
								}
								p = nodeStack.pop();
								if(p == null)
								{
									break;
								}
								flag = nodeFlagStack.pop().intValue();
							}
							if(flag ==1 && p != null && p.rChild != null) // �������ڵ���Һ��Ӳ�Ϊ��ʱ�������ڵ�ڶ��ν�ջ�������Һ�����Ϊ��ǰ�ڵ㣬��������ǰѭ��
							{
								nodeStack.push(p);
								nodeFlagStack.push(2);
								p = p.rChild;
								break;
							}
						}
					}
				}
			}
		}
		return -1;
	}
	
	/**
	 * ��ȡҶ�ڵ�����
	 * 
	 * @param root
	 * @return
	 */
	public int getLeafNodesNumber(TreeNode<T> root)
	{
		int num = 0;
		if(root == null)
		{
			return 0;
		}
		if(root.rChild == null && root.lChild == null)
		{
			return 1;
		}
		num = getLeafNodesNumber(root.rChild) + getLeafNodesNumber(root.lChild);
		
		return num;
	}
	
	/**
	 * ���������������Ƿ�ȼ�
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public Boolean equalBTree(TreeNode<T> root1, TreeNode<T> root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if(root1 != null && root2 != null && root1.data == root2.data && equalBTree(root1.lChild,root2.lChild) && equalBTree(root1.rChild,root2.rChild))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * ɾ��������Ϊ �������� �Ľڵ㼰��������������ڵ��������е�����Ϊ���������ݣ���ô�÷���ֻ��ɾ�������ڵ�����Ľڵ�
	 * 
	 * @param root
	 * @param item
	 */
	public void deleteNodeAndItsSubtree(TreeNode<T> root, T item)
	{
		if(root == null)
		{
			return;
		}
		if(root.data == item)
		{
			root.lChild = null;
			root.rChild = null;
			root = null;
			return;
		}
		TreeNode<T> p = root, q = null;
		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();
		while(p != null)
		{
			//System.out.print(p.data); // ���ʵ�ǰ�ڵ�
			if(p.data == item)
			{
				if(q.lChild == p)
				{
					q.lChild = null;
				}
				if(q.rChild == p)
				{
					q.rChild = null;
				}
				//delete(p);// Ŀ�����ͷ�p�ڵ㼰�������ڵ���ռ�õĿռ䣬����java��������һ�㣬���þ���Ч
				return;
			}
			if(p.rChild != null) // ��ǰ�ڵ��Һ��Ӳ�Ϊ�գ����Һ��ӽ�ջ,�Һ��Ӹ��ڵ��ջ
			{
				
				nodeStack.push(p.rChild);
				nodeStack.push(p);
			}
			if(p.lChild != null) // ��ǰ�ڵ����Ӳ�Ϊ�գ���������Ϊ��ǰ�ڵ㣬����ջ�ڽڵ��ջ
			{
				q = p;
				p = p.lChild;
			}else{
				q = nodeStack.pop();
				p = nodeStack.pop();
			}
		}	
	}
	
	
	
	
	/**
	 * ɾ������������������java���ԣ�ɾ��������ֻҪ�Ѹ��ڵ��ÿռ���
	 * ������﷨Ϊc���Ե�ʵ��
	 * 
	 */
//	public void delete(TreeNode &root)
//	{
//		if(root == null)
//		{
//			return;
//		}
//		else{
//			delete(root.lChild);
//			delete(root.rChild);
//   		free(root);
//			root  = null;
//		}
//	}
	
}












