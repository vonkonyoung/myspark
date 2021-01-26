package base.array

import scala.collection.mutable

object MapAndTuppleTest {
  def main(args: Array[String]): Unit = {
    val ages=Map("Leo"->30,"Jen"->25,"Jack"->23)
    val ages1=scala.collection.mutable.Map("Leo"->30,"Jen"->25,"Jack"->23)
    val ages2=new mutable.HashMap[String,Int]()
    val leoAge=if(ages2.contains("leo")) ages2("leo") else 0
    val ageage=ages.getOrElse("Leo",2)
    ages1("Leo")=222


  }

}
