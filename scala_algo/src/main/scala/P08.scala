import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, ArrayBuilder}

/**
 * Created by Jiessie on 13/5/15.
 */
/*
 Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
Example:

scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */
object P08 {
  def compressBuiltIn[T](list:List[T]): List[T] = {
    list.distinct
  }

  def compressInternal[T](list:List[T]): List[T] = {
    val b = new ListBuffer[T]
    val seen = new mutable.HashSet[T]()
    list.foreach(x=>if(!seen(x)) {b+=x;seen+=x})
    b.toList
  }

  // Standard recursive.
  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  // Tail recursive.
  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }

  // Functional.
  def compressFunctional[A](ls: List[A]): List[A] = {
    ls.foldLeft(ListBuffer[A]())((r, h) => {
      if (r.isEmpty || !r.contains(h)) r += h
      else r
    }).toList
  }
}
