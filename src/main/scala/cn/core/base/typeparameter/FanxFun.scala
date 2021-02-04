package base.typeparameter

object FanxFun {

  def getCard[T](content:T)={
    if(content.isInstanceOf[Int]){
      "card:001,"+content
    }else if(content.isInstanceOf[String]){
      "card:this is your card,"+content
    }else{
      "card:"+content
    }
  }

  def main(args: Array[String]): Unit = {
    getCard[String]("hello world")
  }

}
