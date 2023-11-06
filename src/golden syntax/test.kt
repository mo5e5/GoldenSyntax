val antiHeroList: MutableList<AntiHero> = mutableListOf()
fun main() {
    val elegaius = Boss("Elegaius", 8750)
    antiHeroList.add(elegaius)

    val hero = Hero("",0)
    val magicBag = MagicBag()

    val artak = DamageHero("Artak", 1750)

    val kyoku = MagicHero("Kyoku", 1500)

    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)

/*
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
    hero.useMagicBag(heroList,magicBag)

    private  var hasUseMagicBag = false
    if (hasUseMagicBag) {
            println("$name hat den Magic Bag benutzt und kann deswegen keinen Zug in dieser Runde mehr machen.")
            return
        }
    hasUseMagicBag = true
*/

    hero.useMagicBag(heroList,antiHeroList,magicBag)
    artak.damageHeroAttack(antiHeroList)
    hero.useMagicBag(heroList,antiHeroList,magicBag)
    artak.damageHeroAttack(antiHeroList)





    antiHeroList.clear()
}
