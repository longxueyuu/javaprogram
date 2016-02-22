package datastructure.sort.internalsort;

import datastructure.node.GenericNode;
import datastructure.node.Node;
import datastructure.queue.Queue;

public class StableSort {
	
	/**
	 * ���������㷨
	 * 
	 * @param array
	 */
	public static void insertionSort(int[] array)
	{
		
		for(int i = 1; i < array.length; i++)
		{
			int temp = array[i];
			int j;
			for(j = i - 1; j >= 0 && temp < array[j]; j--)
			{
					array[j+1] = array[j];
			}
			array[j+1] = temp;
			//CustomizePrint.printArray("��" + i + "��������", array);
		}
	}
	
	/**
	 * ð�������㷨
	 * 
	 * @param array
	 */
	public static void bubblesort(int[] array)
	{
		int flag = 1; // ��flag = 1ʱ, ��ʾ��һ��������Ԫ�ؽ�����Ϊ0���ʾû��Ԫ�ؽ�������û��Ԫ�ؽ������ʾ�������
		for(int i = 0; i < array.length - 1 && flag == 1; i++)
		{
			flag = 0;
			for(int j = 0; j < array.length - i - 1; j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = 1;
				}
			}
			//CustomizePrint.printArray("��" + i + "��������", array);
		}
	}
	
	/**
	 * ��·�鲢����ݹ��㷨
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void mergingSort(int[] array, int low, int high)
	{
		int mid = (low + high) / 2;
		if(low < high)
		{
			mergingSort(array, low, mid);
			mergingSort(array, mid + 1, high);
			merge(array, low, mid, high);
			//CustomizePrint.printArray("�����г���Ϊ" + (mid-low+1) + "������", array);
		}
	}
	
	/**
	 * ��·�鲢����ǵݹ��㷨
	 * 
	 * @param array
	 */
	public static void mergingSort(int[] array)
	{
		int t = 1;
		int n = array.length;
		while(t < n)
		{
			mPass(array, t);
			// CustomizePrint.printArray("�����г���Ϊ" + t + "������", array);
			t *= 2;
		}
	}
	
	/**
	 * �鲢�����������㷨
	 * 
	 * @param src  the array needed to be merged
	 * @param s  the first subsequence start position of the src
	 * @param u  the first subsequence end position of the src
	 * @param v  the second sequence end position of src
	 */
	private static void merge(int[] src, int s, int u, int v)
	{
		/* �������src[s..u]��src[u+1..v]�鲢Ϊ�����src[s..v] */
		int[] dst = new int[src.length];
		int i,j,q;
		i = s;
		j = u + 1;
		q = s;
		while(i <= u && j <= v)
		{
			if(src[i] <= src[j])
			{
				dst[q++] = src[i++];
			}else{
				dst[q++] = src[j++];
			}
		}
		while(i <= u) // ��src[s..u]��ʣ���Ԫ��src[i..u]���Ƶ�dst��
		{
			dst[q++] = src[i++];
		}
		while(j <= v) // ��src[u+1..v]��ʣ���Ԫ��src[j..v]���Ƶ�dst��
		{
			dst[q++] = src[j++];
		}
		
		for(int k = s; k <= v; k++) // ���鲢���dst���Ƶ�src��,ֻ���ƹ鲢������������
		{
			src[k] = dst[k];
		}
	}
	
	/**
	 * һ�˹鲢ɨ���㷨
	 * 
	 * @param src
	 * @param t the length of subsequence
	 */
	private static void mPass(int[] src, int t)
	{
		int i = 0;
		int n = src.length-1;
		while(n-i+1 >= 2*t)
		{
			merge(src, i, i+t-1, i+2*t-1);
			i = i + 2 * t;
		}
		if(n-i+1 > t) // ʣ�µ�Ԫ�ظ�������t����ʣ���������ȳ����й鲢
		{
			merge(src, i, i+t-1, n);
		}else{ //ʣ�µ�Ԫ�ظ���С�ڵ���t����ʣ�µ�Ԫ��ֱ�Ӹ��Ƶ�ǰһ�������к���
//			for(int j = i; j <= n; j++)
//			{
//				dst[j] = src[j];
//			}
		}
	}
	
	/**
	 * ���������㷨
	 * 
	 * @param array
	 * @param r
	 * @param d
	 */
	public static void radixSort(int[] array, int r)
	{
		int d = getMaxDigit(array,r);
		Node front = null, rear = null, p = null; // frontΪ�ܶӶ�ͷָ�룬rearΪ�ܶӶ�βָ��
		Node[] head = new Node[r]; // ���ֶӶ�ͷָ��
		Node[] end = new Node[r]; // ���ֶӶ�βָ��
		int x;
		front = transferToQueue(array); // ������ת��Ϊһ������
		for(int j = 1; j <= d; j++)
		{
			while(front != null) // ���ܶӸ��ڵ���뵽�����ֶ�
			{
				p = front;
				x = get(p,j); // �ֽ�p��������ݵĵ�jλ����
				if(head[x] == null)
				{
					head[x] = p;
				}else{
					end[x].next = p;
				}
				end[x] = p;
				front = front.next;
			}
			
			int k = 0;
			while(head[k] == null) //���ҵ�1���ǿշֶӶӺ�
			{
				k++;
			}
			front = head[k];
			rear = end[k];
			head[k] = null; // �÷ֶӼ����ܶӺ��ÿշֶ�
			for(int m = k + 1; m < r; m++) // ���ΰ�������ǿշֶӲ����ܶ�
			{
				if(head[m] != null) 
				{
					rear.next = head[m];
					rear = end[m];
					head[m] = null;
				}
			}
			rear.next = null; // �ܶӶ�β��next�ÿ�
		}
		
		for(int n = 0; n < array.length; n++) // �����л�ԭΪ����
		{
			if(front == null)
			{
				break;
			}
			array[n] = front.data;
			front = front.next;
		}
	}
	
	/**
	 * ��ȡ���������Ԫ�ص�λ��
	 * 
	 * @param array
	 * @param r
	 * @return
	 */
	private static int getMaxDigit(int[] array, int r)
	{
		int k = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] > array[k]) 
			{
				k = i;
			}
		}
		return Integer.toString(array[k], r).length();
	}
	
	/**
	 * ������ת��Ϊһ������
	 * 
	 * @param array
	 * @return  return the reference of the queue first node
	 */
	private static Node transferToQueue(int[] array)
	{
		Node front = null, rear = null, p = null;
		for(int i = 0; i < array.length; i++)
		{
			p = new Node();
			p.data = array[i];
			p.next = null;
			if(front == null)
			{
				front = p;
			}else{
				rear.next = p;
			}
			rear = p;
		}
		return front;
	}
	
	/**
	 * �����һ�������ĵ�iλ��
	 * 
	 * @param node
	 * @param i
	 * @return
	 */
	private static int get(Node node, int i)
	{
		int x = -1;
		int number = node.data;
		for(int j = i; j > 0; j--)
		{
			x = number % 10;
			number = number / 10;
		}
		return x;
	}
	
}
























