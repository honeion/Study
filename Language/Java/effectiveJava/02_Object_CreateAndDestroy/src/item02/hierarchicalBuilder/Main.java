package item02.hierarchicalBuilder;
import static item02.hierarchicalBuilder.NyPizza.Size.*;
import static item02.hierarchicalBuilder.Pizza.Topping.*;

public class Main {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
		System.out.println(pizza);
		System.out.println(calzone);
	}
}
