package models

import exceptions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll

import java.util.logging.Level
import java.util.logging.Logger

class CalculadoraTest {

    companion object {
        val c: CalculadoraAbstracta = Calculadora()

        @JvmStatic
        @BeforeAll
        fun setUpClass() {
            try {
                println("Creant les operacions de la calculadora general")
                c.add("suma", 10, 25)
                c.add("suma", 10, 31)
                c.add("resta", 10, 4)
                c.add("resta", 15, 5)
                c.add("opera", 3, 4)
                c.add("opera", 5, 5)

            } catch (ex: OperacioInexistentException) {
                Logger.getLogger(CalculadoraTest::class.java.name).log(Level.SEVERE, null, ex)
            } catch (ex: NullOperacioException) {
                Logger.getLogger(CalculadoraTest::class.java.name).log(Level.SEVERE, null, ex)
            }
        }
    }
    /**
     * Test of add method, of class Calculadora.
     */
    @Test
    fun test_01() {
        try {
            println("Afegir una operació")
            val operacio1 = "suma"
            val num1 = 40
            val num2 = 30
            val instance: CalculadoraAbstracta = Calculadora()
            instance.add(operacio1, num1, num2)
            // Ha d'arribar aquí sense generar cap exception
            assert(true)
        }
        catch(ex:Exception) {
            //No ha de passar per aquí
            assert(false)
        }
    }

    /**
     * Test of add method, of class Calculadora.
     */
    @Test
    fun test_02() {
        println("Afegir una operació inexistent")
        try {
            c.add("divisio", 34, 45)
            fail("Ha permès afegir una operació existent!!!")
        } catch (e: OperacioInexistentException) {
            //ha de passar per aquí
        }
    }

    /**
     * Test of add method, of class Calculadora.
     */
    @Test
    fun test_03() {
        println("Afegir una Operacio null")
        val o: Operacio? = null
        val instance: CalculadoraAbstracta = Calculadora()
        try {
            instance.add(o)
            fail("Ha permès afegir una operació nul·la")
        } catch (ex: OperacioInexistentException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of suma operation, of class Calculadora.
     */
    @Test
    fun test_04() {
        println("Provant l'operació suma")
        val result:Int = c.executar(1)
        assertEquals(35, result)
    }

    @Test
    fun test_05() {
        println("Provant l'operació suma")
        val result:Int = c.executar(2)
        assertEquals(51, result)
    }

    /**
     * Test of resta operation, of class Calculadora.
     */
    @Test
    fun test_06() {
        println("Provant l'operació resta")
        val result:Int = c.executar(3)
        assertEquals(6, result)
    }

}