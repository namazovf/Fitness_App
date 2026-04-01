class Workout(
    programName: String,
    programDuration: Int,
    programDescription: String,
    private var workoutName: String,
    private var workoutDuration: Int,
    private var workoutDescription: String,
    private var workoutIntensity: String
) : Fitness(programName, programDuration, programDescription) {

    fun getWorkoutName() = workoutName
    fun setWorkoutName(value: String) { workoutName = value }

    fun getWorkoutDuration() = workoutDuration
    fun setWorkoutDuration(value: Int) { workoutDuration = value }

    fun getWorkoutDescription() = workoutDescription
    fun setWorkoutDescription(value: String) { workoutDescription = value }

    fun getWorkoutIntensity() = workoutIntensity
    fun setWorkoutIntensity(value: String) { workoutIntensity = value }

    override fun displayInfo() {
        println("Workout: $workoutName | Intensity: $workoutIntensity | Duration: ${workoutDuration}min")
        println("Program: ${getProgramName()} (${getProgramDuration()} weeks)")
        println("Description: $workoutDescription")
    }
}