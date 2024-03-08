package exceptions

class OperacioInexistentException:Exception {
    constructor() : this("L'operació no existeix")
    constructor(message: String) : super(message)
}