open class Hero(name: String, healthbar: Int) : Character(name, healthbar) {

    private var healItemUses = 3
    private var healTeamItemUses = 2
    private var buffItemUses = 1

    /**
     *
     *
     */
    open fun useMagicBag(listGood: MutableList<Hero>, listBad: MutableList<AntiHero>, magicBag: MagicBag) {

        val listOfItems = listOf("heallItem", "healItemTeam", "buffItem")
        var hero = Hero("", 0)
        val antiHero = AntiHero("", 0)

        println("Möchtest du deinen Magic Bag nutzen? (y = yes, n = no)")
        val userInput = readln()

        if (userInput == "y") {
            try {
                if (listGood.isNotEmpty()) {
                    println(
                        "Wer soll in den Magic Bag greifen und diese runde keine Fähigkeit nutzen?\n" +
                                "1 = ${listGood[0].name} 2 =${listGood[1].name} 3 = ${listGood[2].name}"
                    )
                    hero = listGood[readln().toInt() - 1]
                }
            } catch (e: Exception) {
                println(
                    "Dieser Held ist kein Held er ist geflohen und hat die anderen im Stich gelassen.\n" +
                            "Wähle noch einmal."
                )
                hero = listGood[readln().toInt() - 1]
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
                    magicBag.healItemTeam(listGood)
                    healTeamItemUses--

                }

                "buffItem" -> {
                    magicBag.buffItem(hero, antiHero)
                    buffItemUses--
                }
            }
        }
    }
}