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
        println("-------")
        println("Runde $roundCount")
        println("-------")
        val heroWhoUsedMagicBag = vergumkaar.useMagicBag(heroList, magicBag)
        println("-------")

        if (heroWhoUsedMagicBag != vergumkaar.name && vergumkaar.healthbar > 0) {
            vergumkaar.tankHeroAttack(antiHeroList)
            println("-------")
            if (antiHeroList.all { it.healthbar <= 0 }) {
                println("Das Gute hat gesiegt.")
                break
            }
        }
        if (heroWhoUsedMagicBag != artak.name && artak.healthbar > 0) {
            artak.damageHeroAttack(antiHeroList)

            println("-------")
            if (antiHeroList.all { it.healthbar <= 0 }) {
                println("Das Gute hat gesiegt.")
                break
            }
        }
        if (heroWhoUsedMagicBag != kyoku.name && kyoku.healthbar > 0) {
            kyoku.magicHeroAttack(antiHeroList, heroList)
            println("-------")
            if (antiHeroList.all { it.healthbar <= 0 }) {
                println("Das Gute hat gesiegt.")
                break
            }
        }
        if (elegaius.healthbar < 0) {
            println("${elegaius.name} hat keine Lebenspunkte mehr. Er ist aus dem Spiel.")
            continue
        }
        if (siphi.healthbar < 0) {
            println("${siphi.name} hat keine Lebenspunkte mehr. Er ist aus dem Spiel.")
            continue
        }
        if (elegaius.healthbar > 0) {
            println("-------")
            val result = elegaius.bossAttack(heroList)

            if (result == 1) {
                antiHeroList.add(siphi)
                println(
                    "${elegaius.name} beschwört mit all seiner macht ${siphi.name}\n" +
                            "um ihm im Kampf gegen die Helden zu helfen."
                )
            }
            println("-------")
            if (heroList.all { it.healthbar <= 0 }) {
                println("Das Böse war Siegreich.")
                break
            }
        }
        if (antiHeroList.size > 1 && siphi.healthbar > 0) {
            println("-------")
            siphi.bossMinionAttack(heroList)

            println("-------")
            if (heroList.all { it.healthbar <= 0 }) {
                println("Das Böse war Siegreich.")
                break
            }

        }
        roundCount++
    }
}
