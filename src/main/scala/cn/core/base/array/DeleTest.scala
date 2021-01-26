package base.array

import scala.collection.mutable.ArrayBuffer

object DeleTest {
  def main(args: Array[String]): Unit = {
    val a=ArrayBuffer[Int]()
    a+=(1,2,3,4,5,6,7,8,-3,-5,-9)
    var foundFirstFNegative=false
    var arrayLength=a.length
    var index=0
    while(index<arrayLength){
      if(a(index)>=0){
        index+=1
      }else{
        if(!foundFirstFNegative){
          foundFirstFNegative=true
          index+=1
        }else{
          a.remove(index);
          arrayLength-=1
        }
      }
    }
  }

}
