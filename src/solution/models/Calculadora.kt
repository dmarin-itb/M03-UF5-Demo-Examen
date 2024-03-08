package models

import exceptions.NullOperacioException
import exceptions.OperacioInexistentException

class Calculadora:CalculadoraAbstracta  {

    constructor():super() {}
    override fun add(operacio: String, valor1: Int, valor2: Int) {
        if (!(operacio.equals("suma") || operacio.equals("resta") || operacio.equals("opera"))) {
            throw OperacioInexistentException("Operació inexistent")
        }
        val oper : Operacio = Operacio(operacio, valor1, valor2)
        this.getOperacions().add(oper)
    }

    override fun add(o: Operacio?) {
        if (o == null) {
            throw NullOperacioException("Operació inexistent")
        }
        this.getOperacions().add(o!!)
    }

    override fun executar(i: Int): Int {
        val o: Operacio = this.getOperacions().get(i-1)
        return o.operar()
    }

}
