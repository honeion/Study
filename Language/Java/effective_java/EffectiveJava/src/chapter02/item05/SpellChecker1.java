package chapter02.item05;

import java.util.List;

//���� ��ƿ��Ƽ�� �߸� ����� �� - �������� �ʰ� �׽�Ʈ�ϱ� �����.
public class SpellChecker1 {
	private static final Lexicon dictionary = new Lexicon();
	private SpellChecker1() {} //��ü ���� ����
	public static boolean isValid(String word) {
		return false;
	}
	public static List<String> suggestions(String typo) {
		return null;
	}
}