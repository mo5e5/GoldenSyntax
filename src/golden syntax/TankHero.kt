import kotlin.random.Random

class TankHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    var healCooldown = 0
    var kickCooldown = 0

    /**
     *  Führt die Fähigkeiten vom BossMinion random selber aus.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun tankHeroAttack(mutableList: MutableList<AntiHero>) {
        val listOfAttack = listOf("heal", "drawAttentionHit", "punsh", "kick")
        val antiHero = mutableList.random()

        println(
            "$name ist an der reihe.\n" +
                    "Du kannst in dieser Runde $listOfAttack nutzen.\n" +
                    "Wähle eine Fähigkeit von 1 - 4."
        )

        val attackNumber = readln().toInt()

        if (attackNumber !in 1..4) {
            println(
                "Hey diese Fähigkeit übersteigt dein Level.\n" +
                        "Bitte wähle eine andere."
            )
            return
        }

        val usedAttack = listOfAttack[attackNumber - 1]

        if ((usedAttack == "heal" && healCooldown > 0) || (usedAttack == "kick" && kickCooldown > 0)) {
            println("$usedAttack hat noch Cooldown such dir schnell eine andere Fähigkeit aus.")
            return
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
    fun heal() {
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
     *  @param mutableList bekommt eine Liste von AntiHelden übergeben.
     */
    fun drawAttentionHit(list: List<AntiHero>) {
        println(
            "$name macht verrückte bewegungen und zieht damit die Aufmerksamkeit der Anti Helden auf sich.\n" +
                    "Dann schlägt er Raptusartig zu und jeder Anti Held erleidet 0.05 % Schaden."
        )
        for (antiHero in list) {
            val useDrawAttentionHit = antiHero.healthbar - antiHero.maxHealth * 0.05
            antiHero.healthbar = useDrawAttentionHit.toInt()
            println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
        }
    }

    /**
     *  Ein heftiger Schlag der den getroffenen Anti Held 15 % seiner gesamten Lebensenergie abzieht.
     *
     *  @param antiHero erhält einen random Anti Helden aus der Helden Liste.
     */
    fun punsh(antiHero: AntiHero) {
        println(
            "$name schleudert seine Faust und zieht ${antiHero.name} 5 % seiner maximalen Lebenspunkte ab.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat ${antiHero.maxHealth * 0.15} Schaden erlitten."
        )
        val usePunsh = antiHero.healthbar - antiHero.maxHealth * 0.15
        antiHero.healthbar = usePunsh.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }

    /**
     *  Ein Roundhouse Kick aller Chuck Norris der den AntiHeld 25 % seiner gesamten Lebensenergie abzieht.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     *
     *  @param antiHero erhält einen random Anti Helden aus der Helden Liste.
     */
    fun kick(antiHero: AntiHero) {
        println(
            "$name macht einen Roundhouse Kick. ${antiHero.name} erleidet 25 % Schaden.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat ${antiHero.maxHealth * 0.25} Schaden erlitten."
        )
        val useKick = antiHero.healthbar - antiHero.maxHealth * 0.25
        antiHero.healthbar = useKick.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }
}