class MagicHero(name: String, healthbar: Int) : Hero(name, healthbar) {


    /**
     *  Es hagelt Blitze vom Himmel die alle AntiHelden treffen und jeweils 5 % der gesamten Lebensenergie
     *  an Schaden verursachen.
     */
    fun lightningStrike() {

    }

    /**
     *  Die Erde erhebt sich und fügt dem AntiHeld der auf ihr steht, 10 % der gesamten Lebensenergie an schaden zu.
     */
    fun earthquake(antiHero: AntiHero) {
        println(
            "$name lässt die Erde erbeben und ${antiHero.name} erleidet 10 % Schaden.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar}.\n" +
                    "Er hat ${antiHero.maxHealth * 0.15} Schaden erlitten."
        )
        val useerthquake = antiHero.healthbar - antiHero.maxHealth * 0.1
        antiHero.healthbar = useerthquake.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }

    /**
     *  Ein Schutzzauber der auf jeden Helden wirkt und um 15 % der maximalen Lebenspunkte heilt.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    fun regenerationBuff(list: List<Hero>) {
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
    fun mortality(antiHero: AntiHero) {
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