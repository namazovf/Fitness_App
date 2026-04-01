class ProgressTracker {
    private val workoutHistory = mutableListOf<Pair<String, Int>>()
    private val calorieHistory = mutableListOf<Pair<String, Float>>()

    fun logWorkout(date: String, durationMinutes: Int) {
        workoutHistory.add(Pair(date, durationMinutes))
        println("Workout logged on $date: ${durationMinutes}min")
    }

    fun logCalories(date: String, calories: Float) {
        calorieHistory.add(Pair(date, calories))
        println("Calories logged on $date: $calories kcal")
    }

    fun displayProgress() {
        println("=== Progress Report ===")
        println("Total Workouts: ${workoutHistory.size}")
        val totalMinutes = workoutHistory.sumOf { it.second }
        println("Total Time Exercised: ${totalMinutes}min")
        if (workoutHistory.size > 1) {
            val first = workoutHistory.first().second
            val last = workoutHistory.last().second
            val trend = if (last >= first) "Improving" else "Declining"
            println("Workout Duration Trend: $trend")
        }
        println("Nutrition Entries: ${calorieHistory.size}")
    }
}