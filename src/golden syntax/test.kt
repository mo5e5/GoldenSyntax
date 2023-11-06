val antiHeroList: MutableList<AntiHero> = mutableListOf()
fun main() {
    val antiHero = AntiHero("",0)
    val hero = Hero("",0)

    val elegaius = Boss("Elegaius", 8750)

    antiHeroList.add(elegaius)


    val magicBag = MagicBag()

    val artak = DamageHero("Artak", 1750)

    val kyoku = MagicHero("Kyoku", 1500)

    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)

    do {
        if (hero in heroList){
            hero.healthbar = 0
            heroList.remove(hero)
        }
        if (antiHero in antiHeroList) {
            antiHero.healthbar = 0
            antiHeroList.remove(antiHero)
        }

        hero.useMagicBag(heroList,magicBag)
        println("-------")
        vergumkaar.tankHeroAttack(antiHeroList)
        println()
        artak.damageHeroAttack(antiHeroList)
        println("-------")
        kyoku.magicHeroAttack(antiHeroList,heroList)
        println("-------")
        elegaius.bossAttack(heroList)
        println("-------")

    } while (heroList.isNotEmpty() || antiHeroList.isNotEmpty() )

    antiHeroList.clear()
}
