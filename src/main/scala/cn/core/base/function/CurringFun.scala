package base.function

object CurringFun {

  def sum(a:Int,b:Int)=a+b
  def sum2(a:Int)=(b:Int)=>a+b
  def sum3(a:Int)(b:Int)=a+b

  def main(args: Array[String]): Unit = {
//    println(sum(1,1))
      println(sum2(1)(1))
      println(sum3(1)(1))
  }

}
