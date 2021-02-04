package base.typeparameter

class Party[T <:Person](p1:T,p2:T){
  def play=p1.makeFriends(p2)
}
