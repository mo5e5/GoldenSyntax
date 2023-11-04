val antiHeroList: MutableList<AntiHero> = mutableListOf()
fun main() {
    val elegaius = Boss("Elegaius", 8750)
    antiHeroList.add(elegaius)

    val artak = DamageHero("Artak", 1750)

    val kyoku = MagicHero("Kyoku", 1500)

    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)


    println("-------")
    vergumkaar.tankHeroAttack(antiHeroList)
    println()
    artak.damageHeroAttack(antiHeroList)
    println("-------")
    kyoku.magicHeroAttack(antiHeroList,heroList)
    println("-------")
    elegaius.bossAttack(heroList)
    println("-------")





    antiHeroList.clear()
}
