package base.matchCase

object MatchCaseTest {

  def judgeGrade(name:String,grade:String): Unit ={
    grade match {
      case "A"=>println("Excellent")
      case "B"=>println("Good")
      case "C"=>println("Just so so")
      case _ if name=="leo"=>println(name+",you are a good boy,come on")
      case _ =>println("you need to work harder")
    }
  }

  def main(args: Array[String]): Unit = {
    judgeGrade("leo","A")
  }

}
