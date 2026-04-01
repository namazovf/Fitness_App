open class Exercise(
    private var exerciseName: String,
    private var exerciseDuration: Int,
    private var exerciseDescription: String,
    private var caloriesBurned: Float
) {
    fun getExerciseName() = exerciseName
    fun setExerciseName(value: String) { exerciseName = value }

    fun getExerciseDuration() = exerciseDuration
    fun setExerciseDuration(value: Int) { exerciseDuration = value }

    fun getExerciseDescription() = exerciseDescription
    fun setExerciseDescription(value: String) { exerciseDescription = value }

    fun getCaloriesBurned() = caloriesBurned
    fun setCaloriesBurned(value: Float) { caloriesBurned = value }

    open fun displayInfo() {
        println("Exercise: $exerciseName | Duration: ${exerciseDuration}min | Calories: $caloriesBurned")
        println("Description: $exerciseDescription")
    }
}