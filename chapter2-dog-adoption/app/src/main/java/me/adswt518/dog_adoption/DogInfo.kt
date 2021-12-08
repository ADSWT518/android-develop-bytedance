package me.adswt518.dog_adoption

val dogMap = mutableMapOf<Int, Triple<Pair<Int, String>, Triple<Int, Boolean, String>, String>>(
    // This is a map: dogId -> ((resId, dogName), (dogAge, dogGender, dogVariety), detailedInfo)
    // dogGender: false for male, true for female
    1 to Triple(Pair(R.drawable.husky, "Max"), Triple(3, false, "Husky"), "very cute."),
    2 to Triple(Pair(R.drawable.poodle, "Abby"), Triple(5, true, "Poodle"), "very cute."),
    3 to Triple(Pair(R.drawable.labrador, "Johnny"), Triple(2, false, "Labrador"), "very cute."),
    4 to Triple(Pair(R.drawable.samoyed, "Luna"), Triple(6, true, "Samoyed"), "very cute."),
    5 to Triple(Pair(R.drawable.shiba, "Scooter"), Triple(5, false, "Shiba"), "very cute."),
    6 to Triple(Pair(R.drawable.shiba, "Scooter1"), Triple(5, false, "Shiba"), "very cute."),
    7 to Triple(Pair(R.drawable.shiba, "Scooter2"), Triple(5, false, "Shiba"), "very cute."),
    8 to Triple(Pair(R.drawable.shiba, "Scooter3"), Triple(5, false, "Shiba"), "very cute."),
    9 to Triple(Pair(R.drawable.shiba, "Scooter4"), Triple(5, false, "Shiba"), "very cute."),
    10 to Triple(Pair(R.drawable.shiba, "Scooter5"), Triple(5, false, "Shiba"), "very cute."),
    11 to Triple(Pair(R.drawable.shiba, "Scooter6"), Triple(5, false, "Shiba"), "very cute.")
)