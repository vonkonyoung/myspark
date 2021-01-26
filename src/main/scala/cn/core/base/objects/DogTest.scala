package base.objects

object DogTest {

  def main(args: Array[String]): Unit = {
    val p=new Dog
    println(p.isInstanceOf[Animal])
    println(p.getClass==classOf[Animal])
    println(p.getClass==classOf[Dog])
    p match {
      case dog:Dog=>println("it is a Dog object")
      case _=>println("unknown type")
    }
  }

}
