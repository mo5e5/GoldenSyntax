fun charakterStatusCheck(character: Character) {
    if (character.healthbar <= 0) {
        println("${character.name} hat keine Lebenspunkte mehr. Er ist aus dem Spiel.")
        return
    }
}