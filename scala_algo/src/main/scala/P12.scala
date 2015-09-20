import scala.collection.mutable.ListBuffer

/**
 * Created by Jiessie on 14/5/15.
 */
/*
Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
<Programming in scala>
Class List does offer an “append” operation —it’s written :+ and is explained in Chapter 24—
but this operation is rarely used, because the time it takes to append to a list grows linearly
with the size of the list, whereas prepending with :: takes constant time. Your options if you want
 to build a list efficiently by appending elements is to prepend them, then when you’re done call reverse;
 or use a ListBuffer, a mutable list that does offer an append operation, and when you’re done call toList.
 ListBuffer will be described in Section 22.2.
 */
object P12 {
  def decode[T](list: List[(Int,T)]): List[T] = {
    list.flatMap(x=>{
      val length = x._1
      val element = x._2
      var xlist = ListBuffer[T]()   // List
      for(i <- 0 until length){
        xlist+=element
      }
      xlist.toList
    })
  }
}
