package models
abstract class AgendaAbstracta  {
    private val contactes: ArrayList<Contacte>

    constructor() {
        contactes = ArrayList<Contacte>()
    }

    fun getContactes(): ArrayList<Contacte> {
        return contactes
    }

    abstract fun add(nom: String, telefon: String, edat: Int)

    abstract fun add(c: Contacte?)

    abstract fun remove(c: Contacte)

    abstract fun search(nom: String): ArrayList<Contacte>

    abstract fun searchExact(nom: String): ArrayList<Contacte>

    abstract fun searchLike(start: String, end: String, vararg contain: String): ArrayList<Contacte>

    abstract fun sorted(): ArrayList<Contacte>
}
