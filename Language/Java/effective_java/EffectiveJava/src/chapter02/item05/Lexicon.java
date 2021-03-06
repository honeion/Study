package chapter02.item05;

public class Lexicon {
}

//SpellChecker1, 2의 방식은 모두 사전을 단 하나만 사용한다는 가정
//실전에서는 사전이 언어별로 따로 있고 특수 어휘용 사전을 별도로 두기도 함
//심지어 테스트용 사전도 필요할 수 있음
//SpellChecker가 여러 사전을 사용할 수 있도록 함
//클래스(SpellChecker)가 여러 자원 인스턴스를 지원해야하며 클라이언트가 원하는 자원(dictionary)을 사용해야함
//이 조건을 만족하는 간단한 패턴이 있으니, 바로 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식
