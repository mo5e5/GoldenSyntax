import kotlin.random.Random

class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    val bossMinionActionList: MutableList<BossMinion> = mutableListOf()
    var count = 0
    var digestCount = 0

    /**
     *  Führt die Fähigkeiten vom Boss random selber aus.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun bossAttack(mutableList: MutableList<Hero>) {
        var attackNumber = Random.nextInt(0, 7)
        val radomHero = mutableList.random()
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
     *
     *  @param bossMinion hier wird der Initialisierte Minion vom Boss übergeben.
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
        println(
            "$name fängt an beulen und Pusteln auf seiner Haut zu bilden.\n" +
                    "Seine Haut ist nun deutlich dicker und schwerer zu durchdringen."
        )
        val useShield = healthbar + maxHealth * 0.5
        healthbar = useShield.toInt()
    }

    /**
     *  Regeneriert 15 % seiner gesamten Lebensenergie.
     */
    fun lifeRegenaration() {
        println(
            "$name frisst ein paar Rinder.\n" +
                    "Danach hat $name deutlich mehr auf den Rippen."
        )
        val useLifeRegenaration = healthbar + maxHealth * 0.15
        healthbar = useLifeRegenaration.toInt()
    }

    /**
     *  Stampft auf einem Helden herum was dem Helden 10 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     *
     *  @param hero erhält einen random Helden aus der Helden Liste.
     */
    fun stomp(hero: Hero) {
        println(
            "$name stampft auf ${hero.name} herum.\n" +
                    "${hero.name} sieht danach etwas zerknittert aus."
        )
        val useStomp = hero.healthbar - hero.maxHealth * 0.1
        hero.healthbar = useStomp.toInt()
    }

    /**
     *  Zerquetscht einen Helden was diesem 15 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     *
     *  @param hero erhält einen random Helden aus der Helden Liste.
     */
    fun crush(hero: Hero) {
        println(
            "$name greift sich ${hero.name} und zerquetscht ihn.\n" +
                    "Darauf hin tropft langsam Blut auf den kalten Boden."
        )
        val useCrush = hero.healthbar - hero.maxHealth * 0.15
        hero.healthbar = useCrush.toInt()
    }

    /**
     *  Verflucht alle Helden die daraufhin für 3 Runden nur 80 % ihres normalen Schadens an ihm machen.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun curse(mutableList: MutableList<Hero>) {
        println(
            "$name tanzt wie wild um seine Feuerstelle und murmelt dabei vor sich hin.\n" +
                    "Nachdem er damit aufhört fühlen die Helden sich komisch.\n" +
                    "$name hat einen Fluch über die Helden ausgesprochen.\n" +
                    "Sie fühlen sich schwach und machen weniger Schaden."
        )
        for (hero in mutableList) {
            val useCurse = hero.maxHealth - 0.2
            hero.healthbar = useCurse.toInt()
        }
    }

    /**
     *  Bespuckt alle Helden mit Magensäure. Die Helden erleiden für 2 Runden 5 % ihrer
     *  gesamten Lebensenergie an Schaden.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun digest(mutableList: MutableList<Hero>) {
        for (hero in mutableList) {
            println(
                "$name fängt an die Helden zu bespucken.\n" +
                        "Die Helden sind danach voll mit Spucke.\n" +
                        "Bis die Spucke getrocknet ist erhalten Sie 5 % Schaden."
            )
            val useDigest = hero.healthbar - hero.healthbar * 0.05
            hero.healthbar = useDigest.toInt()
        }
    }
}