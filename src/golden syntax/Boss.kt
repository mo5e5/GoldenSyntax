import kotlin.random.Random

class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    val bossMinionActionList: MutableList<BossMinion> = mutableListOf()
    var count = 0

    /**
     *  ...
     */
    fun bossAttack(mutableList: MutableList<Hero>) {
        var attackNumber = Random.nextInt(0, 7)
        var radomHero = mutableList.random()
        attackNumber = if (count == 0) {
            Random.nextInt(0, 7)
        } else {
            Random.nextInt(1, 7)
        }
        when (attackNumber) {
            0 -> {
                bossMinion(bossMinionActionList[0])
                count++
            }

            1 -> {
                shield()
            }

            2 -> {
                lifeRegenaration()
            }

            3 -> {
                stomp(radomHero)
            }

            4 -> {
                crush(radomHero)
            }

            5 -> {
                curse(mutableList)
            }

            6 -> {
                digest(mutableList)
            }
        }

    }

    /**
     *  Ruft den BossMinion zur Unterstützung hinzu.
     */
    fun bossMinion(bossMinion: BossMinion) {
        if (bossMinionActionList.contains(bossMinion)) {
            println(
                "$name beschwört mit all seiner macht ${bossMinion.name}\n" +
                        "um ihm im Kampf gegen die Helden zu helfen."
            )

        }
    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner zerstörung 3 Runden Cooldown.
     */
    fun shield() {
        println("$name errichtet ein Schild und hat jetzt deutlich mehr auf den Rippen.")
        val useShield = healthbar + maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Regeneriert 15 % seiner gesamten Lebensenergie.
     */
    fun lifeRegenaration() {
        println("$name frisst ein Rind und erhöht damit seine Lebenspunkte.")
        val useLifeRegenaration = healthbar + maxHealth * 0.15
        healthbar = useLifeRegenaration.toInt()
    }

    /**
     *  Stampft auf einem Helden herum was dem Helden 10 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     */
    fun stomp(hero: Hero) {
        println("$name stampft auf ${hero.name} herum und zieht ihm 10 % seiner Lebensenergie ab.")
        val useStomp = hero.healthbar - hero.maxHealth * 0.1
        hero.healthbar = useStomp.toInt()
    }

    /**
     *  Zerquetscht einen Helden was diesem 15 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     */
    fun crush(hero: Hero) {
        println("$name greift sich ${hero.name} und zerquetscht ihn es tropfen 15 % Lebensenergie auf den kalten Boden.")
        val useCrush = hero.healthbar - hero.maxHealth * 0.15
        hero.healthbar = useCrush.toInt()
    }

    /**
     *  Verflucht alle Helden die daraufhin für 3 Runden nur 80 % ihres normalen Schadens an ihm machen.
     */
    fun curse(list: List<Hero>) {
        println("$name spricht einen Fluch aus und alle Helden machen weniger Schaden.")
        for (hero in list) {
            val useCurse = hero.maxHealth - 0.2
            hero.healthbar = useCurse.toInt()
        }
    }

    /**
     *  Bespuckt alle Helden mit Magensäure. Die Helden erleiden für 2 Runden 5 % ihrer
     *  gesamten Lebensenergie an Schaden.
     */
    fun digest(list: List<Hero>) {
        for (hero in list) {
            println("$name fängt an die Helden zu bespucken. Jeder Held bekommt 5 % Schaden über Zwei Runden.")
            val useDigest = hero.healthbar - hero.healthbar * 0.05
            hero.healthbar = useDigest.toInt()
        }
    }
}