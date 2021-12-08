package me.adswt518.dog_adoption

val dogMap = mutableMapOf<Int, Triple<Pair<Int, String>, Triple<Int, Boolean, String>, String>>(
    // This is a map: dogId -> ((resId, dogName), (dogAge, dogGender, dogVariety), detailedInfo)
    // dogGender: false for male, true for female
    1 to Triple(
        Pair(R.drawable.husky, "Max"),
        Triple(3, false, "Husky"),
        "A husky is a sled dog used in the polar regions. One can differentiate huskies from other dog types by their fast pulling-style. Modern racing huskies (also known as Alaskan huskies) represent an ever-changing crossbreed of the fastest dogs (the Alaskan Malamute, by contrast, pulled heavier loads at a slower speed). Humans use huskies in sled-dog racing. Various companies have marketed tourist treks with dog sledges for adventure travelers in snow regions. Huskies are also kept as pets, and groups work to find new pet homes for retired racing and adventure-trekking dogs."
    ),
    2 to Triple(
        Pair(R.drawable.poodle, "Abby"),
        Triple(5, true, "Poodle"),
        "The Poodle, called the Pudel in German and the Caniche in French, is a breed of water dog. The breed is divided into four varieties based on size, the Standard Poodle, Medium Poodle, Miniature Poodle and Toy Poodle, although the Medium Poodle variety is not universally recognised."
    ),
    3 to Triple(
        Pair(R.drawable.labrador, "Johnny"),
        Triple(2, false, "Labrador"),
        "The Labrador Retriever or Labrador is a British breed of retriever gun dog. It was developed in the United Kingdom from fishing dogs imported from the independent colony of Newfoundland (now part of Canada), and is named for the Labrador region of that colony. It is among the most commonly kept dogs in several countries, particularly in the Western world."
    ),
    4 to Triple(
        Pair(R.drawable.samoyed, "Luna"),
        Triple(6, true, "Samoyed"),
        "The Samoyed is a breed of medium-sized herding dogs with thick, white, double-layer coats. They are a spitz-type dog which takes its name from the Samoyedic peoples of Siberia."
    ),
    5 to Triple(
        Pair(R.drawable.shiba, "Scooter"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    ),
    6 to Triple(
        Pair(R.drawable.shiba, "Scooter1"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    ),
    7 to Triple(
        Pair(R.drawable.shiba, "Scooter2"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    ),
    8 to Triple(
        Pair(R.drawable.shiba, "Scooter3"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    ),
    9 to Triple(
        Pair(R.drawable.shiba, "Scooter4"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    ),
    10 to Triple(
        Pair(R.drawable.shiba, "Scooter5"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    ),
    11 to Triple(
        Pair(R.drawable.shiba, "Scooter6"),
        Triple(5, false, "Shiba"),
        "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan."
    )
)