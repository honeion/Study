package chapter02.item05;

import java.util.List;
import java.util.Objects;

//���� ��ü ������ �������� �׽�Ʈ ���̼��� �����ش�
public class SpellChecker3 {
	private final Lexicon dictionary;
	private SpellChecker3(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	} //��ü ���� ����
	public static boolean isValid(String word) {
		return false;
	}
	public static List<String> suggestions(String typo) {
		return null;
	}
}
