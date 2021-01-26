package base

object GameDoor {

  def main(args: Array[String]): Unit = {

    val name=readLine("welcome to game house!please tell me your name:")
    print("Thanks,Then tell me your age:")
    val age=readInt()
    if(age>18){
      printf("Hi, %s, you are %d years old, so you are legel to come here!", name, age)
    }else{
      printf("Sorry, boy, %s, you are only %d years old. you are illegal to come here!", name, age)
    }
  }

}
