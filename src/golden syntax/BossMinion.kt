class BossMinion(name: String, healthbar: Int, val attention: Boolean = false) : AntiHero(name, healthbar) {

    val bossMinionActionList =
        mutableListOf(drawAttention(), shield(), punsh(hero = Hero("", 0)), hailBlow(list = heroList))

    /**
     *  Zieht die Aufmerksamkeit aller Helden für eine Runde auf den BossMinion.
     */
    fun drawAttention(attention: Boolean = true) {
        println(
            "${siphi.name} zieht die Aufmerksamkeit aller Helden auf sich.\n" +
                    "Die Helden können Ihn nicht mehr aus den Augen lassen und greifen\n" +
                    "für die nächste Runde nur Ihn an."
        )
    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner nutzung 3 Runden Cooldown.
     */
    fun shield() {
        println("$name errichtet ein Schild und hat jetzt deutlich mehr auf den Rippen.")
        val useShield = siphi.healthbar + siphi.maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Ein kraftvoller Schlag der einem Helden 5 % seiner gesamten Lebensenergie abzieht.
     */
    fun punsh(hero: Hero) {
        println("$name haut kräftig zu und zieht ${hero.name} 5 % seiner maximalen Lebenspunkte ab.")
        val usePunsh = hero.healthbar - hero.maxHealth * 0.05
        hero.healthbar = usePunsh.toInt()
    }

    /**
     *  Eine Special Attacke die erst nach 5 Runden zur verfügung steht
     *  und nach benutzen neu aufgeladen werden muss.
     *  Sie fügt allen Helden 10 % ihrer gesamten Lebensenergie an Schaden zu.
     */
    fun hailBlow(list: List<Hero>) {
        println(
            "$name lässt es vom Himmel Hageln und fügt jedem Helden 10 % seiner\n" +
                    "gesamten Lebenspunkte als Schaden zu. "
        )
        for (hero in heroList) {
            val useHailBlow = hero.healthbar - hero.healthbar * 0.1
            hero.healthbar = useHailBlow.toInt()
        }
    }
}