open class Hero(name: String, healthbar: Int) : Character(name, healthbar) {

    var healItemUses = 3
    var healTeamItemUses = 2
    var buffItemUses = 1
    fun useMagicBag(list: List<Hero>,magicBag: MagicBag) {
        val listOfAttack = listOf("heallItem", "healItemTeam", "buffItem")
        var hero = Hero("",0)

        println(
            "$name greift in den Magischen Beutel.\n" +
                    "Nach kurzer Zeit des wühlens findet er ..."
        )
        var useBag: String
        useBag = readln()
        when (useBag) {
            "heallItem" -> {
                magicBag.heallItem(hero)
                healItemUses--


            }

            "healItemTeam" -> {
                magicBag.healItemTeam(list)
                healTeamItemUses--

            }

            "buffItem" -> {
                magicBag.buffItem(hero)
                buffItemUses--
            }
        }
    }
}