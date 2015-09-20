import scala.collection.mutable.ListBuffer

/**
 * Created by Jiessie on 14/5/15.
 */
/*
Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 */
object P15 {
  def duplicateN[T](n:Int, list:List[T]): List[T] = {
    list.flatMap(x=>{
      var duplist = ListBuffer[T]()
      for(i<-0 until n){
        duplist+=x
      }
      duplist.toList
    })
  }

  def duplicateNBuiltin[T](n:Int, list:List[T]): List[T] = {
    list.flatMap(x=>{
      List.fill(n)(x)
    })
  }
}
