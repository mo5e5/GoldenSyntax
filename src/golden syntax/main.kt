val ANTIHEROLIST: MutableList<AntiHero> = mutableListOf()
fun main() {

    var roundCount = 1

    val elegaius = Boss("Elegaius", 8750)
    val siphi = BossMinion("Siphi", 5000)

    ANTIHEROLIST.add(elegaius)

    val magicBag = MagicBag()

    val artak = DamageHero("Artak", 1750)
    val kyoku = MagicHero("Kyoku", 1500)
    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)

    while (heroList.any { it.healthbar > 0 } && ANTIHEROLIST.any { it.healthbar > 0 }) {
        println()
        println("-------")
        println("Runde $roundCount")
        println("-------")
        Thread.sleep(1000)
        println()
        lifeAndDeath(heroList)
        println("Das helle Seite ist am Zug.")
        Thread.sleep(2000)
        println("-------")
        val heroWhoUsedMagicBag = vergumkaar.useMagicBag(heroList, magicBag)
        println("-------")
        println()
        println("-------")
        if (heroWhoUsedMagicBag != vergumkaar.name && vergumkaar.healthbar > 0) {
            vergumkaar.tankHeroAttack(ANTIHEROLIST)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (ANTIHEROLIST.all { it.healthbar <= 0 }) {
                println("-------")
                println("-------")
                println("-------")
                println("Das Gute hat gesiegt.")
                println("-------")
                println("-------")
                println("-------")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        if (heroWhoUsedMagicBag != artak.name && artak.healthbar > 0) {
            artak.damageHeroAttack(ANTIHEROLIST)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (ANTIHEROLIST.all { it.healthbar <= 0 }) {
                println("-------")
                println("-------")
                println("-------")
                println("Das Gute hat gesiegt.")
                println("-------")
                println("-------")
                println("-------")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        if (heroWhoUsedMagicBag != kyoku.name && kyoku.healthbar > 0) {
            kyoku.magicHeroAttack(ANTIHEROLIST, heroList)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (ANTIHEROLIST.all { it.healthbar <= 0 }) {
                println("-------")
                println("-------")
                println("-------")
                println("Das Gute hat gesiegt.")
                println("-------")
                println("-------")
                println("-------")
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
                ANTIHEROLIST.add(siphi)
                println(
                    "${elegaius.name} beschwört mit all seiner macht ${siphi.name}\n" +
                            "um ihm im Kampf gegen die Helden zu helfen."
                )
            }
            if (heroList.all { it.healthbar <= 0 }) {
                println("-------")
                println("-------")
                println("-------")
                println("Das Böse war Siegreich.")
                println("-------")
                println("-------")
                println("-------")
                break
            }
            Thread.sleep(3500)
            println("-------")
        }
        if (ANTIHEROLIST.contains(siphi) && siphi.healthbar > 0) {
            siphi.bossMinionAttack(heroList)
            charakterStatusCheck(vergumkaar)
            charakterStatusCheck(artak)
            charakterStatusCheck(kyoku)
            if (heroList.all { it.healthbar <= 0 }) {
                println("-------")
                println("-------")
                println("-------")
                println("Das Böse war Siegreich.")
                println("-------")
                println("-------")
                println("-------")
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
