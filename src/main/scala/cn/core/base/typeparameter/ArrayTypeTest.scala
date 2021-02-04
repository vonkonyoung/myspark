package base.typeparameter

object ArrayTypeTest {

  def packageFood[T:Manifest](food:T*)={
    val foodPackage=new Array[T](food.length)
    for(i<-0 until food.length)foodPackage(i)=food(i)
    foodPackage
  }

  def main(args: Array[String]): Unit = {

  }

}
