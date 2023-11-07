class TankHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    private var healCooldown = 0
    private var kickCooldown = 0

    /**
     *  Führt die Fähigkeiten vom BossMinion random selber aus.
     *
     *  @param mutableList hier wird eine Liste von Anti Helden übergeben.
     */
    fun tankHeroAttack(mutableList: MutableList<AntiHero>) {
        val listOfAttack = listOf("heal", "drawAttentionHit", "punsh", "kick")
        var antiHero: AntiHero? = null

        if (mutableList.size == 1) {
            antiHero = mutableList[0]
            println("Der Boss steht alleine da, schnell greif ihn an.")
            println()
        }

        while (antiHero == null) {
            try {
                if (mutableList.size > 1) {
                    println(
                        "Der Boss ist nicht alleine. Wähle weise wen du angreifen möchtest.\n" +
                                "1 = ${mutableList[0].name} 2 = ${mutableList[1].name}"
                    )
                    val choice = readln().toInt()
                    if (choice in 1..mutableList.size) {
                        antiHero = mutableList[choice - 1]
                    } else {
                        println("Ungültige Auswahl. Bitte gib 1 oder 2 ein.")
                    }
                }
            } catch (e: NumberFormatException) {
                println("Ungültige Eingabe. Bitte gib eine Zahl ein.")
            } catch (e: IndexOutOfBoundsException) {
                println("Der eingegebene Gegner ist nicht auf dem Feld. Bitte wähle erneut.")
            }
        }

        println(
            "$name ist an der reihe.\n" +
                    "Du kannst in dieser Runde $listOfAttack nutzen.\n" +
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
                if ((usedAttack == "heal" && healCooldown > 0) || (usedAttack == "kick" && kickCooldown > 0)) {
                    println("$usedAttack hat noch Cooldown such dir schnell eine andere Fähigkeit aus.")
                    continue
                }
                break
            } catch (e: NumberFormatException) {
                println("Ungültige Eingabe. Bitte gib eine Zahl ein.")
            }
        }

        if (healCooldown >= 0) {
            healCooldown--
        }
        if (kickCooldown >= 0) {
            kickCooldown--
        }

        when (usedAttack) {
            "heal" -> {
                heal()
                healCooldown = 1

            }

            "drawAttentionHit" -> {
                drawAttentionHit(mutableList)

            }

            "punsh" -> {
                punsh(antiHero)
            }

            "kick" -> {
                kick(antiHero)
                kickCooldown = 3
            }
        }
    }

    /**
     *  Heilt diesen Helden um 10 % seiner gesamten Lebensenergie.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 1 Runden Cooldown.
     */
    private fun heal() {
        println(
            "$name versteckt sich hinter einer Mauer um seine Wunden zu heilen.\n" +
                    "$name regeneriert ${maxHealth * 0.1} Lebenspunkte."
        )
        val useHeal = healthbar + maxHealth * 0.1
        healthbar = useHeal.toInt()
    }

    /**
     *  Zieht die Aufmerksamkeit aller Anti Helden auf sich und schlägt dan Raptusartig zu.
     *  Zieht jedem Anti Held 5 % seiner gesamten Lebensenergie ab.
     *
     *  @param list bekommt eine Liste von Anti Helden übergeben.
     */
    private fun drawAttentionHit(list: List<AntiHero>) {
        println(
            "$name macht verrückte bewegungen und zieht damit die Aufmerksamkeit der Anti Helden auf sich.\n" +
                    "Dann schlägt er Raptusartig zu und jeder Anti Held erleidet 5 % Schaden."
        )
        for (antiHero in list) {
            val damage = antiHero.maxHealth * damageMultiplier * 0.15
            val useDrawAttentionHit = antiHero.healthbar - damage
            antiHero.healthbar = useDrawAttentionHit.toInt()
            println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
        }
    }

    /**
     *  Ein heftiger Schlag der den getroffenen Anti Held 15 % seiner gesamten Lebensenergie abzieht.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun punsh(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.15
        println(
            "$name schleudert seine Faust und zieht ${antiHero.name} 15 % seiner maximalen Lebenspunkte ab.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat $damage Schaden erlitten."
        )
        val usePunsh = antiHero.healthbar - damage
        antiHero.healthbar = usePunsh.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
    }

    /**
     *  Ein Roundhouse Kick aller Chuck Norris der den Anti Held 25 % seiner gesamten Lebensenergie abzieht.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     *
     *  @param antiHero erhält einen Anti Helden aus der antiHeroList.
     */
    private fun kick(antiHero: AntiHero) {
        val damage = antiHero.maxHealth * damageMultiplier * 0.25
        println(
            "$name macht einen Roundhouse Kick. ${antiHero.name} erleidet 25 % Schaden.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat $damage Schaden erlitten."
        )
        val useKick = antiHero.healthbar - damage
        antiHero.healthbar = useKick.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar} Lebenspunkte.")
    }
}