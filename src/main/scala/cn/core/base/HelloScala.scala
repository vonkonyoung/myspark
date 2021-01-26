package base

object HelloScala {

  def main(args: Array[String]): Unit = {

    val name:String=null;
    val gender:Any="leo";
    println(name)
    val name1,name2:String=null;
    println(name1)
    val age=30;
    val isAudult=if (age>30) 1 else 0;
    val n=if(age>18){
      "adult"
    }else if(age>12){
      "teenager"
    }else{
      "children"
    }
    println("n:"+n)
    println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn")
    var a,b,c=0;
    if(a<10){
      b=b+1;c=c+1
    }
    var d=if(a<10){
      b=b+1;
      c+1
    }
    print(d)


  }

}
