import kotlin.random.Random

fun main() {
    val elegaius: Boss = Boss("Elegaius", 8750)

    val siphi: BossMinion = BossMinion("Siphi", 5000)

    val antiHeroList: MutableList<AntiHero> = mutableListOf(elegaius,siphi)


    val artak: DamageHero = DamageHero("Artak", 1750)

    val kyoku: MagicHero = MagicHero("Kyoku", 1500)

    val vergumkaar: TankHero = TankHero("Vergumkaar", 3750)

    val heroList: MutableList<Hero> = mutableListOf(artak, kyoku, vergumkaar)


    val attackNumber = Random.nextInt(0,7)
    println(attackNumber)


}