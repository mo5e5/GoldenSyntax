fun charakterStatusCheck(character: Character) {
    repeat(1) {
        if (character.healthbar <= 0) {
            println("${character.name} hat keine Lebenspunkte mehr. Jeder weitere Treffer macht die Blutlache nur noch größer.")
            return
        }
    }
}

fun lifeAndDeath(listGood: MutableList<Hero>, listBad: MutableList<AntiHero>) {
    println("Helden und Lebenspunkte der Guten Seite.")
    println()
    for (hero in listGood) {
        if (hero.healthbar <= 0) {
            listGood.remove(hero)
        }
        println("${hero.name} hat ${hero.healthbar} Lebensenergie.")
    }
    println("""
        
    """.trimIndent())
    println("Anti Helden und Lebenspunkte der Bösen Seite")
    println()
    for (antiHero in antiHeroList) {
        if (antiHero.healthbar <= 0) {
            antiHeroList.remove(antiHero)
        }
        println("${antiHero.name} ${antiHero.healthbar} Lebensenergie.")
    }
    println("""
        
    """.trimIndent())
}