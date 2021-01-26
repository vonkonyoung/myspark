package base.objects

class Person(val name:String) extends Hello(name) with MakeFriendsTrait with Cloneable with Serializable {
  override def sayHello(name: String): Unit = println("Hello "+name)

  override def makeFriendsTrait(p: Person): Unit =println("Hello,my name is "+name+", your name is "+p.name)
}
