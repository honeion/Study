package chapter02.item06;

public class Sum {
	
 private static long sum() {
     Long sum = 0L;
     for (long i = 0; i <= Integer.MAX_VALUE; i++)
         sum += i;
     return sum;
 }
 
 private static long sum2() {
     long sum = 0L;
     for (long i = 0; i <= Integer.MAX_VALUE; i++)
         sum += i;
     return sum;
 }
 //AutoBoxing
 //Long 인스턴스 -> long 타입
 public static void main(String[] args) {
     long x = 0, y = 0;
     long start = System.nanoTime();
     x += sum();
     long end = System.nanoTime();
     System.out.println("#1 :"+ x +" "+(end - start) / 1_000_000. + " ms.");
     
     start = System.nanoTime();
     y += sum2();
     end = System.nanoTime();
     System.out.println("#2 :"+ y +" "+(end - start) / 1_000_000. + " ms.");
 }
}
