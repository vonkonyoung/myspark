package base.objects

object HelloWorldTest {

  def main(args: Array[String]): Unit = {
    val helloWorld=new HelloWorld
    helloWorld.sayHello()
    println(helloWorld.getName)
  }

}
