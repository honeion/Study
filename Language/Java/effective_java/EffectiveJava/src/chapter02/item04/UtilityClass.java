package chapter02.item04;

/*
 * ���� �޼ҵ�� ���� �ʵ常�� ���� Ŭ������ ���� ��
 * �⺻Ÿ�� ���̳� �迭 ���� �޼ҵ带 ��Ƴ��ų�
 * Ư�� �������̽��� �����ϴ� ��ü�� �������ִ� ���� �޼ҵ�(Ȥ�� ���丮)
 * final Ŭ������ ������ �޼ҵ带 ��Ƴ���
 */
public class UtilityClass {
	//�⺻ �����ڰ� ���õ��� ������ ��������Ƿ� �̸� ���´�(�ν��Ͻ�ȭ ������)
	private UtilityClass() {
		throw new AssertionError();
	}
	//��� �����ڴ� �������̵� �������̵� ���� Ŭ������ �����ڸ� ȣ���ϰ� �Ǵµ� �̸� private���� ���������� ����Ŭ������
	//���� Ŭ������ �����ڿ� ������ ���� ���� ����� �Ұ����ϰ� �ϴ� ȿ���� ����
}