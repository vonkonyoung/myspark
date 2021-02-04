package base.typeparameter

class Calculator[T:Ordering](val number1:T,val number2:T) {

  def max(implicit  order:Ordering[T])={
    if(order.compare(number1,number2)>0)number1 else number2
  }

}
