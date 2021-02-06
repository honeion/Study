package chapter02.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	public void push (Object o) {
		ensureCapacity();
		elements[size++] = o;
	}
	/*
	 * 원소를 위한 공간을 적어도 하나 이상 확보
	 * 배열 크기를 늘려야할 때마다 대략 2배씩 늘린다
	 */
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	// 스택이 커졌다 줄어들었을 때 스택에서 꺼내진 객체들을 GC가 회수 하지 않음
	// 이 스택에서 객체들의 다 쓴 참조(obsolete reference)를 갖고 있기 때문(다시 쓰지 않을 참조)
	// elements 배열의 활성영역(index < size) 밖의 참조들이 해당됨
	// 객체 참조 하나를 살려두면 GC는 그 객체들이 참조하는 모든 객체를 회수하지 못함
	// * 해당 참조를 다 썼을 때 null 처리(참조 해제)로 해결

	//	public Object pop() {
	//		if(size == 0) throw new EmptyStackException();
	//		return elements[--size];
	//	}
	// -> 아래와 같이 변경
	public Object pop() {
		if(size == 0) throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // null 처리한 참조를 사용할 경우 NullPointerException으로 에러 확인 가능
		return result;
	}
	
//	 메모리 누수의 주범
//	 1. 자기 메모리를 직접관리하는 클래스
//	 객체 참조를 null 처리하는 일은 예외적인 경우여야 함
//	 다 쓴 참조를 해제하는 가장 좋은 방법은 그 참조를 담은 변수를 유효 범위 밖으로 밀어내는 것(변수의 범위를 최소가 되게 정의)
//	 null처리가 필요한 경우는 위의 스택처럼 자기 메모리를 직접 관리하는 경우(객체 자체가 아닌 객체 참조를 담는 elements 배열로 저장소 풀을 만들어 관리)
//	 프로그래머가 비활성 영역이 되는 순간 null처리를 통해 GC에 알려야 유효하지 않은 객체임을 알 수 있음
//	 "자기 메모리를 직접 관리하는 클래스에서는 메모리 누수를 주의"
//	 2. 캐시
//	 객체 참조를 캐시에 넣고 나서 놔둘 수 있음
//	 - 캐시 외부에서 키를 참조하는 동안만 엔트리가 살아있는 캐시가 필요한 상황이면 WeakHashMap을 사용해 캐시를 만들 것
//		  다 쓴 엔트리는 즉시 자동으로 제거될 것이나, 이러한 상황에서만 유용한 자료구조임
//	 캐시를 만들 때 보통은 캐시 엔트리의 유효 기간을 정확히 정의하기 어렵기 대문에 시간이 지날 수록 엔트리의 가치를 떨어뜨리는 방식을 주로 사용
//	 - 쓰지 않는 엔트리 청소 필요 - ScheduledTrheadPoolExecutor같은 백그라운드 스레드를 활용하거나 캐시에 새 엔트리를 추가할 때 부수작업으로 수행하는 방법이 있음
//	 - LinkedHashMap은 removeEldestEntry 메소드를 써서 후자의 방식으로 처리함
//	 3. 리스너, 콜백
//	 클라이언트가 콜백을 등록만 하고 명확히 해지하지 않으면 콜백은 계속 쌓임
//	 이럴때 콜백을 약한 참조로 저장하면 GC가 즉시 수거함(ex)WeakHashMap에 키로 저장)
	
}
