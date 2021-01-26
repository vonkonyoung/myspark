package base.objects

class Student  {

  private var myAge=0
  def age_=(newAge:Int): Unit ={
    if(newAge>0){
      myAge=newAge
    }else{
      println("illegal agel")
    }
  }

  private var myName="leo"
  def updateName(newName:String): Unit ={
    if(newName=="leo1"){
      myName=newName
    }else{
      println("not accept this new name!!")
    }
  }

  def name="your name is "+myName

}
