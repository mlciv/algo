/**
 * Created by Jiessie on 14/5/15.
 */
/*
Extract a slice from a list.
Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
 */
object P18 {
  def slice[T](start:Int,end: Int , list:List[T]):List[T] ={
    list.zipWithIndex.filter(x=>(x._2>=start&&x._2<end)).map(_._1)
  }

  def sliceBuiltin[T](start:Int,end: Int , list:List[T]):List[T] ={
    list.slice(start,end)
  }

}
