/**
 * Created by Jiessie on 14/5/15.
 */
/*
Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */
object P21 {
  def insertAt[T](elem:T,index:Int,list:List[T]):List[T] = list.splitAt(index) match{
    case (pre,post) => pre:::elem::post
  }
}
