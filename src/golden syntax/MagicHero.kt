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
        var antiHero: AntiHero? = null

        if (mutableListBad.size == 1) {
            antiHero = mutableListBad[0]
            println("Der Anti Held steht alleine da, schnell greif ihn an.")
            println()
        }

        while (antiHero == null) {
            try {
                if (mutableListBad.size > 1) {
                    println(
                        "Der Anti Held ist nicht mehr alleine. Wähle weise wen du angreifen möchtest.\n" +
                                "1 = ${mutableListBad[0].name} 2 = ${mutableListBad[1].name}"
                    )
                    val choice = readln().toInt()
                    if (choice in 1..mutableListBad.size) {
                        antiHero = mutableListBad[choice - 1]
                    } else {
                        println("Wenn möchtest du da bitte angreifen? Bitte gib 1 oder 2 ein.")
                    }
                }
            } catch (e: NumberFormatException) {
                println("Der eingegebene Gegner ist nicht auf dem Feld. Bitte wähle erneut.")
            } catch (e: IndexOutOfBoundsException) {
                println("Der eingegebene Gegner ist nicht auf dem Feld. Bitte wähle erneut.")
            }
        }

        println(
            "$name ist an der reihe.\n" +
                    "Du kannst in dieser Runde ${BOLD}$listOfAttack${RESET} nutzen.\n" +
                    "Wähle eine Fähigkeit von 1 - 4."
        )

        var attackNumber: Int
        var usedAttack: String

        while (true) {
            try {
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
            } catch (e: NumberFormatException) {
                println(
                    "Hey diese Fähigkeit übersteigt dein Level.\n" +
                            "Bitte wähle eine andere."
                )
            }

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
                    "Alle Anti Helden werden 5 % Lebensenergie abgezogen."
        )
        for (antiHero in list) {
            val damage = antiHero.maxHealth * damageMultiplier * 0.05
            val useLightningStrike = antiHero.healthbar - damage
            antiHero.healthbar = useLightningStrike.toInt()
            println("${antiHero.name} erleidet ${RED}$damage${RESET} Schaden.")
        }
    }

    /**
     *  Die Erde erhebt sich und fügt dem AntiHeld der auf ihr steht, 10 % der gesamten Lebensenergie an schaden zu.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun earthquake(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.1
        println(
            "$name lässt die Erde erbeben und ${antiHero.name} erleidet 10 % Schaden.\n" +
                    "${antiHero.name} hat ${RED}$damage${RESET} Schaden erlitten."
        )
        val useEarthquake = antiHero.healthbar - antiHero.maxHealth * 0.1
        antiHero.healthbar = useEarthquake.toInt()
    }

    /**
     *  Ein Schutzzauber der auf jeden Helden wirkt und um 15 % der maximalen Lebensenergie heilt.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    private fun regenerationBuff(list: List<Hero>) {
        println("$name spricht einen Zauber und alle Helden erhalten Lebensenergie zurück.")
        for (hero in list) {
            val useRegenerationBuff = hero.healthbar + hero.maxHealth * 0.15
            hero.healthbar = useRegenerationBuff.toInt()
            println("${hero.name} regeneriert ${GREEN}${maxHealth * 0.15}${RESET} Lebensenergie.")
        }
    }

    /**
     *  Spricht einen mächtigen Zauber der 25 % seiner maximalen Lebensenergie an Schaden verursacht.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 5 Runden Cooldown.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun mortality(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.25
        println(
            "$name spricht einen mächtigen Zauber über ${antiHero.name} aus.\n" +
                    "${antiHero.name} hat ${RED}$damage${RESET} Schaden erlitten."
        )
        val useMortality = antiHero.healthbar - damage
        antiHero.healthbar = useMortality.toInt()
    }
}