package chapter02.item06;

import java.util.regex.Pattern;

public class RomanNumerals {
	//������ ��� ���� ���丮 �޼ҵ带 �����ϴ� �Һ� Ŭ�������� ���� ���丮 �޼ҵ带 ����� ���ʿ��� ��ü ������ ���� �� ����
	//���丮 �޼ҵ�� ȣ�� �� ���� ���ο� ��ü�� ������ ����
	//�Һ� ��ü �Ӹ��ƴ϶� ���� ��ü���ص� ������� ���� ���� �˸� ������ �� ����

    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
    //String.matches�� ����ǥ�������� ���ڿ� ���¸� Ȯ���ϴ� ���� ���� ���������, ������ �߿��� �� �ݺ��� ����ϱ⿡�� �������� ����
	//�� �޼ҵ尡 ���ο��� ����� ����ǥ���Ŀ� Pattern �ν��Ͻ��� �ѹ� ���� ������ GC ����� ��.
	//Pattern�� �Է¹��� ����ǥ���Ŀ� �ش��ϴ� ���� ���¸ӽ�(finite state machine)�� ����� ������ �ν��Ͻ� ���� ����� ����
	//-> ���ɰ����� ���� �ʿ��� ����ǥ������ ǥ���ϴ� Pattern �ν��Ͻ��� Ŭ���� �ʱ�ȭ(���� �ʱ�ȭ) �������� ���� ������ ĳ���صΰ�, ���߿� ȣ��� �� ���� 
	//   �ν��Ͻ��� �����ϴ� ����� ����

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
                // ���� ���̸� Ȯ���Ϸ��� xxxSlow �޼��带 xxxFast �޼���� �ٲ� �����غ���.
                b ^= isRomanNumeralSlow("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " ��s.");
        }

        // VM�� ����ȭ���� ���ϰ� ���� �ڵ�
        if (!b)
            System.out.println();
    }
}
