import java.util.NoSuchElementException

/**
 * Created by Jiessie on 12/5/15.
 */
// P03 (*) Find the Kth element of a list.
//     By convention, the first element in the list is element 0.
//
//     Example:
//     scala> nth(2, List(1, 1, 2, 3, 5, 8))
//     res0: Int = 2

object P03 {

  def NthBuiltIn[T](list: List[T],n:Int): T ={
    if(list==Nil||list.length<=n) throw new NoSuchElementException else list(n)
  }

  def NthRecursive[T](list: List[T],n: Int): T = (list,n) match{
    case (Nil,n)=> throw new NoSuchElementException
    case (head::tail,0) => head
    case (_::tail,n) => NthRecursive(tail,n-1)
  }
}
