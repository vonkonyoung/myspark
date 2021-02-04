package base.typeparameter

class Person(val name:String) {

  def sayHello=println("Hello,I am "+name)
  def makeFriends(p:Person): Unit ={
    sayHello
    p.sayHello
  }

}
