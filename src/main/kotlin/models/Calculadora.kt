package models

class Calculadora:CalculadoraAbstracta  {

    constructor():super() {}
    override fun add(operacio: String, valor1: Int, valor2: Int) {
        val oper : Operacio = Operacio(operacio, valor1, valor2)
        this.getOperacions().add(oper)
    }

    override fun add(o: Operacio?) {
        this.getOperacions().add(o!!)
    }

    override fun executar(i: Int): Int {
        return 1
    }

}
