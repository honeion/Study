package item05;

import java.util.List;
import java.util.Objects;

//의존 객체 주입은 유연성과 테스트 용이성을 높여준다
public class SpellChecker3 {
	private final Lexicon dictionary;
	private SpellChecker3(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	} //객체 생성 방지
	public static boolean isValid(String word) {
		return false;
	}
	public static List<String> suggestions(String typo) {
		return null;
	}
}

