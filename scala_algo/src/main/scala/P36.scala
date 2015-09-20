/**
 * Created by Jiessie on 18/5/15.
 */
/*
Determine the prime factors of a given positive integer (2).
Construct a list containing the prime factors and their multiplicity.
scala> 315.primeFactorMultiplicity
res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
Alternately, use a Map for the result.

scala> 315.primeFactorMultiplicity
res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)
 */
object P36 {
  def primeFactorMultiplicity(number:Int): List[(Int,Int)] ={
    (2 to number) filter({x=>P31.isPrime(x)&&number%x==0}) map(x=>{
      var tempNumber = number
      var list = List.newBuilder[Int]
      while(tempNumber%x==0){
        tempNumber = tempNumber/x
        list+=x
      }
      (x,list.result().length)
    }) toList
  }

  def main(args: Array[String]) {
    println(primeFactorMultiplicity(315))
  }
}
