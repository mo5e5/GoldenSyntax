open class MagicBag {

    /**
     *  Ein mächtiger Trank der seinem Benutzer 20 % seiner gesamten Lebenspunkte zurückgibt.
     */
    fun heallItem(hero: Hero) {
        val useHealItem = hero.maxHealth + hero.maxHealth * 0.2
        hero.maxHealth = useHealItem.toInt()
        println("${hero.name} hat nun ${hero.healthbar} Lebenspunkte.")
    }

    /**
     *  Ein mächtiges Schutzpulver was jedem Gruppen Mitglied 10 % seiner gesamten Lebenspunkte zurückgibt.
     *  Leider hält es nur eine Runde.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    fun healItemTeam(list: List<Hero>) {
        println("Alle Helden erhalten 10 % ihrer Lebenspunkte zurück.")
        for (hero in list) {
            val useHealItemTeam = hero.healthbar + hero.maxHealth * 0.1
            hero.healthbar = useHealItemTeam.toInt()
            println("${hero.name} hat nun ${hero.healthbar} Lebenspunkte.")
        }
    }

    /**
     *  Ein mächtiger Trank der seinem Benutzer dauerhaft 20 % mehr Schaden gibt.
     *
     *  @param hero erhält einen random Helden aus der heroList.
     */
    fun buffItem(hero: Hero) {
        val useBuffItem = hero.maxHealth + hero.maxHealth * 0.2
        hero.maxHealth = useBuffItem.toInt()
        println("${hero.name} macht nun 20 % mehr Schaden.")
    }

}
