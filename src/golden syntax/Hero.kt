open class Hero(name: String, healthbar: Int) : Character(name, healthbar) {

    var damageMultiplier = 1.0
    private var healItemUses = 3
    private var healTeamItemUses = 2
    private var buffItemUses = 1

    /**
     *
     *
     */
    open fun useMagicBag(list: MutableList<Hero>, magicBag: MagicBag): String {

        val listOfItems = listOf("heallItem", "healItemTeam", "buffItem")
        var hero: Hero = list[0]

        println("Möchtest du deinen Magic Bag nutzen? (y = yes, n = no)")
        val userInput = readln()
        if (userInput == "y") {
            try {
                if (list.isNotEmpty()) {
                    println(
                        "Wer soll in den Magic Bag greifen und diese runde keine Fähigkeit nutzen?\n" +
                                "1 = ${list[0].name} 2 =${list[1].name} 3 = ${list[2].name}"
                    )
                    hero = list[readln().toInt() - 1]
                }
            } catch (e: Exception) {
                println(
                    "Dieser Held ist kein Held er ist geflohen und hat die anderen im Stich gelassen.\n" +
                            "Wähle noch einmal."
                )
                hero = list[readln().toInt() - 1]
            }

            println(
                "${hero.name} greift in den Magischen Beutel.\n" +
                        "Nach kurzer Zeit des wühlens findet er ..."
            )
            println()

            println(
                "Du kannst in dieser Runde $listOfItems nutzen.\n" +
                        "Wähle eine Item von 1 - 3."
            )

            var tryUseBag: Int
            var useBag: String

            while (true) {
                tryUseBag = readln().toInt()
                if (tryUseBag !in 1..3) {
                    println(
                        "Das Item ist nicht im Beutel.\n" +
                                "Greif nochmal rein."
                    )
                    continue
                }
                useBag = listOfItems[tryUseBag - 1]
                if ((useBag == "heallItem" && healItemUses == 0) ||
                    (useBag == "healItemTeam" && healTeamItemUses == 0) ||
                    (useBag == "buffItem" && buffItemUses == 0)
                ) {
                    println(
                        "$useBag ist schon aufgebraucht.\n" +
                                "Versuche ein anderes."
                    )
                    continue
                }
                break
            }

            when (useBag) {
                "heallItem" -> {
                    magicBag.heallItem(hero)
                    healItemUses--


                }

                "healItemTeam" -> {
                    magicBag.healItemTeam(list)
                    healTeamItemUses--

                }

                "buffItem" -> {
                    magicBag.buffItem(hero)
                    buffItemUses--
                }
            }
            return hero.name
        }
        return ""
    }
}

