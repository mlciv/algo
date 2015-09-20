/**
 * Created by Jiessie on 14/5/15.
 */
/*
Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */
object P14 {
  def duplicate[T](list:List[T]): List[T] = {
    list.flatMap(x=>List(x,x))
  }
}
