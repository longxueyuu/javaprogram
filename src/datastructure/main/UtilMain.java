package datastructure.main;

import util.BasicMethod;

public class UtilMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double result = BasicMethod.power(5,-3);
		System.out.println("result:" + result);
		
		System.out.println("쳲��������У�");
		for(int i = 0; i <= 20; i++)
		{
			int fibonaaciNumber = BasicMethod.fibonacci(i);
			System.out.print(fibonaaciNumber + " ");
		}
		

		System.out.println( "\n" + Math.ceil(3.79));
		System.out.println(Math.floor(3.79));
		System.out.println(0.0d + "\n" + 0.0f);
		
		//���Զ��ֲ���
		int[] arr = new int[]{1, 3, 5, 6, 8, 9, 20, 30, 45, 67, 98, 99, 100, 102};
		int pos = BasicMethod.binarySearch(arr, 0, arr.length-1, 45);
		if(-1 != pos)
		{
			System.out.println("���ҵ���Ϊ��" + arr[pos]);
		}else{
			System.out.println("û�и���");
		}
		
		
		
	}

}
