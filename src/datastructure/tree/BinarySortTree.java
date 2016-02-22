package datastructure.tree;

import datastructure.node.TreeNode;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class BinarySortTree<T> extends BinaryTree<T> {
	/**
	 * ����������������������������
	 * 
	 * @param nodeSequence
	 * @return
	 */
	public TreeNode<Integer> createBinarySortTree(Integer[] nodeSequence)
	{
		TreeNode<Integer> root = null;
		for(int i = 0; i < nodeSequence.length; i++)
		{
			root = insertBinarySortTreeNode(root, nodeSequence[i]);
		}
		
		return root;
	}
	
	/**
	 * ��������������ڵ�ݹ��㷨
	 * 
	 * @param root
	 * @param t
	 * @return
	 */
	private TreeNode<Integer> insertBinarySortTreeNode(TreeNode<Integer> root, int t)
	{
		if(root == null)
		{
			root = new TreeNode<Integer>();
			root.data = t;
			root.lChild = null;
			root.rChild = null;
			return root;
		}
		else if(root.data.intValue() > t )
		{
			root.lChild = insertBinarySortTreeNode(root.lChild, t);
		}
		else
		{
			root.rChild = insertBinarySortTreeNode(root.rChild, t);
		}
		
		return root;
	}
	
	/**
	 * ��������������������������)�ǵݹ��㷨
	 * 
	 * @param nodeSequence
	 * @return
	 */
	public TreeNode<Integer> createBinarySortTreeNonRecursion(Integer[] nodeSequence)
	{
		TreeNode<Integer> root = null, p, q = null;
		for(int i = 0; i < nodeSequence.length; i++)
		{
			p = new TreeNode<Integer>();
			p.data = nodeSequence[i];
			p.lChild = null;
			p.rChild = null;
			if(root == null)
			{
				root = p;
			}else{
				q = root;
				while(true)
				{
					if(q.data > nodeSequence[i]){
						if(q.lChild != null)
						{
							q = q.lChild;
						}else{
							q.lChild = p;
							break;
						}
					}else{
						if(q.rChild != null)
						{
							q = q.rChild;
						}else{
							q.rChild = p;
							break;
						}
					}
				}
			}
			
		}
		return root;
	}
	
	
	/**
	 * ���Ҷ����������� �����Ľ�� �ݹ��㷨
	 * 
	 * @param root
	 * @param t
	 * @return ���ҳɹ����ؽ�����ã����򷵻�null
	 */
	public TreeNode<Integer> search(TreeNode<Integer> root, int t)
	{
		if(root == null)
		{
			return null;
		}
		else if(root.data.intValue() == t){
			return root;
		}else if(root.data.intValue() > t){
			root = search(root.lChild, t);
		}else {
			root = search(root.rChild, t);
		}
		return root;
	}
	
	/**
	 * ���Ҷ����������� �����Ľ�� �ǵݹ��㷨
	 * 
	 * @param root
	 * @param t
	 * @return
	 */
	public TreeNode<Integer> searchNonRecursion(TreeNode<Integer> root, int t)
	{
		TreeNode<Integer> p = root;
		while(p != null)
		{
			if(p.data.intValue() == t)
			{
				return p;
			}else if(p.data.intValue() > t){
				p = p.lChild;
			}else{
				p = p.rChild;
			}
		}
			return null;
	}
	
	/**
	 * ���Ҷ������������������ĸ����
	 * 
	 * @param root
	 * @param t
	 * @return
	 */
	public TreeNode<Integer> searchParentNode(TreeNode<Integer> root, int t)
	{
		TreeNode<Integer> p = root, q = root;
		while(p != null)
		{
			if(p.data.intValue() == t)
			{
				return q;
			}else if(p.data.intValue() > t){
				q = p;
				p = p.lChild;
			}else{
				q = p;
				p = p.rChild;
			}
		}
			return null;
	}
	
	/**
	 * 
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode<Integer> deleteBinarySortTreeNode(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
	{
		TreeNode<Integer> r = null, s = null;
		int flag = 0;
		if(p.lChild == null)
		{
			if(p == root)
			{
				root = p.rChild;
				return root;
			}else{
				r = p.rChild;
				flag = 1;
			}
		}else if(p.rChild == null)
		{
			if(p == root)
			{
				root = p.lChild;
				return root;
			}else{
				r = p.lChild;
				flag = 1;
			}
		}else{
			s = p;
			r = s.rChild;
			while(r.lChild != null)
			{
				s = r;
				r = r.lChild;
			}
			r.lChild = p.lChild;
			if(s != p) // p�ڵ���������ĸ��ڵ��������Ϊ��
			{
				s.lChild = r.rChild;
				r.rChild = p.rChild;
			}
			if(p == root)
			{
				root = r;
				return root;
			}
			else
			{
				flag = 1;
			}
		}
		if(flag == 1)
		{
			if(q.lChild == p)
			{
				q.lChild = r;
			}else{
				q.rChild = r;
			}
		}
		return root;
	}
}
