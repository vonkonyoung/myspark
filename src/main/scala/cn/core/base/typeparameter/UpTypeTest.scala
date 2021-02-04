package base.typeparameter

object UpTypeTest {

  def getIDCard[R>:Child](person:R): Unit ={
    if(person.getClass==classOf[Child]){
      println("please tell us your parent~s name")
    }else if(person.getClass==classOf[Father]){
      println("sign your name for your cihlds id card")
    }else{
      println("sorry,you are not allowed to get id card")
    }
  }

  def main(args: Array[String]): Unit = {

  }

}
