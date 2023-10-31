import Hero

class TankHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    val tankHeroActionList = mutableListOf(heal(), drawAttention(), punch(), kick())

    /**
     *  Heilt diesen Helden um 10 % seiner gesamten Lebensenergie.
     */
    private fun heal() {

    }

    /**
     *  Zieht die Aufmerksamkeit aller AntiHelden für zwei Runden auf sich.
     */
    private fun drawAttention() {

    }

    /**
     *  Ein heftiger Schlag der den getroffenen AntiHeld 15 % seiner gesamten Lebensenergie abzieht.
     */
    private fun punch() {

    }

    /**
     *  Ein Roundhouse Kick aller Chuck Norris der den AntiHeld 25 % seiner gesamten Lebensenergie abzieht.
     */
    private fun kick() {

    }
}