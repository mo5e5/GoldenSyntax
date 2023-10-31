import AntiHero

class Boss(name: String, healthbar: Int) : AntiHero(name, healthbar) {

    /**
     *  Ruft den BossMinion zur Unterstützung hinzu.
     */
    fun bossMinion() {

    }

    /**
     *  Ein Schild der 50 % der gesamten Lebensenergie beträgt. Er hält bis er zerstört wird.
     *  Hat nach seiner zerstörung drei Runden Cooldown.
     */
    fun shield() {

    }

    /**
     *  Regeneriert in einer Runde für insgesamt drei Runden jeweils 5 % der gesamten Lebensenergie.
     */
    fun lifeRegenaration() {

    }

    /**
     *  Stampft auf einem Helden herum was dem Helden 10 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     */
    fun stomp() {

    }

    /**
     *  Zerquetscht einen Helden was diesem 15 % seiner gesamten Lebensenergie an Schaden
     *  zufügt.
     */
    fun crush() {

    }

    /**
     *  Verflucht alle Helden die für drei Runden nur 80 % ihres normalen Schadens machen.
     */
    fun curse() {

    }

    /**
     *  Bespuckt alle Helden mit Magensäure. Die Helden erleiden für 2 Runden 5 % ihrer
     *  gesamten Lebensenergie an Schaden.
     */
    fun digest() {

    }
}