package models

class Operacio  {
    private var operacio: String
    private var val1: Int
    private var val2: Int

    constructor (operacio:String, val1:Int, val2:Int) {
        this.operacio = operacio
        this.val1 = val1
        this.val2 = val2
    }

    fun operar():Int {
        val result = when (operacio) {
            "suma" ->  val1 + val2
            "resta" ->  val1 - val2
            "opera" ->  (val1 + val2) * (val1 - val2)
            else -> 0
        }

        return result
    }
}
