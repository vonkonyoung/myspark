package base.matchCase
import java.io._

object MatchCaseTypeTest {

  def processException(e:Exception): Unit ={
    e match {
      case e1:IllegalArgumentException=>println("you have illegal arguments!exception is："+e1)
      case e2:FileNotFoundException=>println("cannot find the file you need read or write!,exception is :"+e2)
      case e2:IOException=>println("you got an error while you were doing IO operation!exception is:"+e2)
      case _:Exception=>println("cannot know which exception you have")
    }
  }

}
