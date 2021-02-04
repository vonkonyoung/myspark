package base.typeparameter

class Card[+T](val name:String) {

  def enterMeet(card:Card[Master]): Unit ={
    println("welcome to have this meeting")
    println("welcome to have this meeting")
  }

}
