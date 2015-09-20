import scala.collection.parallel.mutable

/**
 * Created by Jiessie on 13/5/15.
 */

/*
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */
object P05 {
  def reverseBuiltIn[T](list:List[T]): List[T] = {
    list.reverse
  }

  def reverseInternal[T](list:List[T]): List[T] = {
    var these = list
    var reversedList = List[T]()
    while(!these.isEmpty){
      reversedList = these.head::reversedList
      these = these.tail
    }
    reversedList
  }

  def reverseRecursive[T](list:List[T]): List[T] = list match {
    case Nil=> Nil
    case head::Nil => List[T](head)
    case head::tail => reverseRecursive(tail):::reverseRecursive(List[T](head))
  }

}
