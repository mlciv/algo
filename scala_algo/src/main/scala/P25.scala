/**
 * Created by Jiessie on 14/5/15.
 */
/*
Generate a random permutation of the elements of a list.
Hint: Use the solution of problem P23.
Example:

scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 */
object P25 {
  def randomPermute[T](list:List[T]): List[T] ={
    P24.lottoSelect(list.length,list.length).map(x=>list(x-1))
  }
}
