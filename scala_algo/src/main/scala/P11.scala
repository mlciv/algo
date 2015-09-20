/**
 * Created by Jiessie on 14/5/15.
 */
/*
Modified run-length encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */
object P11 {

  def encodeModifiedWithPack[T](list:List[T]): List[Any] = {
    P10.encodeWithPack(list).map(x=> {
      x match {
        case (1,h) => h
        case _ => x
      }
    })
  }

  def encodeModified[T](list:List[T]): List[Any] = {
    val (packed,next) = list span {_==list.head}
    val encode = if (packed.length==1) packed.head else (packed.length,packed.head)
    if(next==Nil) List(encode)
    else encode::encodeModified(next)
  }
}
