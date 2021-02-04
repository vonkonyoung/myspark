package base.collection

object ListTest {
  def decorator(l:List[Int],prefix:String): Unit ={
    if(l!=Nil){
      println(prefix+l.head)
    }else{
      decorator(l.tail,prefix)
    }
  }


  def main(args: Array[String]): Unit = {

    val list=scala.collection.mutable.LinkedList(1,2,3,4,5,6)
    var currentList=list
    while(currentList!=Nil){
      currentList.elem=currentList.elem*2
      currentList=currentList.next
    }
  }

}
