package base.array

object Arr2Fun {

  def main(args: Array[String]): Unit = {
    val a=Array(1,2,3,4,5)
    val a2=for (ele<- a) yield  ele *ele

  }

}
