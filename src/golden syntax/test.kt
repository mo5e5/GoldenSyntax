fun main() {
    val elegaius = Boss("Elegaius", 8750)

    val siphi = BossMinion("Siphi", 5000)

    elegaius.bossMinionActionList.add(siphi)

    val antiHeroList: MutableList<AntiHero> = mutableListOf(elegaius, siphi)


    val artak = DamageHero("Artak", 1750)

    val kyoku = MagicHero("Kyoku", 1500)

    val vergumkaar = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)



    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)
    println("-------")
    siphi.bossMinionAttack(heroList)

}