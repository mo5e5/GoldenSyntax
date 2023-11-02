import kotlin.random.Random

class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    val bossMinionActionList: MutableList<BossMinion> = mutableListOf()
    var bossMinionCount = 0
    var shieldCooldown = 0
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
        if (shieldCooldown >= 0) {
            shieldCooldown--
        }
        if (curseCooldown >= 0) {
            curseCooldown--
        }
        if (digestCooldown >= 0) {
            digestCooldown--
        }
        if (bossMinionCount == 0) {
            Random.nextInt(0, 7)
        } else {
            if (shieldCooldown >= 0 && curseCooldown >= 0 && digestCooldown >= 0) {
                val listOfAttack = listOf(2, 3, 4)
                attackNumber = listOfAttack.random()
            } else if (shieldCooldown >= 0 && curseCooldown >= 0) {
                val listOfAttack = listOf(2, 3, 4, 6)
                attackNumber = listOfAttack.random()
            } else if (shieldCooldown >= 0 && digestCooldown >= 0) {
                val listOfAttack = listOf(2, 3, 4, 5)
                attackNumber = listOfAttack.random()
            } else if (curseCooldown >= 0 && digestCooldown >= 0) {
                val listOfAttack = listOf(1, 2, 3, 4)
                attackNumber = listOfAttack.random()
            } else if (shieldCooldown >= 0) {
                val listOfAttack = listOf(2, 3, 4, 5, 6)
                attackNumber = listOfAttack.random()
            } else if (curseCooldown >= 0) {
                val listOfAttack = listOf(1, 2, 3, 4, 6)
                attackNumber = listOfAttack.random()
            } else if (digestCooldown >= 0) {
                val listOfAttack = listOf(1, 2, 3, 4, 5)
                attackNumber = listOfAttack.random()
            }
        }
        if (digestCount == 1) {
            digest(mutableList)
            digestCount = 0
        }
        when (attackNumber) {
            0 -> {
                bossMinion(bossMinionActionList[0])
                bossMinionCount = 1
            }

            1 -> {
                shield()
                shieldCooldown = 3
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
                curseCooldown = 5
            }

            6 -> {
                digest(mutableList)
                digestCooldown = 3
                digestCount = 1
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
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 5 Runden Cooldown.
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