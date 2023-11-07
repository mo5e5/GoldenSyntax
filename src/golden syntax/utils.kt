fun charakterStatusCheck(character: Character) {
    if (character.healthbar <= 0) {
        println("${character.name} hat keine Lebenspunkte mehr. Jeder weitere Treffer macht die Blutlache nur noch größer.")
        return
    }
}