package base.typeparameter

class Student[T](val localld:T) {

  def getSchoold(hukouId:T)="S-"+hukouId+"-"+localld

}
