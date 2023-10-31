class BossMinion(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    /**
     *  Zieht die Aufmerksamkeit aller Helden für eine Runde auf den BossMinion.
     */
    fun drawAttention() {
        println(
            "${UNDERTAKER.name} zieht die Aufmerksamkeit aller Helden auf sich.\n" +
                    "Die Helden können Ihn nicht mehr aus den Augen lassen und greifen\n" +
                    "für die nächste Runde nur Ihn an."
        )
    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner zerstörung drei Runden Cooldown.
     */
    fun shield() {
    }

    /**
     *  Ein kraftvoller Schlag der einem Helden 5 % seiner gesamten Lebensenergie abzieht.
     */
    fun punsh() {

    }

    /**
     *  Eine Special Attacke die erst nach 5 Runden zur verfügung steht
     *  und nach benutzen neu aufgeladen werden muss.
     *  Sie fügt allen Helden 10 % ihrer gesamten Lebensenergie an Schaden zu.
     */
    fun hailBlow() {

    }
}