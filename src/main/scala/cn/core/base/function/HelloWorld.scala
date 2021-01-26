package base.function

object HelloWorld {


  def sayHello(name:String): Unit ={
    println("Hello,"+name)
  }

  def greeting(func:(String)=>Unit,name:String){func(name)}

  def triple(func:(Int)=>Int)={func(3)}
  def main(args: Array[String]): Unit = {
//    val sayHelloFunc = sayHello _
//    sayHelloFunc("Leo")
    val sayhelloFunc=(name:String)=>println("Hello "+name)
    sayhelloFunc("Leo")
    greeting(sayhelloFunc,"LLLLL")
    println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    Array(1,2,3,4,5,6).map((num:Int)=>num*num)
    println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
    def getGreetingFunc(msg:String)=(name:String)=>println(msg+","+name)
    val greetingFunc=getGreetingFunc("Hello")
    greetingFunc("Leoooooooooooooooooooooo")
    println(triple(3*_))




  }

}
