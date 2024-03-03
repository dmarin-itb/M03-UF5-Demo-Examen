package models

/**
 * Compara dos objectes de tipus Contacte
 */
class ComparatorContacte : Comparator<Contacte> {
    override fun compare(o1: Contacte, o2: Contacte): Int {
        return o1.compareTo(o2)
    }
}
