fun main() {
    val workouts = mutableListOf<Workout>()
    val exercises = mutableListOf<Exercise>()
    val nutritionPlan = NutritionPlan("My Plan")
    val tracker = ProgressTracker()
    val scanner = java.util.Scanner(System.`in`)

    fun readLine(prompt: String): String {
        print(prompt)
        return scanner.nextLine().trim()
    }

    fun readInt(prompt: String): Int {
        print(prompt)
        return scanner.nextLine().trim().toIntOrNull() ?: 0
    }

    fun readFloat(prompt: String): Float {
        print(prompt)
        return scanner.nextLine().trim().toFloatOrNull() ?: 0f
    }

    fun workoutMenu() {
        while (true) {
            println("\n--- Trening Menyusu ---")
            println("1. Trening elave et")
            println("2. Butun treningleri goster")
            println("0. Geri")
            when (readLine("Secim: ")) {
                "1" -> {
                    val progName = readLine("Proqram adi: ")
                    val progDur = readInt("Proqram muddeti (hefte): ")
                    val progDesc = readLine("Proqram aciqlamasi: ")
                    val wName = readLine("Trening adi: ")
                    val wDur = readInt("Trening muddeti (deq): ")
                    val wDesc = readLine("Trening aciqlamasi: ")
                    val wInt = readLine("Intensivlik (Low/Medium/High): ")
                    val w = Workout(progName, progDur, progDesc, wName, wDur, wDesc, wInt)
                    workouts.add(w)
                    tracker.logWorkout(java.time.LocalDate.now().toString(), wDur)
                    println("Trening elave edildi.")
                }
                "2" -> {
                    if (workouts.isEmpty()) println("Heç bir trening yoxdur.")
                    else workouts.forEach { it.displayInfo(); println() }
                }
                "0" -> return
                else -> println("Yanlış seçim.")
            }
        }
    }

    fun exerciseMenu() {
        while (true) {
            println("\n--- Mesq Menyusu ---")
            println("1. Cardio mesqi elave et")
            println("2. Guc mesqi elave et")
            println("3. Ceviklik mesqi elave et")
            println("4. Butun mesqleri goster")
            println("0. Geri")
            when (readLine("Secim: ")) {
                "1" -> {
                    val name = readLine("Mesq adi: ")
                    val dur = readInt("Muddeti (deq): ")
                    val desc = readLine("Aciqlamasi: ")
                    val cal = readFloat("Yandirilan kalori: ")
                    val cardioType = readLine("Cardio novu (Steady State/Interval): ")
                    exercises.add(CardioExercise(name, dur, desc, cal, cardioType))
                    println("Cardio mesqi elave edildi.")
                }
                "2" -> {
                    val name = readLine("Mesq adi: ")
                    val dur = readInt("Muddeti (deq): ")
                    val desc = readLine("Aciqlamasi: ")
                    val cal = readFloat("Yandirilan kalori: ")
                    val muscle = readLine("Esas eze grupu: ")
                    exercises.add(StrengthExercise(name, dur, desc, cal, muscle))
                    println("Guc mesqi elave edildi.")
                }
                "3" -> {
                    val name = readLine("Mesq adi: ")
                    val dur = readInt("Muddeti (deq): ")
                    val desc = readLine("Aciqlamasi: ")
                    val cal = readFloat("Yandirilan kalori: ")
                    val stretch = readLine("Germe novu (Dynamic/Static): ")
                    exercises.add(FlexibilityExercise(name, dur, desc, cal, stretch))
                    println("Ceviklik mesqi elave edildi.")
                }
                "4" -> {
                    if (exercises.isEmpty()) println("Heç bir mesq yoxdur.")
                    else exercises.forEach { it.displayInfo(); println() }
                }
                "0" -> return
                else -> println("Yanlış seçim.")
            }
        }
    }

    fun nutritionMenu() {
        while (true) {
            println("\n--- Qidalanma Menyusu ---")
            println("1. Gundelik kalori hesabla")
            println("2. Yemek elave et")
            println("3. Yemek logunu goster")
            println("0. Geri")
            when (readLine("Secim: ")) {
                "1" -> {
                    val weight = readFloat("Ceki (kg): ")
                    val height = readFloat("Boy (cm): ")
                    val age = readInt("Yas: ")
                    val activity = readLine("Aktivlik (sedentary/light/moderate/active/very active): ")
                    val cal = nutritionPlan.calculateCalories(weight, height, age, activity)
                    println("Gundelik kalori hedefiniz: $cal kcal")
                }
                "2" -> {
                    val name = readLine("Yemek adi: ")
                    val desc = readLine("Aciqlamasi: ")
                    val cal = readFloat("Kalorisi: ")
                    val date = java.time.LocalDate.now().toString()
                    nutritionPlan.logMeal(Meal(name, desc, cal))
                    tracker.logCalories(date, cal)
                    println("Yemek elave edildi.")
                }
                "3" -> nutritionPlan.displayMealLog()
                "0" -> return
                else -> println("Yanlış seçim.")
            }
        }
    }

    while (true) {
        println("\n====== FITNESS APP ======")
        println("1. Treningler")
        println("2. Mesqler")
        println("3. Qidalanma")
        println("4. Proqres")
        println("0. Cix")
        when (readLine("Secim: ")) {
            "1" -> workoutMenu()
            "2" -> exerciseMenu()
            "3" -> nutritionMenu()
            "4" -> tracker.displayProgress()
            "0" -> { println("Cixilir..."); return }
            else -> println("Yanlış seçim.")
        }
    }
}