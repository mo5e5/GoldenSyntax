import kotlin.random.Random

class BossMinion(name: String, healthbar: Int, val attention: Boolean = false) : AntiHero(name, healthbar) {

    var shieldCooldown = 0
    var hailBlowCooldown = 0

    /**
     *  Führt die Fähigkeiten vom BossMinion random selber aus.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun bossMinionAttack(mutableList: MutableList<Hero>) {
        var attackNumber = Random.nextInt(0, 4)
        val radomHero = mutableList.random()
        if (shieldCooldown >= 0) {
            shieldCooldown--
        }
        if (hailBlowCooldown >= 0) {
            hailBlowCooldown--
        }
        if (shieldCooldown >= 0 && hailBlowCooldown >= 0) {
            val listOfAttack = listOf(0, 3)
            attackNumber = listOfAttack.random()
        } else if (shieldCooldown >= 0) {
            val listOfAttack = listOf(0, 2, 3)
            attackNumber = listOfAttack.random()
        } else if (hailBlowCooldown >= 0) {
            val listOfAttack = listOf(0, 1, 2)
            attackNumber = listOfAttack.random()
        }
        when (attackNumber) {
            0 -> {
                drawAttention()
            }

            1 -> {
                shield()
                shieldCooldown = 2
            }

            2 -> {
                punsh(radomHero)
            }

            3 -> {
                hailBlow(mutableList)
                hailBlowCooldown = 4
            }
        }
    }

    /**
     *  Zieht die Aufmerksamkeit aller Helden für eine Runde auf den BossMinion.
     */
    fun drawAttention(attention: Boolean = true) {
        println(
            "$name zieht die Aufmerksamkeit aller Helden auf sich.\n" +
                    "Die Helden können Ihn nicht mehr aus den Augen lassen und greifen\n" +
                    "für die nächste Runde nur Ihn an."
        )
    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 2 Runden Cooldown.
     */
    fun shield() {
        println("$name errichtet ein Schild und hat jetzt deutlich mehr auf den Rippen.")
        val useShield = healthbar + maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Ein kraftvoller Schlag der einem Helden 5 % seiner gesamten Lebensenergie abzieht.
     *
     *  @param hero erhält einen random Helden aus der Helden Liste.
     */
    fun punsh(hero: Hero) {
        println("$name haut kräftig zu und zieht ${hero.name} 5 % seiner maximalen Lebenspunkte ab.")
        val usePunsh = hero.healthbar - hero.maxHealth * 0.05
        hero.healthbar = usePunsh.toInt()
    }

    /**
     *  Ein Hagel Regen der allen Helden 10 % ihrer gesamten Lebensenergie an Schaden zu fügt.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 4 Runden Cooldown.
     *
     *  @param list bekommt eine Liste von Helden übergeben.
     */
    fun hailBlow(list: List<Hero>) {
        println(
            "$name lässt es vom Himmel Hageln und fügt jedem Helden 10 % seiner\n" +
                    "gesamten Lebenspunkte als Schaden zu. "
        )
        for (hero in list) {
            val useHailBlow = hero.healthbar - hero.healthbar * 0.1
            hero.healthbar = useHailBlow.toInt()
        }
    }
}