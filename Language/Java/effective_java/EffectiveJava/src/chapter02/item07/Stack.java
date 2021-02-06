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
	 * ���Ҹ� ���� ������ ��� �ϳ� �̻� Ȯ��
	 * �迭 ũ�⸦ �÷����� ������ �뷫 2�辿 �ø���
	 */
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	// ������ Ŀ���� �پ����� �� ���ÿ��� ������ ��ü���� GC�� ȸ�� ���� ����
	// �� ���ÿ��� ��ü���� �� �� ����(obsolete reference)�� ���� �ֱ� ����(�ٽ� ���� ���� ����)
	// elements �迭�� Ȱ������(index < size) ���� �������� �ش��
	// ��ü ���� �ϳ��� ����θ� GC�� �� ��ü���� �����ϴ� ��� ��ü�� ȸ������ ����
	// * �ش� ������ �� ���� �� null ó��(���� ����)�� �ذ�

	//	public Object pop() {
	//		if(size == 0) throw new EmptyStackException();
	//		return elements[--size];
	//	}
	// -> �Ʒ��� ���� ����
	public Object pop() {
		if(size == 0) throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // null ó���� ������ ����� ��� NullPointerException���� ���� Ȯ�� ����
		return result;
	}
	
//	 �޸� ������ �ֹ�
//	 1. �ڱ� �޸𸮸� ���������ϴ� Ŭ����
//	 ��ü ������ null ó���ϴ� ���� �������� ��쿩�� ��
//	 �� �� ������ �����ϴ� ���� ���� ����� �� ������ ���� ������ ��ȿ ���� ������ �о�� ��(������ ������ �ּҰ� �ǰ� ����)
//	 nulló���� �ʿ��� ���� ���� ����ó�� �ڱ� �޸𸮸� ���� �����ϴ� ���(��ü ��ü�� �ƴ� ��ü ������ ��� elements �迭�� ����� Ǯ�� ����� ����)
//	 ���α׷��Ӱ� ��Ȱ�� ������ �Ǵ� ���� nulló���� ���� GC�� �˷��� ��ȿ���� ���� ��ü���� �� �� ����
//	 "�ڱ� �޸𸮸� ���� �����ϴ� Ŭ���������� �޸� ������ ����"
//	 2. ĳ��
//	 ��ü ������ ĳ�ÿ� �ְ� ���� ���� �� ����
//	 - ĳ�� �ܺο��� Ű�� �����ϴ� ���ȸ� ��Ʈ���� ����ִ� ĳ�ð� �ʿ��� ��Ȳ�̸� WeakHashMap�� ����� ĳ�ø� ���� ��
//		  �� �� ��Ʈ���� ��� �ڵ����� ���ŵ� ���̳�, �̷��� ��Ȳ������ ������ �ڷᱸ����
//	 ĳ�ø� ���� �� ������ ĳ�� ��Ʈ���� ��ȿ �Ⱓ�� ��Ȯ�� �����ϱ� ��Ʊ� �빮�� �ð��� ���� ���� ��Ʈ���� ��ġ�� ����߸��� ����� �ַ� ���
//	 - ���� �ʴ� ��Ʈ�� û�� �ʿ� - ScheduledTrheadPoolExecutor���� ��׶��� �����带 Ȱ���ϰų� ĳ�ÿ� �� ��Ʈ���� �߰��� �� �μ��۾����� �����ϴ� ����� ����
//	 - LinkedHashMap�� removeEldestEntry �޼ҵ带 �Ἥ ������ ������� ó����
//	 3. ������, �ݹ�
//	 Ŭ���̾�Ʈ�� �ݹ��� ��ϸ� �ϰ� ��Ȯ�� �������� ������ �ݹ��� ��� ����
//	 �̷��� �ݹ��� ���� ������ �����ϸ� GC�� ��� ������(ex)WeakHashMap�� Ű�� ����)
	
}
