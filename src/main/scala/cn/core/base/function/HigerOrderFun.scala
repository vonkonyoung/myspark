package base.function

object HigerOrderFun {

  val sayHelloFunc=(name:String)=>println("Hello,"+name)
  def greeting(func:(String)=>Unit,name:String){func(name)}
  def getGreetingFunc(msg:String)=(name:String)=>println(msg+","+name)
  def triple(func:(Int)=>Int)={func(3)}

  def main(args: Array[String]): Unit = {

//    greeting(sayHelloFunc,"Leo")

//    Array(1,2,3,4,5).map((num:Int)=>println(num*num))
//    val greetingFunc=getGreetingFunc("hello")
//    greetingFunc("leo")
//    triple(3*_)
    Array(1,2,3,4,5).map(2*_)
    (1 to 9).map("*"*_).foreach(println(_))
    (1 to 20).filter(_ % 2==0).foreach(println(_))
    println((1 to 9).reduce(_+_))
    println((1 to 9).reduceLeft(_+_))
    println((1 to 9).reduceRight(_+_))
    println((1 to 9).reduceOption(_+_))
    println((1 to 9).reduceLeftOption(_+_))
    println((1 to 9).reduceRightOption(_+_))
    println(Array(1,2,5,2,3,6,5).sortWith(_ > _).mkString(","))

  }

}
