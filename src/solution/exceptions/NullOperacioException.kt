package exceptions

class NullOperacioException:Exception {
    constructor() : this("L'operació no pot ser NULL")
    constructor(message: String) : super(message)
}