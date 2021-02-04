package base.function

object ReturnTest {

  def greeting(name:String)={
    def sayHello(name:String):String={
      return "Hello,"+name
    }
    sayHello(name)
  }

  def main(args: Array[String]): Unit = {
    println(greeting("cainiao"))
  }

}
