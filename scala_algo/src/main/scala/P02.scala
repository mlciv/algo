import java.util.NoSuchElementException

/**
 * Created by Jiessie on 12/5/15.
 */

/*
Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */
object P02 {
  // public is default in scala
  def penultimateIndex[T](list: List[T]): T = {
    if (list.length < 2) throw new NoSuchElementException
    list(list.length-2)
  }

  def penultimateBuiltIn[T](list: List[T]): T= {
    // list.init return the whole list except for the last one.
    if (list.length < 2) throw new NoSuchElementException
    list.init.last
  }

  def penultimateRecursive[T](list:List[T]): T = list match{
    case h ::_:: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  def lastNthIndex[T](list: List[T],n: Int): T = {
    if(list.length < n) throw new NoSuchElementException
    list(list.length-n)
  }

  def lastNthRecursive[T](list: List[T],n: Int): T = {
    if (list == Nil || n<0) throw new NoSuchElementException
    if (n==1) list.last
    if (n==2&&list.length>1) list.init.last else lastNthRecursive(list.init, n - 1)
    // List.init means the whole list but the last one
    // List.tail means the whole list but the first one
    // List.head the first element
    // List.last the last element
  }

  def lastNthRecursive1[T](list:List[T],n:Int): T = (list,n) match {
    case (head::Nil,0) => head
    case (head::tail,n) => if (tail.length+1==n) head else lastNthRecursive1(tail,n)
    case (Nil,n) => throw new NoSuchElementException
  }

}
