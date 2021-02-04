package base.implicitetest

class Man(val name:String) {
  implicit  def man2superman(man:Man)=new SuperMan(man.name)

}
