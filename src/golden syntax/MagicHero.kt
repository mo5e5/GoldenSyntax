class MagicHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    private var regenerationBuffCooldown = 0
    private var mortalityCooldown = 0

    /**
     *  Führt die Fähigkeiten vom BossMinion random selber aus.
     *
     *  @param mutableListBad hier wird eine Liste von Anti Helden übergeben.
     *  @param mutableListGood hier wird eine Liste von Helden übergeben.
     */
    fun magicHeroAttack(mutableListBad: MutableList<AntiHero>, mutableListGood: MutableList<Hero>) {
        val listOfAttack = listOf("lightningStrike", "earthquake", "regenerationBuff", "mortality")
        var antiHero = AntiHero("", 0)

        if (mutableListBad.size == 1) {
            antiHero = mutableListBad[0]
            println("Der Boss steht alleine da, schnell greif ihn an.")
            println()
        }
        try {
            if (mutableListBad.size > 1) {
                println(
                    "Der Boss ist nicht alleine. Wähle weise wen du angreifen möchtest.\n" +
                            "1 = ${mutableListBad[0].name} 2 =${mutableListBad[1].name}"
                )
                antiHero = mutableListBad[readln().toInt() - 1]
            }
        } catch (e: Exception) {
            println(
                "Der eingegebene Gegner ist nicht auf dem Feld.\n" +
                        "Wähle noch einmal."
            )
            antiHero = mutableListBad[readln().toInt() - 1]
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
            if ((usedAttack == "regenerationBuff" && regenerationBuffCooldown > 0) ||
                (usedAttack == "mortality" && mortalityCooldown > 0)
            ) {
                println("$usedAttack hat noch Cooldown such dir schnell eine andere Fähigkeit aus.")
                continue
            }
            break
        }

        if (regenerationBuffCooldown >= 0) {
            regenerationBuffCooldown--
        }
        if (mortalityCooldown >= 0) {
            mortalityCooldown--
        }

        when (usedAttack) {
            "lightningStrike" -> {
                lightningStrike(mutableListBad)


            }

            "earthquake" -> {
                earthquake(antiHero)

            }

            "regenerationBuff" -> {
                regenerationBuff(mutableListGood)
                regenerationBuffCooldown = 3
            }

            "mortality" -> {
                mortality(antiHero)
                mortalityCooldown = 5
            }
        }
    }

    /**
     *  Es hagelt Blitze vom Himmel die alle AntiHelden treffen und jeweils 5 % der gesamten Lebensenergie
     *  an Schaden verursachen.
     *
     *  @param list bekommt eine Liste von Anti Helden übergeben.
     */
    private fun lightningStrike(list: List<AntiHero>) {
        println(
            "Der Himmel wird dunkel und $name lässt es Blitze hageln.\n" +
                    "Alle Anti Helden werden 5 % Lebenspunkte abgezogen."
        )
        for (antiHero in list) {
            val useLightningStrike = antiHero.healthbar - antiHero.maxHealth * 0.05
            antiHero.healthbar = useLightningStrike.toInt()
            println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
        }
    }

    /**
     *  Die Erde erhebt sich und fügt dem AntiHeld der auf ihr steht, 10 % der gesamten Lebensenergie an schaden zu.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun earthquake(antiHero: AntiHero) {
        println(
            "$name lässt die Erde erbeben und ${antiHero.name} erleidet 10 % Schaden.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar}.\n" +
                    "Er hat ${antiHero.maxHealth * 0.15} Schaden erlitten."
        )
        val useEarthquake = antiHero.healthbar - antiHero.maxHealth * 0.1
        antiHero.healthbar = useEarthquake.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }

    /**
     *  Ein Schutzzauber der auf jeden Helden wirkt und um 15 % der maximalen Lebenspunkte heilt.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    private fun regenerationBuff(list: List<Hero>) {
        println("$name spricht einen Zauber und alle Helden erhalten ${maxHealth * 0.15}")
        for (hero in list) {
            val useRegenerationBuff = hero.healthbar + hero.maxHealth * 0.15
            hero.healthbar = useRegenerationBuff.toInt()
            println("${hero.name} hat nun ${hero.healthbar} Lebenspunkte.")
        }
    }

    /**
     *  Spricht einen mächtigen Zauber der 25 % seiner maximalen Lebensenergie an Schaden verursacht.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 5 Runden Cooldown.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun mortality(antiHero: AntiHero) {
        println(
            "$name spricht einen mächtigen Zauber über ${antiHero.name} aus.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat ${maxHealth * 0.25} Schaden erlitten."
        )
        val useMortality = antiHero.healthbar - maxHealth * 0.25
        antiHero.healthbar = useMortality.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }
}