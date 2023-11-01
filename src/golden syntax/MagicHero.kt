import Hero

class MagicHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    val magicHeroActionList = mutableListOf(lightningStrike(), earthquake(), blockDamageBuff(), immortality())

    /**
     *  Es hagelt Blitze vom Himmel die alle AntiHelden treffen und jeweils 5 % der gesamten Lebensenergie
     *  an Schaden verursachen.
     */
    fun lightningStrike() {

    }

    /**
     *  Die Erde erhebt sich und fügt dem AntiHeld der auf ihr steht, 10 % der gesamten Lebensenergie an schaden zu.
     */
    fun earthquake() {

    }

    /**
     *  Ein Schutzzauber der auf jeden Helden wirkt und 15 % des eingehen Schadens blockiert.
     *  Der Zauber hält 3 Runden.
     */
    fun blockDamageBuff() {

    }

    /**
     *  Macht den Helden für 2 Runden unsterblich wobei der eingehende Schaden trotzdem von seinen
     *  Lebenspunkten abgezogen wird.
     *  Hat nach Benutzung 3 Runden Cooldown.
     */
    fun immortality() {

    }
}