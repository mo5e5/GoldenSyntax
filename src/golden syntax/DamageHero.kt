class DamageHero(name: String, healthbar: Int) : Hero(name, healthbar) {

    /**
     *  Schleuder das Schwert in richtung des Anti Helden dieser wird mehrfach von der rotierenden
     *  Klinge getroffen und erleidet 15 % seiner gesamten Lebensenergie an Schaden.
     */
    private fun swordSpin(antiHero: AntiHero) {
        println(
            "$name schleudert sein schwert auf ${antiHero.name} und zieht ihm 15 % seiner Lebenspunkte ab.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat ${antiHero.maxHealth * 0.15} Schaden erlitten."
        )
        val useSwordSpin = antiHero.healthbar - antiHero.maxHealth * 0.15
        antiHero.healthbar = useSwordSpin.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }

    /**
     *  Schlägt mit dem Griff seines Schwertes fest zu und fügt dem Anti Helden 10 % seiner gesamten Lebensenergie
     *  an Schaden zu.
     */
    private fun knopStrike(antiHero: AntiHero) {
        println(
            "$name wirft sein Schwert in die luft und fängt es an der klinge und haut mit dem Griff\n" +
                    "fest zu und trifft ${antiHero.name}.\n" +
                    "${antiHero.name} hatte ${antiHero.healthbar} Lebenspunkte.\n" +
                    "Er hat ${antiHero.maxHealth * 0.1} Schaden erlitten."
        )
        val useKnopStrike = antiHero.healthbar - antiHero.maxHealth * 0.1
        antiHero.healthbar = useKnopStrike.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }

    /**
     *  Wirft ein kreisendes Schwert auf alle Anti Helden und fügt 15 % der gesamten Lebensenergie an Schaden zu.
     *  Nachdem diese Fähigkeit ausgeführt wurde, hat sie 3 Runden Cooldown.
     */
    private fun swordMultiSpin(list: List<AntiHero>) {
        println(
            "$name wirft sein Schwert in kreisenden Bewegungen und trift jeden Anti Helden.\n" +
                    "Jeder Anti Held erleidet 15 % Schaden."
        )
        for (antiHero in list) {
            val useSwordMultiSpin = antiHero.healthbar - antiHero.maxHealth * 0.15
            antiHero.healthbar = useSwordMultiSpin.toInt()
            println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
        }
    }

    /**
     *  Blitze kommen aus dem Himmel geflogen. Diese treffen einen Anti Held mit einem Schaden von 30 %
     *  der gesamten Lebensenergie des AntiHelden.
     *  Diese Fähigkeit geht nach benutzen für 5 Runden in den Cooldown.
     */
    private fun thunderSword(antiHero: AntiHero) {
        println(
            "$name hält sein Schwert in die Luft und murmelt etwas.\n" +
                    "Plötzlich fängt es an zu Donnern und Blitze schlagen auf ${antiHero.name} ein."
        )
        val useThunderSword = antiHero.healthbar - antiHero.maxHealth * 0.3
        antiHero.healthbar = useThunderSword.toInt()
        println("${antiHero.name} hat nun noch ${antiHero.healthbar}.")
    }
}