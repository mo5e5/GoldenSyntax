class BossMinion(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    fun drawAttention() {
        println(
            "${UNDERTAKER.name} zieht die Aufmerksamkeit aller Helden auf sich.\n" +
                    "Die Helden können Ihn nicht mehr aus den Augen lassen und greifen\n" +
                    "für die nächste Runde nur Ihn an."
        )
    }

    fun shield() {

    }

    fun punsh() {

    }

    fun hailBlow() {

    }
}