/**
 * Created by Jiessie on 14/5/15.
 */
/*
Generate the combinations of K distinct objects chosen from the N elements of a list.
In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
Example:

scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 */
object P26{

  def combinations[T](count:Int,list:List[T]):List[List[T]]  = (count,list) match {
    case (_,Nil)=> Nil
    case (1,ls) => ls.distinct.map(List[T](_))
    case (count,head::tail) => combinations(count-1,tail).map(head::_):::combinations(count,tail)
  }


  def permute[T](count:Int, list:List[T]):List[List[T]] = (count,list) match{
    case (1,ls)=> ls.distinct.map(x=>List[T](x))
    case (count,ls)=> ls.distinct.flatMap(x=>{
      permute(count-1,ls.distinct.filter(e=>{e!=x})).map(x::_)
    })
  }

  def main (args: Array[String]) {
    val list = List('a, 'b, 'c, 'd, 'e, 'f)
    println(permute(3, list).length)
    println(combinations(3,list))
  }
}
