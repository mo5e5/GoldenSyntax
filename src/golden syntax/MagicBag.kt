open class MagicBag {

    /**
     *  Ein mächtiger Trank der seinem Benutzer 20 % seiner gesamten Lebensenergie zurückgibt.
     */
    fun heallItem(hero: Hero) {
        val useHealItem = hero.maxHealth + hero.maxHealth * 0.2
        hero.maxHealth = useHealItem.toInt()
        println("${hero.name} heilt sich um ${hero.maxHealth * 0.2} Lebensenergie.")
    }

    /**
     *  Ein mächtiges Schutzpulver was jedem Gruppen Mitglied 10 % seiner gesamten Lebensenergie zurückgibt.
     *  Leider hält es nur eine Runde.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    fun healItemTeam(list: List<Hero>) {
        println("Alle Helden erhalten eine 10 % Heilung.")
        for (hero in list) {
            val useHealItemTeam = hero.healthbar + hero.maxHealth * 0.1
            hero.healthbar = useHealItemTeam.toInt()
            println("${hero.name} heilt sich um ${hero.maxHealth * 0.1} Lebensenergie.")
        }
    }

    /**
     *  Ein mächtiger Trank der seinem Benutzer dauerhaft 20 % mehr Schaden gibt.
     *
     *  @param hero erhält einen random Helden aus der heroList.
     */
    fun buffItem(hero: Hero) {
        hero.damageMultiplier += 0.2
        println("${hero.name} macht nun 20 % mehr Schaden.")
    }
}
