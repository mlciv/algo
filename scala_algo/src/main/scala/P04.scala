/**
 * Created by Jiessie on 13/5/15.
 */
/*
Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */
object P04 {

  def lengthBuiltIn[T](list: List[T]): Int = {
    if (list == Nil) throw new NullPointerException else list.length
  }

  def lengthCount[T](list: List[T]): Int = {
    var these = list
    var length = 0
    while (!these.isEmpty) {
      these = these.tail
      length += 1
    }
    length
  }

  def lengthRecursive[T](list: List[T]): Int = list match {
    case Nil => 0
    case head :: tail => 1 + lengthRecursive(tail)
  }
}
