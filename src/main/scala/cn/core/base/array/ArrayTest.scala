package base.array
import scala.collection.mutable.ArrayBuffer

object ArrayTest {

  def main(args: Array[String]): Unit = {
    val a=Array(1,2,7,3,4,5)
    println(a.sum)
    println(a.max)
    scala.util.Sorting.quickSort(a)
    println(a.mkString(","))
    print(a.toString)
    val b=ArrayBuffer[Int]()
    b+=1
    b+=(2,3,4,5)
    b++=ArrayBuffer(6,7,8,9,10)
    b.trimEnd(5)
    println(b.mkString(","))
  }

}
