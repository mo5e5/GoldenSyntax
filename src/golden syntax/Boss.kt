import kotlin.random.Random

class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    val bossMinionActionList: MutableList<BossMinion> = mutableListOf()
    var bossMinionCount = 0
    var curseCount = 0
    var curseCooldown = 0
    var digestCooldown = 0
    var digestCount = 0

    /**
     *  Führt die Fähigkeiten vom Boss random selber aus.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun bossAttack(mutableList: MutableList<Hero>) {
        var attackNumber = Random.nextInt(0, 7)
        val radomHero = mutableList.random()
        attackNumber = if (bossMinionCount == 0) {
            Random.nextInt(0, 7)
        } else {
            Random.nextInt(1, 7)
        }
        if (curseCooldown == 1 || curseCooldown == 2 || curseCooldown == 3) {
            val a = Random.nextInt(0, 5)
            val b = Random.nextInt(6, 7)
            attackNumber = intArrayOf(a,b).random()
            curseCooldown = 0
        } else if (bossMinionCount == 1) {
            Random.nextInt(1, 5)
            Random.nextInt(6, 7)
            curseCooldown = 0
        }
        if (digestCooldown == 1 || digestCooldown == 2 || digestCooldown == 3) {
            Random.nextInt(0, 6)
            digestCooldown = 0
        } else if (bossMinionCount == 1) {
            Random.nextInt(1, 6)
            digestCooldown = 0
        }
        if (digestCount == 1) {
            digest(mutableList)
            digestCount = 0
        }
        when (attackNumber) {
            0 -> {
                bossMinion(bossMinionActionList[0])
                bossMinionCount++
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
                curseCooldown++
                curseCount++
            }

            6 -> {
                digest(mutableList)
                digestCooldown++
                digestCount++
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
     *  Verflucht alle Helden daraufhin wird die gesamte Lebensenergie 20 % reduziert.
     *  Nach dem diese Fähigkeit ausgeführt wurde, hat sie 5 Runden Cooldown.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun curse(mutableList: MutableList<Hero>) {
        for (hero in mutableList) {
            val useCurse = hero.maxHealth - 0.2
            hero.healthbar = useCurse.toInt()
        }
        println(
            "$name tanzt wie wild um seine Feuerstelle und murmelt dabei vor sich hin.\n" +
                    "Nachdem er damit aufhört fühlen die Helden sich komisch.\n" +
                    "$name hat einen Fluch über die Helden ausgesprochen.\n" +
                    "Sie fühlen sich schwach und machen weniger Schaden."
        )
    }

    /**
     *  Bespuckt alle Helden mit Magensäure. Die Helden erleiden für 2 Runden 5 % ihrer
     *  gesamten Lebensenergie an Schaden.
     *  Nach benutzung hat die Fähigkeit 3 Runde Cooldown.
     *
     *  @param mutableList hier wird eine Liste von Helden übergeben.
     */
    fun digest(mutableList: MutableList<Hero>) {
        for (hero in mutableList) {
            val useDigest = hero.healthbar - hero.maxHealth * 0.05
            hero.healthbar = useDigest.toInt()
        }
        println(
            "$name fängt an zu  Magensäure zu spucken.\n" +
                    "Die Helden sind danach durchtränkt mit Magensäure."
        )

    }
}