import Hero

class TankHero(name: String, healthbar: Int) : Hero(name, healthbar) {

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
     *  Zieht die Aufmerksamkeit aller Anti Helden auf sich und schlägt dan zu.
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
    fun punch(antiHero: AntiHero) {
        println(
            "$name schleudert seine Faust und zieht ${antiHero.name} 5 % seiner maximalen Lebenspunkte ab.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat ${antiHero.maxHealth * 0.05} Schaden erlitten."
        )
        val usePunsh = antiHero.healthbar - antiHero.maxHealth * 0.05
        antiHero.healthbar = usePunsh.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }

    /**
     *  Ein Roundhouse Kick aller Chuck Norris der den AntiHeld 25 % seiner gesamten Lebensenergie abzieht.
     */
    fun kick() {

    }
}