package javaclass.exception;

public class ExceptionMain {

	/**
	 * �����Զ����쳣
	 * 
	 * @param str
	 * @throws TypeException
	 */
	public void testTypeException(String str) throws TypeException
	{
		if("hello".equals(str))
		{
			throw new TypeException("������ַ�������Ϊhello");
		}
		if(str == null)
		{
			throw new TypeException("������ַ�������Ϊnull");
		}
		return;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExceptionMain em = new ExceptionMain();
		String str = "hello";
		try {
			System.out.println("����Try�飡");
			em.testTypeException(str);
		} catch (TypeException e) {
			System.out.println("����TypeException Catch�飡");
			e.printStackTrace();
		}
		finally{//ִ����try��󣬳���exit(0)�˳�������⣬�����Ƿ�ִ��catch�飬finally�鶼����ִ��һ�Σ���ʹ��try������return���Ҳ������
			System.out.println("����finally�飡");
		}
		System.out.println("�������!��");
	}

}
