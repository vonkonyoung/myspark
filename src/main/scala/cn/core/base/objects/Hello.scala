package base.objects

abstract  class Hello(var message:String) {
  def sayHello(name:String):Unit

}


object  HelloImpl extends Hello("hello"){
  override def sayHello(name: String)={
    println(message+","+name)
  }
}
