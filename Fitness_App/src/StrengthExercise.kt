class StrengthExercise(
    exerciseName: String,
    exerciseDuration: Int,
    exerciseDescription: String,
    caloriesBurned: Float,
    private var muscleGroup: String
) : Exercise(exerciseName, exerciseDuration, exerciseDescription, caloriesBurned) {

    fun getMuscleGroup() = muscleGroup
    fun setMuscleGroup(value: String) { muscleGroup = value }

    override fun displayInfo() {
        println("[STRENGTH - Muscle Group: $muscleGroup]")
        super.displayInfo()
    }
}