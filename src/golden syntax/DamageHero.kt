class DamageHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    val damageHeroActionList = mutableListOf(swordSpin(), knopStrike(), swordBlock(), thunderSword())

    /**
     *  Schleuder das Schwert in richtung des AntiHelden dieser wird mehrfach von der rotierenden
     *  Klinge getroffen und erleidet 15 % seiner gesamten Lebensenergie an Schaden.
     */
    private fun swordSpin() {

    }

    /**
     *  Schlägt mit dem Griff seines Schwertes fest zu und fügt dem AntiHelden 10 % seiner gesamten Lebensenergie
     *  an Schaden zu.
     */
    private fun knopStrike() {

    }

    /**
     *  Hält das Schwert schützend vor sich und blockt so 50 % vom nächsten Schaden der auf ihm gewirkt wird.
     */
    private fun swordBlock() {

    }

    /**
     *  Blitze kommen aus dem Himmel geflogen. Diese treffen einen AntiHeld mit einem Schaden von 30 %
     *  der gesamten Lebensenergie des AntiHelden. Diese Fähigkeit geht nach benutzen für 5 Runden in den
     *  Cooldown.
     */
    private fun thunderSword() {

    }
}