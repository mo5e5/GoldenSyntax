/**
 *  Gibt eine Information aus, wenn ein Character keine Lebensenergie mehr hat.
 *
 *  @param character bekommt einen beliebigen Character übergeben.
 */
fun charakterStatusCheck(character: Character) {
    if (character.healthbar <= 0) {
        println("${BLACK}${character.name} hat keine Lebensenergie mehr. Jeder weitere Treffer macht die Blutlache nur noch größer.${RESET}")
        return
    }
}

/**
 *  Überprüft ob hero und antiHero Lebensenergie haben. Wenn Ja, werden diese wiedergeben, wenn Nein wird der
 *  hero oder antiHero nicht mehr ausgegeben.
 *
 *  @param listGood wird eine Liste vom Typ hero übergeben.
 */
fun lifeAndDeath(listGood: MutableList<Hero>) {
    println("${BOLD}Helden und deren Lebensenergie.${RESET}")
    println()
    listGood.removeIf { it.healthbar <= 0 }
    for (hero in listGood) {
        if (hero.healthbar >= 0) {
            println("${BACKGROUNDGREEN}${BLACK}${hero.name} hat ${hero.healthbar} Lebensenergie.${RESET}")
        }
    }
    println(
        """
        
    """.trimIndent()
    )
    println("${BOLD}Anti Helden und deren Lebensenergie.${RESET}")
    println()
    ANTIHEROLIST.removeIf { it.healthbar <= 0 }
    for (antiHero in ANTIHEROLIST) {
        if (antiHero.healthbar >= 0) {
            println("${BACKGROUNDGREEN}${BLACK}${antiHero.name} ${antiHero.healthbar} Lebensenergie.${RESET}")
        }
    }
    println(
        """
        
    """.trimIndent()
    )
}

val BLACK = "\u001B[30m"
val RED = "\u001B[31m"
val GREEN = "\u001B[32m"
val MAGENTA = "\u001B[35m"
val WHITE = "\u001B[37m"
val BOLD = "\u001B[1m"
val BACKGROUNDWHITE = "\u001B[47m"
val BACKGROUNBLACK = "\u001B[40m"
val BACKGROUNDGREEN ="\u001B[42m"
val RESET = "\u001B[0m"