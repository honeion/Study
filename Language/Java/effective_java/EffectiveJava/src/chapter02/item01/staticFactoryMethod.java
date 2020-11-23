package chapter02.item01;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class staticFactoryMethod {
	public static void main(String[] args) {
		BigInteger randomPrime = BigInteger.probablePrime(12, new Random());
		Instant instant = Instant.now();
		Date d = Date.from(instant);
	}
}
