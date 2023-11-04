import Hero

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
    fun earthquake() {

    }

    /**
     *  Ein Schutzzauber der auf jeden Helden wirkt und 15 % des eingehen Schadens blockiert.
     *  Der Zauber hält 3 Runden.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    fun blockDamageBuff(list: List<Hero>) {

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