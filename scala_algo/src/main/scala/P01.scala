/**
 * Created by Jiessie on 7/5/15.
 */

// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8

// The start of the definition of last should be
//     def last[A](l: List[A]): A = ...
// The `[A]` allows us to handle lists of any type.


object P01 {
  def lastBuiltin[T](list:List[T]): T = list.last

  def lastRecursive[T](list:List[T]): T = list match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)   // the operator end with ':' means that it is a right operandm. tail.::(_)
    case _ => throw new NoSuchElementException
  }
}
