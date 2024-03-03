package controllers

import models.*
import exceptions.*

/**
 * No heu de tocar res en aquest fitxer. Heu d'implementar la classe Agenda per
 * tal que aquest programa funcioni correctament. Mireu que passi tots els jocs
 * de prova, però tingueu en compte que hi haurà altres casos de prova privats.
 */

fun main() {
    val agenda: Agenda = Agenda()

    try {
        //Crea un contacte i l'afegeix a l'agenda
        val c: Contacte = Contacte("Josep Antoni Margarit", "93 622 15 90", 77)
        agenda.add(c)
        println("1.- Ha afegit correctament al Josep Antoni")

        //Afegeix un contacte informant directament els valors
        agenda.add("Anna Maria Quirant", "656 123 456", 50)
        println("2.- Ha afegit correctament l'Anna Maria!")
    } catch (e: ContacteRepetitException) {
        println("Sembla ser que aquest contacte ja existeix...")
    } catch (ex: NullContactException) {
        println("El contacte no pot ser null")
    }

    try {
        //Crea un contacte i l'elimina correctament de l'agenda (compara nom i edat, però no el telèfon)
        val c: Contacte = Contacte("Josep Antoni Margarit", "93 xxx xx xx", 77)
        agenda.remove(c)
        println("3.- Ha eliminat correctament al Josep Antoni!")
        //Provo d'eliminar a l'Anna Maria, però ara és més joveneta... Ha de fallar!!
        println("4.- Mirant d'eliminar a l'Anna Maria de joveneta...")
        val c2: Contacte = Contacte("Anna Maria Quirant", "656 xxx xxx", 22)
        agenda.remove(c2)
        println("Ha eliminat correctament l'Anna Maria!")
    } catch (e: ContacteInexistentException) {
        println("5.- Sembla ser que aquest contacte no existeix...")
    } catch (e: AgendaBuidaException) {
        println("No puc eliminar res que l'agenda es troba buida!!")
    }

    try {
        //Elimino el contacte que queda
        println("6.- Ara sí elimino a l'Anna Maria")
        val c2: Contacte = Contacte("Anna Maria Quirant", "656 xxx xxx", 50)
        agenda.remove(c2)
        println("7.- Ha eliminat correctament l'Anna Maria!")
        //Provo d'eliminar sobre una agenda buida
        println("8.- Provo d'eliminar-la una altra vegada, però ara l'agenda ja es troba buida")
        agenda.remove(c2)
        println("Si arriba aquí és tota una sorpresa!!!")
    } catch (e: ContacteInexistentException) {
        println("Sembla ser que aquest contacte no existeix...")
    } catch (e: AgendaBuidaException) {
        println("9.- No puc eliminar res que l'agenda es troba buida!!")
    }


    //Provo d'afegir dues vegades el mateix contacte
    try {
        println("10.- Miro d'afegir dues vegades el mateix contacte.")
        val c1: Contacte = Contacte("Josep Antoni Margarit", "93 xxx xx xx", 77)
        agenda.add(c1)
        println("11.- La primera vegada sí que ho permet.")
        val c2: Contacte = Contacte("Josep Antoni Margarit", "93 xxx xx xx", 77)
        agenda.add(c2)
        println("La segona no ho hauria de permetre.")
    } catch (e: ContacteRepetitException) {
        println("12.- El contacte ja existeix a l'agenda")
    } catch (ex: NullContactException) {
        println("El contacte no pot ser null")
    }


    //Introduir sis contactes, per fer les següents proves
    val c1: Contacte = Contacte("Juan García", "666 555 111", 70)
    val c2: Contacte = Contacte("Juan García", "666 555 222", 45)
    val c3: Contacte = Contacte("José María García", "666 555 333", 22)
    val c4: Contacte = Contacte("Pedro López", "666 555 444", 33)
    val c5: Contacte = Contacte("Marta López", "666 555 555", 28)
    val c6: Contacte = Contacte("Juan García", "666 555 666", 65)
    try {
        agenda.add(c1)
        agenda.add(c2)
        agenda.add(c3)
        agenda.add(c4)
        agenda.add(c5)
        agenda.add(c6)
        println("13.- Afegits sis contactes a l'agenda")
    } catch (e: ContacteRepetitException) {
        println("El contacte ja existeix a l'agenda")
    } catch (ex: NullContactException) {
        println("El contacte no pot ser null")
    }


    //Obté la llista de contactes ordenada
    //Sobre una agenda buida dona error
    try {
        val a2: Agenda = Agenda()
        a2.sorted()
    } catch (ex: AgendaBuidaException) {
        println("14.- No es pot ordenar una llista buida!")
    }

    try {
        println("15.- Obtinc la llista de contactes ordenada")
        val llistaOrdenada: ArrayList<Contacte> = agenda.sorted()
        for (c in llistaOrdenada) {
            println("16.x.- Contacte: " + c.getNom() + " de " + c.getEdat() + " anys i telèfon: " + c.getTelefon())
        }
    } catch (ex: AgendaBuidaException) {
        println("No es pot ordenar una llista buida!")
    }


    //Provant el mètode Search
    //Buscar alguna cosa dins una agenda buida
    try {
        val a2: Agenda = Agenda()
        a2.search("Juan")
    } catch (ex: AgendaBuidaException) {
        println("17.- No es pot buscar sobre una llista buida!")
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!")
    }


    //Provant el mètode Search
    //Buscar un registre inexistent
    try {
        println("18.- Buscar un registre inexistent")
        agenda.search("Pujol")
    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida!")
    } catch (ex: ContacteInexistentException) {
        println("19.- No existeix el contacte buscat!")
    }


    //Provant el mètode Search
    //Ha de trobar aquells contactes que, dins del nom, contenen el text indicat
    try {
        val trobats: ArrayList<Contacte> = agenda.search("Mar")
        println("20.- He trobat tots aquests contactes que contenen 'Mar'")
        for (c in trobats) {
            println("21.x - Contacte: " + c.getNom())
        }
    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida!" + ex.message)
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!" + ex.message)
    }


    //Provant el mètode SearchExact
    //Buscar alguna cosa dins una agenda buida
    try {
        val a2: Agenda = Agenda()
        a2.searchExact("Juan")
    } catch (ex: AgendaBuidaException) {
        println("22.- No es pot buscar sobre una llista buida!")
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!")
    }


    //Provant el mètode SearchExact
    //Buscar un registre inexistent
    try {
        agenda.searchExact("Pujol")
    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida!")
    } catch (ex: ContacteInexistentException) {
        println("23.- No existeix el contacte buscat!")
    }


    //Provant el mètode SearchExact
    //Buscar un registre existent
    try {
        val trobats: ArrayList<Contacte> = agenda.search("Juan García")
        println("24.- He trobat tots aquests contactes que es diuen 'Juan García'")
        for (c in trobats) {
            println("25.x.- Contacte: " + c.getNom() + " - Edat: " + c.getEdat())
        }

    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida! " + ex.message)
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!" + ex.message)
    }


    //Provant el mètode SearchLike
    //Buscar alguna cosa dins una agenda buida
    try {
        val a2: Agenda = Agenda()
        a2.searchLike("Mar", "pez")
    } catch (ex: AgendaBuidaException) {
        println("26.- No es pot buscar sobre una llista buida!")
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!")
    }


    //Provant el mètode SearchLike
    //Buscar un registre inexistent  (Mar...Ro...pez)
    try {
        agenda.searchLike("Mar", "pez", "Ro")
    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida!")
    } catch (ex: ContacteInexistentException) {
        println("27.- No existeix el contacte buscat!")
    }


    //Provant el mètode SearchLike
    //Buscar un registre existent (J...cía)
    //Comença per "J" i acaba per "cía"
    try {
        val trobats: ArrayList<Contacte> = agenda.searchLike("J", "cía")
        println("28.- He trobat tots aquests contactes que es diuen 'Juan García'")
        for (c in trobats) {
            println("29.x.- Contacte: " + c.getNom() + " - Edat: " + c.getEdat())
        }
    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida!" + ex.message)
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!" + ex.message)
    }


    //Provant el mètode SearchLike
    //Buscar un registre existent (J..M..r..cía)
    //Comença per "J", acaba per "cía" i entremig té una M i després una r
    try {
        val trobats: ArrayList<Contacte> = agenda.searchLike("J", "cía", "M", "r")
        println("30.- He trobat tots aquests contactes que es diuen 'J..M..r..cía'")
        for (c in trobats) {
            println("31.x.- Contacte: " + c.getNom() + " - Edat: " + c.getEdat())
        }

    } catch (ex: AgendaBuidaException) {
        println("No es pot buscar sobre una llista buida!" + ex.message)
    } catch (ex: ContacteInexistentException) {
        println("No existeix el contacte buscat!" + ex.message)
    }
}


