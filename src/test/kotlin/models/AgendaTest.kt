package models

import exceptions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll

import java.util.logging.Level
import java.util.logging.Logger

class AgendaTest {

    companion object {
        val a: Agenda = Agenda()

        @JvmStatic
        @BeforeAll
        fun setUpClass() {
            try {
                println("Creant els contactes de l'agenda general")
                a.add("To be deleted at Test6", "93 111 22 33", 11)
                a.add("Alberto Martín", "93 123 45 00", 45)
                a.add("María Martínez", "93 123 45 11", 56)
                a.add("María Martínez", "93 123 99 99", 20)
                a.add("Carlos Jiménez", "93 123 45 22", 67)
                a.add("María Pérez", "93 123 45 33", 78)
                a.add("Luis Alberto Alcaraz", "93 123 45 44", 12)
                a.add("María José Domínguez", "93 123 45 55", 23)
                a.add("Marcos Esteban Vincent", "93 123 45 66", 34)
                a.add("aMarcos Esteban Vincentz", "93 123 45 99", 22)
                a.add("Lluís Collet", "93 123 45 77", 54)
                a.add("Teresa Valldemolins", "93 123 45 88", 43)
            } catch (ex: ContacteRepetitException) {
                Logger.getLogger(AgendaTest::class.java.name).log(Level.SEVERE, null, ex)
            } catch (ex: NullContactException) {
                Logger.getLogger(AgendaTest::class.java.name).log(Level.SEVERE, null, ex)
            }
        }
    }
    /**
     * Test of add method, of class Agenda.
     */
    @Test
    fun test_01() {
        println("Afegir un contacte inexistent")
        val nom = "Nou Contacte"
        val telefon = "93 123 99 99"
        val edat = 30
        val instance: Agenda = Agenda()
        instance.add(nom, telefon, edat)
    }

    /**
     * Test of add method, of class Agenda.
     */
    @Test
    fun test_02() {
        println("Afegir un contacte ja existent")
        try {
            a.add("Alberto Martín", "93 123 45 00", 45)
            fail("Ha permès afegir un contacte existent!!!")
        } catch (e: ContacteRepetitException) {
            //ha de passar per aquí
        }
    }

