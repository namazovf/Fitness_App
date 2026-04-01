class CardioExercise(
    exerciseName: String,
    exerciseDuration: Int,
    exerciseDescription: String,
    caloriesBurned: Float,
    private var cardioType: String
) : Exercise(exerciseName, exerciseDuration, exerciseDescription, caloriesBurned) {

    fun getCardioType() = cardioType
    fun setCardioType(value: String) { cardioType = value }

    override fun displayInfo() {
        println("[CARDIO - $cardioType]")
        super.displayInfo()
    }
}
