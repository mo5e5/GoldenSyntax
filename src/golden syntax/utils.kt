/**
 *  Gibt eine Information aus wenn ein Character keine Lebensenergie mehr hat.
 *
 *  @param character bekommt einen beliebigen Character übergeben.
 */
fun charakterStatusCheck(character: Character) {
    repeat(1) {
        if (character.healthbar <= 0) {
            println("${character.name} hat keine Lebensenergie mehr. Jeder weitere Treffer macht die Blutlache nur noch größer.")
            return
        }
    }
}

/**
 *  Überprüft ob Helden und Anti Helden Lebensenergie haben. Wenn Ja, werden diese wiedergeben, wenn Nein wird der
 *  Held oder Anti Held aus der jeweiligen Liste entfernt.
 *
 *  @param listGood wird eine Liste vom Typ Held übergeben.
 */
fun lifeAndDeath(listGood: MutableList<Hero>) {
    println("Helden und deren Lebensenergie der Guten Seite.")
    println()
    for (hero in listGood) {
        if (hero.healthbar >= 0) {
            println("${hero.name} hat ${hero.healthbar} Lebensenergie.")
        } else {
            listGood.remove(hero)
        }
    }
    println("""
        
    """.trimIndent())
    println("Anti Helden und deren Lebensenergie der Bösen Seite")
    println()
    for (antiHero in antiHeroList) {
        if (antiHero.healthbar >= 0) {
            println("${antiHero.name} ${antiHero.healthbar} Lebensenergie.")
        } else {
            antiHeroList.remove(antiHero)
        }
    }
    println("""
        
    """.trimIndent())
}