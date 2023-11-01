open class Hero(name: String, healthbar: Int) : Character(name, healthbar) {

    open val heroActionList =
        mutableListOf(artak.damageHeroActionList, kyoku.magicHeroActionList, vergumkaar.tankHeroActionList)

    fun useMagicBag() {

        println(
            "$name greift in den Magischen Beutel.\n" +
                    "Nach kurzer Zeit des wühlens findet er ..."
        )
    }
}