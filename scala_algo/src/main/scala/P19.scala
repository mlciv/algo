/**
 * Created by Jiessie on 14/5/15.
 */
/*
Rotate a list N places to the left.
Examples:
scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 */
object P19 {
  def rotate[T](index:Int, list:List[T]): List[T] = {
    val (left,right) = list.splitAt((index+list.length)%list.length)
    right:::left
  }

  def rotate2[A](n: Int, ls: List[A]): List[A] = {  // drop/tak n will delete/take n element from the beginning,
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else (ls drop nBounded) ::: (ls take nBounded)
  }
}
