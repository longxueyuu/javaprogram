package spring.proxy.jdk;

public class TargetBean implements ITarget {

	@Override
	public String doAction() {
		System.out.println("----ִ��ҵ�񷽷�----");
		return "success";
	}

}
