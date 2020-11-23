package chapter02.item06;


public class InternedString {
	public static void main(String[] args) {
		/*
		  Java String 
		 	String은 참조 자료형이기때문에 new로 인스턴스를 만들고 Heap 영역에서 관리를 하지만 immutable(불변)하다는 특징이 존재
			new 로 생성하면 Heap 메모리에 개별 객체가 생성되고 ""(문자열 리터럴)로 생성하면 Heap 영역 내의 String Constant Pool에 객체가 생성됨
			String Constant Pool에 저장되면 재사용이 가능(똑같은 값 존재시 reference 참조)
			intern() 메소드를 호출하여 String Pool로 이동해서 reference를 참조할 수 있음
			- 불필요한 객체 생성을 피하기 위해서 String은 반드시 ""로 생성하자.
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