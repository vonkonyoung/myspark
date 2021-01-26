package base

object ForTest {

  def main(args: Array[String]): Unit = {
    var n=10
    for(i<-1 to 10) println(i)
    for(i<-1 to 10 if i%2==0)println(i)
    var arr=for(i<-1 to 10) yield i
    println(arr)
  }

}
