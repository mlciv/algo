import scala.collection.mutable.ListBuffer

/**
 * Created by Jiessie on 14/5/15.
 */
/*
P13 (**) Run-length encoding of a list (direct solution).
Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
Example:

scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
object P13 {
  def encodeDirect[T](list:List[T]): List[(Int, T)]= {
    list.foldLeft(ListBuffer[(Int,T)]())((r,h) => {
      if(r.isEmpty) r+=((1,h))
      else {
        if ((!r.isEmpty) && r.last._2 == h) {
          val num = r.last._1
          r -= r.last;
          r += ((num + 1, h))
        }
        else r+=((1,h))
      }
    }).toList
  }
}
