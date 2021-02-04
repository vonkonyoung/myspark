package base.matchCase

object CaseClassTest {

  def judgeIdentify(p:Person): Unit ={
    p match {
      case Teacher(name,subject) =>println("Teacher name is "+name+",subject is "+subject)
      case Student(name,classroom)=>println("Student,name is "+name+",classroom is "+classroom)
      case _=>println("Illegal access,please go out of the school")
    }
  }

}
