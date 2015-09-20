/**
 * Created by Jiessie on 14/5/15.
 */
/*
Remove the Kth element from a list.
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */
object P20 {
  def removeAt[T](index:Int, list:List[T]): (List[T],T) ={
    val element = list(index)
    val remains =  list.zipWithIndex.filter(x=>x._2!=index).map(_._1)
    (remains,element)
  }

  def removeAtRecursive[T](index:Int, list:List[T]):(List[T],T) = {
    def removeAtR[T](curIndex:Int,curlist:List[T],result:List[T]):(List[T],T) = (curIndex,curlist) match {
      case (_,Nil) => throw new ArrayIndexOutOfBoundsException
      case (0,head::tail) => (result.reverse:::tail,head)
      case (count,head::tail) => removeAtR(count-1,tail,head::result)
    }
    removeAtR(index,list,List[T]())
  }
}
