package base.objects

class HelloWorld {
  private var name="leo"
  def sayHello(): Unit ={
    println("Hello,"+name)
  }
  def getName=name

}
