package item03;

import java.io.Serializable;

//싱글턴 만들기
public class Elvis implements Serializable{
	
//	/* 
//	 * 1) public static final 필드 방식의 싱글턴
//	 * private 생성자가 Elvis.INSTANCE 초기화 할 때 한번만 호출됨 (public, protected 생성자가 없어서 초기화될때 전체 시스템에서 하나뿐임이 보장됨
//	 * 권한이 있는 클라이언트는 리플렉션 API (AccessibleObject.setAccessible을 사용해 private 생성자 호출이 가능함
//	 * 이를 막기위해서는 생성자를 수정해 두번째 객체가 생성되려 할 때 예외를 던져야함
//	 */
//	public static final Elvis INSTANCE = new Elvis();
//	private Elvis() {};
//	public void leaveTheBuilding() {};
	
	
//	/*
//	 * 2) 정적팩토리 방식의 싱글턴
//	 * Elvis.getInstance는 항상 같은 객체의 참조를 반환하므로 제 2의 인스턴스는 만들어지지 않음(리플렉션 예외는 똑같음)
//	 * 1)의 경우는 해당 클래스가 싱글턴임이 API에 명백히 드러나며, 간결함
//	 * 2)는 API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있음
//	 * 유일한 인스턴스를 반환하던 팩토리메소드가 호출하는 스레드별로 다른 인스턴스를 넘겨주게 할 수 있음
//	 * 원한다면 정적 팩토리를 제너릭 싱글턴 팩토리로 만들 수 있음
//	 * 정적 팩토리의 메소드 참조를 공급자로 사용할 수 있음 (Elvis::getInstance를 Supplier<Elvis>로 사용하는 식)
//	 * 이 장점들이 필요없으면 1)이 좋음
//	 */
//	private static final Elvis INSTANCE = new Elvis();
//	private Elvis() {}
//	public static Elvis getInstance() { return INSTANCE; }
//	public void leaveTheBuilding() {}
//	
//	// 두 방식 중 하나로 싱글톤 클래스를 직렬화하려면 단순히 Serializable을 구현한다고 선언하는 것으로 부족함
//	// 모든 인스턴스 필드를 일시적(transient)이라고 선언하고 readResolve 메소드를 제공해야함
//	// 이렇게 하지 않으면 직렬화된 인스턴스를 역직렬화할 때마다 새로운 인스턴스가 생김
//	// 싱글턴임을 보장해주는 readResolve 메소드
//	private Object readResovle() {
//		//진짜 Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다.
//		return INSTANCE;
//	}
	
	
}
