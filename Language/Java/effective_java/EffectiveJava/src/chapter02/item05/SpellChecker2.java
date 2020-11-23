package chapter02.item05;

import java.util.List;

//싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
public class SpellChecker2 {
	private static final Lexicon dictionary = new Lexicon();
	private SpellChecker2() {} //객체 생성 방지
	public static SpellChecker2 INSTANCE = new SpellChecker2();
	public static boolean isValid(String word) {
		return false;
	}
	public static List<String> suggestions(String typo) {
		return null;
	}
}