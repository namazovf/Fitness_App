class FlexibilityExercise(
    exerciseName: String,
    exerciseDuration: Int,
    exerciseDescription: String,
    caloriesBurned: Float,
    private var stretchType: String
) : Exercise(exerciseName, exerciseDuration, exerciseDescription, caloriesBurned) {

    fun getStretchType() = stretchType
    fun setStretchType(value: String) { stretchType = value }

    override fun displayInfo() {
        println("[FLEXIBILITY - $stretchType]")
        super.displayInfo()
    }
}