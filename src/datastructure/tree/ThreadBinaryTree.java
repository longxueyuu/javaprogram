package datastructure.tree;

import datastructure.node.TreeNode;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class ThreadBinaryTree<T> extends BinaryTree<T> {
	private TreeNode<T> previous = null; //�����������������õ���ȫ�ֱ������ñ���ʼ��ָ�����������ǰ���ʽ���ǰ���ڵ�
	
	/**
	 * ��������������������������ǰ���ڵ�
	 * 
	 * @param x
	 * @return
	 */
	private TreeNode<T> inPrior(TreeNode<T> x)
	{
		TreeNode<T> s = null;
		s = x.lChild;
		if(x.lBit == 1)
		{
			while(s.rBit == 1)
			{
				s = s.rChild;
			}
		}
		return s;
	}
	
	/**
	 * �����������������������ڵ�ĺ�̽ڵ�
	 * 
	 * @param x
	 * @return
	 */
	private TreeNode<T> inSucc(TreeNode<T> x)
	{
		TreeNode<T> s = null;
		s = x.rChild;
		if(x.rBit == 1)
		{
			while(s.lBit == 1)
			{
				s = s.lChild;
			}
		}
		
		return s;
	}
	
	/**
	 * �����������ݹ��㷨
	 * 
	 * @param root
	 */
	private void inThread(TreeNode<T> root)
	{
		TreeNode<T> p = root;
		if(p != null)
		{
			inThread(p.lChild);
			if(p.lChild == null) // �����ǰ�ڵ������Ϊ�գ���ǰ�ڵ����ָ���־��Ϊ0����������ָ����ָ��ǰ�ڵ��ǰ���ڵ�
			{
				p.lBit = 0;
				p.lChild = previous;
			}
			if(p.rChild == null) // �����ǰ�ڵ���Һ���Ϊ�գ���ǰ�ڵ����ָ���־��Ϊ0������
			{
				p.rBit = 0;
			}
			if(previous.rBit == 0) // �����ǰ�ڵ��ǰ���ڵ����ָ���־Ϊ0����������ǰ���ڵ����ָ����ָ��ǰ�ڵ�
			{
				previous.rChild = p;
			}
			previous = p; // ����ǰ�ڵ���Ϊǰ���ڵ㣬�Խ�����һ���ڵ��������
			inThread(p.rChild);
			
		}
	}
	
	/**
	 * ����������������
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode<T> inorderThreadBTree(TreeNode<T> root)
	{
		previous = null;
		TreeNode<T> head = new TreeNode<T>();
		head.lBit = 1;
		head.rBit = 0;
		head.lChild = null;
		head.rChild = null;
		previous = head; // ǰ���ڵ���Ϊͷ���
		inThread(root); // ������������
		previous.rChild = head; // ��������������һ���ڵ�ĺ�̽ڵ���Ϊͷ���
		head.rChild = head; // ��ͷ������ָ��ָ���Լ�
		head.lChild = root; // ��ͷ������ָ��ָ�����ĸ��ڵ�
		head.rBit = 1; // ��ͷ������ָ���־��Ϊ1
		return head;
	}
	
	/**
	 * ���������������������� �������
	 * 
	 * @param head
	 */
	public void inorderByThreadBTree(TreeNode<T> head)
	{
		TreeNode<T> p = head;
		
		while(true)
		{
			p = inSucc(p);
			if(p == head)
			{
				break;
			}
			System.out.print(p.data);
		}
		
		System.out.print("\n");
		while(true) // ����������������
		{
			p = inPrior(p);
			if(p == head)
			{
				break;
			}
			System.out.print(p.data);
		}
	}
}
