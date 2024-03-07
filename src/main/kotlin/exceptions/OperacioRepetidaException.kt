package exceptions

class OperacioRepetidaException:Exception {
    constructor() : this("L'operació no pot estar repetida")
    constructor(message: String) : super(message)
}