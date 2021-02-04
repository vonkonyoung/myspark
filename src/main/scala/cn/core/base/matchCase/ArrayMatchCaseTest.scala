package base.matchCase

object ArrayMatchCaseTest {

  def greeting(arr:Array[String]): Unit ={
    arr match {
      case Array("Leo")=>println("Hi,leo!")
      case Array(girl1,girl2,girl3)=>println("Hi,girls,nice to meet you ."+girl1+" and "+girl2+" and "+girl3)
      case Array("Leo",_*)=>println("Hi,Leo,please introduce your friends to me.")
      case _=>println("hey,who are you")
    }
  }

}
