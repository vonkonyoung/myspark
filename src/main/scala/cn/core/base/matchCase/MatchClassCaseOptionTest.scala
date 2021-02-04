package base.matchCase

object MatchClassCaseOptionTest {

  val grades=Map("Leo"->"A","Jack"->"B","Jen"->"C")
  def getGrade(name:String): Unit ={
    val grade=grades.get(name)
    grade match {
      case Some(grade)=>println("your grade is "+grade)
      case None =>println("Sorry, your grade information is not the system")
    }
  }

}
