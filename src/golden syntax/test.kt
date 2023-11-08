val antiHeroList: MutableList<AntiHero> = mutableListOf()
fun main() {

    var roundCount = 1

    val elegaius = Boss("Elegaius", 8750)
    val siphi = BossMinion("Siphi", 5000)

    antiHeroList.add(elegaius)

    val magicBag = MagicBag()

    val artak = DamageHero("Artak", 1750)
    val kyoku = MagicHero("Kyoku", 1500)
    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)

    while (heroList.any { it.healthbar > 0 } && antiHeroList.any { it.healthbar > 0 }) {
        println()
        println("-------")
        println("Runde $roundCount")
        println("-------")
        Thread.sleep(1000)
        println()
        /*println("Helden und Lebenspunkte der Guten Seite.")
        println()
        for (hero in heroList) {
            if (hero.healthbar <= 0) {
                heroList.remove(hero)
            }
            println("${hero.name} hat ${hero.healthbar} Lebensenergie.")
        }
        println("-------")
        println("Anti Helden und Lebenspunkte der Bösen Seite")
        println()
        for (antiHero in antiHeroList) {
            if (antiHero.healthbar <= 0) {
                antiHeroList.remove(antiHero)
            }
            println("${antiHero.name} ${antiHero.healthbar} Lebensenergie.")
        }

         */
        lifeAndDeath(heroList,antiHeroList)
        println("Das helle Seite ist am Zug.")
        Thread.sleep(2000)
        println("-------")
        val heroWhoUsedMagicBag = vergumkaar.useMagicBag(heroList, magicBag)
        println("-------")
        println()
        println("-------")
        if (heroWhoUsedMagicBag != vergumkaar.name && vergumkaar.healthbar > 0) {
            vergumkaar.tankHeroAttack(antiHeroList)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (antiHeroList.all { it.healthbar <= 0 }) {
                println("Das Gute hat gesiegt.")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        if (heroWhoUsedMagicBag != artak.name && artak.healthbar > 0) {
            artak.damageHeroAttack(antiHeroList)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (antiHeroList.all { it.healthbar <= 0 }) {
                println("Das Gute hat gesiegt.")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        if (heroWhoUsedMagicBag != kyoku.name && kyoku.healthbar > 0) {
            kyoku.magicHeroAttack(antiHeroList, heroList)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (antiHeroList.all { it.healthbar <= 0 }) {
                println("Das Gute hat gesiegt.")
                break
            }
            println("-------")
            Thread.sleep(3500)
        }
        println()
        println("Das Böse ist am Zug.")
        println("-------")
        if (elegaius.healthbar > 0) {
            val result = elegaius.bossAttack(heroList)
            charakterStatusCheck(vergumkaar)
            charakterStatusCheck(artak)
            charakterStatusCheck(kyoku)
            if (result == 1) {
                antiHeroList.add(siphi)
                println(
                    "${elegaius.name} beschwört mit all seiner macht ${siphi.name}\n" +
                            "um ihm im Kampf gegen die Helden zu helfen."
                )
            }
            if (heroList.all { it.healthbar <= 0 }) {
                println("Das Böse war Siegreich.")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        if (antiHeroList.size > 1 && siphi.healthbar > 0) {
            siphi.bossMinionAttack(heroList)
            charakterStatusCheck(vergumkaar)
            charakterStatusCheck(artak)
            charakterStatusCheck(kyoku)
            if (heroList.all { it.healthbar <= 0 }) {
                println("Das Böse war Siegreich.")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        println()
        println("-------")
        println("Diese Runde ist vorbei.")
        println("-------")
        Thread.sleep(1000)
        roundCount++
    }
}
