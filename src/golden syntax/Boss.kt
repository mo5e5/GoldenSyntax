import kotlin.random.Random

class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    private var bossMinionCount = 0
    private var shieldCooldown = 0
    private var curseCooldown = 0
    private var digestCooldown = 0
    private var digestCount = 0

    /**
     *  Führt die Fähigkeiten vom Boss random selber aus.
     *
     *  @param list hier wird eine Liste von Helden übergeben.
     */
    fun bossAttack(list: MutableList<Hero>): Int {
        var attackNumber = Random.nextInt(0, 7)
        // var attackNumber = 0
        val radomHero = list.random()
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
            digest(list)
            println()
            digestCount = 0
        }
        when (attackNumber) {
            0 -> {
                bossMinionCount = 1
                return 1
            }

            1 -> {
                shield()
                shieldCooldown = 3
                return 0
            }

            2 -> {
                lifeRegenaration()
                return 0
            }

            3 -> {
                stomp(radomHero)
                return 0
            }

            4 -> {
                crush(radomHero)
                return 0
            }

            5 -> {
                curse(list)
                curseCooldown = 5
                return 0
            }

            6 -> {
                digest(list)
                digestCooldown = 3
                digestCount = 1
                return 0
            }
        }
        return 0
    }

    /**
     *  Ein Lebensenergie Boost der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner zerstörung 3 Runden Cooldown.
     */
    private fun shield() {
        println(
            "$name fängt an beulen und Pusteln auf seiner Haut zu bilden.\n" +
                    "Seine Haut ist nun deutlich dicker er hat ${maxHealth * 0.5} Lebensenergie mehr."
        )
        val useShield = healthbar + maxHealth * 0.5
        healthbar = useShield.toInt()
        println("$name hat nun $healthbar Lebensenergie.")
    }

    /**
     *  Regeneriert 15 % seiner gesamten Lebensenergie.
     */
    private fun lifeRegenaration() {
        println(
            "$name frisst ein paar Rinder.\n" +
                    "Danach hat $name deutlich mehr auf den Rippen.\n" +
                    "Er regeneriert ${maxHealth * 0.15} Lebensenergie."
        )
        val useLifeRegenaration = healthbar + maxHealth * 0.15
        healthbar = useLifeRegenaration.toInt()
    }

    /**
     *  Stampft auf einem Helden herum was dem Helden 10 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     *
     *  @param hero erhält einen random Helden aus der heroList.
     */
    private fun stomp(hero: Hero) {
        println(
            "$name stampft auf ${hero.name} herum.\n" +
                    "${hero.name} sieht danach etwas zerknittert aus.\n" +
                    "Er hat ${hero.maxHealth * 0.1} Schaden erlitten."
        )
        val useStomp = hero.healthbar - hero.maxHealth * 0.1
        hero.healthbar = useStomp.toInt()
    }

    /**
     *  Zerquetscht einen Helden was diesem 15 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     *
     *  @param hero erhält einen random Helden aus der heroList.
     */
    private fun crush(hero: Hero) {
        println(
            "$name greift sich ${hero.name} und zerquetscht ihn.\n" +
                    "Darauf hin tropft langsam Blut auf den kalten Boden.\n" +
                    "Er hat ${hero.maxHealth * 0.1} Schaden erlitten."
        )
        val useCrush = hero.healthbar - hero.maxHealth * 0.15
        hero.healthbar = useCrush.toInt()
    }

    /**
     *  Verflucht alle Helden daraufhin wird die gesamte Lebensenergie 20 % reduziert.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 5 Runden Cooldown.
     *
     *  @param mutableList bekommt eine Liste von Helden übergeben.
     */
    private fun curse(mutableList: MutableList<Hero>) {
        println(
            "$name tanzt wie wild um seine Feuerstelle.\n" +
                    "Nachdem er damit aufhört fühlen die Helden sich komisch.\n" +
                    "$name hat einen Fluch über die Helden ausgesprochen."
        )
        for (hero in mutableList) {
            val useCurse = hero.maxHealth - 0.2
            hero.healthbar = useCurse.toInt()
            println("${hero.name} erleidet ${hero.maxHealth * 0.2} Schaden.")
        }
    }

    /**
     *  Bespuckt alle Helden mit Magensäure. Die Helden erleiden für 2 Runden 5 % ihrer
     *  gesamten Lebensenergie an Schaden.
     *  Nach benutzung hat die Fähigkeit 3 Runde Cooldown.
     *
     *  @param mutableList bekommt eine Liste von Helden übergeben.
     */
    private fun digest(mutableList: MutableList<Hero>) {
        println(
            "$name fängt an zu Magensäure zu spucken.\n" +
                    "Die Helden sind danach durchtränkt mit Magensäure."
        )
        for (hero in mutableList) {
            val useDigest = hero.healthbar - hero.maxHealth * 0.05
            hero.healthbar = useDigest.toInt()
            println("${hero.name} erleidet ${hero.maxHealth * 0.05} Schaden.")
        }
    }
}