package chapter02.item03;
import java.io.Serializable;

//�̱��� �����
public class Elvis implements Serializable{
	
//	/* 
//	 * 1) public static final �ʵ� ����� �̱���
//	 * private �����ڰ� Elvis.INSTANCE �ʱ�ȭ �� �� �ѹ��� ȣ��� (public, protected �����ڰ� ��� �ʱ�ȭ�ɶ� ��ü �ý��ۿ��� �ϳ������� �����
//	 * ������ �ִ� Ŭ���̾�Ʈ�� ���÷��� API (AccessibleObject.setAccessible�� ����� private ������ ȣ���� ������
//	 * �̸� �������ؼ��� �����ڸ� ������ �ι�° ��ü�� �����Ƿ� �� �� ���ܸ� ��������
//	 */
//	public static final Elvis INSTANCE = new Elvis();
//	private Elvis() {};
//	public void leaveTheBuilding() {};
	
	
//	/*
//	 * 2) �������丮 ����� �̱���
//	 * Elvis.getInstance�� �׻� ���� ��ü�� ������ ��ȯ�ϹǷ� �� 2�� �ν��Ͻ��� ��������� ����(���÷��� ���ܴ� �Ȱ���)
//	 * 1)�� ���� �ش� Ŭ������ �̱������� API�� ����� �巯����, ������
//	 * 2)�� API�� �ٲ��� �ʰ� �̱����� �ƴϰ� ������ �� ����
//	 * ������ �ν��Ͻ��� ��ȯ�ϴ� ���丮�޼ҵ尡 ȣ���ϴ� �����庰�� �ٸ� �ν��Ͻ��� �Ѱ��ְ� �� �� ����
//	 * ���Ѵٸ� ���� ���丮�� ���ʸ� �̱��� ���丮�� ���� �� ����
//	 * ���� ���丮�� �޼ҵ� ������ �����ڷ� ����� �� ���� (Elvis::getInstance�� Supplier<Elvis>�� ����ϴ� ��)
//	 * �� �������� �ʿ������ 1)�� ����
//	 */
//	private static final Elvis INSTANCE = new Elvis();
//	private Elvis() {}
//	public static Elvis getInstance() { return INSTANCE; }
//	public void leaveTheBuilding() {}
//	
//	// �� ��� �� �ϳ��� �̱��� Ŭ������ ����ȭ�Ϸ��� �ܼ��� Serializable�� �����Ѵٰ� �����ϴ� ������ ������
//	// ��� �ν��Ͻ� �ʵ带 �Ͻ���(transient)�̶�� �����ϰ� readResolve �޼ҵ带 �����ؾ���
//	// �̷��� ���� ������ ����ȭ�� �ν��Ͻ��� ������ȭ�� ������ ���ο� �ν��Ͻ��� ����
//	// �̱������� �������ִ� readResolve �޼ҵ�
//	private Object readResovle() {
//		//��¥ Elvis�� ��ȯ�ϰ�, ��¥ Elvis�� ������ �÷��Ϳ� �ñ��.
//		return INSTANCE;
//	}
	
	
}
