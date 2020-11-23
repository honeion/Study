package chapter02.item02;

public class NutritionFacts {
	private final int servingSize;	
	private final int servings;		
	private final int calories;		
	private final int fat;			
	private final int sodium;		
	private final int carbohydrate;	
	public NutritionFacts(Builder builder) {
		this.servingSize	= builder.servingSize;
		this.servings		= builder.servings;
		this.calories		= builder.calories;
		this.fat 			= builder.fat;
		this.sodium			= builder.sodium;
		this.carbohydrate	= builder.carbohydrate;
	}
	
	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}

	//매개변수를 늘려가는 점층적 생성자패턴 개선
	// 1. 자바빈즈 패턴(매개변수 없는 생성자로 객체 생성후 세터메소드로 설정)
	// setter 추가 후 인스턴스 생성하여 설정
	// NutritionFacts cocaCola = new NutritionFacts();
	// cocaCola.setServingSize(240);...
	// 2. 빌더 패턴(필수 매개변수로 생성자를 호출해 빌더 객체 얻고, 빌더 객체가 제공하는 세터메소드로 설정 후 호출)
	public static class Builder {
		// 필수
		private final int servingSize;
		private final int servings;
		// 선택 매개변수 - 기본값으로 초기화
		private int calories 	= 0;
		private int fat		 	= 0;			
		private int sodium		= 0;		
		private int carbohydrate= 0;
		public Builder(int servingSize, int servings) {
			super();
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val) 	 { this.calories = val; return this; }
		public Builder fat(int val) 		 { this.fat = val; return this; }
		public Builder sodium(int val) 		 { this.sodium = val; return this; }
		public Builder carbohydrate(int val) { this.carbohydrate = val; return this; }
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Item02 builder Test");
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
		System.out.println(cocaCola);
		
	}
}
