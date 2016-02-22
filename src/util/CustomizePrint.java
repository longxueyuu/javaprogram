package util;

public class CustomizePrint {

	/**
	 * ��ӡһά����
	 * 
	 * @param description
	 * @param array
	 */
	public static void printArray(String description, int array[])
	{
		
		System.out.print("\n" + description + ":");
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}
	
	/**
	 * ��ӡ��ά����
	 * 
	 * @param description
	 * @param array
	 */
	public static void print2DArray(String description, int[][] array)
	{
		System.out.println(description + "����:" + array.length);
		for(int[] i : array)
		{
			for(int j : i)
			{
				System.out.print(j + "		");
			}
			System.out.print("\n");
		}
	}
}
