package chapter02.item06;

import java.util.regex.Pattern;

public class RomanNumerals {
	//생성자 대신 정적 팩토리 메소드를 제공하는 불변 클래스에서 정적 팩토리 메소드를 사용해 불필요한 객체 생성을 피할 수 있음
	//팩토리 메소드는 호출 시 마다 새로운 객체를 만들지 않음
	//불변 객체 뿐만아니라 가변 객체라해도 변경되지 않을 것을 알면 재사용할 수 있음

    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
    //String.matches는 정규표현식으로 문자열 형태를 확인하는 가장 쉬운 방법이지만, 성능이 중요할 때 반복해 사용하기에는 적합하지 않음
	//이 메소드가 내부에서 만드는 정규표현식용 Pattern 인스턴스는 한번 쓰고 버려져 GC 대상이 됨.
	//Pattern을 입력받은 정규표현식에 해당하는 유한 상태머신(finite state machine)을 만들기 때문에 인스턴스 생성 비용이 높음
	//-> 성능개선을 위해 필요한 정규표현식을 표현하는 Pattern 인스턴스를 클래스 초기화(정적 초기화) 과정에서 직접 생성해 캐싱해두고, 나중에 호출될 때 마다 
	//   인스턴스를 재사용하는 방법이 낫다

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt("1");
        int numReps = Integer.parseInt("10");
        boolean b = false;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                // 성능 차이를 확인하려면 xxxSlow 메서드를 xxxFast 메서드로 바꿔 실행해보자.
                b ^= isRomanNumeralSlow("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        // VM이 최적화하지 못하게 막는 코드
        if (!b)
            System.out.println();
    }
}
