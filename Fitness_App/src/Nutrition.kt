interface Nutrition {
    fun calculateCalories(weight: Float, height: Float, age: Int, activityLevel: String): Float
    fun logMeal(meal: Meal)
}