package chapter02.item05;

import java.util.List;

//�̱����� �߸� ����� �� - �������� �ʰ� �׽�Ʈ�ϱ� ��ƴ�.
public class SpellChecker2 {
	private static final Lexicon dictionary = new Lexicon();
	private SpellChecker2() {} //��ü ���� ����
	public static SpellChecker2 INSTANCE = new SpellChecker2();
	public static boolean isValid(String word) {
		return false;
	}
	public static List<String> suggestions(String typo) {
		return null;
	}
}