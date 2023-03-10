package diet;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
    
	private String name;
	private Food food;
	
	private double calories=0.0;
	private double proteins=0.0;
	private double carbs=0.0;
	private double fat=0.0;
	private double weight=0.0;

	//CTOR
	public Recipe(String name, Food food) {
		this.name=name;
		this.food=food;
	}

	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {
		this.calories+=food.getRawMaterial(material).getCalories(quantity);
		this.proteins+=food.getRawMaterial(material).getProteins(quantity);
		this.carbs+=food.getRawMaterial(material).getCarbs(quantity);
		this.fat+=food.getRawMaterial(material).getFat(quantity);
		weight+=quantity;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories/weight*100;
	}

	@Override
	public double getProteins() {
		return proteins/weight*100;
	}

	@Override
	public double getCarbs() {
		return carbs/weight*100;
	}

	@Override
	public double getFat() {
		return fat/weight*100;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expressed nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
	    // a recipe expressed nutritional values per 100g
		return true;
	}

}
