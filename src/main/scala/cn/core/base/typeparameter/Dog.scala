package base.typeparameter

class Dog(val name:String) {
  def sayHello = println("Wang,Wang,i am " + name)

//  implicit def dog2person(dog: Object): Person = if(dog.isInstanceOf[Dog]) {val _dog = dog.asInstanceOf[Dog]; new Person(_dog.name) } else Nil


}
