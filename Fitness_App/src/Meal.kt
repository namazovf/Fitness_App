class Meal(
    private var mealName: String,
    private var mealDescription: String,
    private var calories: Float
) {
    fun getMealName() = mealName
    fun setMealName(value: String) { mealName = value }

    fun getMealDescription() = mealDescription
    fun setMealDescription(value: String) { mealDescription = value }

    fun getCalories() = calories
    fun setCalories(value: Float) { calories = value }

    fun displayInfo() {
        println("Meal: $mealName | Calories: $calories kcal")
        println("Description: $mealDescription")
    }
}