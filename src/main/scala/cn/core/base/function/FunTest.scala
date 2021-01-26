//package base.function
//
//object FunTest {
//
//  def sum(nums: Int*) = {
//    var res = 0
//    for (num <- nums) res += num
//    res
//  }
//
//  def sum2(nums: Int*): Int = {
//    if (nums.length == 0) 0
//    else nums.head + sum2(nums.tail: _*)
//  }
//
//
//
//  def main(args: Array[String]): Unit = {
////    val s = sum(1 to 5:_*)
//  }
//
//}
