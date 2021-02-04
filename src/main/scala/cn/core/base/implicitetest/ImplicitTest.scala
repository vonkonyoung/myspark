package base.implicitetest

object ImplicitTest {
  implicit def object2SpecialPerson(obj:Object):SpecialPerson={
    if(obj.getClass==classOf[Student]){
      val stu=obj.asInstanceOf[Student];
      new SpecialPerson(stu.name)
    }else if(obj.getClass==classOf[Older]){
      val older=obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    }else Nil
  }

}
