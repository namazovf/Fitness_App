class NutritionPlan(private val planName: String) : Nutrition {
    private val loggedMeals = mutableListOf<Meal>()

    override fun calculateCalories(weight: Float, height: Float, age: Int, activityLevel: String): Float {
        val bmr = 10 * weight + 6.25f * height - 5 * age + 5
        val multiplier = when (activityLevel.lowercase()) {
            "sedentary" -> 1.2f
            "light" -> 1.375f
            "moderate" -> 1.55f
            "active" -> 1.725f
            "very active" -> 1.9f
            else -> 1.2f
        }
        return bmr * multiplier
    }

    override fun logMeal(meal: Meal) {
        loggedMeals.add(meal)
        println("Logged: ${meal.getMealName()} (${meal.getCalories()} kcal)")
    }

    fun getTotalCaloriesConsumed() = loggedMeals.sumOf { it.getCalories().toDouble() }.toFloat()

    fun displayMealLog() {
        println("=== Meal Log for $planName ===")
        loggedMeals.forEach { it.displayInfo() }
        println("Total Calories Consumed: ${getTotalCaloriesConsumed()} kcal")
    }
}