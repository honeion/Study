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

	//�Ű������� �÷����� ������ ���������� ����
	// 1. �ڹٺ��� ����(�Ű����� ���� �����ڷ� ��ü ������ ���͸޼ҵ�� ����)
	// setter �߰� �� �ν��Ͻ� �����Ͽ� ����
	// NutritionFacts cocaCola = new NutritionFacts();
	// cocaCola.setServingSize(240);...
	// 2. ���� ����(�ʼ� �Ű������� �����ڸ� ȣ���� ���� ��ü ���, ���� ��ü�� �����ϴ� ���͸޼ҵ�� ���� �� ȣ��)
	public static class Builder {
		// �ʼ�
		private final int servingSize;
		private final int servings;
		// ���� �Ű����� - �⺻������ �ʱ�ȭ
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
