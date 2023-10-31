class BossMinion(name: String, healthbar: Int,val attetion: Boolean = false) : AntiHero(name, healthbar) {

    /**
     *  Zieht die Aufmerksamkeit aller Helden für eine Runde auf den BossMinion.
     */
    fun drawAttention(attetion: Boolean = true) {
        println(
            "${undertaker.name} zieht die Aufmerksamkeit aller Helden auf sich.\n" +
                    "Die Helden können Ihn nicht mehr aus den Augen lassen und greifen\n" +
                    "für die nächste Runde nur Ihn an."
        )
    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner nutzung drei Runden Cooldown.
     */
    fun shield() {
        val useShield = undertaker.healthbar + maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Ein kraftvoller Schlag der einem Helden 5 % seiner gesamten Lebensenergie abzieht.
     */
    fun punsh() {
        val

    }

    /**
     *  Eine Special Attacke die erst nach 5 Runden zur verfügung steht
     *  und nach benutzen neu aufgeladen werden muss.
     *  Sie fügt allen Helden 10 % ihrer gesamten Lebensenergie an Schaden zu.
     */
    fun hailBlow() {

    }
}