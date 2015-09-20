import scala.collection.mutable.ListBuffer

/**
 * Created by Jiessie on 14/5/15.
 */
/*
Split a list into two parts.
The length of the first part is given. Use a Tuple for your result.
Example:

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 */
object P17 {

  // tail rec
  def split[T](n:Int,list:List[T]): List[List[T]] = {
    def splitR[T](curIndex:Int,curList:List[T], result:List[T]): List[List[T]] = (curIndex,curList) match{
      case (_,Nil) => throw new ArrayIndexOutOfBoundsException
      case (1,head::tail) =>List[List[T]]((head::result).reverse,tail)
      case (count,head::tail) => splitR(count-1,tail,head::result)
    }
    splitR[T](n,list,List[T]())
  }

  //using split
  def splitBuiltin[T](n:Int,list:List[T]): List[List[T]] = {
    val (first,second) = list.splitAt(n)
    List[List[T]](first,second)
  }
}
