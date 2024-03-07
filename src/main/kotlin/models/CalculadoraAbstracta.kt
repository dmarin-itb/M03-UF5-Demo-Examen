package models
abstract class CalculadoraAbstracta  {
    private val operacions: ArrayList<Operacio>

    constructor() {
        operacions = ArrayList<Operacio>()
    }


    fun getOperacions(): ArrayList<Operacio> {
        return operacions
    }

    abstract fun add(operacio: String, valor1: Int, valor2: Int)

    abstract fun add(o: Operacio?)
    abstract fun executar(i: Int): Int

}
