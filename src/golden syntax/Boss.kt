class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    val bossMinionActionList: MutableList<BossMinion> = mutableListOf()

    fun bossAttack() {

    }

    /**
     *  Ruft den BossMinion zur Unterstützung hinzu.
     */
    fun bossMinion(bossMinion: BossMinion) {
        if (!bossMinionActionList.contains(bossMinion)) {
            println(
                "$name beschwört mit all seiner macht ${bossMinion.name}\n" +
                        "um ihm im Kampf gegen die Helden zu helfen."
            )
            bossMinionActionList.add(bossMinion)
        }
    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner zerstörung 3 Runden Cooldown.
     */
    fun shield() {
        val useShield = healthbar + maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Regeneriert 15 % seiner gesamten Lebensenergie.
     */
    fun lifeRegenaration() {
        val useLifeRegenaration = healthbar + maxHealth * 0.15
        healthbar = useLifeRegenaration.toInt()
    }

    /**
     *  Stampft auf einem Helden herum was dem Helden 10 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     */
    fun stomp(hero: Hero) {
        val useStomp = hero.healthbar - hero.maxHealth * 0.1
        hero.healthbar = useStomp.toInt()
    }

    /**
     *  Zerquetscht einen Helden was diesem 15 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     */
    fun crush(hero: Hero) {
        val useCrush = hero.healthbar - hero.maxHealth * 0.15
        hero.healthbar = useCrush.toInt()
    }

    /**
     *  Verflucht alle Helden die daraufhin für 3 Runden nur 80 % ihres normalen Schadens an ihm machen.
     */
    fun curse(list: List<Hero>) { // ?!?!?!
        for (hero in list) {
            val useCurse = hero.healthbar - 0.2
            hero.healthbar = useCurse.toInt()
        }
    }

    /**
     *  Bespuckt alle Helden mit Magensäure. Die Helden erleiden für 2 Runden 5 % ihrer
     *  gesamten Lebensenergie an Schaden.
     */
    fun digest(list: List<Hero>) { // ?!?!?!
        for (hero in list) {
            val useDigest = hero.healthbar - hero.healthbar * 0.05
            hero.healthbar = useDigest.toInt()
        }
    }
}