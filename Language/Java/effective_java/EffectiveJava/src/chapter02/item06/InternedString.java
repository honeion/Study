package chapter02.item06;


public class InternedString {
	public static void main(String[] args) {
		/*
		  Java String 
		 	String�� ���� �ڷ����̱⶧���� new�� �ν��Ͻ��� ����� Heap �������� ������ ������ immutable(�Һ�)�ϴٴ� Ư¡�� ����
			new �� �����ϸ� Heap �޸𸮿� ���� ��ü�� �����ǰ� ""(���ڿ� ���ͷ�)�� �����ϸ� Heap ���� ���� String Constant Pool�� ��ü�� ������
			String Constant Pool�� ����Ǹ� ������ ����(�Ȱ��� �� ����� reference ����)
			intern() �޼ҵ带 ȣ���Ͽ� String Pool�� �̵��ؼ� reference�� ������ �� ����
			- ���ʿ��� ��ü ������ ���ϱ� ���ؼ� String�� �ݵ�� ""�� ��������.
		 */
		String constantString = "interned String";
		String newString = new String("interned String");
		String internedString = newString.intern();
		//false true true
		System.out.println(constantString==newString);
		System.out.println(constantString==newString.intern());
		System.out.println(constantString==internedString);
		
	}
}