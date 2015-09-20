import scala.collection.GenTraversableOnce
import scala.collection.generic.CanBuildFrom
import scala.collection.immutable.List

/**
 * Created by Jiessie on 15/5/15.
 */
/*
Group the elements of a set into disjoint subsets.
a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
Example:

scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

Example:

scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...). However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).

You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
 */
object P27 {
  def group[T](argList:List[Int],list:List[T]):List[List[List[T]]] = (argList,list) match{
    case (Nil,_)=> Nil
    case (head::Nil,curlist) => List[List[List[T]]](P26.combinations(head,curlist))
    case (head::tail,curlist) =>P26.combinations(head,curlist).flatMap(x=>group(tail,curlist.filter(y=>(!x.contains(y)))).map(z=>x::z))
  }

//  import P26.combinations
//
//  def group3[A](ls: List[A]): List[List[List[A]]] =
//    for {
//      a <- combinations(2, ls)
//      noA = ls -- a
//      b <- combinations(3, noA)
//    } yield List(a, b, noA -- b)
//
//  def group_b[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
//    case Nil     => List(Nil)
//    case n :: ns => combinations(n, ls) flatMap { c =>
//      group(ns, ls -- c) map {c :: _}
//    }
//  }

  def main(args: Array[String]) {
    println(group(List(1,2,3),List('a,'b,'c,'d,'e,'f)).length)
    println("shouldBe "+6*(5*4/2))
  }

}
