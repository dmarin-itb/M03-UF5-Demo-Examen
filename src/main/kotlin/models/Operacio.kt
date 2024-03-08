package models

class Operacio {
  private val nom:String
  private val valor1 :Int
  private val valor2 :Int
  constructor(s: String, i1: Int, i2: Int) {
    this.nom= s
    this.valor1= i1
    this.valor2 = i2
  }

  fun operar():Int {
   var result:Int = 0
   if (nom.equals("suma"))
     result= valor1+valor2
   else if (nom.equals("resta"))
    result= valor1-valor2
   else if (nom.equals("opera"))
    result= (valor1+valor2) * (valor1-valor2)

   return result
  }

}
