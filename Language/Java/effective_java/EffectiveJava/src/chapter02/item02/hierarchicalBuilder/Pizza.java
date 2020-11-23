package chapter02.item02.hierarchicalBuilder;

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
		//���� Ŭ������ �� �޼ҵ带 �������Ͽ� this�� ��ȯ�ϵ��� �ؾ���
		protected abstract T self(); 
		//self Ÿ���� �ڹٿ��� ���� ������ �� ��ȸ����� "�ùķ���Ʈ�� ���� Ÿ�� ���뱸"��� ��
	}
	Pizza(Builder<?> builder){
		toppings = builder.toppings.clone();
	}
	
}