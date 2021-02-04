package base.array

import scala.collection.mutable

object ListTest {

  val prefix="ctsi"
  def decorator(list:List[Int],prefix:String): Unit ={
    if(list!=Nil){
      println(prefix+list.head)
      decorator(list.tail,prefix)
    }
  }

  def linkedList = {
    val linkList = mutable.LinkedList(1, 2, 3, 4, 5)
    var currentList = linkList
    while (currentList != Nil) {
      currentList.elem = currentList.elem * 2
      currentList = currentList.next
    }
  }

  def main(args: Array[String]): Unit = {

    val list=List(1,2,3,4)
    println(list.head)
    println(list.tail)
    0::list
    println(list)
    decorator(list,prefix)
    println(list)
    println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa----每个元素都乘以2")
    linkedList
    println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa----每隔一个元素都乘以2")
    val linkedList2=mutable.LinkedList(1,2,3,4,5,6,7,8,9)
    var currentList=linkedList2
    var first=true
    while(currentList!=Nil&&currentList.next!=Nil){

    }


  }

}
