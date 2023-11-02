class BossMinion(name: String, healthbar: Int, val attention: Boolean = false) : AntiHero(name, healthbar) {

    /**
     *  Zieht die Aufmerksamkeit aller Helden für eine Runde auf den BossMinion.
     */
    fun drawAttention(attention: Boolean = true) {
        println(
            "$name zieht die Aufmerksamkeit aller Helden auf sich.\n" +
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
        val useShield = healthbar + maxHealth * 0.5
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
     *  Ein Hagel Regen der allen Helden 10 % ihrer gesamten Lebensenergie an Schaden zu fügt.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 4 Runden Cooldown.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    fun hailBlow(list: List<Hero>) {
        println(
            "$name lässt es vom Himmel Hageln und fügt jedem Helden 10 % seiner\n" +
                    "gesamten Lebenspunkte als Schaden zu. "
        )
        for (hero in list) {
            val useHailBlow = hero.healthbar - hero.healthbar * 0.1
            hero.healthbar = useHailBlow.toInt()
        }
    }
}