import scala.collection.mutable.ListBuffer
/**
 * Created by Jiessie on 14/5/15.
 */
/*
Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */
object P16 {

  // Simple Recursive
  def dropEveryN[T](n:Int,list:List[T]):List[T] = {
    def dropEveryNInternal[T](c:Int,curList:List[T]):List[T] = (c,curList) match{
      case (_,Nil) => Nil
      case (1, head::tail) => dropEveryNInternal(n, tail)
      case (_, head::tail) => head::dropEveryNInternal(c - 1, tail)
    }
    dropEveryNInternal(n,list)
  }

  //tailrec, normally, tailrec can be optimized by keep the result.
  def dropEveryNTail[T](n:Int,list:List[T]):List[T] = {
    def dropEveryNInternal[T](c:Int,curList:List[T],result:List[T]):List[T] = (c,curList) match{
      case (_,Nil) => result.reverse
      case (1, head::tail) => dropEveryNInternal(n, tail,result)
      case (_, head::tail) => dropEveryNInternal(c - 1, tail,head::result)
    }
    dropEveryNInternal(n,list,List())
  }

  // Functional.
  def dropFunctional[A](n: Int, ls: List[A]): List[A] =
    ls.zipWithIndex filter { v => ((v._2 + 1) % n != 0) } map { _._1 }

//  // Functional.  dropwhile means drop all until the one fit the pattern
//  def dropFunctional2[A](n: Int, ls: List[A]): List[A] =
//    ls.zipWithIndex.dropWhile(x=>((x._2+1)%n==0)).map(_._1)
}