    /**
     * Test of add method, of class Agenda.
     */
    @Test
    fun test_03() {
        println("Afegir un contacte null")
        val c: Contacte? = null
        val instance: Agenda = Agenda()
        try {
            instance.add(c)
            fail("Ha permès afegir un contacte null")
        } catch (ex: NullContactException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of remove method, of class Agenda.
     */
    @Test
    fun test_04() {
        println("Eliminar un contacte d'una agenda buida")
        val c: Contacte = Contacte("Test", "123", 20)
        val instance:Agenda = Agenda()
        try {
            instance.remove(c)
            fail("No pots eliminar un contacte d'una agenda buida.")
        } catch (ex: AgendaBuidaException) {
            //passa per aquí
        }
    }

    /**
     * Test of remove method, of class Agenda.
     */
    @Test
    fun test_05() {
        println("Eliminar un contacte inexistent d'una agenda")
        val c: Contacte = Contacte("Does not exists", "93 111 22 33", 11)
        try {
            a.remove(c)
            fail("No pots eliminar un contacte inexistent d'una agenda.")
        } catch (ex: ContacteInexistentException) {
            //OK, ha de passar per aqui
        }
    }

    /**
     * Test of remove method, of class Agenda.
     */
    @Test
    fun test_06() {
        println("Eliminar un contacte existent d'una agenda")
        val c: Contacte = Contacte("To be deleted at Test6", "93 111 22 33", 11)
        a.remove(c)
    }

    /**
     * Test of Search method, of class Agenda.
     */
    @Test
    fun test_07() {
        println("Buscant en una llista buida")
        val nom = "Buit"
        val instance: Agenda = Agenda()
        try {
            instance.search(nom)
            fail("No es pot buscar en una llista buida")
        } catch (ex: AgendaBuidaException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of Search method, of class Agenda.
     */
    @Test
    fun test_08() {
        println("Buscant un contacte que no existeix")
        val nom = "INEXISTENT"
        try {
            a.search(nom)
            fail("S'ha buscat un contacte inexistent sense llençar l'exepció adequada")
        } catch (ex: ContacteInexistentException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of Search method, of class Agenda.
     */
    @Test
    fun test_09() {
        println("Buscant un contacte")
        val c: Contacte = Contacte("Alberto Martín", "93 123 45 00", 45)
        val result:ArrayList<Contacte> = a.search("berto Mar")
        assertEquals(result.size, 1)
        assertEquals(result[0], c)
    }

    /**
     * Test of SearchExact method, of class Agenda.
     */
    @Test
    fun test_10() {
        println("Buscant per nom exacte en una llista buida")
        val nom = "Buit"
        val instance: Agenda = Agenda()
        try {
            instance.searchExact(nom)
            fail("No es pot buscar en una llista buida")
        } catch (ex: AgendaBuidaException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of SearchExact method, of class Agenda.
     */
    @Test
    fun test_11() {
        println("Buscant per nom exacte un contacte que no existeix")
        val nom = "INEXISTENT"
        try {
            a.searchExact(nom)
            fail("S'ha buscat de forma exacta un contacte inexistent sense llençar l'exepció adequada")
        } catch (ex: ContacteInexistentException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of SearchExact method, of class Agenda.
     */
    @Test
    fun test_12() {
        println("Buscant un contacte per texte exacte")
        val c: Contacte = Contacte("Alberto Martín", "93 123 45 00", 45)
        val result: ArrayList<Contacte> = a.searchExact("Alberto Martín")
        assertEquals(result.size, 1)
        assertEquals(result[0], c)
    }

    /**
     * Test of SearchLike method, of class Agenda.
     */
    @Test
    fun test_13() {
        println("Buscant amb SearchLike en una llista buida")
        val instance: Agenda = Agenda()
        try {
            instance.searchLike("A", "Z")
            fail("No es pot buscar en una llista buida")
        } catch (ex: AgendaBuidaException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of SearchLike method, of class Agenda.
     */
    @Test
    fun test_14() {
        println("Buscant amb SearchLike un contacte que no existeix")
        try {
            a.searchLike("DOES NOT", "EXISTS")
            fail("S'ha buscat amb SearchLike un contacte inexistent sense llençar l'exepció adequada")
        } catch (ex: ContacteInexistentException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of SearchLike method, of class Agenda.
     */
    @Test
    fun test_15() {
        println("Buscant un contacte amb SearchLike")
        val c: Contacte = Contacte("Alberto Martín", "93 123 45 00", 45)
        val result: ArrayList<Contacte> = a.searchLike("Alb", "tín")
        assertEquals(result.size, 1)
        assertEquals(result[0], c)
    }

    /**
     * Test of SearchLike method, of class Agenda.
     */
    @Test
    fun test_16() {
        println("Buscant un contacte amb SearchLike i 3 paràmetres")
        val c: Contacte = Contacte("Marcos Esteban Vincent", "93 123 45 66", 34)
        val result: ArrayList<Contacte> = a.searchLike("Mar", "t", "o", "s", "n")
        assertEquals(result.size, 1)
        assertEquals(result[0], c)
    }

    /**
     * Test of SearchLike method, of class Agenda.
     */
    @Test
    fun test_17() {
        println("Buscant un contacte amb SearchLike i 7 paràmetres")
        val c: Contacte = Contacte("Marcos Esteban Vincent", "93 123 45 66", 34)
        val result: ArrayList<Contacte> = a.searchLike("Mar", "t", "o", "s", "te", "V", "c", "n")
        assertEquals(result.size, 1)
        assertEquals(result[0], c)
    }

    /**
     * Test of GetSorted method, of class Agenda.
     */
    @Test
    fun test_18() {
        try {
            println("Obtenir la llista ordenada de contactes d'una agenda buida")
            val ag: Agenda = Agenda()
            ag.sorted()
            fail("No podem recuperar els contactes d'una agenda buida")
        } catch (e: AgendaBuidaException) {
            // Ha de passar per aquí
        }
    }

    /**
     * Test of GetSorted method, of class Agenda.
     */
    @Test
    fun test_19() {
        println("Obtenir la llista ordenada de contactes")
        val result: ArrayList<Contacte> = a.sorted()
        assertEquals(result[0].getNom(), "Alberto Martín")
        assertEquals(result[1].getNom(), "Carlos Jiménez")
        assertEquals(result[2].getNom(), "Lluís Collet")
        assertEquals(result[3].getNom(), "Luis Alberto Alcaraz")
        assertEquals(result[4].getNom(), "Marcos Esteban Vincent")
        assertEquals(result[5].getNom(), "María José Domínguez")
        assertEquals(result[6].getNom(), "María Martínez")
        assertEquals(result[6].getEdat(), 20)
        assertEquals(result[7].getNom(), "María Martínez")
        assertEquals(result[7].getEdat(), 56)
        assertEquals(result[8].getNom(), "María Pérez")
        assertEquals(result[9].getNom(), "Teresa Valldemolins")
        assertEquals(result[10].getNom(), "aMarcos Esteban Vincentz")
    }

    
}