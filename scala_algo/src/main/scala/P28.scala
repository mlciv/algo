import scala.collection.immutable.{HashMap, HashSet}

/**
 * Created by Jiessie on 15/5/15.
 */
/*
Sorting a list of lists according to length of sublists.
a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the list according to their length. E.g. short lists first, longer lists later, or vice versa.
Example:

scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is to sort the elements according to their length frequency; i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.

Example:

scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once. The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have length 2. This is the most frequent length.
 */
object P28 {
  def lsort[T](list:List[List[T]]) = {
    def selectSortR(curlist:List[((List[T],Int),Int)]): List[((List[T],Int),Int)] = curlist match{
      case Nil => Nil
      case ls => {
        val min = curlist.foldLeft(((List[T](), Int.MaxValue),-1))((x, y) => {
          if (x._1._2 <= y._1._2) x else y
        })
        min::selectSortR(ls.filter(_!=min))
      }
    }

    selectSortR(list.zip(list.map(_.length)).zipWithIndex).map(x=>x._1._1)
  }

  def lsortFreq[T](list:List[List[T]]) = {
    def selectSortR(curlist:List[(List[T],Int)]): List[(List[T],Int)] = curlist match{
      case Nil => Nil
      case ls => {
        val min = curlist.foldLeft((List[T](), Int.MaxValue))((x, y) => {
          if (x._2 <= y._2) x else y
        })
        min::selectSortR(ls.filter(_!=min))
      }
    }
    val hashSet = list.foldLeft(HashMap[Int,Int]())((x,y)=> {
      if (x.contains(y.length)) x.updated(y.length,1+x.getOrElse(y.length,0)) else x.+((y.length,1))
    })
    selectSortR(list.zip(list.map(x=>hashSet.get(x.length).getOrElse(0)))).map(x=>x._1)
  }


  def main(args: Array[String]) {
    println(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
    println(lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }
}
