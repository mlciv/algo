/**
 * Created by Jiessie on 14/5/15.
 */
/*
Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 */
object P22 {
  def rangeBuiltin(start:Int,end:Int):List[Int] = {
    List.range(start,end+1)
  }

  def rangeRecursive(start:Int, end:Int): List[Int] = (start,end) match{
    case (start,end) => if(start>end) Nil else start::rangeRecursive(start+1,end)
  }

  //tail rec
  def rangeRecursive2(start:Int, end: Int): List[Int] = {
    def rangeR(i:Int,j:Int,result:List[Int]): List[Int] = (i,j) match{
      case (i,j) => if(i>j) result.reverse else rangeR(i+1,j,i::result)
    }
    rangeR(start,end,List[Int]())
  }

}
