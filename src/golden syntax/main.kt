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
        println("${MAGENTA}${BOLD}Runde $roundCount${RESET}")
        println("-------")
        Thread.sleep(1000)
        lifeAndDeath(heroList)
        Thread.sleep(2000)
        println("-------")
        println("${BACKGROUNDWHITE}${BLACK}Das helle Seite der Macht ist am Zug.${RESET}")
        val heroWhoUsedMagicBag = vergumkaar.useMagicBag(heroList, magicBag)
        println("-------")
        if (heroWhoUsedMagicBag != vergumkaar.name && vergumkaar.healthbar > 0) {
            vergumkaar.tankHeroAttack(ANTIHEROLIST)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (ANTIHEROLIST.all { it.healthbar <= 0 }) {
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BACKGROUNBLACK}${GREEN}${BOLD}Das Gute hat gesiegt.${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                break
            }
            Thread.sleep(3000)
            println("-------")
        }
        if (heroWhoUsedMagicBag != artak.name && artak.healthbar > 0) {
            artak.damageHeroAttack(ANTIHEROLIST)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (ANTIHEROLIST.all { it.healthbar <= 0 }) {
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BACKGROUNBLACK}${GREEN}${BOLD}Das Gute hat gesiegt.${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                break
            }
            Thread.sleep(3000)
            println("-------")
        }
        if (heroWhoUsedMagicBag != kyoku.name && kyoku.healthbar > 0) {
            kyoku.magicHeroAttack(ANTIHEROLIST, heroList)
            charakterStatusCheck(elegaius)
            charakterStatusCheck(siphi)
            if (ANTIHEROLIST.all { it.healthbar <= 0 }) {
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BACKGROUNBLACK}${GREEN}${BOLD}Das Gute hat gesiegt.${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                println("${BOLD}-------${RESET}")
                break
            }
            println("-------")
            Thread.sleep(3000)
        }
        println()
        println("${BACKGROUNBLACK}${WHITE}Die dunkle Seite der Macht ist am Zug.${RESET}")
        println("-------")
        if (elegaius.healthbar > 0) {
            val result = elegaius.bossAttack(heroList)
            charakterStatusCheck(vergumkaar)
            charakterStatusCheck(artak)
            charakterStatusCheck(kyoku)
            if (result == 1) {
                ANTIHEROLIST.add(siphi)
                println(
                    "${BACKGROUNBLACK}${WHITE}${BOLD}${elegaius.name} beschwört mit all seiner macht ${siphi.name}.${RESET}"
                )
            }
            if (heroList.all { it.healthbar <= 0 }) {
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BACKGROUNBLACK}${RED}${BOLD}Das Böse war Siegreich.${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                break
            }
            Thread.sleep(3000)
            println("-------")
        }
        if (ANTIHEROLIST.contains(siphi) && siphi.healthbar > 0) {
            siphi.bossMinionAttack(heroList)
            charakterStatusCheck(vergumkaar)
            charakterStatusCheck(artak)
            charakterStatusCheck(kyoku)
            if (heroList.all { it.healthbar <= 0 }) {
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BACKGROUNBLACK}${RED}${BOLD}Das Böse war Siegreich.${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                println("${BLACK}${BOLD}-------${RESET}")
                break
            }
            Thread.sleep(3000)
            println("-------")
        }
        println()
        println("-------")
        println("${MAGENTA}${BOLD}Runde vorbei.${RESET}")
        println("-------")
        Thread.sleep(2000)
        roundCount++
    }
}
