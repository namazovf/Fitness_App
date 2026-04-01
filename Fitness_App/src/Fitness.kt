abstract class Fitness(
    private var programName: String,
    private var programDuration: Int,
    private var programDescription: String
) {
    fun getProgramName() = programName
    fun setProgramName(value: String) { programName = value }

    fun getProgramDuration() = programDuration
    fun setProgramDuration(value: Int) { programDuration = value }

    fun getProgramDescription() = programDescription
    fun setProgramDescription(value: String) { programDescription = value }

    abstract fun displayInfo()
}