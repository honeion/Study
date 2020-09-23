package item02.hierarchicalBuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
	final Set<Topping> toppings;
	abstract static class Builder<T extends Builder<T>>{
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		abstract Pizza build();
		//하위 클래스는 이 메소드를 재정의하여 this를 반환하도록 해야함
		protected abstract T self(); 
		//self 타입이 자바에는 없기 때문에 이 우회방법을 "시뮬레이트한 셀프 타입 관용구"라고 함
	}
	Pizza(Builder<?> builder){
		toppings = builder.toppings.clone();
	}
	
}
