val antiHeroList: MutableList<AntiHero> = mutableListOf()
fun main() {
    var roundCount = 1

    val elegaius = Boss("Elegaius", 8750)

    antiHeroList.add(elegaius)


    val magicBag = MagicBag()

    val artak = DamageHero("Artak", 1750)

    val kyoku = MagicHero("Kyoku", 1500)

    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)


    while (heroList.any { it.healthbar > 0 } && antiHeroList.any { it.healthbar > 0 }) {
        for (hero in heroList) {
            println("-------")
            println("Runde $roundCount")
            println("-------")
            if (hero.healthbar <= 0) {
                println("${hero.name} hat keine Lebenspunkte mehr. Er ist aus dem Spiel.")
                continue
            }
            val heroWhoUsedMagicBag = hero.useMagicBag(heroList, magicBag)
            println("-------")
            if (heroWhoUsedMagicBag != vergumkaar.name) {
                vergumkaar.tankHeroAttack(antiHeroList)
                println("-------")
                if (antiHeroList.all { it.healthbar <= 0 }) {
                    println("Das Gute hat gesiegt.")
                    break
                }
            }
            if (heroWhoUsedMagicBag != artak.name) {
                artak.damageHeroAttack(antiHeroList)
                println("-------")
                if (antiHeroList.all { it.healthbar <= 0 }) {
                    println("Das Gute hat gesiegt.")
                    break
                }
            }
            if (heroWhoUsedMagicBag != kyoku.name) {
                kyoku.magicHeroAttack(antiHeroList, heroList)
                println("-------")
                if (antiHeroList.all { it.healthbar <= 0 }) {
                    println("Das Gute hat gesiegt.")
                    break
                }
            }
            for (antiHero in antiHeroList) {
                if (antiHero.healthbar <= 0) {
                    println("${antiHero.name} hat keine Lebenspunkte mehr. Er ist aus dem Spiel.")
                    continue
                }
                println("-------")
                elegaius.bossAttack(heroList)
                println("-------")
                if (heroList.all { it.healthbar <= 0 }) {
                    println("Das Böse war Siegreich.")
                    break
                }
            }
            roundCount++
        }
        antiHeroList.clear()
    }
}
