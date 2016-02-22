package datastructure.sort.internalsort;

import java.util.Random;

import util.CustomizePrint;

public class UnstableSort {

	
	/**
	 * ѡ�������㷨
	 * 
	 * @param array
	 */
	public static void selectionSort(int[] array)
	{
		
		for(int i = 0; i < array.length - 1; i++)
		{ 
			int k = i;// ��i������ �ٶ���i��Ԫ��Ϊ��Сֵ����ʣ��n-i-1���Ƚϻ��n-iԪ�ص���Сֵ
			for(int j = i + 1; j < array.length; j++)
			{
				if(array[j] < array[k])
				{
					k = j;
				}
			}
			if(k != i)
			{
				int temp = array[k];
				array[k] = array[i];
				array[i] = temp;
			}	
			// CustomizePrint.printArray("��" + i + "��������", array);
		}
	}
	
	/**
	 * л�������㷨
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array)
	{
		int gap = array.length; // �����ʼΪ���鳤�ȵ�һ��
		
		for(;gap > 1;)
		{
			gap = gap /2; // �������1ʱ��ÿ�μ���
			for(int i = 0; i < gap; i++) // �ڵ�ǰgapֵ����������ĿΪgap�� ��ÿ�������н���������Ҳ�ɶ�ÿ�������в����������򷽷���
			{
				int flag = 1; // flag Ϊ1��ʾ��������Ԫ�ؽ���������Ϊ0��ʾ��Ԫ�ؽ����Ķ���
				for(; flag != 0;) // ��Ԫ�ؽ�������˵�����������Ѿ����򣬽�����ѭ����������һ�������е�����
				{
					flag = 0;
					for(int j = i; j + gap < array.length; j = j + gap)
					{
						if(array[j] > array[j + gap])
						{
							int temp = array[j];
							array[j] = array[j + gap];
							array[j + gap] = temp;
							flag = 1;
						}
					}
				}
			}
			//CustomizePrint.printArray("gapֵΪ" + gap + "��������", array);
		}
	}
	
	/**
	 * ���������㷨
	 * 
	 * @param array
	 */
	public static void quickSort(int[] array, int low, int high)
	{
		int i = low;
		int j = high;
		if(low >= high) //�ݹ����
		{
			return;
		}
		int x = array[low];
		while(i < j){
			while(i < j && x < array[j]) j--;
			if(i < j)
			{
				array[i] = array[j];
				i++;
			}
			while(i < j && x > array[i]) i++;
			if(i < j)
			{
				array[j] = array[i];
				j--;
			}
		}
		array[i] = x;
		//CustomizePrint.printArray("�ݹ�������", array);
		quickSort(array, low, i-1);
		quickSort(array, i+1, high);
	}
	
	/**
	 * �ѻ������㷨
	 * 
	 * @param array
	 */
	public static  void heapSort(int[] array)
	{
		int n = array.length;
		int i;
		for(i = n/2 - 1; i >= 0; i--)// ��һ����������ת��Ϊһ���ѻ�����
		{
			adjustToHeapSequence(array, i, n);
		}
		for(int j = n-1; j > 0; j--)
		{
			int temp = array[j];
			array[j] = array[0];
			array[0] = temp;
			adjustToHeapSequence(array, 0, j);
			//CustomizePrint.printArray("��" + (n-j) + "��������", array);
		}
	}
	
	/**
	 * �����ڵ��������������һ���ѻ��ķǶѻ�����Ϊһ���ѻ�
	 * 
	 * @param array
	 * @param i the position of the root node in the array
	 * @param n the length of the array
	 */
	private static void adjustToHeapSequence(int[] array, int i, int n)
	{
		int temp = array[i];
		int j = 2 * (i+1);
		while(j <= n)
		{
			if(j < n && array[j-1] < array[j])
			{
				j++;
			}
			if(temp >= array[j-1])
			{
				break;
			}
			array[j/2 - 1] = array[j - 1];
			j = 2 * j;
		}
		array[j/2 - 1] = temp;
	}
	
	
	
	/**
	 * ��������������㷨
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void randomizeQuickSort(int[] array, int low, int high)
	{
		if(low < high)
		{
			int position = randomizedPartition(array,low,high);
			randomizeQuickSort(array, low, position-1);
			randomizeQuickSort(array, position + 1, high);
		}
	}
	
	/**
	 * �������������
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int randomizedPartition(int[] array, int low, int high)
	{
		int t = random(low,high);
		int temp = array[t];
		array[t] = array[low];
		array[low] = temp;
		return partition(array,low,high);
	}
	
	/**
	 * �Ե�һ������Ϊ��Ԫ��������
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] array, int low, int high)
	{
		int baseElement = array[low];
		int i = low;
		for(int j = low + 1; j <= high; j++)
		{
			if(array[j] < baseElement)
			{
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[i];
		array[i] = baseElement;
		array[low] = temp;
		return i;
	}
	
	/**
	 * produce a random number from low to high
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	private static int random(int low, int high)
	{
		Random rdm = new Random();
		return low + rdm.nextInt(high - low + 1);
	}
	
}


























