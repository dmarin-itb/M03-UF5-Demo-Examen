package models

import exceptions.NullOperacioException
import exceptions.OperacioInexistentException

class Calculadora : CalculadoraAbstracta() {
    override fun add(operacio: String, valor1: Int, valor2: Int) {
        if (operacio.equals("divisio"))
            throw OperacioInexistentException()
        val o:Operacio = Operacio(operacio,valor1,valor2)
        this.getOperacions().add(o)
    }

    override fun add(o: Operacio?) {
        if (o == null)
            throw NullOperacioException()
        this.getOperacions().add(o)
    }

    override fun executar(i: Int): Int {
        val o:Operacio = this.getOperacions().get(i-1)

        return o.operar()
    }

}
