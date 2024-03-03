package models

abstract class ContacteAbstracte : Comparable<ContacteAbstracte> {
    private var nom:String
    private var telefon:String
    private var edat:Int

    constructor(nom: String, telefon: String, edat: Int) {
        this.nom = nom
        this.telefon = telefon
        this.edat = edat
    }

    fun getNom(): String {
        return nom
    }

    fun getTelefon(): String {
        return telefon
    }
    fun getEdat(): Int {
        return edat
    }

    override fun equals(other: Any?): Boolean {
        return if (this.compareTo(other as Contacte) == 0) true
                else false
    }



}
