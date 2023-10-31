class BossMinion(name: String, healthbar: Int, val attention: Boolean = false) : AntiHero(name, healthbar) {

    val bossMinionActionList =
        mutableListOf(drawAttention(), shield(), punsh(hero = Hero("", 0)), hailBlow(list = heroList))

    /**
     *  Zieht die Aufmerksamkeit aller Helden für eine Runde auf den BossMinion.
     */
    private fun drawAttention(attention: Boolean = true) {
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
    private fun shield() {
        val useShield = siphi.healthbar + siphi.maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Ein kraftvoller Schlag der einem Helden 5 % seiner gesamten Lebensenergie abzieht.
     */
    private fun punsh(hero: Hero) {
        val usePunsh = hero.healthbar - hero.maxHealth * 0.05
        hero.healthbar = usePunsh.toInt()
    }

    /**
     *  Eine Special Attacke die erst nach 5 Runden zur verfügung steht
     *  und nach benutzen neu aufgeladen werden muss.
     *  Sie fügt allen Helden 10 % ihrer gesamten Lebensenergie an Schaden zu.
     */
    private fun hailBlow(list: List<Hero>) {
        for (hero in heroList) {
            val useHailBlow = hero.healthbar - hero.healthbar * 0.1
            hero.healthbar = useHailBlow.toInt()
        }
    }
}