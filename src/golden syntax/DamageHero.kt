class DamageHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    private var swordMultiSpinCooldown = 0
    private var thunderSwordCooldown = 0

    /**
     *  Führt die Fähigkeiten vom BossMinion random selber aus.
     *
     *  @param mutableList hier wird eine Liste von Anti Helden übergeben.
     */
    fun damageHeroAttack(mutableList: MutableList<AntiHero>) {

        val listOfAttack = listOf("swordSpin", "knopStrike", "swordMultiSpin", "thunderSword")
        var antiHero = AntiHero("", 0)

        if (mutableList.size == 1) {
            antiHero = mutableList[0]
            println("Der Boss steht alleine da, schnell greif ihn an.")
            println()
        }
        try {
            if (mutableList.size > 1) {
                println(
                    "Der Boss ist nicht alleine. Wähle weise wen du angreifen möchtest.\n" +
                            "1 = ${mutableList[0].name} 2 =${mutableList[1].name}"
                )
                antiHero = mutableList[readln().toInt() - 1]
            }
        } catch (e: Exception) {
            println(
                "Der eingegebene Gegner ist nicht auf dem Feld.\n" +
                        "Wähle noch einmal."
            )
            antiHero = mutableList[readln().toInt() - 1]
        }

        println(
            "$name ist an der reihe.\n" +
                    "Du kannst in dieser Runde $listOfAttack nutzen.\n" +
                    "Wähle eine Fähigkeit von 1 - 4."
        )

        var attackNumber: Int
        var usedAttack: String

        while (true) {
            attackNumber = readln().toInt()
            if (attackNumber !in 1..4) {
                println(
                    "Hey diese Fähigkeit übersteigt dein Level.\n" +
                            "Bitte wähle eine andere."
                )
                continue
            }
            usedAttack = listOfAttack[attackNumber - 1]
            if ((usedAttack == "swordMultiSpin" && swordMultiSpinCooldown > 0) ||
                (usedAttack == "thunderSword" && thunderSwordCooldown > 0)
            ) {
                println("$usedAttack hat noch Cooldown such dir schnell eine andere Fähigkeit aus.")
                continue
            }
            break
        }

        if (swordMultiSpinCooldown >= 0) {
            swordMultiSpinCooldown--
        }
        if (thunderSwordCooldown >= 0) {
            thunderSwordCooldown--
        }

        when (usedAttack) {
            "swordSpin" -> {
                swordSpin(antiHero)


            }

            "knopStrike" -> {
                knopStrike(antiHero)

            }

            "swordMultiSpin" -> {
                swordMultiSpin(mutableList)
                swordMultiSpinCooldown = 3
            }

            "thunderSword" -> {
                thunderSword(antiHero)
                thunderSwordCooldown = 5
            }
        }
    }

    /**
     *  Schleuder das Schwert in richtung des Anti Helden dieser wird mehrfach von der rotierenden
     *  Klinge getroffen und erleidet 15 % seiner gesamten Lebensenergie an Schaden.
     */
    private fun swordSpin(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.15
        println(
            "$name schleudert sein schwert auf ${antiHero.name} und zieht ihm 15 % seiner Lebenspunkte ab.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat $damage Schaden erlitten."
        )
        val useSwordSpin = antiHero.healthbar - damage
        antiHero.healthbar = useSwordSpin.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
    }

    /**
     *  Schlägt mit dem Griff seines Schwertes fest zu und fügt dem Anti Helden 10 % seiner gesamten Lebensenergie
     *  an Schaden zu.
     */
    private fun knopStrike(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.1
        println(
            "$name wirft sein Schwert in die luft und fängt es an der Klinge und haut mit dem Griff\n" +
                    "fest zu und trifft ${antiHero.name}.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat $damage Schaden erlitten."
        )
        val useKnopStrike = antiHero.healthbar - damage
        antiHero.healthbar = useKnopStrike.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
    }

    /**
     *  Wirft ein kreisendes Schwert auf alle Anti Helden und fügt 15 % der gesamten Lebensenergie an Schaden zu.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     *
     *  @param list bekommt eine Liste von Anti Helden übergeben.
     */
    private fun swordMultiSpin(list: List<AntiHero>) {
        println(
            "$name wirft sein Schwert in kreisenden Bewegungen und trift jeden Anti Helden.\n" +
                    "Jeder Anti Held erleidet 15 % Schaden."
        )
        for (antiHero in list) {
            val damage = antiHero.maxHealth * damageMultiplier * 0.15
            val useSwordMultiSpin = antiHero.healthbar - damage
            antiHero.healthbar = useSwordMultiSpin.toInt()
            println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
        }
    }

    /**
     *  Blitze kommen aus dem Himmel geflogen. Diese treffen einen Anti Held mit einem Schaden von 30 %
     *  der gesamten Lebensenergie des AntiHelden.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 5 Runden Cooldown.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun thunderSword(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.30
        println(
            "$name hält sein Schwert in die Luft und murmelt etwas.\n" +
                    "Plötzlich fängt es an zu Donnern und Blitze schlagen auf ${antiHero.name} ein.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat $damage Schaden erlitten."
        )
        val useThunderSword = antiHero.healthbar - damage
        antiHero.healthbar = useThunderSword.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
    }
}