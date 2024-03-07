package controllers

import models.*
import exceptions.*

/**
 * No heu de tocar res en aquest fitxer. Heu d'implementar la classe Agenda per
 * tal que aquest programa funcioni correctament. Mireu que passi tots els jocs
 * de prova, però tingueu en compte que hi haurà altres casos de prova privats.
 */

fun main() {
    val calc: Calculadora = Calculadora()

    try {
        //Crea una operació i l'afegeix a la calculadora
        val c: Operacio = Operacio("*", 2, 2)
        calc.add(c)
        println("1.- Afegida correctament l'operació")

        //Afegeix una operació informant directament els valors
        calc.add("*", 3, 3)
        println("2.- Ha afegit una segona operacio")
    } catch (ex: OperacioRepetidaException) {
        println("Sembla ser que aquesta operació ja existeix...")
    } catch (ex: NullOperacioException) {
        println("L'operació no pot ser null")
    }

    try {
        var result:Int = calc.executar(1)
        println("3.- El resultat de la primera operació és 4")
        result = calc.executar(2)
        println("4.- El resultat de la segona operació és 9")
    }
    catch (ex: Exception) {
        println(ex.message)
    }
}


